package simonellifabio.GestionePrenotazioni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simonellifabio.GestionePrenotazioni.entities.Edificio;

import java.util.UUID;

@Repository
public interface EdificioDAO extends JpaRepository<Edificio, UUID> {
}
