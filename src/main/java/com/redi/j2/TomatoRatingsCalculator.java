package com.redi.j2;

import java.math.BigDecimal;
import java.util.Map;

public class TomatoRatingsCalculator implements RatingsCalculator{

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
            if (rating.floatValue() > 5.0f) {
                sum = sum.add(new BigDecimal(occurrences));
            }
        }
        return sum.divide(new BigDecimal(divider)).multiply(new BigDecimal(10));
    }
}
