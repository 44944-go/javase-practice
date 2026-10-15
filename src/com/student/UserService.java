package com.student;

/**
 * 业务层：编排流程 —— 先校验、再存取数据。
 * 不打印、不读取输入、不直接操作数据结构。
 */
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 注册：依次校验各项输入，全部通过后保存用户。
     * 任何一步校验失败，立刻返回失败原因（卫语句，不往下走）。
     */
    public Result register(String userName, String password, String confirm,
                           String personId, String phone) {

        Result r = Validator.validateUserName(userName);
        if (!r.isSuccess()) {
            return r;
        }

        r = Validator.validatePassword(password, confirm);
        if (!r.isSuccess()) {
            return r;
        }

        r = Validator.validateId(personId);
        if (!r.isSuccess()) {
            return r;
        }

        r = Validator.validatePhone(phone);
        if (!r.isSuccess()) {
            return r;
        }

        // 校验都过了，才检查用户名是否重复
        if (userDao.existsByUserName(userName)) {
            return Result.fail("用户名已存在");
        }

        userDao.save(new User(userName, password, personId, phone));
        return Result.ok();
    }

    /** 登录：查用户 → 比对密码 */
    public Result login(String userName, String password) {
        User user = userDao.findByUserName(userName);
        if (user == null) {
            return Result.fail("用户未注册，请先注册");
        }
        if (!user.getPassWor().equals(password)) {
            return Result.fail("用户名或密码错误");
        }
        return Result.ok();
    }

    /** 忘记密码：验证身份 → 改密 */
    public Result resetPassword(String userName, String personId, String phone, String newPassword) {
        User user = userDao.findByUserName(userName);
        if (user == null) {
            return Result.fail("用户未注册");
        }
        if (!user.getPersonId().equals(personId)) {
            return Result.fail("身份证号错误");
        }
        if (!user.getPhoneNumber().equals(phone)) {
            return Result.fail("手机号错误");
        }
        user.setPassWor(newPassword);
        // 注意：user 是从 userDao 里取出的同一个对象引用，直接改它就已经生效了。
        // 阶段 2 换成文件存储后，这里才需要在改完之后显式保存一次。
        return Result.ok();
    }
}
