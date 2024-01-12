package simonellifabio.GestionePrenotazioni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simonellifabio.GestionePrenotazioni.entities.Prenotazione;
import simonellifabio.GestionePrenotazioni.entities.Utente;
import simonellifabio.GestionePrenotazioni.exceptions.AlreadyBookedException;
import simonellifabio.GestionePrenotazioni.exceptions.ItemNotFoundException;

import java.util.Optional;
import java.util.UUID;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void savePrenotazione(Prenotazione prenotazione){
        if(prenotazione.isAlreadyBooked()){
            throw new AlreadyBookedException();
        }
        prenotazioneDAO.save(prenotazione);
    }

    public void removePrenotazione(UUID id){
        Optional<Prenotazione> prenotazione = prenotazioneDAO.findById(id);
        prenotazione.ifPresentOrElse(prenotazione1 -> prenotazioneDAO.delete(prenotazione1), () -> {
            throw new ItemNotFoundException(id);
        });
    }
}
