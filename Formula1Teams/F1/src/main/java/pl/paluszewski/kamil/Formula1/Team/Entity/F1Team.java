package pl.paluszewski.kamil.Formula1.Team.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
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

    private String nationality;

    @Column(name = "first_entry_year")
    private Integer firstEntryYear;

    @Column(name = "world_championships_won")
    private Integer worldChampionshipsWon;

    @Column(name = "races_won")
    private Integer racesWon;

    @Column(name = "team_chief")
    private String teamChief;

    private String chassis;
}
