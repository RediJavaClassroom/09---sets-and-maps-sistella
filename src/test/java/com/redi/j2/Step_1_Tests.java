package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Movie;
import com.redi.j2.utils.TestUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Step_1_Tests {

    @Test
    void task_1_1_shouldCreateTheMovieClass() {

        // given - the class we want the students to implement
        Movie m = Fixtures.createMovie();

        // when - we check if it exists

        // then - it should exist
        assertTrue(m.existsClass(), "Movie class is not defined");
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("movieProperties")
    void task_2_1_shouldHaveProperty(String name, Class<?> type, Class<?>[] parameterizedTypes) {

        // given - the class we want the students to implement
        Movie m = Fixtures.createMovie();

        // when - we check if the property exists

        // then - it should exist
        assertTrue(m.hasProperty(name), "Variable '"+name+"' is not defined");

        // and - it should be of expected type
        assertTrue(m.isPropertyOfType(name, type, parameterizedTypes), "Variable '"+name+"' must have type "+TestUtils.formatClassName(type, parameterizedTypes));

        // and - it should be private
        assertTrue(m.isPropertyPrivate(name), "Variable '"+name+"' must be private");

        // and - it should be final
        assertTrue(m.isPropertyFinal(name), "Variable '"+name+"' must be final");
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("movieProperties")
    void task_2_2_shouldHaveGetterMethod(String name, Class<?> type, Class<?>[] parameterizedTypes) {

        // given - the class we want the students to implement
        Movie m = Fixtures.createMovie();

        // when - we check if the getter is correctly implemented

        // then - it should exist
        assertTrue(m.hasMethod(TestUtils.toGetterName(name)), "Property '"+name+"' must have a getter called '"+TestUtils.toGetterName(name)+"'");
        assertTrue(m.isMethodReturnType(type, TestUtils.toGetterName(name)), "Method '"+TestUtils.toGetterName(name)+"' must return "+TestUtils.formatClassName(type, parameterizedTypes));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("movieProperties")
    void task_2_3_shouldNotHaveSetterMethod(String name, Class<?> type, Class<?>[] parameterizedTypes) {

        // given - the class we want the students to implement
        Movie m = Fixtures.createMovie();

        // when - we check if it has the setter for the property

        // then - it should not exist
        assertFalse(m.hasMethod(TestUtils.toSetterName(name), type), "Property '"+name+"' cannot have a setter");
    }

    @Test
    void task_3_1_shouldHaveParameterizedConstructor() {

        // given - some parameters
        UUID id = UUID.randomUUID();
        String name = "MovieName";

        // when - we check if it has the constructor
        Movie m = Fixtures.createMovie(id, name);

        // then - it should exist
        assertTrue(m.hasConstructor(UUID.class, String.class),
                "Movie must have a constructor that receives the 'id' and 'name'");

        // and - it should assign the values
        assertEquals(id, m.getId(),
                "The constructor is not well implemented - 'id' is not being set properly inside the constructor");
        assertEquals(name, m.getName(),
                "The constructor is not well implemented - 'name' is not being set properly inside the constructor");

        // and - all collections should be initialized empty
        assertNotNull(m.getRatings(), "You need to initialize the 'ratings' property inside the constructor");
        assertEquals(0, m.getRatings().size(), "The 'ratings' property must be empty");
        assertNotNull(m.getTags(), "You need to initialize the 'tags' property inside the constructor");
        assertEquals(0, m.getTags().size(), "The 'tags' property must be empty");
        assertNotNull(m.getActors(), "You need to initialize the 'actors' property inside the constructor");
        assertEquals(0, m.getActors().size(), "The 'actors' property must be empty");
    }

    @Test
    void task_4_1_shouldHaveAnotherConstructor() {

        // given - some parameters
        UUID id = UUID.randomUUID();
        String name = "MovieName";
        Map<BigDecimal, Integer> ratings = new HashMap<>();
        ratings.put(BigDecimal.valueOf(7.5), 3);
        SortedSet<String> tags = new TreeSet<>();
        tags.add("comedy");
        Set<String> actors = new HashSet<>();
        actors.add("Jackie Chan");

        // when - we check if it has the constructor
        Movie m = Fixtures.createMovie(id, name, ratings, tags, actors);

        // then - it should exist
        assertTrue(m.hasConstructor(UUID.class, String.class, Map.class, SortedSet.class, Set.class),
                "Movie must have a constructor that receives all the properties, in the correct order");

        // and - it should assign the values
        assertEquals(id, m.getId(),
                "The constructor is not well implemented - 'id' is not being set properly inside the constructor");
        assertEquals(name, m.getName(),
                "The constructor is not well implemented - 'name' is not being set properly inside the constructor");

        // and - it should assign the collections
        assertNotNull(m.getRatings(), "The constructor is not well implemented - 'ratings' is not being set properly inside the constructor");
        assertEquals(1, m.getRatings().size(), "The constructor is not well implemented - 'ratings' is not being set properly inside the constructor");
        assertEquals(ratings.get(BigDecimal.valueOf(7.5)), m.getRatings().get(BigDecimal.valueOf(7.5)),
                "The constructor is not well implemented - 'ratings' is not being set properly inside the constructor");
        assertNotNull(m.getTags(), "The constructor is not well implemented - 'tags' is not being set properly inside the constructor");
        assertEquals(1, m.getTags().size(), "The constructor is not well implemented - 'tags' is not being set properly inside the constructor");
        assertEquals(tags.first(), m.getTags().first(),
                "The constructor is not well implemented - 'tags' is not being set properly inside the constructor");
        assertNotNull(m.getActors(), "The constructor is not well implemented - 'actors' is not being set properly inside the constructor");
        assertEquals(1, m.getActors().size(), "The constructor is not well implemented - 'actors' is not being set properly inside the constructor");
        assertEquals(actors.iterator().next(), m.getActors().iterator().next(),
                "The constructor is not well implemented - 'actors' is not being set properly inside the constructor");
    }

    @Test
    void task_5_1_shouldHaveToStringMethod() {

        // given - an Movie
        Movie m = Fixtures.createMovie();

        // when - we check if it has the 'toString' method
        String result = m.toString();

        // then - it should exist
        assertTrue(m.hasMethod("toString"), "Method 'toString' is not defined");

        // and - it should have the correct return type
        assertTrue(m.isMethodReturnType(String.class, "toString"), "Method 'toString' should return a String");

        // and - it should have public access
        assertTrue(m.isMethodPublic("toString"), "Method 'toString' should be public");

        // and - it should consider all properties
        assertNotNull(result, "The 'toString' method cannot return null");
        assertTrue(result.contains("id"), "The name of the property 'id' should be present in the returned String");
        assertTrue(result.contains(m.getId().toString()), "The value of the property 'id' should be present in the returned String");
        assertTrue(result.contains("name"), "The name of the property 'name' should be present in the returned String");
        assertTrue(result.contains(m.getName()), "The value of the property 'name' should be present in the returned String");
        assertTrue(result.contains("ratings"), "The name of the property 'ratings' should be present in the returned String");
        assertTrue(result.contains("tags"), "The name of the property 'tags' should be present in the returned String");
        assertTrue(result.contains("actors"), "The name of the property 'actors' should be present in the returned String");
    }

    @Test
    void task_5_2_1_shouldHaveEqualsMethod() {

        // given - a Movie
        Movie m = Fixtures.createMovie();

        // when - we check if it has the 'equals' method

        // then - it should exist
        assertTrue(m.hasMethod("equals", Object.class), "Method 'equals' is not defined");

        // and - it should have the correct return type
        assertTrue(m.isMethodReturnType(boolean.class, "equals", Object.class), "Method 'equals' should return a boolean");

        // and - it should have public access
        assertTrue(m.isMethodPublic("equals", Object.class), "Method 'equals' should be public");
    }

    @Test
    void task_5_2_2_shouldReturnTrueForIdenticalObjects() {

        // given - two Movie instances with same properties
        Movie m1 = Fixtures.createMovie();
        m1.getRatings().put(BigDecimal.valueOf(7.5), 3);
        m1.getTags().add("Comedy");
        m1.getActors().add("Jackie Chan");
        Movie m2 = Fixtures.cloneMovie(m1);

        // when - we compare the objects with the 'equals' method
        boolean areEqual = m1.equals(m2);

        // then - it should return true
        assertTrue(areEqual, "Method 'equals' must return true for two identical objects");
    }

    @Test
    void task_5_2_3_shouldReturnFalseForNonIdenticalObjects() {

        // given - two Movie instances with (almost) same properties
        Movie m1 = Fixtures.createMovie();
        m1.getRatings().put(BigDecimal.valueOf(7.5), 3);
        m1.getTags().add("Comedy");
        m1.getActors().add("Jackie Chan");
        Movie m2 = Fixtures.cloneMovie(m1);
        m2.getActors().add("Jet Li");

        // when - we compare the objects with the 'equals' method
        boolean areEqual = m1.equals(m2);

        // then - it should return false
        assertFalse(areEqual, "Method 'equals' must return false for two non identical objects (must check all properties)");
    }

    private static Stream<Arguments> movieProperties() {
        return Stream.of(
                Arguments.of("id", UUID.class, null),
                Arguments.of("name", String.class, null),
                Arguments.of("ratings", Map.class, new Class<?>[]{BigDecimal.class, Integer.class}),
                Arguments.of("tags", SortedSet.class, new Class<?>[]{String.class}),
                Arguments.of("actors", Set.class, new Class<?>[]{String.class})
        );
    }
}
