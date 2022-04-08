package pl.paluszewski.kamil.Formula1.Team.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.paluszewski.kamil.Formula1.Driver.Entity.F1Driver;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "f1_teams")
public class F1Team {

    @Id
    @Column(name = "team_name")
    private String teamName;

    @OneToMany (mappedBy = "team", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<F1Driver> drivers;
}
