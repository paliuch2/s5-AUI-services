package pl.paluszewski.kamil.Formula1.Team.Entity;

import org.springframework.stereotype.Service;
import pl.paluszewski.kamil.Formula1.Team.Event.Repository.F1TeamEventRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class F1TeamService {

    private F1TeamRepository repo;

    private F1TeamEventRepository eventRepository;

    public F1TeamService(F1TeamRepository repo, F1TeamEventRepository eventRepository) {

        this.repo = repo;
        this.eventRepository = eventRepository;
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
        eventRepository.create(team);
    }

    @Transactional
    public void delete(F1Team team) {
        eventRepository.delete(team);
        repo.delete(team);
    }

    @Transactional
    public void update(F1Team team) {
        repo.save(team);
    }
}
