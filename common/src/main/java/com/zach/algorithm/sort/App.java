package com.zach.algorithm.sort;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] a = {1,2,4,5,5,6,6,7,7,7,7,76,5,5,4,4,3,3,3,3,3};
        int i = Arrays.binarySearch(a, 1);
        System.out.println(i);

        int i1 = Arrays.binarySearch(a, 7);

        System.out.println(i1);
    }
}
