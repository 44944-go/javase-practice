package com.learn;

import java.util.Scanner;

public class 罗马数的两种写法1 {
    public static void main(String[] args) {
        System.out.println("输入一串阿拉伯数字");
        Scanner sc = new Scanner(System.in);
        String num = "";
        while(true){
            num = sc.nextLine();
            boolean check = check(num);
            if (!check) {
                System.out.println("输入有误");
                continue;
            }
            break;
        }
        StringBuilder sb = new StringBuilder();
       for (int i = 0; i < num.length(); i++) {
           char c = num.charAt(i);
           sb.append(change((c-48)));
       }
       System.out.println(sb);
       String res = sb.toString();
       System.out.println(res);
    }
    public static boolean check(String num) {//判断是否为罗马数
        if(num.length()>9){
            return false;
        }
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if(c<'0'||c>'9'){
                return false;
            }
        }
        return true;
    }
    public static String change(int num){
        String [] arr={"","I ","II ","III ","IV ","V ","VI ","VII ","VIII ","IX"};
        return arr[num];
    }
}
