package simonellifabio.GestionePrenotazioni;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import simonellifabio.GestionePrenotazioni.dao.PostazioneDAO;
import simonellifabio.GestionePrenotazioni.dao.PostazioneService;
import simonellifabio.GestionePrenotazioni.dao.PrenotazioneService;
import simonellifabio.GestionePrenotazioni.dao.UsersService;
import simonellifabio.GestionePrenotazioni.entities.Edificio;
import simonellifabio.GestionePrenotazioni.entities.Postazione;
import simonellifabio.GestionePrenotazioni.entities.Prenotazione;
import simonellifabio.GestionePrenotazioni.entities.Utente;
import simonellifabio.GestionePrenotazioni.entities.enums.StationType;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class GestionePrenotazioniApplication {

	public static <UtenteService> void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		PrenotazioneService prenotazioneService = new PrenotazioneService();
		UsersService utenteService = new UsersService();
		PostazioneService postazioneService = new PostazioneService();

		System.out.println("Inserisci la tua email:");
		String email = scanner.nextLine();
		Utente utente = utenteService.getUtenteByEmail(email);

		for(Prenotazione prenotazione : utente.getPrenotazioni()){
			if(Objects.equals(prenotazione.getBookingDate(), LocalDate.now())){
				System.out.println("Hai già delle prenotazioni attive per oggi.");
			}else{
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
				Prenotazione prenotazione1 = new Prenotazione();
				prenotazione.setAlreadyBooked(false);
				prenotazione.setBookingDate(LocalDate.now());
				prenotazione.setPostazione(postazione);
				prenotazione.setUtente(utente);
				prenotazioneService.savePrenotazione(prenotazione);
			}
		}
	}

}
