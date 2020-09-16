package com.biblioteka.biblioteka.service;

import com.biblioteka.biblioteka.model.Czytelnik;
import com.biblioteka.biblioteka.model.Ksiazka;
import com.biblioteka.biblioteka.repository.OddzialRepository;
import com.biblioteka.biblioteka.repository.KsiazkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CzytelnikService {

    @Autowired
    private KsiazkaRepository ksiazkaRepository;

    @Autowired
    private OddzialRepository oddzialRepository;

    public void saveGatunek (Czytelnik czytelnik, Long ksiazkaId){
        Optional<Ksiazka> ksiazkaOptional= ksiazkaRepository.findById(ksiazkaId);
        if(ksiazkaOptional.isPresent()){
            Ksiazka ksiazka = ksiazkaOptional.get();
            czytelnik.setKsiazka(ksiazka);
            oddzialRepository.save(czytelnik);
        }
    }


    public Optional<Czytelnik> findById (Long gatunekId){
        return oddzialRepository.findById(gatunekId);
    }

}
