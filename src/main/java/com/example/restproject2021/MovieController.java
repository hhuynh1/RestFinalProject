/**
 *  Name: Henry Huynh
 *  Section: ITEC 4860
 *  Assignment: REST Project
 *  Date: 10/15/2021
 *  Term: Fall 2021
 *
 *  Test
 */

package com.example.restproject2021;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieDAO movieDAO = new MovieDAO();

    // Returns a list of movies
    @RequestMapping(value="/movies", method= RequestMethod.GET)
    public List<Movie> getMovieList() {
        return movieDAO.getAll();
    }

    // Returns a single movie by ID
    @RequestMapping(value="/movies/{id}", method=RequestMethod.GET)
    public Movie movieById(@PathVariable int id) {
        return movieDAO.getMovieById(id);
    }

    // Adds new movie to database
    @RequestMapping(value="/movies", method=RequestMethod.POST)
    public Movie movies(@RequestBody Movie movie) {
        Movie moviePost = movieDAO.create(movie);
        return moviePost;
    }

    // Adds movie to database by ID
    @RequestMapping(value="/movies", method=RequestMethod.PUT)
    public Movie updateMovie(@RequestBody Movie movie) {
        Movie moviePut = movieDAO.updateMovie(movie);
        return moviePut;
    }

    // Deletes movie by ID
    @RequestMapping(value="/movies/{id}", method=RequestMethod.DELETE)
    public String deleteMovie(@PathVariable int id) {
        movieDAO.deleteMovieById(id);
        return "ID " + id + " deleted.";
    }
}
