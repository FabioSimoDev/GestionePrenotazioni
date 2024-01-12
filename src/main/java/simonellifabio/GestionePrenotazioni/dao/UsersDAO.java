package simonellifabio.GestionePrenotazioni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simonellifabio.GestionePrenotazioni.entities.Utente;

import java.util.UUID;

@Repository
public interface UsersDAO extends JpaRepository<Utente, UUID> {
}
