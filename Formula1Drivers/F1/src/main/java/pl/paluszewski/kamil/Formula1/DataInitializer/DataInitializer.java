package pl.paluszewski.kamil.Formula1.DataInitializer;

import org.springframework.stereotype.Component;
import pl.paluszewski.kamil.Formula1.Driver.Entity.F1Driver;
import pl.paluszewski.kamil.Formula1.Driver.Entity.F1DriverService;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1TeamService;
import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DataInitializer {

    private final F1DriverService driverService;

    private final F1TeamService teamService;

    public DataInitializer(F1DriverService driverService, F1TeamService teamService) {
        this.driverService = driverService;
        this.teamService = teamService;
    }

    @PostConstruct
    private synchronized void initialize() {
        F1Team mclaren = F1Team.builder().teamName("McLaren")
                .build();

        F1Team ferrari = F1Team.builder().teamName("Ferrari")
                .build();

        F1Team red_bull = F1Team.builder().teamName("Red Bull Racing")
                .build();

        F1Team mercedes = F1Team.builder().teamName("Mercedes-AMG")
                .build();

        teamService.add(mclaren);
        teamService.add(ferrari);
        teamService.add(red_bull);
        teamService.add(mercedes);

        F1Driver norris = F1Driver.builder().startingNo(4)
                .name("Lando")
                .surname("Norris")
                .nationality("United Kingdom")
                .team(mclaren)
                .dateOfBirth(LocalDate.parse("1999-11-13"))
                .placeOfBirth("Bristol")
                .GPsEntered(54)
                .pointsEarned(291.0)
                .racesWon(0)
                .build();

        F1Driver ricciardo = F1Driver.builder().startingNo(3)
                .name("Daniel")
                .surname("Ricciardo")
                .nationality("Australia")
                .team(mclaren)
                .dateOfBirth(LocalDate.parse("1989-07-01"))
                .placeOfBirth("Perth")
                .GPsEntered(204)
                .pointsEarned(1254.0)
                .racesWon(8)
                .build();

        F1Driver verstappen = F1Driver.builder().startingNo(33)
                .name("Max")
                .surname("Verstappen")
                .nationality("Netherlands")
                .team(red_bull)
                .dateOfBirth(LocalDate.parse("1997-09-30"))
                .placeOfBirth("Hasselt")
                .GPsEntered(135)
                .pointsEarned(1424.5)
                .racesWon(17)
                .build();

        F1Driver hamilton = F1Driver.builder().startingNo(44)
                .name("Lewis")
                .surname("Hamilton")
                .nationality("United Kingdom")
                .team(mercedes)
                .dateOfBirth(LocalDate.parse("1985-01-07"))
                .placeOfBirth("Stevenage")
                .GPsEntered(282)
                .pointsEarned(4034.5)
                .racesWon(100)
                .build();

        F1Driver leclerc = F1Driver.builder().startingNo(16)
                .name("Charles")
                .surname("Leclerc")
                .nationality("Monaco")
                .team(ferrari)
                .dateOfBirth(LocalDate.parse("1997-10-16"))
                .placeOfBirth("Monte Carlo")
                .GPsEntered(75)
                .pointsEarned(517.0)
                .racesWon(2)
                .build();

        driverService.add(norris);
        driverService.add(ricciardo);
        driverService.add(hamilton);
        driverService.add(verstappen);
        driverService.add(leclerc);
    }
}
