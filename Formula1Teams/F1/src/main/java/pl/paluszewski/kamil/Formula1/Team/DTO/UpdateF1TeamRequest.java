package pl.paluszewski.kamil.Formula1.Team.DTO;


import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;

import javax.persistence.Column;
import java.util.function.BiFunction;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UpdateF1TeamRequest {

    private Integer worldChampionshipsWon;

    private Integer racesWon;

    private String teamChief;

    private String chassis;

    public static BiFunction<F1Team, UpdateF1TeamRequest, F1Team> updater() {
        return (team, req) -> {
            team.setWorldChampionshipsWon(req.getWorldChampionshipsWon());
            team.setRacesWon(req.getRacesWon());
            team.setTeamChief(req.getTeamChief());
            team.setChassis(req.getChassis());
            return team;
        };
    }
}
