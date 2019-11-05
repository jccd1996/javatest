package com.jccd.javatests.movies.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movie {
    @EqualsAndHashCode.Include
    private Integer id;
    @EqualsAndHashCode.Include
    private String name;
    private int minutes;
    @EqualsAndHashCode.Include
    private Genre genre;
    private String director;

    public Movie(String name, int minutes, Genre genre, String director) {
        this(null, name, minutes, genre, director);
    }
}
