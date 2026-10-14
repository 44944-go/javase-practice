package com.learn;

import java.util.Scanner;

public class 回文数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = x;
        int res = 0;
        while(y!=0){
            int temp = y%10;
            y=y/10;
            res = res*10+temp;
        }
        System.out.println(res);
        if(x == res){
            System.out.println("是回文数");
        }else {
            System.out.println("不是回文数");
        }
    }
}
