package simonellifabio.GestionePrenotazioni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Postazione extends JpaRepository<Postazione, UUID> {
}
