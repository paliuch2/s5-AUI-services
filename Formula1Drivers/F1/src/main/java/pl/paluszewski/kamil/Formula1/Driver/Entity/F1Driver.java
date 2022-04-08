package pl.paluszewski.kamil.Formula1.Driver.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "f1_drivers")
public class F1Driver {

    @Id
    @Column(name = "starting_no")
    private Integer startingNo;

    private String name;

    private String surname;

    private String nationality;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @ManyToOne
    @JoinColumn(name = "team")
    private F1Team team;

    @Column(name = "points_earned")
    private Double pointsEarned;

    @Column(name = "gps_entered")
    private Integer GPsEntered;

    @Column(name = "races_won")
    private Integer racesWon;
}
