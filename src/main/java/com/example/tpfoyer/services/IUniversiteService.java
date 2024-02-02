package com.example.tpfoyer.services;

import com.example.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite retrieveUniversite(Long universiteId);
    Universite addUniversite(Universite universite);
    void removeUniversite(Long universiteId);

    Universite modifyUniversite(Universite universite);
}
