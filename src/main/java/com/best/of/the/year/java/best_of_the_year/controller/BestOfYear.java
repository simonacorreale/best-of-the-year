package com.best.of.the.year.java.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

Creare due metodi - Non completo✅

- “/movies/{id}”
- “/songs/{id}”

che dato il parametro id passato tramite il path, mostri in pagina il titolo relativo al film / canzone.
Testare chiamando dal browser i diversi url.
Buon lavoro! (edited)  

________________


Seconda parte esercizio:

Continuiamo a lavorare sul nostro progetto Best of the year (stessa repo).
Includere Bootstrap e fare il refactoring del layout come da allegato, cercando di creare componenti riutilizzabili con i fragments.

Modificare i metodi che rispondono agli url
- “/movies”
- “/songs”
in modo che i Model restituiscano una lista di oggetti (Movie o Song) invece di una stringa.

Modificare anche le rispettive view.

Ogni elemento mostrato nella lista (film o canzone) deve essere un link che punta alla rispettiva pagina di dettaglio (e anche in questo caso restituire il Model al posto della stringa col titolo).
Nella pagina home (quella che risponde alla root dell’applicazione) aggiungere due link che portano agli url /movies e /songs.
Nelle pagine con le liste aggiungere un link che riporta alla home page.
Testare navigando l’applicazione.
Buon lavoro!
 
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

        // Lista di film ✅ //modo di visualizzare lista 1 esempio (per me)
        film.add(new Movie(1, "Film 1"));
        film.add(new Movie(2, "Film 2"));
        film.add(new Movie(3, "Film 3"));
        film.add(new Movie(4, "Film 4"));

        return film;
    }

    // Metodo per la lista delel Songs ✅
    private List<Songs> getBestSongs() {
        List<Songs> canzoni = new ArrayList<>();

        Songs canzone1 = new Songs(1, "Alba chiara", "Biaggio Felicino", "2020");
        Songs canzone2 = new Songs(2, "Alba media", "Biaggio Medino", "2021");
        Songs canzone3 = new Songs(3, "Alba nera", "Biaggio Depressino", "2022");
        Songs canzone4 = new Songs(4, "Alba blue", "Biaggio Tristino", "2023");

        // Lista di canzoni ✅ //modo di visualizzare lista 1 esempio (per me)
        canzoni.add(canzone1);
        canzoni.add(canzone2);
        canzoni.add(canzone3);
        canzoni.add(canzone4);

        return canzoni;
    }

    // -----------------
    // URL pagina dei canzoni e il rispettivo metodo per mostrare la lista ✅
    // Metodo modificato per l'esercizio 2

    @GetMapping("/song")
    public String bestSongs(Model model) {
        List<Songs> canzoni = getBestSongs();

        model.addAttribute("songsList", canzoni);

        return "song";
    }

    // -----------------

    // URL pagina dei film e il rispettivo metodo per mostrare la lista ✅
    // metodo modificato per l'esercizio 2

    @GetMapping("/movie")
    public String bestMovies(Model model) {
        List<Movie> films = getBestMovies();

        model.addAttribute("movieList", films);
        return "movie";

    }

    // Creare due metodi ✅

    // movies/{id}”
    // “/songs/{id}”

    // _____________________________________

    @GetMapping("/movie/{id}")
    public String idfilm(@PathVariable int id, Model model) {

        List<Movie> films = getBestMovies();

        for (Movie movie : films) {
            if (movie.getId() == id) {
                model.addAttribute("searchFilm", movie); // Assegno il film trovato al modello

            }

        }

        return "idfilm"; // Il nome del template Thymeleaf per visualizzare i dettagli del film
    }

    @GetMapping("/song/{id}")
    public String idSongs(@PathVariable int id, Model model) {

        List<Songs> songs = getBestSongs();

        for (Songs song : songs) {

            if (song.getId() == id) {
                model.addAttribute("searchSong", song);// Assegno il film trovato al modello
            }

        }

        return "idsong"; // Il nome del template Thymeleaf che visualizzerà i dettagli del film
    }

    // _____________________________________

    @GetMapping("/home")
    public String homePageController(Model model) {

        model.addAttribute("nome pagina", "homepage");

        return "home";

    }

}
