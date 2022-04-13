package com.redi.j2;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class AverageRatingsCalculator implements RatingsCalculator{

    @Override
    public BigDecimal calculate(Movie m) {
        BigDecimal sum = new BigDecimal(0);
        int divider = 0;
        Map<BigDecimal, Integer> ratings =  m.getRatings();
        if (ratings.size() == 0) {
            return new BigDecimal(0);
        }
        for (BigDecimal rating : ratings.keySet()) {
            int occurrences = ratings.get(rating);
            divider+=occurrences;
            sum = sum.add(rating.multiply(new BigDecimal(occurrences)));
        }
        return sum.divide(new BigDecimal(divider));
    }
}
