package com.jccd.javatests.movies.service;

import com.jccd.javatests.movies.data.MovieRepository;
import com.jccd.javatests.movies.model.Genre;
import com.jccd.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMovieByGenre(Genre genre) {
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre).
                collect(Collectors.toList());
    }


    public Collection<Movie> findMoviesByLenght(int lenght) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= lenght).
                collect(Collectors.toList());
    }
}
