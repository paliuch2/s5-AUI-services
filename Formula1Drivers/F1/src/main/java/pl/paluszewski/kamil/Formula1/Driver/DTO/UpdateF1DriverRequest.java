package pl.paluszewski.kamil.Formula1.Driver.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.paluszewski.kamil.Formula1.Driver.Entity.F1Driver;

import java.util.function.BiFunction;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UpdateF1DriverRequest {

    private Double pointsEarned;

    private Integer GPsEntered;

    private Integer racesWon;

    public static BiFunction<F1Driver, UpdateF1DriverRequest, F1Driver> updater() {
        return (driver, req) -> {
            driver.setPointsEarned(req.getPointsEarned());
            driver.setGPsEntered(req.getGPsEntered());
            driver.setRacesWon(req.getRacesWon());
            return driver;
        };
    }
}
