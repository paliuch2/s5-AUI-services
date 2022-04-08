package pl.paluszewski.kamil.Formula1.Team.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface F1TeamRepository extends JpaRepository<F1Team, String> {

}
