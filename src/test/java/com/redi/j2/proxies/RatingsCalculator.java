package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

public class RatingsCalculator extends ReflectionProxy {
    @Override
    public String getTargetClassName() {
        return "com.redi.j2.RatingsCalculator";
    }
}
