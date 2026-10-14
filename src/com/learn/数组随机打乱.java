package com.learn;

import java.util.Random;
import java.util.Scanner;

public class 数组随机打乱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的长度");
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第"+(i+1)+"个元素");
            arr[i]=sc.nextInt();
        }
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int RandomIndex=r.nextInt(arr.length);
            int temp=arr[i];
            arr[i]=arr[RandomIndex];
            arr[RandomIndex]=temp;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }
}
