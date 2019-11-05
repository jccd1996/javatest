package com.jccd.javatests.movies.service;

import com.jccd.javatests.movies.data.MovieRepositoryJdbc;
import com.jccd.javatests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieRepositoryJdbcTest {

    private MovieRepositoryJdbc base;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup() {
        base = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void findById() {
        when(jdbcTemplate.queryForObject(anyString(), any(), any(RowMapper.class))).thenReturn(buildPelicula());

        final Movie movie = base.findById(1L);
        assertNotNull(movie);
        assertEquals("Jose", movie.getDirector());

        verify(jdbcTemplate).queryForObject(anyString(), any(), any(RowMapper.class));
    }


    private Movie buildPelicula() {
        final Movie movie = new Movie();
        movie.setId(ThreadLocalRandom.current().nextInt());
        movie.setDirector("Jose");

        return movie;
    }

}
