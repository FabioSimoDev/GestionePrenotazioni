package simonellifabio.GestionePrenotazioni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simonellifabio.GestionePrenotazioni.entities.Edificio;
import simonellifabio.GestionePrenotazioni.entities.Postazione;
import simonellifabio.GestionePrenotazioni.exceptions.ItemNotFoundException;

import java.util.Optional;
import java.util.UUID;

@Service
public class EdificioService {
    @Autowired
    private EdificioDAO edificioDAO;

    public void saveEdificio(Edificio edificio){
        String name = edificio.getName();
        String address = edificio.getAddress();
        String city = edificio.getCity();
        if(name == null || address == null || city == null){
            throw new IllegalArgumentException();
        }

        edificioDAO.save(edificio);
    }

    public void deleteEdificio(UUID id){
        Optional<Edificio> edificio = edificioDAO.findById(id);
        edificio.ifPresentOrElse(edificio1 -> edificioDAO.delete(edificio1), () -> {
            throw new ItemNotFoundException(id);
        });
    }
}
