package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

import java.math.BigDecimal;

public class AverageRatingsCalculator extends ReflectionProxy {
    @Override
    public String getTargetClassName() {
        return "com.redi.j2.AverageRatingsCalculator";
    }

    public BigDecimal calculate(Movie movie) {
        if (movie.getTarget() == null) return null;
        return invokeMethod("calculate",
                new Class[] { movie.getTarget().getClass() },
                new Object[] { movie.getTarget() });
    }
}
