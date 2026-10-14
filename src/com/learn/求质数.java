package com.learn;

import java.util.Scanner;

public class 求质数 {
    public static void main(String[] args) {
        System.out.println("请输入一个整数");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.println("不是质数");
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("是质数");
        }
    }
}
