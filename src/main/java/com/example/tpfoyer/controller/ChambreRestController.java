package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.services.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService chambreService;

    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        if (listChambres.size()>0){
            return listChambres;
        }
        return listChambres;
    }

    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public ResponseEntity<Object> retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        if (chambre !=null){
            return  new ResponseEntity<>(chambre, HttpStatus.OK);
        }
      return new ResponseEntity<>("error ",HttpStatus.CONFLICT);
    }

    @PostMapping("/add-chambre")
    public ResponseEntity<Object> addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        if(chambre!=null){
            return new ResponseEntity<>(chambre,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(" error ",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }

    @PutMapping("/modify-chambre")
    public ResponseEntity modifyChambre(@RequestBody Chambre c) {
        if  (chambreService.modifyChambre(c) !=null){
            return new ResponseEntity(chambreService.modifyChambre(c),HttpStatus.OK);
        }

       return new ResponseEntity("error ",HttpStatus.CONFLICT);
    }

}
