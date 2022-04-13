package com.redi.j2;

import java.math.BigDecimal;
import java.util.*;

public class Movie {
    private final UUID id;
    private final String name;
    private final Map<BigDecimal, Integer> ratings;
    private final SortedSet<String> tags;
    private final Set<String> actors;

    public Movie(UUID id, String name) {
        this(
                id,
                name,
                new HashMap<BigDecimal, Integer>(),
                new TreeSet<String>(),
                new HashSet<String>()
        );
    }

    public Movie(UUID id, String name, Map<BigDecimal, Integer> ratings, SortedSet<String> tags, Set<String> actors) {
        this.id = id;
        this.name = name;
        this.ratings = ratings;
        this.tags = tags;
        this.actors = actors;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<BigDecimal, Integer> getRatings() {
        return ratings;
    }

    public SortedSet<String> getTags() {
        return tags;
    }

    public Set<String> getActors() {
        return actors;
    }

    public void addTag (String tag) {
        this.tags.add(tag);
    }
    public void removeTag (String tag) {
        this.tags.remove(tag);
    }
    public void addActor (String actor) {
        this.actors.add(actor);
    }
    public void removeActor (String actor) {
        this.actors.remove(actor);
    }
    public boolean addRating (BigDecimal rating) {
        if (rating.intValue() < 0 || rating.intValue() > 10) {
            return false;
        }
        ratings.putIfAbsent(rating, 0);
        ratings.put(rating, ratings.get(rating) + 1);
        return true;
    }

    public boolean removeRating (BigDecimal rating) {
        if (rating.intValue() < 0 ) {
            return false;
        }
        if(!ratings.containsKey(rating)) {
            return false;
        }
        if (ratings.get(rating) == 1) {
            ratings.remove(rating);
        } else {
            ratings.put(rating, ratings.get(rating) - 1);
        }
        return true;
    }

    public Set<String> hasTags (Set<String> searchTags) {
        Set<String> result = new HashSet<String>();
        for(String tag : tags) {
            if (searchTags.contains(tag)) {
                result.add(tag);
            }
        }
        return result;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ratings=" + ratings +
                ", tags=" + tags +
                ", actors=" + actors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != null ? !id.equals(movie.id) : movie.id != null) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        if (ratings != null ? !ratings.equals(movie.ratings) : movie.ratings != null) return false;
        if (tags != null ? !tags.equals(movie.tags) : movie.tags != null) return false;
        return actors != null ? actors.equals(movie.actors) : movie.actors == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ratings != null ? ratings.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        return result;
    }
}
