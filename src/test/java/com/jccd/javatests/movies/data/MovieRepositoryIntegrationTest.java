package com.jccd.javatests.movies.data;

import com.jccd.javatests.movies.model.Genre;
import com.jccd.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepository;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws Exception {
         dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {
        Collection<Movie> movies = movieRepository.findAll();
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION,"Mell Gibson"),
                new Movie(2, "Memento", 113, Genre.THRILLER,"Guillermo del Toro"),
                new Movie(3, "Matrix", 136, Genre.ACTION,"Camilo Cubillos"),
                new Movie(4, "Dark Phoenix", 190, Genre.COMEDY, "Tobias Pacheco"),
                new Movie(5, "Dark Moon", 100, Genre.THRILLER, "Camilo Cubillos"))
        ));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);
        assertThat(movie, CoreMatchers.is(new Movie(2, "Memento", 113, Genre.THRILLER,"Guillermo del Toro")));
    }

    @Test
    public void load_movie_by_name() {
        Collection<Movie> movies = movieRepository.findByName("dark");
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION,"Mell Gibson"),
                new Movie(4, "Dark Phoenix", 190, Genre.COMEDY, "Tobias Pacheco"),
                new Movie(5, "Dark Moon", 100, Genre.THRILLER, "Camilo Cubillos"))));
    }

    @Test
    public void load_movie_by_second_way() {
        Collection<Movie> movies = movieRepository.findByNameOtherWay("dark");
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION,"Mell Gibson"),
                new Movie(4, "Dark Phoenix", 190, Genre.COMEDY, "Tobias Pacheco"),
                new Movie(5, "Dark Moon", 100, Genre.THRILLER, "Camilo Cubillos"))));
    }

    @Test
    public void load_movie_by_director() {
        Collection<Movie> movies = movieRepository.findByDirector("Camilo Cubillos");
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(3, "Matrix", 136, Genre.ACTION,"Camilo Cubillos"),
                new Movie(5, "Dark Moon", 100, Genre.THRILLER, "Camilo Cubillos"))));
    }

    @Test
    public void insert_movie() {
        Movie movie = new Movie (6,"Super 8", 112, Genre.THRILLER,"Dua Crack");
        movieRepository.saveOrUpdate(movie);
        Movie movieFromDB = movieRepository.findById(6);
        assertThat(movieFromDB, CoreMatchers.is(movie));

    }

    @After
    public void clearDataBaseFields() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}