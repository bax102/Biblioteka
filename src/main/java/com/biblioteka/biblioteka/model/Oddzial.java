package com.biblioteka.biblioteka.model;

public enum Oddzial {

    GDAŃSK  ("Gdańsk"),
    SOPOT ("Sopot"),
    GDYNIA ("Gdynia");

    private String opis;

    Oddzial(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }
}
