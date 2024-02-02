package com.example.tpfoyer.services;

import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {

        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambre(Long chambreId) {
        Chambre ch = chambreRepository.findById(chambreId).get();
        if (ch != null) {
            return ch;

        } else return null;
    }

    @Override
    public Chambre addChambre(Chambre c) {

        Chambre ch = chambreRepository.save(c);
            if (ch !=null){
              return  ch;
            }
            return null;
    }

    @Override
    public void removeChambre(Long chambreId) {

     chambreRepository.deleteById(chambreId);
        System.out.println("chambre supprime");
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        Chambre oldChambre = chambreRepository.findById(chambre.getIdChambre()).get();
        oldChambre.setNumeroChambre(chambre.getNumeroChambre());
        oldChambre.setTypeChambre(chambre.getTypeChambre());
        oldChambre.setBloc(chambre.getBloc());
        if(oldChambre !=null){
            return chambre;
        }
        return null;
    }
}
