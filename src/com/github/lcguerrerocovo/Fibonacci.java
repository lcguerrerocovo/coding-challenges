package com.github.lcguerrerocovo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * fibonacci recursive solution using meoization
 */

class Fibonacci {

    private static Map<Integer,Integer> cache = new ConcurrentHashMap<Integer, Integer>();

    public Fibonacci() {
        cache.put(0,0);
        cache.put(1,1);
        cache.put(2,1);
    }

    public static Integer nth(int n) {
        if(n > 2) {
            if (!cache.containsKey(n - 2)) cache.put(n - 2, nth(n - 4) + nth(n - 3));
            if (!cache.containsKey(n - 1)) cache.put(n - 1, nth(n - 3) + nth(n - 2));

            cache.put(n, cache.get(n - 1) + cache.get(n - 2));
        }
        return cache.get(n);
    }

}
