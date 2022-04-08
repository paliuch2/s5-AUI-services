package pl.paluszewski.kamil.Formula1.Driver.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.paluszewski.kamil.Formula1.Driver.Entity.F1Driver;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReadAllF1DriversRequest {

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class F1DriverShort {
        private Integer startingNo;

        private String name;

        private String surname;
    }

    @Singular
    private List<F1DriverShort> drivers;

    public static Function<Collection<F1Driver>, ReadAllF1DriversRequest> readAllMapper() {
        return drivers -> {
            ReadAllF1DriversRequestBuilder req = ReadAllF1DriversRequest.builder();
            drivers.stream()
                    .map(driver -> F1DriverShort.builder()
                            .startingNo(driver.getStartingNo())
                            .name(driver.getName())
                            .surname(driver.getSurname())
                            .build()).forEach(req::driver);
            return req.build();
        };
    }
}
