package com.learn;

public class 调整字符串 {
    public static void main(String[] args) {
        String str = "abcde";
        String str2 = "cdeab";
        for (int i = 0; i < str.length(); i++) {
             str = rotate(str);
             if (str.equals(str2)){
                 System.out.println(true);
                return;
             }
        }
        System.out.println(false);
    }
    public static String rotate(String str){
        String first = str.substring(0,1);
        String rest = str.substring(1);
        return rest+first;
    }
}
