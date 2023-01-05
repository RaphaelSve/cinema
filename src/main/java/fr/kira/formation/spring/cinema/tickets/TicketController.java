package fr.kira.formation.spring.cinema.tickets;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
@CrossOrigin
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public Ticket save(@RequestBody Ticket entity) {
        return service.save(entity);
    }

    @GetMapping("{id}")
    public Ticket findById(@PathVariable Integer integer) {
        return service.findById(integer);
    }

    @GetMapping("{seances}")
    public List<Ticket> getReservedTicket(@PathVariable Integer id) {
        return service.findTicketBySeance(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer integer) {
        service.deleteById(integer);
    }

    @GetMapping
    public Iterable<Ticket> findAll() {
        return service.findAll();
    }

}
