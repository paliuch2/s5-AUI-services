package pl.paluszewski.kamil.Formula1.Driver.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.paluszewski.kamil.Formula1.Driver.Entity.F1Driver;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;
import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Supplier;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateF1DriverRequest {

    private Integer startingNo;

    private String name;

    private String surname;

    private String nationality;

    private LocalDate dateOfBirth;

    private String team;

    private String placeOfBirth;

    private Double pointsEarned;

    private Integer GPsEntered;

    private Integer racesWon;

    public static Function<CreateF1DriverRequest, F1Driver> createMapper ( Supplier<F1Team> teamSupplier) {
        return req -> F1Driver.builder()
                .startingNo(req.getStartingNo())
                .name(req.getName())
                .surname(req.getSurname())
                .nationality(req.getNationality())
                .team(teamSupplier.get())
                .dateOfBirth(req.getDateOfBirth())
                .placeOfBirth(req.getPlaceOfBirth())
                .GPsEntered(req.getGPsEntered())
                .pointsEarned(req.getPointsEarned())
                .racesWon(req.getRacesWon())
                .build();
    }
}
