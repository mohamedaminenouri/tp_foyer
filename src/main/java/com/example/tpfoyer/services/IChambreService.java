package com.example.tpfoyer.services;

import com.example.tpfoyer.entity.Chambre;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IChambreService {
     List<Chambre> retrieveAllChambres();
     Chambre retrieveChambre(Long chambreId);
     Chambre addChambre(Chambre c);
     void removeChambre(Long chambreId);

     Chambre modifyChambre(Chambre chambre);
}
