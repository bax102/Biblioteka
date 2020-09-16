package com.biblioteka.biblioteka.service;

import com.biblioteka.biblioteka.model.Ksiazka;
import com.biblioteka.biblioteka.repository.KsiazkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KsiazkaService {

    @Autowired
    private KsiazkaRepository ksiazkaRepository;


    public void add(Ksiazka ksiazka) {
        ksiazkaRepository.save(ksiazka);
    }

    public List<Ksiazka> getBazaDanych(){

       return ksiazkaRepository.findAll();
    }

    public void deleteById (Long ksiazkaIdentifier){
        ksiazkaRepository.deleteById(ksiazkaIdentifier);
    }

    public Optional<Ksiazka> findKsiazka (Long id){
        return ksiazkaRepository.findById(id);
    }
}

