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
        film.add(new Movie(1, "Film 1"));
        film.add(new Movie(2, "Film 2"));
        film.add(new Movie(3, "Film 3"));
        film.add(new Movie(4, "Film 4"));

        return film;
    }

    // Metodo per la lista delel Songs ✅
    private List<Songs> getBestSongs() {
        List<Songs> canzoni = new ArrayList<>();

        // Lista di canzoni ✅
        canzoni.add(new Songs(1, "Song 1"));
        canzoni.add(new Songs(2, "Song 2"));
        canzoni.add(new Songs(3, "Song 3"));
        canzoni.add(new Songs(4, "Song 4"));

        return canzoni;
    }

    // -----------------
    // URL pagina dei canzoni e il rispettivo metodo per mostrare la lista ✅

    @GetMapping("/song")
    public String bestSongs(Model model) {
        List<Songs> canzoni = getBestSongs();
        // cambiare il nome da singolare al pulrale
        String canzoneTitolo = "";

        for (Songs canzone : canzoni) {

            canzoneTitolo += canzone.getTitolo() + ", ";

            // substring(Object target, int start) <--Documentazione w3c
            // copia una parte dell'indice di inizio della destinazione alla fine della
            // destinazione.

            canzoneTitolo = canzoneTitolo.substring(0, canzoneTitolo.length() - 2);
            System.out.println(canzoneTitolo);

        }

        model.addAttribute("stringSong", canzoneTitolo);
        return "song";
    }

    // -----------------

    // URL pagina dei film e il rispettivo metodo per mostrare la lista ✅

    @GetMapping("/movie")
    public String bestMovies(Model model) {
        List<Movie> films = getBestMovies();

        String filmsTitle = "";

        for (Movie film : films) {
            // bho non mi funziona non so
            filmsTitle += film.getTitolo() + ", ";

            // substring(Object target, int start) <--Documentazione w3c
            // copia una parte dell'indice di inizio della destinazione alla fine della
            // destinazione.

            filmsTitle = filmsTitle.substring(0, filmsTitle.length() - 2);

        }

        model.addAttribute("stringMovie", filmsTitle);
        return "movie";

    }

    // Creare due metodi - Non completo non funziona ☄️

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

}
