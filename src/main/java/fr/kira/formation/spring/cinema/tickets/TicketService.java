package fr.kira.formation.spring.cinema.tickets;

import fr.kira.formation.spring.cinema.seances.Seance;
import fr.kira.formation.spring.cinema.seances.SeanceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository repository;
    private final SeanceService seanceService;

    public TicketService(TicketRepository repository, SeanceService seanceService) {
        this.repository = repository;
        this.seanceService = seanceService;
    }

    public List<Ticket> findTicketBySeance(Integer id){
        return this.repository.findBySeanceId(id);
    }

    public List<Ticket> getReservedTickets(Integer id) {
        return null;
    }

    public Ticket save(Ticket entity) {
        Seance seance = seanceService.findById(entity.getSeance().getId());

        if (seance.getNombrePlace() < entity.getNombrePlace()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pas assez de places disponibles");
        }

        seance.setNombrePlace(seance.getNombrePlace() - entity.getNombrePlace());
        entity.setSeance(seance);
        return repository.save(entity);
    }

    public Ticket findById(Integer integer) {
        return repository.findById(integer).orElseThrow();
    }

    public void deleteById(Integer integer) {
        repository.deleteById(integer);
    }

    public Iterable<Ticket> findAll() {
        return repository.findAll();
    }



}
