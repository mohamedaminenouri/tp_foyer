package com.example.tpfoyer.services;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.repository.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{
   BlocRepository blocRepository;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll() ;
    }

    @Override
    public Bloc retrieveBloc(Long blocId) {
        Bloc bloc = blocRepository.findById(blocId).get();
        if (bloc != null) {
            return bloc;

        } else return null;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        Bloc  ch = blocRepository.save(bloc);
        if (ch !=null){
            return  ch;
        }
        return null;
    }

    @Override
    public void removeBloc(Long blocId) {

        blocRepository.deleteById(blocId);
        System.out.println("bloc supprime");
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
       return blocRepository.save(bloc);
    }
}
