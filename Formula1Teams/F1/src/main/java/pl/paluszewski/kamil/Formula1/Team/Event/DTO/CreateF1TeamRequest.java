package pl.paluszewski.kamil.Formula1.Team.Event.DTO;

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

    public static Function<F1Team, CreateF1TeamRequest> createMapper() {
        return entity -> CreateF1TeamRequest.builder()
                .teamName(entity.getTeamName())
                .build();
    }

}
