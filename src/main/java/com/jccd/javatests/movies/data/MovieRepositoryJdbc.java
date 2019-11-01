package com.jccd.javatests.movies.data;

import com.jccd.javatests.movies.model.Genre;
import com.jccd.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

    }

    private static  RowMapper<Movie> movieMapper = (rs, rowNumber) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre")));
}
