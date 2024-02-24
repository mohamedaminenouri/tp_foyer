package com.example.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;
  @ManyToOne
    private  Bloc bloc;

  @OneToMany(fetch = FetchType.EAGER)

    private Set<Reservation> listReservation;

}
