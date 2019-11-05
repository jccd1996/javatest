package com.jccd.javatests.movies.data;

import com.jccd.javatests.movies.model.Genre;
import com.jccd.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};

        return jdbcTemplate.queryForObject("SELECT * FROM MOVIES Where id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public Collection<Movie> findByName(String name) {
        name = name.toLowerCase();
        return jdbcTemplate.query("SELECT * FROM MOVIES WHERE LOWER(name) LIKE '%" + name + "%'", movieMapper);
    }

    @Override
    public Collection<Movie> findByNameOtherWay(String name) {
        return findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Movie> findByDirector(String name) {
        name = name.toLowerCase();
        return jdbcTemplate.query("SELECT * FROM MOVIES WHERE LOWER(director) LIKE '%" + name + "%'", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

        jdbcTemplate.update("INSERT INTO movies (name, minutes, genre) values (?, ?, ?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString());

    }

    private static RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    Genre.valueOf(rs.getString("genre")),
                    rs.getString("director"));
}
