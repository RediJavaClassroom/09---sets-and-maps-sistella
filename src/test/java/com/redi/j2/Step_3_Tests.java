package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.AverageRatingsCalculator;
import com.redi.j2.proxies.Movie;
import com.redi.j2.proxies.RatingsCalculator;
import com.redi.j2.proxies.TomatoRatingsCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Step_3_Tests {

    @Test
    void task_1_1_shouldCreateRatingsCalculatorInterface() {

        // given - the class we want the students to implement
        RatingsCalculator r = Fixtures.createRatingsCalculator();

        // when - we check if it exists

        // then - it should exist
        assertTrue(r.existsClass(), "RatingsCalculator interface is not defined");

        // and - it should be an interface
        assertTrue(r.isInterface(), "RatingsCalculator must be an interface");
    }

    @Test
    void task_1_2_shouldDefineMethodCalculate() {

        // given - the RatingsCalculator interface
        RatingsCalculator r = Fixtures.createRatingsCalculator();
        Movie m = Fixtures.createMovie();

        // when - we check if it has the 'calculate' method definition

        // then - it should exist
        assertTrue(r.hasMethod("calculate", m.getTargetClass()), "Method 'calculate' is not defined or does not receive a Movie");

        // and - it should be abstract
        assertTrue(r.isMethodAbstract("calculate", m.getTargetClass()), "Method 'calculate' must be abstract");

        // and - it should have the correct return type
        assertTrue(r.isMethodReturnType(BigDecimal.class, "calculate", m.getTargetClass()), "Method 'calculate' should return BigDecimal");

        // and - it should have public access
        assertTrue(r.isMethodPublic("calculate", m.getTargetClass()), "Method 'calculate' should be public");
    }

    @Test
    void task_2_1_shouldCreateAverageRatingsCalculatorClass() {

        // given - the class we want the students to implement
        AverageRatingsCalculator a = Fixtures.createAverageRatingsCalculator();

        // when - we check if it exists

        // then - it should exist
        assertTrue(a.existsClass(), "AverageRatingsCalculator class is not defined");
    }

    @Test
    void task_2_2_shouldImplementRatingsCalculator() {

        // given - a AverageRatingsCalculator
        AverageRatingsCalculator a = Fixtures.createAverageRatingsCalculator();

        // when - we check if it implements the 'RatingsCalculator' interface
        RatingsCalculator r = Fixtures.createRatingsCalculator();

        // then - it should
        assertTrue(a.implementsInterface(r.getTargetClass()), "AverageRatingsCalculator should implement the RatingsCalculator interface");
    }

    @Test
    void task_2_3_shouldImplementCalculateMethodLogic() {

        // given - a AverageRatingsCalculator
        AverageRatingsCalculator a = Fixtures.createAverageRatingsCalculator();

        // and - a Movie with ratings
        Movie m = Fixtures.createMovie();
        Stream.of(0.5, 7.2, 1.5, 1.5, 2.3, 2.0, 5.0, 5.0, 5.9, 7.7, 9.7, 9.6, 9.7, 10.0, 10.0, 10.0)
                .map(BigDecimal::valueOf).forEach(m::addRating);

        // when - we call the method
        BigDecimal result = a.calculate(m);

        // then - it should have the correct result
        assertNotNull(result, "Calculate method is not implemented");
        assertEquals(6.1, result.doubleValue(), "The calculation is not correct for Movie "+m);
    }

    @Test
    void task_3_1_shouldCreateTomatoRatingsCalculatorClass() {

        // given - the class we want the students to implement
        TomatoRatingsCalculator a = Fixtures.createTomatoRatingsCalculator();

        // when - we check if it exists

        // then - it should exist
        assertTrue(a.existsClass(), "TomatoRatingsCalculator class is not defined");
    }

    @Test
    void task_3_2_shouldImplementRatingsCalculator() {

        // given - a TomatoRatingsCalculator
        TomatoRatingsCalculator a = Fixtures.createTomatoRatingsCalculator();

        // when - we check if it implements the 'RatingsCalculator' interface
        RatingsCalculator r = Fixtures.createRatingsCalculator();

        // then - it should
        assertTrue(a.implementsInterface(r.getTargetClass()), "TomatoRatingsCalculator should implement the RatingsCalculator interface");
    }

    @Test
    void task_3_3_shouldImplementCalculateMethodLogic() {

        // given - a TomatoRatingsCalculator
        TomatoRatingsCalculator a = Fixtures.createTomatoRatingsCalculator();

        // and - a Movie with ratings
        Movie m = Fixtures.createMovie();
        Stream.of(0.5, 7.2, 1.5, 1.5, 2.3, 2.0, 5.0, 5.0, 5.9, 7.7, 9.7, 9.6, 9.7, 10.0, 10.0, 10.0)
                .map(BigDecimal::valueOf).forEach(m::addRating);

        // when - we call the method
        BigDecimal result = a.calculate(m);

        // then - it should have the correct result
        assertNotNull(result, "Calculate method is not implemented");
        assertEquals(5.625, result.doubleValue(), "The calculation is not correct for Movie "+m);
    }
}
