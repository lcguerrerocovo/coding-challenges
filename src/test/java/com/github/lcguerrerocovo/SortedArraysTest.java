package com.github.lcguerrerocovo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SortedArraysTest {

    int[] arr = new int[]{1,2,3,4,5,6,8};
    int[] arr2 = new int[]{9,10,11,13,14,15};

    SortedArrays sortedArrays = new SortedArrays(arr,arr2);

    @Test
    public void searchAllGreaterThanPivot() {
        assertThat(sortedArrays.search(arr,9,1), is(arr.length-1));
    }

    @Test
    public void searchAllLessThanPivot() {
        assertThat(sortedArrays.search(arr2,8,2), is(0));
    }

    @Test
    public void searchIndexOfLessThanPivot() {
        //assertThat(Main.search(arr,7,1), is(5)); // 1,2,3,4,5,6(7),8 index has to be <= 7 since searching in 1st array
        //assertThat(Main.search(arr2,12,2), is(2)); // 9,10,11(12),13,14,15 index has to be >= 12 since searching in 2nd array
    }

    @Test
    public void seachIndexOfPivotInArray() {
        assertThat(sortedArrays.search(arr,4,1), is(3));
    }

    @Test
    public void correctMedian() {
        //assertThat(Main.median(new int[]{1,5,6,9,12,15,17},new int[]{3,8,10,14,16,20,21},4,2),is(true));
    }

    @Test
    public void satisfyOnlyOrderingCheck() {
       // assertThat(Main.median(new int[]{1,5,6,9,12,15,17},new int[]{3,8,10,14,16,20,21},3,1),is(false));
    }

    @Test
    public void satisfyOnlyPartitionCheck() {
       // assertThat(Main.median(new int[]{1,5,6,9,12,15,17},new int[]{3,8,10,14,16,20,21},5,1),is(false));
    }

    @Test
    public void medianOfTwoSameSizeArrays() {
        assertThat(new SortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{3,8,10,14,16,20,21}).findMedian(),is(11d));
    }

    @Test
    public void medianOfTwoSameSizeArrays2() {
        assertThat(new SortedArrays(new int[]{1,5,6,9,19,24,30},new int[]{3,8,10,12,16,20,21}).findMedian(),is(11d));
    }

    @Test
    public void medianOfTwoSameSizeArrays3() {
        assertThat(new SortedArrays(new int[]{1,5,6,9,10,12,30},new int[]{3,8,16,19,20,21,24}).findMedian(),is(11d));
    }

    @Test
    public void medianOfDifferentSizeArrays() {
        assertThat(new SortedArrays(new int[]{1,5,6,9,12,13,15,17},new int[]{3,8,10,14,16,20,21}).findMedian(),is(12d));
        //assertThat(Main.findMedianSortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{2,3,8,10,14,16,20,21}),is(10d));
    }

    @Test
    public void smallTest() {
        assertThat(new SortedArrays(new int[]{1,2,3},new int[]{4}).findMedian(),is(2.5d));
        //assertThat(Main.findMedianSortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{2,3,8,10,14,16,20,21}),is(10d));
    }

    @Test
    public void emptyArray() {
        assertThat(new SortedArrays(new int[]{},new int[]{1}).findMedian(),is(1d));
        //assertThat(Main.findMedianSortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{2,3,8,10,14,16,20,21}),is(10d));
    }


    @Test
    public void emptyArray10() {
        assertThat(new SortedArrays(new int[]{},new int[]{1,2,3}).findMedian(),is(2d));
        //assertThat(Main.findMedianSortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{2,3,8,10,14,16,20,21}),is(10d));
    }


    @Test
    public void emptyArray2() {
        assertThat(new SortedArrays(new int[]{},new int[]{2,3}).findMedian(),is(2.5d));
        //assertThat(Main.findMedianSortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{2,3,8,10,14,16,20,21}),is(10d));
    }

    @Test
    public void emptyArray3() {
        assertThat(new SortedArrays(new int[]{1},new int[]{2,3,4}).findMedian(),is(2.5d));
        //assertThat(Main.findMedianSortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{2,3,8,10,14,16,20,21}),is(10d));
    }

    @Test
    public void emptyArray5() {
        assertThat(new SortedArrays(new int[]{1,1},new int[]{1,1}).findMedian(),is(1d));
        //assertThat(Main.findMedianSortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{2,3,8,10,14,16,20,21}),is(10d));
    }

    @Test
    public void otherTest() {
        assertThat(new SortedArrays(new int[]{2},new int[]{1,3,4,5,6}).findMedian(),is(3.5d));
    }
}
