package simonellifabio.GestionePrenotazioni.exceptions;

public class AlreadyBookedException extends RuntimeException{
    public AlreadyBookedException(){
        super("la postazione è già stata prenotata per quella data.");
    }
}
