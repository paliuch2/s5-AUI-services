package pl.paluszewski.kamil.Formula1.Driver.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;
import java.util.List;
import java.util.Optional;

@Repository
public interface F1DriverRepository extends JpaRepository<F1Driver, Integer> {

    List<F1Driver> findAllByTeam(F1Team team);

    Optional<F1Driver> findByStartingNoAndTeam (Integer no, F1Team t);
}
