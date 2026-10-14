package com.learn;

import java.util.Scanner;

public class 罗马数2 {
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
            sb.append(change(c));
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
    public static String change(char num){
        String str = switch (num){
            case '1' ->  "I ";
            case '2' ->  "II ";
            case '3' ->  "III ";
            case '4' ->  "IV ";
            case '5' ->  "V ";
            case '6' ->  "VI ";
            case '7' ->  "VII ";
            case '8' ->  "VIII ";
            case '9' ->  "IX";
            default ->   "";
        };
        return str;
    }
}
