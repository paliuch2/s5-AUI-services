package pl.paluszewski.kamil.Formula1.Driver.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.paluszewski.kamil.Formula1.Driver.DTO.CreateF1DriverRequest;
import pl.paluszewski.kamil.Formula1.Driver.DTO.ReadAllF1DriversRequest;
import pl.paluszewski.kamil.Formula1.Driver.DTO.ReadF1DriverRequest;
import pl.paluszewski.kamil.Formula1.Driver.DTO.UpdateF1DriverRequest;
import pl.paluszewski.kamil.Formula1.Driver.Entity.F1Driver;
import pl.paluszewski.kamil.Formula1.Driver.Entity.F1DriverService;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1TeamService;

import java.util.Optional;

@RestController
@RequestMapping("api/teams/{teamname}/drivers")
public class F1DriverTeamController {

    private F1DriverService driverService;
    private F1TeamService teamService;

    public F1DriverTeamController(F1DriverService driverService, F1TeamService teamService) {

        this.driverService = driverService;
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<ReadAllF1DriversRequest> readTeamDrivers(@PathVariable("teamname") String teamname) {
        Optional<F1Team> team = teamService.find(teamname);
        return team.map(val -> ResponseEntity.ok(ReadAllF1DriversRequest.readAllMapper().apply(driverService.findAll(val))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<ReadF1DriverRequest> readF1Driver(@PathVariable("teamname") String teamname,
                                                            @PathVariable("id") int no) {
        Optional<F1Team> team = teamService.find(teamname);
        if (team.isPresent()) {
            Optional<F1Driver> driver = driverService.find(no, team.get());

            return driver.map(v -> ResponseEntity.ok(ReadF1DriverRequest.readMapper().apply(v)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> addF1Driver(@PathVariable("teamname") String teamname,
                                            @RequestBody CreateF1DriverRequest r,
                                            UriComponentsBuilder b) {
        Optional<F1Team> team = teamService.find(teamname);
        if (team.isPresent()) {
            F1Driver driver = CreateF1DriverRequest
                    .createMapper(team::get)
                    // .createMapper(name -> teamService.find(name).orElseThrow())
                    .apply(r);

            Optional<F1Driver> d = driverService.find(driver.getStartingNo());
            if (d.isPresent()) {
                return ResponseEntity.badRequest().build();
            } else {
                driver = driverService.add(driver);
                return ResponseEntity.created(b.pathSegment("api", "teams", "{teamname}", "drivers", "{id}")
                        .buildAndExpand(team.get().getTeamName(), driver.getStartingNo()).toUri()).build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteF1Driver(@PathVariable("teamname") String teamname,
                                               @PathVariable("id") int no) {
        Optional<F1Team> team = teamService.find(teamname);
        if (team.isPresent()) {
            Optional<F1Driver> driver = driverService.find(no, team.get());
            if (driver.isPresent()) {
                driverService.delete(driver.get().getStartingNo());
                return ResponseEntity.accepted().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateDriver(@PathVariable("teamname") String teamname,
                                             @PathVariable("id") int no,
                                             @RequestBody UpdateF1DriverRequest r) {
        Optional<F1Team> team = teamService.find(teamname);
        if (team.isPresent()) {
            Optional<F1Driver> driver = driverService.find(no, team.get());
            if (driver.isPresent()) {
                UpdateF1DriverRequest.updater().apply(driver.get(), r);
                driverService.update(driver.get());
                return ResponseEntity.accepted().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


