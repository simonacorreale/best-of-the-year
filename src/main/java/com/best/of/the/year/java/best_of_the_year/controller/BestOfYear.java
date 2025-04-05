package com.best.of.the.year.java.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* 

-> Exercizio ripreso il 5 aprile per motivi personali
Esercitazione di oggi: Spring MVC - Best of the year
Nome repo: best-of-the-year
Le modalità di consegna sono le solite, con repo github da associare alla cartella di progetto java.
Cosa fare?
Step 1
Creare un nuovo progetto Spring Boot MVC + Thymeleaf (vedi tutorial sulle slide).
Il nome del progetto è best-of-the-year (stesso nome del repo).
Nel progetto aggiungere un controller che risponde alla root dell’applicazione, con un metodo che restituisce una view fatta con Thymeleaf in cui viene stampato un titolo: “Best of the year by …” (al posto dei puntini deve apparire il vostro nome, passato come attributo dal controller attraverso il Model).
Step 2
Creare all’interno del controller due metodi privati :
- uno restituisce una lista di oggetti di tipo Movie - getBestMovies()
- l’altro restituisce una lista di  oggetti di tipo Song - getBestSongs()
Creare le classi Movie e Song aventi almeno :
- un id
- un titolo
Aggiungere al controller altri due metodi, che rispondono agli url
- “/movies”
- “/songs”
In ognuno di questi metodi aggiungere al Model un attributo stringa con una lista di titoli di migliori film o canzoni (in base al metodo che stiamo implementando) separati da virgole.
Utilizzare i due metodi getBest… per recuperare i film e le canzoni.
Creare i rispettivi template Thymeleaf.
Creare due metodi
- “/movies/{id}”
- “/songs/{id}”
che dato il parametro id passato tramite il path, mostri in pagina il titolo relativo al film / canzone.
Testare chiamando dal browser i diversi url.
Buon lavoro! (edited)  */
@Controller
@RequestMapping("/")
public class BestOfYear {

    // Best of nome in index
    @GetMapping("/index")
    public String controllerMain(Model model) {
        // Il mio nome
        model.addAttribute("name", "Simona Correale");
        System.out.println("ciao");
        return "index";

    }

    private List<Movie> getBestMovies() {
        List<Movie> film = new ArrayList<>();

        // Lista di film
        film.add(new Movie(232, "Film 1"));
        film.add(new Movie(222, "Film 2"));
        film.add(new Movie(242, "Film 3"));
        film.add(new Movie(252, "Film 4"));

        return film;
    }

    private List<Songs> getBestSongs() {
        List<Songs> canzoni = new ArrayList<>();

        // Lista di canzoni
        canzoni.add(new Songs(232, "Song 1"));
        canzoni.add(new Songs(222, "Song 2"));
        canzoni.add(new Songs(242, "Song 3"));
        canzoni.add(new Songs(252, "Song 4"));

        return canzoni;
    }

    // URL "/movie"
    @GetMapping("/movie")
    public String bestMovies(Model model) {

        List<Movie> movie = getBestMovies();
        model.addAttribute("movie", movie);
        return "movie";
    }

    // URL "/songs"
    @GetMapping("/songs")
    public String bestSongs(Model model) {
        List<Songs> song = getBestSongs();
        model.addAttribute("songs", song);

        return "songs";
    }
    /*
     * // URL "/movies/{id}"
     * 
     * @GetMapping("path")
     * public String getMethodName(@RequestParam String param) {
     * return new String();
     * }
     */

    /*
     * // URL "/songs/{id}"
     * 
     * @GetMapping("path")
     * public String getMethodName(@RequestParam String param) {
     * return new String();
     * }
     */

}
