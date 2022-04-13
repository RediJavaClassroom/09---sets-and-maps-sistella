package com.redi.j2.fixtures;

import com.redi.j2.proxies.*;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;

public class Fixtures {

    private static int count = 0;

    public static Movie createMovie() {
        return createMovie(UUID.randomUUID(), "MovieName"+(count++));
    }

    public static Movie createMovie(UUID id, String name) {
        return new Movie(id, name);
    }

    public static Movie createMovie(UUID id, String name, Map<BigDecimal, Integer> ratings, SortedSet<String> tags, Set<String> actors) {
        return new Movie(id, name, ratings, tags, actors);
    }

    public static Movie cloneMovie(Movie movie) {
        return createMovie(movie.getId(), movie.getName(),
                new HashMap<>(movie.getRatings()),
                new TreeSet<>(movie.getTags()),
                new HashSet<>(movie.getActors()));
    }

    public static RatingsCalculator createRatingsCalculator() {
        return new RatingsCalculator();
    }

    public static AverageRatingsCalculator createAverageRatingsCalculator() {
        return new AverageRatingsCalculator();
    }

    public static TomatoRatingsCalculator createTomatoRatingsCalculator() {
        return new TomatoRatingsCalculator();
    }
}
