package com.biblioteka.biblioteka.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@Table(name="Student")
@NoArgsConstructor
@AllArgsConstructor
public class Ksiazka {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String nazwiskoAutora;
    private String tytul;
    private boolean czyDlaDoroslych;
    private int ileSztuk;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "ksiazka")
    private List<Czytelnik> listaCzytelnikow;



}
