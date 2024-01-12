package simonellifabio.GestionePrenotazioni;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import simonellifabio.GestionePrenotazioni.dao.EdificioService;
import simonellifabio.GestionePrenotazioni.dao.PostazioneService;
import simonellifabio.GestionePrenotazioni.dao.PrenotazioneService;
import simonellifabio.GestionePrenotazioni.dao.UsersService;
import simonellifabio.GestionePrenotazioni.entities.Edificio;
import simonellifabio.GestionePrenotazioni.entities.Postazione;
import simonellifabio.GestionePrenotazioni.entities.Prenotazione;
import simonellifabio.GestionePrenotazioni.entities.Utente;
import simonellifabio.GestionePrenotazioni.entities.enums.StationType;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    UsersService usersService;
    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    PostazioneService postazioneService;
    @Autowired
    EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception{
        Faker faker = new Faker();

        Edificio edificio = new Edificio();
        edificio.setName(faker.university().name());
        edificio.setAddress(faker.address().fullAddress());
        edificio.setCity(faker.address().city());

        Postazione postazione = new Postazione();
        postazione.setDescription(faker.shakespeare().asYouLikeItQuote());
        postazione.setMaxPeople(10);
        postazione.setType(StationType.OPENSPACE);
        postazione.setEdificio(edificio);

        Utente user = new Utente();
        user.setName(faker.name().firstName());
        user.setSurname(faker.name().lastName());
        user.setUsername(faker.name().username());
        user.setEmail(faker.internet().emailAddress());

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setAlreadyBooked(false);
        prenotazione.setBookingDate(LocalDate.now());
        prenotazione.setPostazione(postazione);
        prenotazione.setUtente(user);

        edificioService.saveEdificio(edificio);
        postazioneService.savePostazione(postazione);
        usersService.saveUser(user);
        prenotazioneService.savePrenotazione(prenotazione);
    }
}
