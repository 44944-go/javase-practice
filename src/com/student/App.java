package com.student;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        ArrayList<user> list = new ArrayList<>();
        list.add(new user("admin1", "123456", "123456789101010101X", "12345678911"));
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("欢迎来到学生管理系统");
            System.out.println("1.登录 2.注册 3.忘记密码 4.退出");
            System.out.println("请输入您的选择：");
            String choose = sc.nextLine();

            switch (choose) {
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                default -> {
                    System.out.println("感谢使用,再见");
                    System.exit(0);
                }
            }
        }
    }

    public static void forgetPassword(ArrayList<user> list) {
        System.out.println("请输入账号");
        Scanner sc = new Scanner(System.in);
        String account = sc.next();
        boolean flag = check(list,account);
        if (flag) {
            System.out.println("未注册");
            return;
        }
        System.out.println("请输入账号和密码");
        System.out.println("电话");
        String Phone = sc.next();
        System.out.println("身份证");
        String PersonId = sc.next();
        int Index = matchName(list , account);
        boolean check1=list.get(Index).getPersonId().equals(PersonId);
        boolean check2 = list.get(Index).getPhoneNumber().equals(Phone);
        if (check1&&check2) {
            System.out.println("请输入密码");
            String password = sc.next();
            list.get(Index).setPassWor(password);
        }else {
            System.out.println("输入信息有误,修改失败");
        }
    }

    public static void register(ArrayList<user> list) {
        Scanner sc = new Scanner(System.in);
        user u = new user();
        while (true) {
            System.out.println("请输入用户名：");
            String userName = sc.nextLine();
            boolean check1 = check(list, userName);
            boolean check2 = checkNameLength(userName);
           if (!check2){
                System.out.println("用户名长度必须在3-15之间,请重新输入");
            } else  if (!check1){
                System.out.println("用户名存在,请重新输入");
            }else if (!checkNameContain(userName)){
                System.out.println("用户名必须包含字母和数字,不能包含特殊字符,请重新输入");
            }else{
               while(true) {
                   System.out.println("请输入密码：");
                   String password = sc.nextLine();
                   System.out.println("请确认密码：");
                   String confirmPassword = sc.nextLine();
                   if (!password.equals(confirmPassword)) {
                       System.out.println("两次密码不一致,请重新输入");
                       continue;
                   }
                   u.setPassWor(password);
                   break;
               }
                System.out.println("请输入身份证号：");
                String personId ;
                while(true){
                    personId = sc.nextLine();
                    if(personId.length()!=18){
                        System.out.println("身份证号长度必须为18位,请重新输入");
                        continue;
                    } else if (!checkId(personId)) {
                        System.out.println("身份证号格式错误,请重新输入");
                        continue;
                    }
                    u.setPersonId(personId);
                    break;
                }
                System.out.println("请输入手机号：");
                while(true){
                    String phoneNumber = sc.nextLine();
                    if(phoneNumber.length()!=11){
                        System.out.println("手机号长度必须为11位,请重新输入");
                        continue;
                    } else if (phoneNumber.charAt(0)=='0') {
                        System.out.println("手机号不能以0开头,请重新输入");
                        continue;
                    }
                    u.setPhoneNumber(phoneNumber);
                    break;
                }

                list.add(u);
                System.out.println("注册成功");
                break;
            }
        }


    }

    public static void login(ArrayList<user> list) {
        Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String userName = sc.nextLine();
            System.out.println("请输入密码：");
            String password = sc.nextLine();
            boolean check1 = check(list, userName);
            String code = getCode();
            System.out.println("验证码为："+code);
            System.out.println("请输入验证码：");
            String code1 = sc.nextLine();
            boolean check3 = code.equals(code1);
        if (!check3) {
            System.out.println("验证码错误");
            return;
        }
        if (check1) {
            System.out.println("用户未注册,请先注册");
            return;
        }
        boolean check2 = matchPassword(list, matchName(list, userName), password);
        if (check2) {
            System.out.println("登录成功");
        } else {
            System.out.println("用户名或密码错误");
        }
        }
        public static boolean check(ArrayList<user> list,String userName) {
            for (user user : list) {
                if (user.getUserName().equals(userName)) {
                    return false;
                }
            }
            return true;
        }
        public static int matchName(ArrayList<user> list,String userName) {
        int count = 0;
            for (user user : list) {
                if (user.getUserName().equals(userName)) {
                    return count;
                }
                count++;
            }
            return -1;
        }
        public static boolean checkNameLength(String userName) {
            return userName.length() >= 3 && userName.length() <= 15;
        }

        public static boolean checkNameContain(String userName) {
            for (int i = 0; i < userName.length(); i++) {
                char c = userName.charAt(i);
                if (!(c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c >= 'A' && c <= 'Z')) {
                    return false;
                }
            }
            int count = 0;
            for (int i = 0; i < userName.length(); i++) {
                if (userName.charAt(i) >= 'A' && userName.charAt(i) <= 'Z') {
                    count++;
                }else if (userName.charAt(i) >= 'a' && userName.charAt(i) <= 'z') {
                    count++;
                }
            }
            if (count == userName.length()) {
                return false;
            }
            return count > 0;
        }
        public static boolean checkId(String id) {
        if (!(id.charAt(0)>'0'&&id.charAt(0)<='9')) {
            System.out.println("身份证号不能以0或非数字开头,请重新输入");
            return false;
        }
            for (int i = 1; i < id.length()-1; i++) {
                char c = id.charAt(i);
                if (!(c >= '0' && c <= '9')) {
                    System.out.println("身份证号前17位必须为数字,不能包含特殊字符,请重新输入");
                    return false;
                }
            }
            if (id.charAt(id.length()-1)>='0'&&id.charAt(id.length()-1)<='9') {
                return true;
            } else if (id.charAt(id.length()-1)=='X'||id.charAt(id.length()-1)=='x') {
                return true;
            }
            System.out.println("身份证号最后一位必须为数字或X,请重新输入");
            return false;
        }
        public static boolean matchPassword(ArrayList<user> list,int index,String password) {
            if(index==-1){
                return false;
            }
            if (list.get(index).getPassWor().equals(password)) {
                return true;
            }
            return false;
        }
        public static String getCode() {
            Random r = new Random();
            
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                list.add((char) (i + 'a'));
                list.add((char) (i + 'A'));
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<4;i++){
                int index = r.nextInt(list.size());
                sb.append( list.get(index));
            }
            sb.append(r.nextInt(10));
            char[] code=sb.toString().toCharArray();
            int index = r.nextInt(code.length);
            char temp = code[index];
            code[index]=code[code.length-1];
            code[code.length-1]=temp;
            return new String(code);
        }
}
