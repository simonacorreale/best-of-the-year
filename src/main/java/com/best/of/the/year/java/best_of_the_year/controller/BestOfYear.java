package com.best.of.the.year.java.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* 

-> Exercizio ripreso il 5 aprile per motivi personali   
Esercitazione di oggi: Spring MVC - Best of the year
Nome repo: best-of-the-year

Step 1
Creare un nuovo progetto Spring Boot MVC + Thymeleaf (vedi tutorial sulle slide).✅
Il nome del progetto è best-of-the-year (stesso nome del repo).✅
Nel progetto aggiungere un controller che risponde alla root dell’applicazione, con un metodo che 
restituisce una view fatta con Thymeleaf in cui viene stampato un titolo: 
“Best of the year by …” (al posto dei puntini deve apparire il vostro nome, passato come attributo dal 
controller attraverso il Model).✅
_______________

Step 2
Creare all’interno del controller due metodi privati:
- uno restituisce una lista di oggetti di tipo Movie - getBestMovies()✅
- l’altro restituisce una lista di  oggetti di tipo Song - getBestSongs()✅
Creare le classi Movie e Song aventi almeno :
- un id✅
- un titolo✅
_______________

Aggiungere al controller altri due metodi, che rispondono agli url
- “/movies”✅
- “/songs”✅
_______________

In ognuno di questi metodi aggiungere al Model un attributo stringa con una lista di titoli di migliori film o canzoni 
(in base al metodo che stiamo implementando) separati da virgole.
Utilizzare i due metodi getBest… per recuperare i film e le canzoni.
Creare i rispettivi template Thymeleaf.

Creare due metodi - Non completo☄️
- “/movies/{id}”
- “/songs/{id}”
che dato il parametro id passato tramite il path, mostri in pagina il titolo relativo al film / canzone.
Testare chiamando dal browser i diversi url.
Buon lavoro! (edited)  

________________

*/

@Controller
@RequestMapping("/")
public class BestOfYear {

    // Step 1 ✅
    // Best of nome in index

    @GetMapping("/index")
    public String controllerMain(Model model) {
        // Il mio nome
        model.addAttribute("name", "Simona Correale 👩🏻");
        System.out.println("ciao");
        return "index";
    }

    // -----------------
    // Step 2 ✅
    // Metodo per la lista delel canzoni ✅

    // Metodo per la lista delel Film ✅
    private List<Movie> getBestMovies() {
        List<Movie> film = new ArrayList<>();

        // Lista di film ✅
        film.add(new Movie(232, "Film 1"));
        film.add(new Movie(222, "Film 2"));
        film.add(new Movie(242, "Film 3"));
        film.add(new Movie(252, "Film 4"));

        return film;
    }

    // Metodo per la lista delel Songs ✅
    private List<Songs> getBestSongs() {
        List<Songs> canzoni = new ArrayList<>();

        // Lista di canzoni ✅
        canzoni.add(new Songs(232, "Song 1"));
        canzoni.add(new Songs(222, "Song 2"));
        canzoni.add(new Songs(242, "Song 3"));
        canzoni.add(new Songs(252, "Song 4"));

        return canzoni;
    }

    // -----------------
    // URL pagina dei canzoni e il rispettivo metodo per mostrare la lista ✅

    @GetMapping("/song")
    public String bestSongs(Model model) {
        List<Songs> song = getBestSongs();
        model.addAttribute("songs", song);

        String songs = "";

        for (Songs song1 : song) {

            songs += song1.getTitolo() + "";

            // substring(Object target, int start) <--Documentazione w3c
            // copia una parte dell'indice di inizio della destinazione alla fine della
            // destinazione.

            songs = songs.substring(0, songs.length() - 2);

        }

        model.addAttribute("stringSong", songs);
        return "song";
    }

    // --------

    // URL pagina dei film e il rispettivo metodo per mostrare la lista ✅

    @GetMapping("/movie")
    public String bestMovies(Model model) {
        List<Movie> film = getBestMovies();

        String movies = "";

        for (Movie movie : film) {

            movies += movie.getTitolo() + ", ";

            // substring(Object target, int start) <--Documentazione w3c
            // copia una parte dell'indice di inizio della destinazione alla fine della
            // destinazione.

            movies = movies.substring(0, movies.length() - 2);

        }

        model.addAttribute("stringMovie", movies);
        return "movie";

    }

    // Creare due metodi - Non completo☄️

    // movies/{id}”
    // “/songs/{id}”

    // _____________________________________

    @GetMapping("/movies/{id}")
    public String getMethodName(@RequestParam String param) {

        List<Movie> film = getBestMovies();

        for (Movie movie : film) {

        }

        return new String();
    }

    /*
     * @GetMapping("/songs/{id}")
     * public String getMethodName(@RequestParam String param) {
     * 
     * 
     * 
     * return new String();
     * }
     */

    // --------

}
