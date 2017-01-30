package com.github.lcguerrerocovo;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        /*System.out.println(anagramChecker("eaosir", "roseia"));

        xorSwap(45,67);

        Fibonacci fib = new Fibonacci();

        for(int i=0; i< 10; i++) {
            System.out.println("n=" + i);
            System.out.println("fib iter=" + fibonacci(i));
            System.out.println("fib recu=" + fib.nth(i));
        }

        Stack stack = new Stack();
        stack.push(5);
        stack.push(10);
        stack.push(1);
        System.out.println(stack.min());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        swappingFail();             */


        //System.out.println(hammingDistance(2147483647,0)); // should print '31'

        //System.out.println(findComplement(5)); // should print '2'

        //System.out.println(Arrays.toString(countBits(8)));

        /*LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        
        cache.put(2, 2);
        
        System.out.println(cache.get(1));       // returns 1
        
        cache.put(3, 3);    // evicts key 2
        
        System.out.println(cache.get(2));       // returns -1 (not found)
        
        cache.put(4, 4);    // evicts key 1
        
        System.out.println(cache.get(1));       // returns -1 (not found)
        
        System.out.println(cache.get(3));       // returns 3
        
        System.out.println(cache.get(4));
          */

        /*long startTime = System.nanoTime();

        LRUCache cache = new LRUCache(10);
        cache.put(10,13);
        cache.put(3,17);
        cache.put(6,11);
        cache.put(10,5);
        cache.put(9,10);
        cache.get(13);
        cache.put(2,19);
        cache.get(2);
        cache.get(3);
        cache.put(5,25);
        cache.get(8);
        cache.put(9,22);
        cache.put(5,5);
        cache.put(1,30);
        cache.get(11);
        cache.put(9,12);
        cache.get(7);
        cache.get(5);
        cache.get(8);
        cache.get(9);
        cache.put(4,30);
        cache.put(9,3);
        cache.get(9);
        cache.get(10);
        cache.get(10);
        cache.put(6,14);
        cache.put(3,1);
        cache.get(3);
        cache.put(10,11);
        cache.get(8);
        cache.put(2,14);
        cache.get(1);
        cache.get(5);
        cache.get(4);
        cache.put(11,4);
        cache.put(12,24);
        cache.put(5,18);
        cache.get(13);
        cache.put(7,23);
        cache.get(8);
        cache.get(12);
        cache.put(3,27);
        cache.put(2,12);
        cache.get(5);
        cache.put(2,9);
        cache.put(13,4);
        cache.put(8,18);
        cache.put(1,7);
        cache.get(6);
        cache.put(9,29);
        cache.put(8,21);
        cache.get(5);
        cache.put(6,30);
        cache.put(1,12);
        cache.get(10);
        cache.put(4,15);
        cache.put(7,22);
        cache.put(11,26);
        cache.put(8,17);
        cache.put(9,29);
        cache.get(5);
        cache.put(3,4);
        cache.put(11,30);
        cache.get(12);
        cache.put(4,29);
        cache.get(3);
        cache.get(9);
        cache.get(6);
        cache.put(3,4);
        cache.get(1);
        cache.get(10);
        cache.put(3,29);
        cache.put(10,28);
        cache.put(1,20);
        cache.put(11,13);
        cache.get(3);
        cache.put(3,12);
        cache.put(3,8);
        cache.put(10,9);
        cache.put(3,26);
        cache.get(8);
        cache.get(7);
        cache.get(5);
        cache.put(13,17);
        cache.put(2,27);
        cache.put(11,15);
        cache.get(12);
        cache.put(9,19);
        cache.put(2,15);
        cache.put(3,16);
        cache.get(1);
        cache.put(12,17);
        cache.put(9,1);
        cache.put(6,19);
        cache.get(4);
        cache.get(5);
        cache.get(5);
        cache.put(8,1);
        cache.put(11,7);
        cache.put(5,2);
        cache.put(9,28);
        cache.get(1);
        cache.put(2,2);
        cache.put(7,4);
        cache.put(4,22);
        cache.put(7,24);
        cache.put(9,26);
        cache.put(13,28);
        cache.put(11,26);
        long endTime = System.nanoTime();
        System.out.println("    time spent in execution:" + (endTime - startTime));*/

        findMedianSortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{3,8,10,14,16,20,21});

        double result = findMedianSortedArrays(new int[]{1,2,3,4,5,6,7},new int[]{8,9,10,11,12,13,14});
        System.out.println("result="+result);



    }

    private static boolean anagramChecker(String first, String second) {
        String str = first + second;
        int sum = 0;
        for (char c : str.toCharArray()) {
            sum ^= c;
        }

        boolean isAnagram = false;
        if(sum == 0) isAnagram = true;

        return isAnagram;
    }

    private static void xorSwap(int a, int b) {
        System.out.println("input= a:" + a + " b:" + b);
        b = b ^ a;
        a = a ^ b;
        b = a ^ b;
        System.out.println("output= a:" + a + " b:" + b);
    }

    private static int fibonacci(int n) {
        int result = 0;
        if(n > 0 && n < 3) result = 1;
        else if(n >= 3) {
            int prev = 1;
            result = 1;
            for (int i = 2; i < n; i++) {
                int next = prev + result;
                prev = result;
                result = next;
            }
        }

        return result;
    }

    public static int hammingDistance(int x, int y) {
        int[] a = intToBinary(x,new int[]{});
        int[] b = intToBinary(y,new int[]{});

        if(a.length > b.length) return getDistance(a,b,0);
        else return getDistance(b,a,0);
    }

    private static int getDistance(int[] a, int[] b, int distance) {
        for(int i=0; i < a.length; i++) {
            int bValue = 0;
            if(i < b.length) bValue = b[i];
            if(a[i] != bValue) ++distance;
        }
        return distance;
    }

    private static int[] intToBinary(int decimal, int [] binaryArr) {
        if(decimal > 0) {
            int[] newArr = Arrays.copyOf(binaryArr,binaryArr.length+1);
            newArr[newArr.length-1] = (decimal % 2);
            return intToBinary(decimal / 2, newArr);
        }  else return binaryArr;
    }

    public static int findComplement(int num) {
        int[] a = intToBinary(num,new int[]{});

        int decimal = 1;
        int result = 0;

        for(int i=0; i < a.length; i++) {
            a[i] ^= 1;
            result += decimal * a[i];
            decimal *= 2;
        }

        return result;
    }

    public static int[] countBits(int num) {
        int[] arr = new int[num+1];
        int power = 1;
        for (int i = 1; i <= num; i++) {
            if (i > 1 && (i % power) == 0)
                power *= 2;
            arr[i] = arr[i % power] + 1;
        }
        return arr;
    }

    private static void swappingFail() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,0);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(" ");
        Point.trickySwap(p1,p2);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = (nums1.length/2);
        int index2 = (nums2.length/2);
        if(nums1.length == 0) {
            return singleArrayMedian(nums2,0);
        } else if(nums2.length == 0) {
            return singleArrayMedian(nums1,0);
        }
        if(nums1[index1] < nums2[index2]) {
            return findMedianSortedArrays(nums1,nums2,index1,index2,false);
        }  else {
            return findMedianSortedArrays(nums2,nums1,index2,index1,false);
        }

    }

    private static double singleArrayMedian(int[] array, int offset) {
        int index = (array.length)/2 + offset;
        if((array.length+offset) % 2 == 0) {
            return (array[index - 1] + array[index])/2d;
        } else {
            return array[index];
        }
    }

    public static double findMedianSortedArrays(int[] xarr, int[] yarr, int xk, int yl, boolean stable) {
        if(stable) {
            if(xk == xarr.length-1 && yl == 0) {
                if(xarr.length-1 == yarr.length-1) return singleArrayMedian(new int[]{xarr[xk],yarr[yl]},0);
                else if(xarr.length-1 < yarr.length-1) return singleArrayMedian(yarr,-(xarr.length));
                else if(xarr.length-1 > yarr.length-1) return singleArrayMedian(xarr,(yarr.length));
            }
            return median(xarr,yarr,xk,yl,stable);
        } else {
            int m1 = xarr[xk];
            int m2 = yarr[yl];
            xk = search(xarr, yarr[yl], 1);
            yl = search(yarr, xarr[xk], 2);
            if (xarr[xk] == m1 && yarr[yl] == m2) stable = true;
            return findMedianSortedArrays(xarr, yarr, xk, yl, stable);
        }
    }


    protected static int median(int[] xarr, int[] yarr, int xk, int yl, boolean stable) {
        //validateRange(xarr,xk);
        //validateRange(yarr,yl);
        int ltMedian = xk + yl;
        int gtMedian = (xarr.length - xk - 1) + (yarr.length - yl - 1);
        if (/*(xk + 1 <= xarr.length - 1 && yarr[yl] <= xarr[xk + 1])
                && (yl - 1 >= 0 && xarr[xk] >= yarr[yl - 1])
                && Math.abs(gtMedian-ltMedian) <= 2
                && xarr[xk] < yarr[yl]*/stable) {
            int[] s = (ltMedian <= gtMedian) ? new int[]{ltMedian,1} : new int[]{gtMedian,-1};

            List<Integer> medianList = new ArrayList<>((s[1] == 1) ? Arrays.asList(xarr[xk],yarr[yl]) : Arrays.asList(yarr[yl],xarr[xk]));
            medianList = medianList(xarr,yarr,xk,yl,s[0],s[1],medianList);
            if(medianList.size() > 1)
                medianList = medianList.stream().map(n -> n/2).collect(Collectors.toList());;
            return medianList.stream().mapToInt(Integer::intValue).sum();
        }
        return -1;
    }

    protected static List<Integer> medianList(int[] xarr, int[] yarr, int xk, int yl, int s,int direction, List<Integer> medianList) {
        int size = xarr.length + yarr.length;
        int medianListSize = ((int) Math.ceil((size)/2d) + ((size+1) % 2)) -  s;
        if(medianList.size() >= medianListSize) {
            medianListSize = medianList.size();
            int fromIndex = medianListSize - ((size+1) % 2) - 1;
            return medianList.subList(fromIndex,medianListSize);
        } else {
            if((direction == 1)
                    ? (xarr[xk+direction] <= yarr[yl+direction]) :
                    (xarr[xk+direction] >= yarr[yl+direction])) {
                medianList.add(xarr[xk+direction]);
                return medianList(xarr, yarr, xk+direction,yl,s,direction,medianList);
            } else {
                medianList.add(yarr[yl+direction]);
                return medianList(xarr, yarr, xk, yl+direction,s,direction,medianList);
            }
        }
    }

    private static void validateRange(int[] arr, int index) {
        if (index < 0 || index > arr.length-1) {
            throw new IllegalArgumentException("index out of array range");
        }
    }

    protected static int search(int[] array, int pivot, int firstOrSecond) {
        int result =  Arrays.binarySearch(array, pivot);
        if(result == -1) return 0;
        else if (result >= 0) return result;
        else {
            if(firstOrSecond == 1) return Math.abs(result) - 2;
            return Math.abs(result) - 1;
        }
    }



}






