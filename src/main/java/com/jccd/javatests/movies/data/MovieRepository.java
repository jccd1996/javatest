package com.jccd.javatests.movies.data;

import com.jccd.javatests.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);

    Collection<Movie> findAll();

    Collection<Movie> findByName(String name);

    Collection<Movie> findByNameOtherWay(String name);

    Collection<Movie> findByDirector(String name);

    void saveOrUpdate(Movie movie);

    default int suma(int num1, int num2) {
        return num1 + num2;
    }

}
