package com.example.tpfoyer.services;

import com.example.tpfoyer.entity.Foyer;
import com.example.tpfoyer.repository.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService{
    FoyerRepository foyerRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {

        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long foyerId) {
        Foyer ch = foyerRepository.findById(foyerId).get();
        if (ch != null) {
            return ch;

        } else return null;
    }

    @Override
    public Foyer addFoyer(Foyer c) {

        Foyer ch = foyerRepository.save(c);
        if (ch !=null){
            return  ch;
        }
        return null;
    }

    @Override
    public void removeFoyer(Long foyerId) {

        foyerRepository.deleteById(foyerId);
        System.out.println("foyer supprime");
    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {

        if(foyerRepository.save(foyer) !=null){
            return foyer;
        }
        return null;
    }
}
