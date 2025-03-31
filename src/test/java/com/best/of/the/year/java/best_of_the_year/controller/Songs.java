package com.best.of.the.year.java.best_of_the_year.controller;

public class Songs {

    private final int id;
    private final String titolo;

    public Songs(int id, String titolo) {
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
