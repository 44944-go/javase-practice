package com.learn;

public class 数组求最值 {
    public static void main(String[] args){
        int[] arr = {12,25,35,4,54,56,17,82,91,10};
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("数组的最大值为："+max);
        System.out.println("数组的最小值为："+min);
    }
}
