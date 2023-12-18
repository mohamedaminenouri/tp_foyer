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
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;
   @OneToOne(mappedBy = "foyer")
    private Universite universite;
   @OneToMany(mappedBy = "foyer")
    private Set<Bloc> listBloc;

}
