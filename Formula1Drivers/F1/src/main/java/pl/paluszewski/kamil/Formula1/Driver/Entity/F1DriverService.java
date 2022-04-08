package pl.paluszewski.kamil.Formula1.Driver.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.paluszewski.kamil.Formula1.Team.Entity.F1Team;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class F1DriverService {

    private F1DriverRepository repo;

    @Autowired
    public F1DriverService(F1DriverRepository repo) {
        this.repo = repo;
    }

    public Optional<F1Driver> find(Integer startingNo) {
        return repo.findById(startingNo);
    }

    public Optional<F1Driver> find(Integer no, F1Team t) {
        return repo.findByStartingNoAndTeam(no, t);
    }

    public List<F1Driver> findAll() {
        return repo.findAll();
    }

    public List<F1Driver> findAll(F1Team team) {
        return repo.findAllByTeam(team);
    }

    @Transactional
    public F1Driver add(F1Driver driver) {
        return repo.save(driver);
    }

    @Transactional
    public void delete(Integer startingNo) {
        repo.deleteById(startingNo);
    }

    @Transactional
    public void update(F1Driver driver) {
        repo.save(driver);
    }

}
