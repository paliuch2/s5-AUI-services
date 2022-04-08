package pl.paluszewski.kamil.Formula1.Team.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;


import java.util.function.Function;
import java.util.function.Supplier;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateF1TeamRequest {

    private String teamName;

    private String nationality;

    private Integer firstEntryYear;

    private Integer worldChampionshipsWon;

    private Integer racesWon;

    private String teamChief;

    private String chassis;

    public static Function<CreateF1TeamRequest, F1Team> createMapper () {
        return req -> F1Team.builder()
                .teamName(req.getTeamName())
                .nationality(req.getNationality())
                .firstEntryYear(req.getFirstEntryYear())
                .worldChampionshipsWon(req.getWorldChampionshipsWon())
                .racesWon(req.getRacesWon())
                .chassis(req.getChassis())
                .teamChief(req.getTeamChief())
                .build();
    }
}
