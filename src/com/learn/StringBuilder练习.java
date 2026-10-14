package com.learn;

public class StringBuilder练习 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append("world");
        System.out.println(sb);
        sb.reverse();//反转
        System.out.println(sb);
        System.out.println(sb.length());
        String str = sb.toString();
        System.out.println(str);

    }
}
