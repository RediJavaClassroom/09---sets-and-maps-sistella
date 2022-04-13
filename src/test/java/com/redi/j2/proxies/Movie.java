package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

import java.math.BigDecimal;
import java.util.*;

public class Movie extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Movie";
    }

    public Movie(UUID id, String name) {
        super(id, name);
    }

    public Movie(UUID id, String name, Map<BigDecimal, Integer> ratings, SortedSet<String> tags, Set<String> actors) {
        super(id, name, ratings, tags, actors);
    }

    public Boolean addRating(BigDecimal rating) {
        Boolean response = invokeMethod("addRating", new Class[]{BigDecimal.class}, rating);
        return (response != null)? response : false;
    }

    public Boolean removeRating(BigDecimal rating) {
        Boolean response = invokeMethod("removeRating", new Class[]{BigDecimal.class}, rating);
        return (response != null)? response : false;
    }

    public Map<BigDecimal, Integer> getRatings() {
        Map<BigDecimal, Integer> result = invokeMethod("getRatings", new Class[]{});
        return (result != null)? result : new HashMap<>();
    }

    public UUID getId() {
        return invokeMethod("getId", new Class[]{});
    }

    public String getName() {
        return invokeMethod("getName", new Class[]{});
    }

    public Set<String> getActors() {
        Set<String> result = invokeMethod("getActors", new Class[]{});
        return (result != null)? result : new HashSet<>();
    }

    public SortedSet<String> getTags() {
        SortedSet<String> result = invokeMethod("getTags", new Class[]{});
        return (result != null)? result : new TreeSet<>();
    }

    public void addActor(String actor) {
        invokeMethod("addActor", new Class[]{String.class}, actor);
    }

    public void removeActor(String actor) {
        invokeMethod("removeActor", new Class[]{String.class}, actor);
    }

    public void addTag(String tag) {
        invokeMethod("addTag", new Class[]{String.class}, tag);
    }

    public void removeTag(String tag) {
        invokeMethod("removeTag", new Class[]{String.class}, tag);
    }

    public Set<String> hasTags(Set<String> otherTags) {
        return invokeMethod("hasTags", new Class[]{Set.class}, otherTags);
    }
}
