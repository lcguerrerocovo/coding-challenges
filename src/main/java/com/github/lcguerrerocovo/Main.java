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

        swappingFail();

        System.out.println(hammingDistance(2147483647,0)); // should print '31'
        System.out.println(findComplement(5)); // should print '2'
        System.out.println(Arrays.toString(countBits(8)));

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));

        SortedArrays arrays = new SortedArrays(new int[]{1,5,6,9,12,15,17},new int[]{3,8,10,14,16,20,21});
        System.out.println("median="+arrays.findMedian());*/

        System.out.println(nailPlanks(new int[]{1,4,5,8},new int[]{4,5,9,10},new int[]{4,6,7,10,2}));



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

    public static int nailPlanks(int[] A, int[] B, int[] C) {
        int[] solution = new int[B.length];
        int max = B.length;
        for(int i=0;i<C.length;i++) {
            int[] index = search(B,C[i]);
            if(index[1] != -1) {
                int j = i;
                if (C[i] >= A[index[1]]) {
                    solution[index[1]] = 1;

                    if (C[i] == A[index[1]] && index[1] > 0) {
                        j = setPreviousPlanks(C[i], A, B, index[1]);
                        Arrays.fill(solution, j, index[1], 1);
                    }
                    if (index[0] >= 0 && index[1] <= max) {
                        j = setNextPlanks(C[i], A, B, index[1]);
                        Arrays.fill(solution, index[1], j, 1);
                    }
                }

                max = checkSolutionArray(solution, max);
                if (max == -1) return i + 1;
            }
        }
        return -1;
    }

    public static int nailPlanksBrute(int[] A, int[] B, int[] C) {
        int[] solution = new int[B.length];
        int max = B.length;
        for(int i=0;i<C.length;i++) {
            for(int j=0;j<A.length;j++) {
                if(C[i] >= A[j] && C[i] <= B[j]) {
                    if(C[i] == A[j]) {
                        for (int k = j; k >= 0; k--) {
                            if (C[i] >= A[k] && C[i] <= B[k]) {
                                solution[k] = 1;
                            }
                        }
                    }
                    if(C[i] == B[j]) {
                        for (int k = j; k < A.length; k++) {
                            if (C[i] >= A[k] && C[i] <= B[k]) {
                                solution[k] = 1;
                            }
                        }
                    }
                    solution[j] = 1;
                    break;
                }
            }
            if(sumArray(solution) == max) return i+1;
        }
        return -1;
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for(int element: arr) {
            sum += element;
        }
        return sum;
    }

    public static int setNextPlanks(int c, int[] a, int[] b, int j) {
        for(int i=j;i<b.length;i++) {
            if(!(a[i] <= c && b[i] >= c)) return i;
        }
        return b.length;
    }

    public static int setPreviousPlanks(int c, int[] a, int[] b, int j) {
        for(int i=j;i>=0;i--) {
            if(!(a[i] <= c && b[i] >= c) && i > 0)return i-1;
        }
        return 0;
    }

    public static int checkSolutionArray(int[] solution, int index) {
        if(index == 0) return -1;
        else if(solution[index-1] == 0) return index;
        else return checkSolutionArray(solution,index-1);
    }

    public static int[] search(int[] arr, int pivot) {
        int index = Arrays.binarySearch(arr,pivot);
        if(index >= 0) return new int[]{index,index};
        else {
            if(index == -(arr.length+1)) return new int[]{index,-1};
            return new int[]{index,Math.abs(index)-1};
        }
    }



}






