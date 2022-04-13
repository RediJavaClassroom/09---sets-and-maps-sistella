package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Movie;
import com.redi.j2.utils.TestUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Step_2_Tests {

    @Test
    void task_1_1_shouldHaveAddTagMethod() {

        // given - the class we want the students to implement
        Movie m = Fixtures.createMovie();

        // when - we check if the method exists

        // then - it should exist
        assertTrue(m.hasMethod("addTag", String.class), "Method 'addTag' does not exist");
        assertTrue(m.isMethodReturnType(void.class, "addTag", String.class), "Method 'addTag' must return void");

        // and - it must be public
        assertTrue(m.isMethodPublic("addTag", String.class), "Method 'addTag' must be public");
    }

    @Test
    void task_1_2_shouldImplementAddTagMethod() {

        // given - a Movie
        Movie m = Fixtures.createMovie();

        // when - we call the method
        m.addTag("Comedy");

        // then - the tag should be added into the set
        assertEquals(1, m.getTags().size(), "The tag must be added to the set");
        assertTrue(m.getTags().contains("Comedy"), "The tag must be added to the set");
    }

    @Test
    void task_2_1_shouldHaveRemoveTagMethod() {

        // given - the class we want the students to implement
        Movie m = Fixtures.createMovie();

        // when - we check if the method exists

        // then - it should exist
        assertTrue(m.hasMethod("removeTag", String.class), "Method 'removeTag' does not exist");
        assertTrue(m.isMethodReturnType(void.class, "removeTag", String.class), "Method 'removeTag' must return void");

        // and - it must be public
        assertTrue(m.isMethodPublic("removeTag", String.class), "Method 'removeTag' must be public");
    }

    @Test
    void task_2_2_shouldImplementRemoveTagMethod() {

        // given - a Movie with a tag
        Movie m = Fixtures.createMovie();
        m.addTag("Comedy");

        // when - we call the method
        m.removeTag("Comedy");

        // then - the tag should be removed from the set
        assertEquals(0, m.getTags().size(), "The tag must be removed from the set");
    }

    @Test
    void task_3_1_shouldHaveAddActorMethod() {

        // given - the class we want the students to implement
        Movie m = Fixtures.createMovie();

        // when - we check if the method exists

        // then - it should exist
        assertTrue(m.hasMethod("addActor", String.class), "Method 'addActor' does not exist");
        assertTrue(m.isMethodReturnType(void.class, "addActor", String.class), "Method 'addActor' must return void");

        // and - it must be public
        assertTrue(m.isMethodPublic("addActor", String.class), "Method 'addActor' must be public");
    }

    @Test
    void task_3_2_shouldImplementAddActorMethod() {

        // given - a Movie
        Movie m = Fixtures.createMovie();

        // when - we call the method
        m.addActor("Jackie Chan");

        // then - the tag should be added into the set
        assertEquals(1, m.getActors().size(), "The tag must be added to the set");
        assertTrue(m.getActors().contains("Jackie Chan"), "The tag must be added to the set");
    }

    @Test
    void task_4_1_shouldHaveRemoveActorMethod() {

        // given - the class we want the students to implement
        Movie m = Fixtures.createMovie();

        // when - we check if the method exists

        // then - it should exist
        assertTrue(m.hasMethod("removeActor", String.class), "Method 'removeActor' does not exist");
        assertTrue(m.isMethodReturnType(void.class, "removeActor", String.class), "Method 'removeActor' must return void");

        // and - it must be public
        assertTrue(m.isMethodPublic("removeActor", String.class), "Method 'removeActor' must be public");
    }

    @Test
    void task_4_2_shouldImplementRemoveActorMethod() {

        // given - a Movie with a tag
        Movie m = Fixtures.createMovie();
        m.addActor("Jackie Chan");

        // when - we call the method
        m.removeActor("Jackie Chan");

        // then - the tag should be removed from the set
        assertEquals(0, m.getActors().size(), "The actor must be removed from the set");
    }

    @Test
    void task_5_1_shouldHaveAddRatingMethod() {

        // given - the class we want the students to implement
        Movie m = Fixtures.createMovie();

        // when - we check if the method exists

        // then - it should exist
        assertTrue(m.hasMethod("addRating", BigDecimal.class), "Method 'addRating' does not exist");
        assertTrue(m.isMethodReturnType(boolean.class, "addRating", BigDecimal.class), "Method 'addRating' must return boolean");

        // and - it must be public
        assertTrue(m.isMethodPublic("addRating", BigDecimal.class), "Method 'addRating' must be public");
    }

    @Test
    void task_5_2_shouldNotAddInvalidRatings() {

        // given - a Movie
        Movie m = Fixtures.createMovie();

        // when - we try to add invalid ratings
        boolean attempt1 = m.addRating(BigDecimal.valueOf(-1));
        boolean attempt2 = m.addRating(BigDecimal.valueOf(11));

        // then - it should return false
        assertFalse(attempt1, "Method 'addRating' must return false for values lower than 0");
        assertFalse(attempt2, "Method 'addRating' must return false for values higher than 10");

        // and - it must not add the ratings to the map
        assertEquals(0, m.getRatings().size(), "Method 'addRating' must not change the map with invalid parameters");
    }

    @Test
    void task_5_2_shouldAddNewRatings() {

        // given - a Movie
        Movie m = Fixtures.createMovie();

        // when - we add a new rating
        boolean newRating = m.addRating(BigDecimal.valueOf(3.5));

        // then - it should return true
        assertTrue(newRating, "Method 'addRating' must return true when adding a new rating");

        // and - it should have added the value to the ratings
        assertEquals(1, m.getRatings().size(), "Method 'addRating' must add new ratings to the map");
        assertEquals(1, m.getRatings().get(BigDecimal.valueOf(3.5)), "Method 'addRating' is not counting the amounts correctly");
    }

    @Test
    void task_5_3_shouldAddNewRatings() {

        // given - a Movie with an existing rating
        Movie m = Fixtures.createMovie();
        m.getRatings().put(BigDecimal.valueOf(3.5), 100);

        // when - we add an existing rating
        boolean newRating = m.addRating(BigDecimal.valueOf(3.5));

        // then - it should return true
        assertTrue(newRating, "Method 'addRating' must return true when adding an existing rating");

        // and - it should have added the value to the ratings
        assertEquals(1, m.getRatings().size(), "Method 'addRating' must not change the size of the map when adding an existing rating");
        assertEquals(101, m.getRatings().get(BigDecimal.valueOf(3.5)), "Method 'addRating' must increment the amount for existing ratings");
    }

    @Test
    void task_6_1_shouldHaveAddRatingMethod() {

        // given - the class we want the students to implement
        Movie m = Fixtures.createMovie();

        // when - we check if the method exists

        // then - it should exist
        assertTrue(m.hasMethod("removeRating", BigDecimal.class), "Method 'removeRating' does not exist");
        assertTrue(m.isMethodReturnType(boolean.class, "removeRating", BigDecimal.class), "Method 'removeRating' must return boolean");

        // and - it must be public
        assertTrue(m.isMethodPublic("removeRating", BigDecimal.class), "Method 'removeRating' must be public");
    }

    @Test
    void task_6_2_shouldNotRemoveInvalidRatings() {

        // given - a Movie with existing ratings
        Movie m = Fixtures.createMovie();
        m.getRatings().put(BigDecimal.valueOf(3.0), 5);

        // when - we try to add invalid ratings
        boolean attempt1 = m.removeRating(BigDecimal.valueOf(-1));
        boolean attempt2 = m.removeRating(BigDecimal.valueOf(11));

        // then - it should return false
        assertFalse(attempt1, "Method 'removeRating' must return false for values lower than 0");
        assertFalse(attempt2, "Method 'removeRating' must return false for values higher than 10");

        // and - it must not change the ratings to the map
        assertEquals(1, m.getRatings().size(), "Method 'removeRating' must not change the map with invalid parameters");
        assertEquals(5, m.getRatings().get(BigDecimal.valueOf(3.0)), "Method 'removeRating' must not change the map with invalid parameters");
    }

    @Test
    void task_6_3_shouldHandleNotExistingRatings() {

        // given - a Movie with existing ratings
        Movie m = Fixtures.createMovie();
        m.getRatings().put(BigDecimal.valueOf(3.0), 5);

        // when - we try to remove a non-existing rating
        boolean attempt = m.removeRating(BigDecimal.valueOf(3.5));

        // then - it should return false
        assertFalse(attempt, "Method 'removeRating' must return false for non existing ratings");

        // and - it must not change the ratings to the map
        assertEquals(1, m.getRatings().size(), "Method 'removeRating' must not change the map for non existing ratings");
        assertEquals(5, m.getRatings().get(BigDecimal.valueOf(3.0)), "Method 'removeRating' must not change the map for non existing ratings");
    }

    @Test
    void task_6_4_shouldHandleExistingRatings() {

        // given - a Movie with existing ratings
        Movie m = Fixtures.createMovie();
        m.getRatings().put(BigDecimal.valueOf(3.0), 5);

        // when - we try to remove an existing rating
        boolean attempt = m.removeRating(BigDecimal.valueOf(3.0));

        // then - it should return true
        assertTrue(attempt, "Method 'removeRating' must return true for existing ratings");

        // and - it must change the ratings properly
        assertEquals(1, m.getRatings().size(), "Method 'removeRating' must keep the rating inside the map if the resulting amount is bigger than 0");
        assertEquals(4, m.getRatings().get(BigDecimal.valueOf(3.0)), "Method 'removeRating' must calculate the new amount properly");
    }

    @Test
    void task_6_5_shouldHandleTotalRemovalOfRatings() {

        // given - a Movie with existing ratings
        Movie m = Fixtures.createMovie();
        m.getRatings().put(BigDecimal.valueOf(3.0), 1);

        // when - we try to remove an existing rating
        boolean attempt = m.removeRating(BigDecimal.valueOf(3.0));

        // then - it should return true
        assertTrue(attempt, "Method 'removeRating' must return true for existing ratings");

        // and - it must change the ratings properly
        assertEquals(0, m.getRatings().size(), "Method 'removeRating' must remove the rating inside the map if the resulting amount is 0");
    }

    @Test
    void task_7_1_shouldHaveHasTagsMethod() {

        // given - the class we want the students to implement
        Movie m = Fixtures.createMovie();

        // when - we check if the method exists

        // then - it should exist
        assertTrue(m.hasMethod("hasTags", Set.class), "Method 'hasTags' does not exist");
        assertTrue(m.isMethodReturnType(Set.class, "hasTags", Set.class), "Method 'hasTags' must return Set<String>");

        // and - it must be public
        assertTrue(m.isMethodPublic("hasTags", Set.class), "Method 'hasTags' must be public");
    }

    @Test
    void task_7_2_shouldSearchForExistingTags() {

        // given - a Movie with existing tags
        Movie m = Fixtures.createMovie();
        m.getTags().add("Comedy");
        m.getTags().add("Romance");
        m.getTags().add("Horror");

        // and - a search we want to do
        Set<String> searchSet = new HashSet<>();
        searchSet.add("Romance"); // exists
        searchSet.add("Horror"); // exists
        searchSet.add("Documentary"); // doesn't exist

        // when - we call the method
        Set<String> result = m.hasTags(searchSet);

        // then - it should return what we expect
        assertNotNull(result, "Method 'hasTags' cannot return null");
        assertEquals(2, result.size(), "Method 'hasTags' does not work correctly");
        assertTrue(result.contains("Romance"), "Method 'hasTags' does not work correctly");
        assertTrue(result.contains("Horror"), "Method 'hasTags' does not work correctly");

        // and - it should not change the ratings
        assertEquals(3, m.getTags().size(), "Method 'hasTags' cannot change the tags inner property");
    }
}
