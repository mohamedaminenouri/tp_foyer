package com.example.tpfoyer.services;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.entity.Chambre;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBlocService  {
    List<Bloc> retrieveAllBlocs();
    Bloc retrieveBloc(Long blocId);
    Bloc addBloc(Bloc bloc);
    void removeBloc(Long blocId);

    Bloc modifyBloc(Bloc bloc);
}
