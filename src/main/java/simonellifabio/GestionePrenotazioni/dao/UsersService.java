package simonellifabio.GestionePrenotazioni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simonellifabio.GestionePrenotazioni.entities.Utente;
import simonellifabio.GestionePrenotazioni.exceptions.InvalidEmailException;
import simonellifabio.GestionePrenotazioni.exceptions.InvalidInputException;
import simonellifabio.GestionePrenotazioni.exceptions.ItemNotFoundException;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsersService {
    @Autowired
    private UsersDAO usersDAO;

    public void saveUser(Utente user) {
        String name = user.getName();
        String username = user.getUsername();
        String surname = user.getSurname();
        String email = user.getEmail();
        if (name == null || username == null || surname == null || email == null) {
            throw new IllegalArgumentException();
        }
        if (name.trim().length() < 2) {
            throw new InvalidInputException(name);
        }
        if (username.trim().length() < 2) {
            throw new InvalidInputException(username);
        }
        if (surname.trim().length() < 2) {
            throw new InvalidInputException(surname);
        }

        String[] emailParts = email.split("@");
        if (emailParts.length != 2) {
            throw new InvalidEmailException(email);
        }
        if (emailParts[0].isEmpty() || emailParts[1].isEmpty()) {
            throw new InvalidEmailException(email);
        }

        usersDAO.save(user);
    }

    public void removeUser(UUID id) {
        Optional<Utente> user = usersDAO.findById(id);
        user.ifPresentOrElse(utente -> usersDAO.delete(utente), () -> {
            throw new ItemNotFoundException(id);
        });
    }
}
