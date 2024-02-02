package com.example.tpfoyer.services;


import com.example.tpfoyer.entity.Universite;
import com.example.tpfoyer.repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{
    UniversiteRepository universiteRepository;


    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long universiteId) {

         Universite universite=universiteRepository.findById(universiteId).get();
              if( universite !=null){
                 return  universite;
              }
              return  null;
    }

    @Override
    public Universite addUniversite(Universite universite) {
        Universite unvt=universiteRepository.save(universite);
        if (unvt!=null){
            return  unvt;
        }
        return null;
    }

    @Override
    public void removeUniversite(Long universiteId) {
        universiteRepository.deleteById(universiteId);
        System.out.println("suppression avec success");
    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        Universite unvt=universiteRepository.save(universite);
        if (unvt!=null){
            return unvt;
        }
        else return null;
    }
}
