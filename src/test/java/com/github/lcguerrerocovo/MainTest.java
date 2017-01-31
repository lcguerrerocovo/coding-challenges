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

    @Test
    public void testOverlapping() {
        assertThat(Main.overlapping(new int[]{1},new int[]{1}),is(1));
    }

    @Test
    public void testOverlapping2() {
        assertThat(Main.overlapping(new int[]{1, 3, 7, 9, 9},new int[]{5, 6, 8, 9, 10}),is(3));
    }

    @Test
    public void testOverlapping3() {
        assertThat(Main.overlapping(new int[]{},new int[]{}),is(0));
    }

    @Test
    public void normalRotate() {
        int[] a = {1,2,3,4,5,6,7};
        Main.rotate(a,3);
        assertThat(a,is(new int[]{5,6,7,1,2,3,4}));
    }

    @Test
    public void normalRotateSizeLessThanKTimes2() {
        int[] a = {1,2,3,4,5};
        Main.rotate(a,3);
        assertThat(a,is(new int[]{3,4,5,1,2}));
    }

    @Test
    public void rotateArrayMoreThanSize() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        Main.rotate(a, 4);
        assertThat(a, is(new int[]{4, 5, 6, 7, 1, 2, 3}));
    }

    @Test
    public void rotateArrayMoreThanSizeWithModulo() {
        int[] a = {1,2,3,4,5,6,7};
        Main.rotate(a,11);
        assertThat(a,is(new int[]{4,5,6,7,1,2,3}));
    }

    @Test
    public void rotateSingleElementArray() {
        int[] a = {1};
        Main.rotate(a,1);
        assertThat(a,is(new int[]{1}));
    }

    @Test
    public void rotateSmallArray() {
        int[] a = {1,2,3};
        Main.rotate(a,2);
        assertThat(a,is(new int[]{2,3,1}));
    }

    @Test
    public void rotateArraySameSizeAsKTimes2() {
        int[] a = {1,2,3,4,5,6};
        Main.rotate(a,1);
        assertThat(a,is(new int[]{6,1,2,3,4,5}));
    }
}
