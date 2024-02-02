package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.services.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        if (listBlocs.size()>0){
            return listBlocs;
        }
        return listBlocs;
    }

    // http://localhost:8089/tpfoyer/bloc/retrieve-bloc/8
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public ResponseEntity<Object> retrieveBloc(@PathVariable("bloc-id") Long chId) {
        Bloc bloc = blocService.retrieveBloc(chId);
        if (bloc !=null){
            return  new ResponseEntity<>(bloc, HttpStatus.OK);
        }
      return new ResponseEntity<>("error ",HttpStatus.CONFLICT);
    }

    @PostMapping("/add-bloc")
    public ResponseEntity<Object> addBloc(@RequestBody Bloc c) {
        Bloc bloc = blocService.addBloc(c);
        if(bloc!=null){
            return new ResponseEntity<>(bloc,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(" error ",HttpStatus.CONFLICT);
    }

    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long chId) {
        blocService.removeBloc(chId);
    }

    @PutMapping("/modify-bloc")
    public ResponseEntity modifyBloc(@RequestBody Bloc c) {
        if  (blocService.modifyBloc(c) !=null){
            return new ResponseEntity(blocService.modifyBloc(c),HttpStatus.OK);
        }

       return new ResponseEntity("error ",HttpStatus.CONFLICT);
    }

}
