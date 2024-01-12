package simonellifabio.GestionePrenotazioni.exceptions;

import java.util.UUID;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(UUID id){
        super("non è stato trovato nessun elemento con l'id: " + id);
    }
    public ItemNotFoundException(){
        super("non è stato trovato nessun elemento");
    }
}
