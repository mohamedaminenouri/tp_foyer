package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Universite;
import com.example.tpfoyer.services.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    IUniversiteService universiteService;

    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.retrieveAllUniversites();
        if (listUniversites.size()>0){
            return listUniversites;
        }
        return listUniversites;
    }

    // http://localhost:8089/tpfoyer/universite/retrieve-universite/8
    @GetMapping("/retrieve-universite/{universite-id}")
    public ResponseEntity<Object> retrieveUniversite(@PathVariable("universite-id") Long chId) {
        Universite universite = universiteService.retrieveUniversite(chId);
        if (universite !=null){
            return  new ResponseEntity<>(universite, HttpStatus.OK);
        }
      return new ResponseEntity<>("error ",HttpStatus.CONFLICT);
    }

    @PostMapping("/add-universite")
    public ResponseEntity<Object> addUniversite(@RequestBody Universite c) {
        Universite universite = universiteService.addUniversite(c);
        if(universite!=null){
            return new ResponseEntity<>(universite,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(" error ",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long chId) {
        universiteService.removeUniversite(chId);
    }

    @PutMapping("/modify-universite")
    public ResponseEntity modifyUniversite(@RequestBody Universite c) {
        if  (universiteService.modifyUniversite(c) !=null){
            return new ResponseEntity(universiteService.modifyUniversite(c),HttpStatus.OK);
        }

       return new ResponseEntity("error ",HttpStatus.CONFLICT);
    }

}
