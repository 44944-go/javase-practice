package com.learn;

import java.util.Scanner;

public class 最后一个单词长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getLastWordLength(str));
    }
    public static int getLastWordLength(String str){
        int count = 0;
        for (int i =(str.length()-1);str.charAt(i)!=' ';i--){
            count++;
        }
        return count;
    }
}
