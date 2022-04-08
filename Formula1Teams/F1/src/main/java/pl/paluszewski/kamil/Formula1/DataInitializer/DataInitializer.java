package pl.paluszewski.kamil.Formula1.DataInitializer;

import org.springframework.stereotype.Component;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1TeamService;
import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final F1TeamService teamService;

    public DataInitializer(F1TeamService teamService) {
        this.teamService = teamService;
    }

    @PostConstruct
    private synchronized void init() {
        F1Team mclaren = F1Team.builder().teamName("McLaren")
                .nationality("United Kingdom")
                .firstEntryYear(1966)
                .worldChampionshipsWon(8)
                .racesWon(183)
                .chassis("MCL35M")
                .teamChief("Andreas Seidl")
                .build();

        F1Team ferrari = F1Team.builder().teamName("Ferrari")
                .nationality("Italy")
                .firstEntryYear(1950)
                .worldChampionshipsWon(16)
                .racesWon(239)
                .chassis("SF21")
                .teamChief("Mattia Binotto")
                .build();

        F1Team red_bull = F1Team.builder().teamName("Red Bull Racing")
                .nationality("Austria")
                .firstEntryYear(2005)
                .worldChampionshipsWon(4)
                .racesWon(72)
                .chassis("RB16B")
                .teamChief("Christian Horner")
                .build();

        F1Team mercedes = F1Team.builder().teamName("Mercedes-AMG")
                .nationality("Germany")
                .firstEntryYear(2010)
                .worldChampionshipsWon(7)
                .racesWon(112)
                .chassis("W12")
                .teamChief("Toto Wolff")
                .build();

        teamService.add(mclaren);
        teamService.add(ferrari);
        teamService.add(red_bull);
        teamService.add(mercedes);
    }
}
