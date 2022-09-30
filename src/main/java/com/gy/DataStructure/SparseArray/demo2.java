package com.gy.DataStructure.SparseArray;

import java.util.Arrays;
import java.util.Comparator;

public class demo2 {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 2));
        System.out.println(Math.ceil(2.23));
        System.out.println(Math.floor(2.23));
        System.out.println(Math.round(2.55));
        System.out.println(Math.cbrt(9));
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 6) + 2);
        }

        String[] arr = {"23","32","12","11"};
        Arrays.sort(arr,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.parseInt((String) o1)-Integer.parseInt((String) o2);
            }
        });
        for (String s : arr) {
            System.out.print(s+"\t");
        }
    }

}
