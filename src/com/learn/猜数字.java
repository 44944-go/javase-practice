package com.learn;
import java.util.Random;
import java.util.Scanner;

public class 猜数字 {
    public static void main(String[] args) {
        Random r = new Random();
        int x = r.nextInt(100)+1;
        System.out.println("请输入一个1-100之间的整数");
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int count = 0;
        while(true){
            if(y==x){
                System.out.println("恭喜你猜对了"+"一共猜了"+count+"次");
                break;
            }else  if(y>x){
                System.out.println("你猜的数字太大了");
            }else{
                System.out.println("你猜的数字太小了");
            }
            System.out.println("请重新输入");
            count++;
            y = sc.nextInt();
        }

    }
}
