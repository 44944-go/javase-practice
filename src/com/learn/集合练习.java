package com.learn;

import java.util.ArrayList;

public class 集合练习 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("周");
        list.add("一");
        list.add("二");
        list.add("三");
        list.add("四");
        list.add("五");
        list.add("六");
        System.out.println(list);
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i<list.size()-1) System.out.print(list.get(i)+", ");
            else System.out.print(list.get(i));
        }
        System.out.print("]");
    }
}

