package com.learn;

import java.util.Scanner;

public class 字符串反转 {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(reverse(str));
    }
    public static String reverse(String str){
        String reverse = "";
        for (int i = str.length()-1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }
}
