package com.best.of.the.year.java.best_of_the_year.controller;

// -----------------
// Step 2 ✅
// Classe song

public class Songs {

    private final int id;
    private final String titolo;

    private final String artista;
    private final String anno;

    public Songs(int id, String titolo, String artista, String anno) {
        this.id = id;
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;

    }

    public String getArtista() {
        return artista;
    }

    public String getAnno() {
        return anno;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }
}
