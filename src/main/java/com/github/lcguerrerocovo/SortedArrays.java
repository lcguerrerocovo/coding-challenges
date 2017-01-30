package com.github.lcguerrerocovo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by luisguerrero on 1/30/17.
 */
public class SortedArrays {

    private int[] xarr;
    private int[] yarr;
    private int xk;
    private int yl;
    private int sizex;
    private int sizey;
    private double median;

    SortedArrays(int[] xarr,int[] yarr) {
        if(xarr.length == 0) {
            median = singleArrayMedian(yarr,0);
        } else if(yarr.length == 0) {
            median = singleArrayMedian(xarr,0);
        } else {
            int xk = (xarr.length/2);
            int yl = (yarr.length/2);
            if(xarr[xk] < yarr[yl]) {
                this.xarr = xarr;
                this.yarr = yarr;
                this.xk = xk;
                this.yl = yl;
            } else {
                this.yarr = xarr;
                this.xarr = yarr;
                this.xk = yl;
                this.yl = xk;
            }
            median = -1d;
        }
    }

    public double findMedian() {
        if(median != -1) return median;
        else {
            return findMedianSortedArrays(false);
        }
    }

    protected double findMedianSortedArrays(boolean stable) {
        if(stable) {
            if(xk == xarr.length-1 && yl == 0) {
                if(xarr.length-1 == yarr.length-1) return singleArrayMedian(new int[]{xarr[xk],yarr[yl]},0);
                else if(xarr.length-1 < yarr.length-1) return singleArrayMedian(yarr,(xarr.length));
                else if(xarr.length-1 > yarr.length-1) return singleArrayMedian(xarr,-(yarr.length));
            }
            return median(xarr,yarr,xk,yl,stable);
        } else {
            int m1 = xarr[xk];
            int m2 = yarr[yl];
            xk = search(xarr, yarr[yl], 1);
            yl = search(yarr, xarr[xk], 2);
            if (xarr[xk] == m1 && yarr[yl] == m2) stable = true;
            return findMedianSortedArrays(stable);
        }
    }

    protected double singleArrayMedian(int[] array, int offset) {
        int index = ((array.length + offset)/2) - offset;
        if((array.length+offset) % 2 == 0) {
            return (array[index - 1] + array[index])/2d;
        } else {
            return array[index];
        }
    }

    protected double median(int[] xarr, int[] yarr, int xk, int yl, boolean stable) {
        int ltMedian = xk + yl;
        int gtMedian = (xarr.length - xk - 1) + (yarr.length - yl - 1);
        if (stable) {
            int[] s = (ltMedian <= gtMedian) ? new int[]{ltMedian,1} : new int[]{gtMedian,-1};

            List<Double> medianList = new ArrayList<>((s[1] == 1) ?
                    Arrays.asList((double)xarr[xk],(double)yarr[yl])
                    : Arrays.asList((double)yarr[yl],(double)xarr[xk]));
            medianList = medianList(xarr,yarr,xk,yl,s[0],s[1],medianList);
            if(medianList.size() > 1)
                medianList = medianList.stream().map(n -> n/2).collect(Collectors.toList());
            return medianList.stream().reduce(0.0, Double::sum);
        }
        return -1;
    }

    protected List<Double> medianList(int[] xarr, int[] yarr, int xk, int yl, int s,int direction, List<Double> medianList) {
        int size = xarr.length + yarr.length;
        int medianListSize = ((int) Math.ceil((size)/2d) + ((size+1) % 2)) -  s;
        if(medianList.size() >= medianListSize) {
            medianListSize = medianList.size();
            int fromIndex = medianListSize - ((size+1) % 2) - 1;
            return medianList.subList(fromIndex,medianListSize);
        } else {
            if((direction > 0) ?
                    getWithOffset(xarr,xk,direction) <= getWithOffset(yarr,yl,direction) :
                    getWithOffset(xarr,xk,direction) >= getWithOffset(yarr,yl,direction)) {
                medianList.add((double) getWithOffset(xarr,xk,direction));
                return medianList(xarr, yarr, xk+direction,yl,s,direction,medianList);
            } else {
                medianList.add((double) getWithOffset(yarr,yl,direction));
                return medianList(xarr, yarr, xk, yl+direction,s,direction,medianList);
            }
        }
    }

    protected int getWithOffset(int[] arr, int index, int offset) {
        if (index+offset < 0) {
            return (int) Double.NEGATIVE_INFINITY;
        } else if(index+offset >= arr.length) {
            return (int) Double.POSITIVE_INFINITY;
        } else return arr[index+offset];
    }

    protected int search(int[] array, int pivot, int firstOrSecond) {
        int result =  Arrays.binarySearch(array, pivot);
        if(result == -1) return 0;
        else if (result >= 0) return result;
        else {
            if(firstOrSecond == 1) return Math.abs(result) - 2;
            return Math.abs(result) - 1;
        }
    }
}
