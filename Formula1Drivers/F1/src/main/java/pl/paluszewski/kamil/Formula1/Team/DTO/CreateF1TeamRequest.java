package pl.paluszewski.kamil.Formula1.Team.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;
import java.util.function.Function;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateF1TeamRequest {

    private String teamName;

    public static Function<CreateF1TeamRequest, F1Team> createMapper() {
        return req -> F1Team.builder()
                .teamName(req.getTeamName())
                .build();
    }
}
