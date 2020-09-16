package com.biblioteka.biblioteka.repository;


import com.biblioteka.biblioteka.model.Czytelnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OddzialRepository extends JpaRepository <Czytelnik, Long> {
}
