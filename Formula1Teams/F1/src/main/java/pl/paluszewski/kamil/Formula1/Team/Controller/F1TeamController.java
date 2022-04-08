package pl.paluszewski.kamil.Formula1.Team.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.paluszewski.kamil.Formula1.Team.DTO.CreateF1TeamRequest;
import pl.paluszewski.kamil.Formula1.Team.DTO.ReadAllF1TeamsRequest;
import pl.paluszewski.kamil.Formula1.Team.DTO.ReadF1TeamRequest;
import pl.paluszewski.kamil.Formula1.Team.DTO.UpdateF1TeamRequest;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1TeamService;
import java.util.Optional;

@RestController
@RequestMapping("api/teams")
public class F1TeamController {

    private F1TeamService teamService;

    public F1TeamController(F1TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<ReadAllF1TeamsRequest> readAllF1Teams() {
        return ResponseEntity.ok(ReadAllF1TeamsRequest.readAllMapper().apply(teamService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ReadF1TeamRequest> readF1Team(@PathVariable("id") String id) {
        Optional<F1Team> team = teamService.find(id);
        return team.map(v -> ResponseEntity.ok(ReadF1TeamRequest.readMapper().apply(v)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Void> addF1Team(@RequestBody CreateF1TeamRequest r,
                                          UriComponentsBuilder b) {

        Optional<F1Team> team = teamService.find(r.getTeamName());
        if (team.isPresent()) {
            return ResponseEntity.badRequest().build();
        } else {

            F1Team t = CreateF1TeamRequest.createMapper().apply(r);
            teamService.add(t);
            return ResponseEntity.created(b.pathSegment("api", "teams", "{id}")
                    .buildAndExpand(t.getTeamName()).toUri()).build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateF1Team (@RequestBody UpdateF1TeamRequest r,
                                                @PathVariable("id") String name) {
        Optional <F1Team> team = teamService.find(name);
        if(team.isPresent()) {
            UpdateF1TeamRequest.updater().apply(team.get(), r);
            teamService.update(team.get());
            return ResponseEntity.accepted().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<Void> deleteF1Team (@PathVariable("id") String name) {
        Optional <F1Team> team = teamService.find(name);
        if(team.isPresent()) {
            teamService.delete(team.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}





