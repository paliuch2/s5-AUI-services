package pl.paluszewski.kamil.Formula1.Team.Event.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;
import pl.paluszewski.kamil.Formula1.Team.Event.DTO.CreateF1TeamRequest;

@Repository
public class F1TeamEventRepository {

    private RestTemplate template;

    @Autowired
    public F1TeamEventRepository(@Value("${formula1.drivers.url}") String baseUrl) {
        template = new RestTemplateBuilder().rootUri(baseUrl).build();
    }

    public void delete(F1Team team) {
        template.delete("/teams/{team_name}", team.getTeamName());
    }

    public void create(F1Team team) {
        template.postForLocation("/teams", CreateF1TeamRequest.createMapper().apply(team));
    }

}
