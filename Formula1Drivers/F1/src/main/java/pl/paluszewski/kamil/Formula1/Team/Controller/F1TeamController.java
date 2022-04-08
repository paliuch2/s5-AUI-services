package pl.paluszewski.kamil.Formula1.Team.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.paluszewski.kamil.Formula1.Team.DTO.CreateF1TeamRequest;
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

    @PostMapping
    public ResponseEntity<Void> addF1Team(@RequestBody CreateF1TeamRequest request, UriComponentsBuilder builder) {
        F1Team team = CreateF1TeamRequest.createMapper().apply(request);
        teamService.add(team);
        return ResponseEntity.created(builder.pathSegment("api", "users", "{username}")
                .buildAndExpand(team.getTeamName()).toUri()).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteF1Team(@PathVariable("id") String name) {
        Optional<F1Team> team = teamService.find(name);
        if (team.isPresent()) {
            teamService.delete(team.get().getTeamName());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}





