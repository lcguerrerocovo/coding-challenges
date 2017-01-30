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
    public void seachIndexOfPivotInArray() {
        assertThat(sortedArrays.search(arr,4,1), is(3));
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
    }

    @Test
    public void smallTest() {
        assertThat(new SortedArrays(new int[]{1,2,3},new int[]{4}).findMedian(),is(2.5d));
    }

    @Test
    public void emptyArray() {
        assertThat(new SortedArrays(new int[]{},new int[]{1}).findMedian(),is(1d));
    }


    @Test
    public void emptyArray2() {
        assertThat(new SortedArrays(new int[]{},new int[]{1,2,3}).findMedian(),is(2d));
    }


    @Test
    public void emptyArray3() {
        assertThat(new SortedArrays(new int[]{},new int[]{2,3}).findMedian(),is(2.5d));
    }

    @Test
    public void smallTest2() {
        assertThat(new SortedArrays(new int[]{1},new int[]{2,3,4}).findMedian(),is(2.5d));
    }

    @Test
    public void allValuesSame() {
        assertThat(new SortedArrays(new int[]{1,1},new int[]{1,1}).findMedian(),is(1d));
    }

    @Test
    public void otherTest() {
        assertThat(new SortedArrays(new int[]{2},new int[]{1,3,4,5,6}).findMedian(),is(3.5d));
    }
}
