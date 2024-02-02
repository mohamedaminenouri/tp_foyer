package com.example.tpfoyer.services;

import com.example.tpfoyer.entity.Etudiant;
import com.example.tpfoyer.entity.Etudiant;
import com.example.tpfoyer.repository.EtudiantRepository;
import com.example.tpfoyer.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class EtudiantServiceImpl implements IEtudiantService{
    EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {

        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant retrieveEtudiant(Long etudiantId) {
        Etudiant ch = etudiantRepository.findById(etudiantId).get();
        if (ch != null) {
            return ch;

        } else return null;
    }

    @Override
    public Etudiant addEtudiant(Etudiant c) {

     return  etudiantRepository.save(c);

    }

    @Override
    public void removeEtudiant(Long etudiantId) {

        etudiantRepository.deleteById(etudiantId);
        System.out.println("etudiant supprime");
    }

    @Override
    public Etudiant modifyEtudiant(Etudiant etudiant) {

        if(etudiantRepository.save(etudiant) !=null){
            return etudiant;
        }
        return null;
    }
}
