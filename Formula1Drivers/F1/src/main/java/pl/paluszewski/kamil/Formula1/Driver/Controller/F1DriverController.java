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
@RequestMapping("api/drivers")
public class F1DriverController {

    private F1DriverService driverService;
    private F1TeamService teamService;

    public F1DriverController(F1DriverService driverService, F1TeamService teamService) {

        this.driverService = driverService;
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<ReadAllF1DriversRequest> readAllF1Drivers() {
        return ResponseEntity.ok(ReadAllF1DriversRequest.readAllMapper().apply(driverService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ReadF1DriverRequest> readF1Driver(@PathVariable("id") int no) {
        Optional<F1Driver> driver = driverService.find(no);
        return driver.map(v -> ResponseEntity.ok(ReadF1DriverRequest.readMapper().apply(v)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteF1Driver(@PathVariable("id") int no) {
        Optional<F1Driver> driver = driverService.find(no);
        if (driver.isPresent()) {
            driverService.delete(driver.get().getStartingNo());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateF1Driver(@RequestBody UpdateF1DriverRequest r,
                                               @PathVariable("id") int no) {
        Optional<F1Driver> driver = driverService.find(no);
        if (driver.isPresent()) {
            UpdateF1DriverRequest.updater().apply(driver.get(), r);
            driverService.update(driver.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




