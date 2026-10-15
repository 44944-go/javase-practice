package com.student;

import java.util.ArrayList;

public class UserDao {

    private final ArrayList<User> users = new ArrayList<>();

    public UserDao() {
        // 初始化一个管理员账号（沿用你原来在 main 里写的那行）
        users.add(new User("admin1", "123456", "123456789101010101X", "12345678911"));
    }

    /** 保存一个用户 */
    public void save(User user) {
        users.add(user);
    }

    /** 按用户名查找，找不到返回 null */
    public User findByUserName(String userName) {
        // TODO: 遍历 users，用 equals 比较用户名
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    /** 用户名是否已存在 */
    public boolean existsByUserName(String userName) {
        return findByUserName(userName) != null;
    }
}