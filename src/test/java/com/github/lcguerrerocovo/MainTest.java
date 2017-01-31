package com.github.lcguerrerocovo;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by luisguerrero on 1/31/17.
 */
public class MainTest {

    @Test
    public void testRandomArray() {
        int max = ThreadLocalRandom.current().nextInt(0, 51);
        int[] a = new int[max];
        int[] b = new int[max];
        int[] c = new int[400];
        int firsta = ThreadLocalRandom.current().nextInt(0, 5);
        int firstb = ThreadLocalRandom.current().nextInt(firsta, firsta+5);
        for(int i=1;i<max;i++) {
            a[i] = ThreadLocalRandom.current().nextInt(a[i-1], a[i-1]+5);
            b[i] = ThreadLocalRandom.current().nextInt(a[i], a[i]+5);
        }

        for(int i=0;i<400;i++) {
            c[i] = ThreadLocalRandom.current().nextInt(0, 100);
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));


        System.out.println(Main.nailPlanks(a,b,c));
        System.out.println(Main.nailPlanksBrute(a,b,c));
        //int[] x = new int[]{74, 19, 41, 77, 69, 38, 29, 59, 85, 14, 48, 71, 86, 96, 39, 54, 37, 37, 49, 22, 0, 29, 66, 91, 95, 77, 14, 16, 27, 52, 90, 78, 49, 88, 23, 63, 2, 35, 97};
        //System.out.println(Main.nailPlanksBrute(new int[]{0},new int[]{0},x));
        //System.out.println(Main.nailPlanks(new int[]{0},new int[]{0},x));

    }
}
