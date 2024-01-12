package simonellifabio.GestionePrenotazioni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simonellifabio.GestionePrenotazioni.entities.Postazione;
import simonellifabio.GestionePrenotazioni.entities.Prenotazione;
import simonellifabio.GestionePrenotazioni.entities.Utente;
import simonellifabio.GestionePrenotazioni.exceptions.AlreadyBookedException;
import simonellifabio.GestionePrenotazioni.exceptions.ItemNotFoundException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void savePrenotazione(Prenotazione prenotazione){
        if(!isPostazioneLibera(prenotazione.getPostazione(), prenotazione.getBookingDate())){
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

    public boolean isPostazioneLibera(Postazione postazione, LocalDate date){
        return prenotazioneDAO.findByPostazioneAndBookingDate(postazione, date).isEmpty();
    }

//    public void prenotaPostazione(Utente user, Postazione postazione, LocalDate date){
//        if(!isPostazioneLibera(postazione, date)){
//            throw new AlreadyBookedException();
//        }
//        Prenotazione prenotazione = new Prenotazione();
//        prenotazione.setUtente(user);
//        prenotazione.setPostazione(postazione);
//        prenotazione.setBookingDate(date);
//        prenotazioneDAO.save(prenotazione);
//    }
}
