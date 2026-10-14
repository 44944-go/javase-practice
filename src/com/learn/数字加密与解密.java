package com.learn;

import java.util.Scanner;

public class 数字加密与解密 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入加密数的长度");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("请输入第" + (i + 1) + "个元素");
            arr[i] = sc.nextInt();
        }
        int code = Code(arr);
        int[] Res = Transform(code);
        System.out.println("加密后的数组为");
        for (int j :Res){
            System.out.print(j + " ");
        }
        System.out.println();
        int code1 = DeCode(Res);
        System.out.println("解密后的数字为 " + code1);

    }
    public static int Code(int[] arr){//数组加密为数字
        for (int i = 0; i < arr.length; i++) {
            arr[i]=arr[i]+5;
        }
        for (int i = 0; i < arr.length; i++) { 
            arr[i]=arr[i]%10;
        }
        extracted(arr);
        //        System.out.print(code);
        return DeTransform(arr);
    }
    public static int[] Transform(int code){//数字转换为数组
        int count = 0;
        int temp = code;
        while (temp != 0) {
            temp = temp/10;
            count++;
        }
        int[] arr = new int[count];
        for (int i = arr.length-1; i >= 0; i--) {
            arr[i] = code%10;
            code = code/10;
        }
        return arr;
    }
    public static int DeTransform(int[] arr){//数组转换为数字
        int number=0;
        for (int j : arr) {
            number = number*10+j;
        }
        return number;
    }
    public static int DeCode(int[] arr){//数组解密为数字
        extracted(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=0&&arr[i]<=4){
                arr[i]=arr[i]+10;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=arr[i]-5;
        }
        return DeTransform(arr);
    }

    public static void extracted(int[] arr) {//数组反转
        for (int i = 0; i < arr.length/2; i++) {
            int temp= arr[i];
            arr[i]= arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
    }
}
