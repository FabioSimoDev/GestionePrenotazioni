package simonellifabio.GestionePrenotazioni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simonellifabio.GestionePrenotazioni.entities.Edificio;
import simonellifabio.GestionePrenotazioni.entities.Postazione;
import simonellifabio.GestionePrenotazioni.entities.Prenotazione;
import simonellifabio.GestionePrenotazioni.entities.enums.StationType;
import simonellifabio.GestionePrenotazioni.exceptions.ItemNotFoundException;

import java.util.Optional;
import java.util.UUID;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneDAO postazioneDAO;

    public void savePostazione(Postazione postazione){
        String description = postazione.getDescription();
        int maxPeople = postazione.getMaxPeople();
        StationType type = postazione.getType();
        Edificio edificio = postazione.getEdificio();
        if(description == null || maxPeople == 0 || type == null || edificio == null){
            throw new IllegalArgumentException();
        }
        postazioneDAO.save(postazione);
    }

    public void removePostazione(UUID id){
        Optional<Postazione> postazione = postazioneDAO.findById(id);
        postazione.ifPresentOrElse(postazione1 -> postazioneDAO.delete(postazione1), () -> {
            throw new ItemNotFoundException(id);
        });
    }
}
