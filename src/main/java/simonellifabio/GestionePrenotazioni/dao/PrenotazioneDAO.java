package simonellifabio.GestionePrenotazioni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simonellifabio.GestionePrenotazioni.entities.Postazione;
import simonellifabio.GestionePrenotazioni.entities.Prenotazione;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, UUID> {
    Optional<Prenotazione> findByPostazioneAndBookingDate(Postazione postazione, LocalDate data);
}
