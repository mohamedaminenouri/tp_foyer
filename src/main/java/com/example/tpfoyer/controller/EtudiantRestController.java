package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Etudiant;
import com.example.tpfoyer.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {

    IEtudiantService etudiantService;

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        if (listEtudiants.size()>0){
            return listEtudiants;
        }
        return listEtudiants;
    }

    // http://localhost:8089/tpfoyer/etudiant/retrieve-etudiant/8
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public ResponseEntity<Object> retrieveEtudiant(@PathVariable("etudiant-id") Long etuId) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(etuId);
        if (etudiant !=null){
            return  new ResponseEntity<>(etudiant, HttpStatus.OK);
        }
      return new ResponseEntity<>("error ",HttpStatus.CONFLICT);
    }

    @PostMapping("/add-etudiant")
    public ResponseEntity<Object> addEtudiant(@RequestBody Etudiant c) {
        Etudiant etudiant = etudiantService.addEtudiant(c);
        if(etudiant!=null){
            return new ResponseEntity<>(etudiant,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(" error ",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long chId) {
        etudiantService.removeEtudiant(chId);
    }

    @PutMapping("/modify-etudiant")
    public ResponseEntity modifyEtudiant(@RequestBody Etudiant c) {
        if  (etudiantService.modifyEtudiant(c) !=null){
            return new ResponseEntity(etudiantService.modifyEtudiant(c),HttpStatus.OK);
        }

       return new ResponseEntity("error ",HttpStatus.CONFLICT);
    }
}
