/**
 *  Name: Henry Huynh
 *  Section: ITEC 4860
 *  Assignment: REST Project
 *  Date: 10/15/2021
 *  Term: Fall 2021
 */

package com.example.restproject2021;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MovieDAO {
    @PersistenceContext
    private EntityManager entityManager;

    // Insert movie into database
    public Movie create(Movie movie) {
        entityManager.persist(movie);
        entityManager.flush();
        return movie;
    }

    // Retrieves moe by ID
    public Movie getMovieById(int id) {
        Movie movie = entityManager.find(Movie.class, id);
        if(movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID " + id + " was not found.");
        }
        return movie;
    }

    // Returns a list of movies from database
    public List<Movie> getAll() {
        List<Movie> movie = entityManager.createQuery("select m from Movie m", Movie.class).getResultList();
        return movie;
    }

    // Updates movie in the database
    public Movie updateMovie(Movie movie){
        getMovieById(movie.getId());
        entityManager.merge(movie);
        entityManager.flush();
        return movie;
    }


    // Deletes movie by ID
    public void deleteMovieById(int id){
        Movie movie = getMovieById(id);
        entityManager.remove(movie);
    }
}