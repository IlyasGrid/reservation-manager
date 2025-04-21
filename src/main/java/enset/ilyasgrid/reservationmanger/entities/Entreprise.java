package enset.ilyasgrid.reservationmanger.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Entreprise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String activity;
    private String username;

    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

}
