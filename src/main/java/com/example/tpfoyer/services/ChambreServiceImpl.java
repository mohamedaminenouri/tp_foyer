package com.example.tpfoyer.services;

import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;


   // @Scheduled(fixedDelay = 5000)
    @Scheduled(cron = "15 * * * * *")
    @Override
    public List<Chambre> retrieveAllChambres() {
          List<Chambre> chambres=chambreRepository.findAll();
          log.info("nombre de chambre "+chambres.size());
          for(int i=0;i<chambres.size();i++){
              log.info("chambre  "+chambres.get(i));
          }
        return chambres;
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

    /*  le AOP est un code qui s'execute au moment de l'execution */
}
