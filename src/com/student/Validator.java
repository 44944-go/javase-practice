package com.student;

import java.util.Random;

/**
 * 校验层：只负责判断数据是否合法，不打印、不存储、不读取输入。
 * 所有方法统一返回 Result：合法返回 Result.ok()，非法返回 Result.fail(原因)。
 */
public class Validator {

    /** 密码长度下限 */
    private static final int PASSWORD_MIN = 6;
    /** 密码长度上限 */
    private static final int PASSWORD_MAX = 20;

    /**
     * 校验用户名：3-15 位，只能包含字母和数字，且必须同时包含字母和数字。
     */
    public static Result validateUserName(String userName) {
        if (userName == null || userName.isEmpty()) {
            return Result.fail("用户名不能为空");
        }
        if (userName.length() < 3 || userName.length() > 15) {
            return Result.fail("用户名长度必须在3-15之间");
        }

        boolean hasLetter = false;
        boolean hasDigit = false;
        for (int i = 0; i < userName.length(); i++) {
            char c = userName.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                hasLetter = true;
            } else if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else {
                // 既不是字母也不是数字，说明含特殊字符
                return Result.fail("用户名只能包含字母和数字，不能包含特殊字符");
            }
        }

        if (!hasLetter) {
            return Result.fail("用户名必须包含字母");
        }
        if (!hasDigit) {
            return Result.fail("用户名必须包含数字");
        }
        return Result.ok();
    }

    /**
     * 校验密码：长度在 6-20 之间，且两次输入必须一致。
     */
    public static Result validatePassword(String password, String confirm) {
        if (password == null || password.isEmpty()) {
            return Result.fail("密码不能为空");
        }
        if (password.length() < PASSWORD_MIN || password.length() > PASSWORD_MAX) {
            return Result.fail("密码长度必须在" + PASSWORD_MIN + "-" + PASSWORD_MAX + "之间");
        }
        if (!password.equals(confirm)) {
            return Result.fail("两次输入的密码不一致");
        }
        return Result.ok();
    }

    /**
     * 校验身份证号：18 位，首位非 0，前 17 位为数字，末位为数字或 X/x。
     */
    public static Result validateId(String id) {
        if (id == null || id.isEmpty()) {
            return Result.fail("身份证号不能为空");
        }
        if (id.length() != 18) {
            return Result.fail("身份证号长度必须为18位");
        }

        char first = id.charAt(0);
        if (first == '0') {
            return Result.fail("身份证号不能以0开头");
        }
        if (first < '0' || first > '9') {
            return Result.fail("身份证号首位必须是数字");
        }

        for (int i = 1; i < 17; i++) {
            char c = id.charAt(i);
            if (c < '0' || c > '9') {
                return Result.fail("身份证号前17位必须为数字");
            }
        }

        char last = id.charAt(17);
        boolean lastIsDigit = last >= '0' && last <= '9';
        boolean lastIsX = last == 'X' || last == 'x';
        if (!lastIsDigit && !lastIsX) {
            return Result.fail("身份证号最后一位必须为数字或X");
        }
        return Result.ok();
    }

    /**
     * 校验手机号：11 位，全为数字，且首位不能为 0。
     */
    public static Result validatePhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return Result.fail("手机号不能为空");
        }
        if (phone.length() != 11) {
            return Result.fail("手机号长度必须为11位");
        }

        char first = phone.charAt(0);
        if (first == '0') {
            return Result.fail("手机号不能以0开头");
        }
        for (int i = 0; i < phone.length(); i++) {
            char c = phone.charAt(i);
            if (c < '0' || c > '9') {
                return Result.fail("手机号必须全部为数字");
            }
        }
        return Result.ok();
    }


    public static String generateCode() {
        Random r = new Random();

        // 准备候选字符：26 个字母的大小写
        StringBuilder pool = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            pool.append((char) ('a' + i));
            pool.append((char) ('A' + i));
        }

        // 随机取 4 个字母
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(pool.length());
            code.append(pool.charAt(index));
        }
        // 追加 1 位数字
        code.append(r.nextInt(10));

        // 随机打乱位置（沿用原来的交换思路）
        char[] chars = code.toString().toCharArray();
        int index = r.nextInt(chars.length);
        char temp = chars[index];
        chars[index] = chars[chars.length - 1];
        chars[chars.length - 1] = temp;

        return new String(chars);
    }
}
