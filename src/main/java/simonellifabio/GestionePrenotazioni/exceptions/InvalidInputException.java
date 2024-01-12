package simonellifabio.GestionePrenotazioni.exceptions;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String field){
        super(field + " non è valido. nome, cognome e username non possono essere inferiori a 2 caratteri.");
    }
}
