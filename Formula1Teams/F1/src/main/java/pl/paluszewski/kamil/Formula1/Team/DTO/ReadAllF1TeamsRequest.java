package pl.paluszewski.kamil.Formula1.Team.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReadAllF1TeamsRequest {

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class F1TeamShort
    {
        private String teamName;
    }

    @Singular
    private List<F1TeamShort> teams;

    public static Function<Collection<F1Team>, ReadAllF1TeamsRequest> readAllMapper() {
        return teams -> {
            ReadAllF1TeamsRequest.ReadAllF1TeamsRequestBuilder req = ReadAllF1TeamsRequest.builder();
            teams.stream()
                    .map(team -> ReadAllF1TeamsRequest.F1TeamShort.builder()
                            .teamName(team.getTeamName())
                            .build()).forEach(req::team);
            return req.build();
        };
    }
}

