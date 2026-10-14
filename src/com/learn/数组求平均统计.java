package com.learn;

import java.util.Random;

public class 数组求平均统计 {
    public static void main(String[] args){
        Random r = new Random();
        int[] arr = new int[10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            arr[i] = r.nextInt(100)+1;
            sum += arr[i];
        }
        int avg = sum/10;
        int count=0;
        System.out.println("数组的平均值为："+avg);
        for (int i = 0; i < 10; i++) {
            if(arr[i]<avg){
                count++;
            }
           System.out.print(arr[i]+" ");
        }
        System.out.println("数组中小于平均值的个数为："+count);
    }
}
