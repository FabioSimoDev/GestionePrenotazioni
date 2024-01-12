package simonellifabio.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;
import simonellifabio.GestionePrenotazioni.entities.enums.StationType;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Postazione")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Postazione {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    private StationType type;
    private int maxPeople;
    @ManyToOne
    private Edificio edificio;
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;
}
