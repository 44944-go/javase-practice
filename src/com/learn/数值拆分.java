package com.learn;
import java.util.Scanner;
public class 数值拆分 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个三位数");
        int i = sc.nextInt();
        int ge = i%10;
        int shi = i/10%10;
        int bai = i/100%10;
        System.out.println("个位为"+ge);
        System.out.println("十位为"+shi);
        System.out.println("百位为"+bai);
    }
}
