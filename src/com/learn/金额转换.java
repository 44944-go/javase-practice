package com.learn;

import java.util.Scanner;

public class 金额转换 {
    public static void main(String[] args) {
        System.out.println("请输入一个金额");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int temp = num;
//        System.out.println(count(num));
        int count = count(num);
        String str = "";
        for (int i = 0; i < count; i++) {//将数字转换为大写
            int ge = temp%10;
            temp = temp/10;
//            System.out.print(getCapital(ge));
            str = getCapital(ge)+str;
        }
        System.out.println(str);
        int fix = 7 - count;
        for (int i = 0; i < fix; i++) {//补零
            str = "零"+str;
        }
        System.out.println(str);
        String [] s ={"佰","拾","万","仟","佰","拾","元"};
        String res ="";
        for (int i = 0; i < s.length; i++) {//加上单位
            res += str.charAt(i)+s[i];
        }
        System.out.println(res);
    }
    public static int count(int num){//统计数字的位数
        int count = 0;
        while(num!=0){
            num=num/10;
            count++;
        }
        return count;
    }
    public static String getCapital(int num){//将数字转换为大写
        String[] s = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        return s[num];
    }
}
