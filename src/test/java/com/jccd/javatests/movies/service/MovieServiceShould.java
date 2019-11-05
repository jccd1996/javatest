package com.jccd.javatests.movies.service;

import com.jccd.javatests.movies.data.MovieRepository;
import com.jccd.javatests.movies.model.Genre;
import com.jccd.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {
    MovieService movieService;


    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1,"Dark Night",152,Genre.ACTION,"Director 1"),
                        new Movie(2,"Memento",113,Genre.THRILLER, "Director 2"),
                        new Movie(3,"There's Spomething About Mary",119,Genre.COMEDY, "Director 3"),
                        new Movie(4,"Super 8",112,Genre.THRILLER, "Director 4"),
                        new Movie(5,"Scream",111,Genre.HORROR, "Director 5"),
                        new Movie(6,"Home Alone",103,Genre.COMEDY, "Director 6"),
                        new Movie(7,"Matrix",136,Genre.ACTION, "Director 7")
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMovieByGenre(Genre.COMEDY);

        assertThat(getMoviesIds(movies), CoreMatchers.is(Arrays.asList(3,6)));
    }

    @Test
    public void return_movies_by_lenght() {
        Collection<Movie> movies = movieService.findMoviesByLenght(119);

        assertThat(getMoviesIds(movies),CoreMatchers.is(Arrays.asList(2, 3 ,4 ,5 ,6)));
    }

    private List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect((Collectors.toList()));
    }
}