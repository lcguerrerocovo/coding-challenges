package com.github.lcguerrerocovo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by luisguerrero on 1/31/17.
 */
public class MainTest {


    @Test
    public void test() {
        assertThat(Main.countRopes(0,new int[]{}),is(0));
    }

    @Test
    public void test0() {
        assertThat(Main.countRopes(1,new int[]{}),is(0));
    }

    @Test
    public void test1() {
        assertThat(Main.countRopes(1,new int[]{1}),is(1));
    }
}
