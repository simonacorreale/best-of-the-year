package com.best.of.the.year.java.best_of_the_year.controller;

// -----------------
// Step 2 ✅
// Classe movie
public class Movie {

    private final int id;
    private final String titolo;

    public Movie(int id, String titolo) {
        this.id = id;
        this.titolo = titolo;

    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

}
