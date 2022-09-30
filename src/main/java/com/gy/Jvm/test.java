package com.gy.Jvm;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(1);
        System.out.println("------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
