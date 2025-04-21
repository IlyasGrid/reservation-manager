package enset.ilyasgrid.reservationmanger.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateReservation;
    private int duree;
    private double cout;

    @Enumerated(EnumType.STRING)
    private TypeReservation typeReservation;

    @Enumerated(EnumType.STRING)
    private EtatReservation etat;

    @ManyToOne
    private Entreprise entreprise;


}
