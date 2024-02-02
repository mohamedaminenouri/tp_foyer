package com.example.tpfoyer.services;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.entity.Etudiant;
import com.example.tpfoyer.entity.Etudiant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEtudiantService<T> {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant retrieveEtudiant(Long etudiantId);
    Etudiant addEtudiant(Etudiant c);
    void removeEtudiant(Long etudiantId);

    Etudiant modifyEtudiant(Etudiant etudiant);
}

