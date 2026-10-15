package com.student;

import java.util.Scanner;

public class App {


    private static final Scanner SC = new Scanner(System.in);


    private static final UserService USER_SERVICE = new UserService(new UserDao());

    public static void main(String[] args) {
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("1.登录 2.注册 3.忘记密码 4.退出");
            System.out.println("请输入您的选择：");
            String choice = SC.nextLine();

            switch (choice) {
                case "1" -> login();
                case "2" -> register();
                case "3" -> forgetPassword();
                default -> {
                    System.out.println("感谢使用,再见");
                    System.exit(0);
                }
            }
        }
    }

    /** 注册：逐个字段读取并校验，某项不合法就重新输入该项 */
    private static void register() {
        String userName;
        while (true) {
            System.out.println("请输入用户名（3-15位，必须同时包含字母和数字）：");
            userName = SC.nextLine();
            Result r = Validator.validateUserName(userName);
            if (r.isSuccess()) {
                break;
            }
            System.out.println(r.getMessage() + "，请重新输入");
        }

        String password;
        while (true) {
            System.out.println("请输入密码：");
            password = SC.nextLine();
            System.out.println("请确认密码：");
            String confirm = SC.nextLine();
            Result r = Validator.validatePassword(password, confirm);
            if (r.isSuccess()) {
                break;
            }
            System.out.println(r.getMessage() + "，请重新输入");
        }

        String personId;
        while (true) {
            System.out.println("请输入身份证号：");
            personId = SC.nextLine();
            Result r = Validator.validateId(personId);
            if (r.isSuccess()) {
                break;
            }
            System.out.println(r.getMessage() + "，请重新输入");
        }

        String phone;
        while (true) {
            System.out.println("请输入手机号：");
            phone = SC.nextLine();
            Result r = Validator.validatePhone(phone);
            if (r.isSuccess()) {
                break;
            }
            System.out.println(r.getMessage() + "，请重新输入");
        }

        // 全部输入合法，交给业务层
        Result result = USER_SERVICE.register(userName, password, password, personId, phone);
        System.out.println(result.isSuccess() ? "注册成功" : result.getMessage());
    }

    /** 登录：先过验证码，再交业务层比对 */
    private static void login() {
        System.out.println("请输入用户名：");
        String userName = SC.nextLine();
        System.out.println("请输入密码：");
        String password = SC.nextLine();

        String code = Validator.generateCode();
        System.out.println("验证码为：" + code);
        System.out.println("请输入验证码：");
        String inputCode = SC.nextLine();
        if (!code.equalsIgnoreCase(inputCode)) {
            System.out.println("验证码错误");
            return;
        }

        Result result = USER_SERVICE.login(userName, password);
        System.out.println(result.isSuccess() ? "登录成功" : result.getMessage());
    }

    /** 忘记密码：验证身份证 + 手机号，然后设置新密码 */
    private static void forgetPassword() {
        System.out.println("请输入账号：");
        String userName = SC.nextLine();

        System.out.println("请输入身份证号：");
        String personId = SC.nextLine();

        System.out.println("请输入手机号：");
        String phone = SC.nextLine();

        String newPassword;
        while (true) {
            System.out.println("请输入新密码：");
            newPassword = SC.nextLine();
            System.out.println("请确认新密码：");
            String confirm = SC.nextLine();
            Result r = Validator.validatePassword(newPassword, confirm);
            if (r.isSuccess()) {
                break;
            }
            System.out.println(r.getMessage() + "，请重新输入");
        }

        Result result = USER_SERVICE.resetPassword(userName, personId, phone, newPassword);
        System.out.println(result.isSuccess() ? "密码修改成功" : result.getMessage());
    }
}
