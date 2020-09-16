package com.biblioteka.biblioteka.repository;

import com.biblioteka.biblioteka.model.Ksiazka;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KsiazkaRepository extends JpaRepository <Ksiazka,Long> {
}
