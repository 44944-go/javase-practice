package com.learn;

import java.util.Scanner;

public class 用户登录练习 {
    public static void main(String[] args) {
        System.out.println("用户登录练习");
        String username = "admin";
        String password = "123456";
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名");
            String UserName1 = sc.next();
            System.out.println("请输入密码");
            String PassWord1 = sc.next();
            if (username.equals(UserName1) && password.equals(PassWord1)) {
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败"+"还有"+(2-i)+"次机会");
                if ((i+1)==3){
                    System.out.println("账号已被锁定");
                }
            }
        }

    }
}
