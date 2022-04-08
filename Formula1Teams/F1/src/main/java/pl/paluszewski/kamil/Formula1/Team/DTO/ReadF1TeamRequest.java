package pl.paluszewski.kamil.Formula1.Team.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReadF1TeamRequest {

    private String teamName;

    private String nationality;

    private Integer firstEntryYear;

    private Integer worldChampionshipsWon;

    private Integer racesWon;

    private String teamChief;

    private String chassis;

    public static Function<F1Team, ReadF1TeamRequest> readMapper () {
        return req -> ReadF1TeamRequest.builder()
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





