package simonellifabio.GestionePrenotazioni.exceptions;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(String email){
        super(email + " non è un indirizzo email valido.");
    }
}
