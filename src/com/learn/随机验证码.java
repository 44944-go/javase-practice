package com.learn;

import java.util.Random;

public class 随机验证码 {
    public static void main(String[] args) {
        Random r = new Random();
        char[] ch = new char[52];
        for (int i = 0; i < 52; i++) {
            if(i<26){
                ch[i]=(char)(65+i);
            }else{
                ch[i]=(char)(97+i-26);
            }
//            System.out.println(ch[i]);
        }
        String Res = "";
        for (int i = 0; i < 4; i++) {
            int RandomIndex = r.nextInt(52);
            Res=Res+ch[RandomIndex];
        }
        int num = r.nextInt(10);
        System.out.println(Res+num);

    }
}
