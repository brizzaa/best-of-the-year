package org.lessons.java.wdpt6.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.wdpt6.best_of_the_year.model.Movie;
import org.lessons.java.wdpt6.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // questa classe è un controllore 
@RequestMapping("/") // risponde a tutte le richieste
public class HomeController {


    @GetMapping
    public String home(Model model){
        model.addAttribute("name", "Luca");
        return "home"; // ritorna il file in resource
    }

    
    @GetMapping("/movies")
    public String moviesList(Model model){
        List<Movie> movies = getBestMovies();
        model.addAttribute("moviesList", movies.toString());
        return "movies";
    }

    // movies
    private List<Movie> getBestMovies(){
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Dunkirk",1));
        movies.add(new Movie("Oppenheimer", 2));
        movies.add(new Movie("The dark knight", 3));
        movies.add(new Movie("Inception", 4));
        movies.add(new Movie("Tenet", 5));
        movies.add(new Movie("Memento", 6));
        return movies;
    }

    // canzoni
    private List<Song> getBestSongs(){ 
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Sweet Boy", 1));
        songs.add(new Song("Florence", 2));
        songs.add(new Song("Concrete", 3));
        songs.add(new Song("Make me a better man", 4));
        songs.add(new Song("Starstudded", 5));
        songs.add(new Song("Earrings", 6));
        songs.add(new Song("Roommates", 7));
        return songs;
    }
    
    @GetMapping("/songs")
    public String songsList(Model model){
        List<Song> songs = getBestSongs();
        model.addAttribute("songsList", songs.toString());
        return "songs";
    }

    @GetMapping("movies/{id}")
    public String singleMovie(Model model, @PathVariable("id") Integer movieId){
        Boolean isMovieFound = false;
        Movie movie = null;

        for (Movie currentMovie : getBestMovies()) {
            if (currentMovie.getId() == movieId) {
                isMovieFound = true;
                movie = currentMovie;
                break;
            }
        }
        model.addAttribute("isMovieFound", isMovieFound);
        model.addAttribute("movie", movie);
        return "movie-details";
    }

    @GetMapping("songs/{id}")
    public String singleSong(Model model, @PathVariable("id") Integer songId){
        
        Boolean isSongFound = false;
        Song song = null;
    
        for (Song currentSong : getBestSongs()) {
            if (currentSong.getId() == songId) {
                isSongFound = true;
                song = currentSong;
                break;
            }
        }
        model.addAttribute("isSongFound", isSongFound);
        model.addAttribute("song", song);
        return "song-details";
    }
}