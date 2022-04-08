package pl.paluszewski.kamil.Formula1.Driver.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.paluszewski.kamil.Formula1.Driver.Entity.F1Driver;
import java.time.LocalDate;
import java.util.function.Function;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReadF1DriverRequest {

    private Integer startingNo;

    private String name;

    private String surname;

    private String nationality;

    private LocalDate dateOfBirth;

    private String placeOfBirth;

    private String team;

    private Double pointsEarned;

    private Integer GPsEntered;

    private Integer racesWon;

    public static Function<F1Driver, ReadF1DriverRequest> readMapper () {
        return req -> ReadF1DriverRequest.builder()
                .startingNo(req.getStartingNo())
                .name(req.getName())
                .surname(req.getSurname())
                .nationality(req.getNationality())
                .team(req.getTeam().getTeamName())
                .dateOfBirth(req.getDateOfBirth())
                .placeOfBirth(req.getPlaceOfBirth())
                .GPsEntered(req.getGPsEntered())
                .pointsEarned(req.getPointsEarned())
                .racesWon(req.getRacesWon())
                .build();
    }
}
