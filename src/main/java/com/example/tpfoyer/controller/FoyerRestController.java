package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Foyer;
import com.example.tpfoyer.services.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    IFoyerService foyerService;

    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = foyerService.retrieveAllFoyers();
        if (listFoyers.size()>0){
            return listFoyers;
        }
        return listFoyers;
    }

    // http://localhost:8089/tpfoyer/foyer/retrieve-foyer/8
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public ResponseEntity<Object> retrieveFoyer(@PathVariable("foyer-id") Long chId) {
        Foyer foyer = foyerService.retrieveFoyer(chId);
        if (foyer !=null){
            return  new ResponseEntity<>(foyer, HttpStatus.OK);
        }
      return new ResponseEntity<>("error ",HttpStatus.CONFLICT);
    }

    @PostMapping("/add-foyer")
    public ResponseEntity<Object> addFoyer(@RequestBody Foyer c) {
        Foyer foyer = foyerService.addFoyer(c);
        if(foyer!=null){
            return new ResponseEntity<>(foyer,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(" error ",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long chId) {
        foyerService.removeFoyer(chId);
    }

    @PutMapping("/modify-foyer")
    public ResponseEntity modifyFoyer(@RequestBody Foyer c) {
        if  (foyerService.modifyFoyer(c) !=null){
            return new ResponseEntity(foyerService.modifyFoyer(c),HttpStatus.OK);
        }

       return new ResponseEntity("error ",HttpStatus.CONFLICT);
    }

}
