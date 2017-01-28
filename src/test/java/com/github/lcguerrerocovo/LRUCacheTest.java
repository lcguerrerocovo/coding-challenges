package com.github.lcguerrerocovo;

import com.github.lcguerrerocovo.LRUCache;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by luisguerrero on 1/27/17.
 */
public class LRUCacheTest {

    @Test
    public void cacheAndQueueHaveCorrectSize() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        assertThat(cache.queue.size(), is(2));
        assertThat(cache.map.size(), is(2));
    }

    /*@Test
    public void sizeReturnsNumberOfElements() {
        List instance = new ArrayList();
        instance.add(new Object());
        instance.add(new Object());
        assertThat(instance.size(), is(2));
    } */



}
