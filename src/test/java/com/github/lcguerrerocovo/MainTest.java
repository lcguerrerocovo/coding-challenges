package com.github.lcguerrerocovo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MainTest {

    int[] arr = new int[]{1,2,3,4,5,6,8};
    int[] arr2 = new int[]{9,10,11,13,14,15};

    @Test
    public void searchAllGreaterThanPivot() {
        assertThat(Main.search(arr,9), is(arr.length-1));
    }

    @Test
    public void searchAllLessThanPivot() {
        assertThat(Main.search(arr2,8), is(0));
    }

    @Test
    public void searchIndexOfLessThanPivot() {
        assertThat(Main.search(arr,7), is(5));
        assertThat(Main.search(arr2,12), is(2));
    }

    @Test
    public void seachIndexOfPivotInArray() {
        assertThat(Main.search(arr,4), is(3));
    }

    @Test
    public void medianOfTwoSameSizeArrays() {
        assertThat(Main.findMedianSortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{3,8,10,14,16,20,21}),is(11d));
    }

    @Test
    public void medianOfDifferentSizeArrays() {
        assertThat(Main.findMedianSortedArrays(new int[]{1,5,6,9,12,13,15,17},new int[]{3,8,10,14,16,20,21}),is(12d));
        assertThat(Main.findMedianSortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{2,3,8,10,14,16,20,21}),is(10d));
    }
}
