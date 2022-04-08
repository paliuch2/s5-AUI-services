package pl.paluszewski.kamil.Formula1.Team.Entity;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class F1TeamService {

    private F1TeamRepository repo;

    public F1TeamService(F1TeamRepository repo) {
        this.repo = repo;
    }

    public Optional<F1Team> find(String name) {
        return repo.findById(name);
    }

    public List<F1Team> findAll() {
        return repo.findAll();
    }

    @Transactional
    public void add(F1Team team) {
        repo.save(team);
    }

    @Transactional
    public void delete(String name) {
        repo.deleteById(name);
    }

    @Transactional
    public void update(F1Team team) {
        repo.save(team);
    }
}
