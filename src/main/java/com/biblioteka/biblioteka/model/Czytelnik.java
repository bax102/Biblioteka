package com.biblioteka.biblioteka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Czytelnik {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private Oddzial Oddzial;

    private String nazwiskoCzytelnika;

    @CreationTimestamp
    private LocalDateTime dataDodania;

    @ManyToOne()
    private Ksiazka ksiazka;

    public Czytelnik(Oddzial oddzial, String nazwiskoCzytelnika) {
        this.Oddzial = oddzial;
        this.nazwiskoCzytelnika = nazwiskoCzytelnika;
    }
}
