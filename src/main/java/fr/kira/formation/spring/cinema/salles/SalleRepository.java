package fr.kira.formation.spring.cinema.salles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalleRepository extends JpaRepository<Salle, Integer> {
}
