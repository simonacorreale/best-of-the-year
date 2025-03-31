package com.best.of.the.year.java.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Controllers {

    // Best of nome in index
    @GetMapping("/")
    public String controllerMain(Model model) {
        // Il mio nome
        model.addAttribute("name", "Simona");
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
