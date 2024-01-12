package simonellifabio.GestionePrenotazioni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simonellifabio.GestionePrenotazioni.entities.Prenotazione;

import java.util.UUID;
@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, UUID> {
}
