package com.learn;

import java.util.Scanner;

public class 字符串拼接 {
    public static void main(String[] args) {
        System.out.println("请输入一个整数");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(concat(arr));
    }
    public static String concat(int [] arr){
        if (arr.length == 0) {
            return "[]";
        }
        if (arr.length == 1) {
            return "";
        }
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i<arr.length-1){
            str += arr[i]+",";
            }else  {
                str += arr[i];
            }
        }
        str += "]";
        return str;
    }
}
