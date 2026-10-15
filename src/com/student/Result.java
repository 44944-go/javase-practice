package com.student;

public class Result {
    private boolean success;
    private String message;

    private Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // 成功：不需要原因
    public static Result ok() {
        return new Result(true, null);
    }

    // 失败：必须带原因
    public static Result fail(String message) {
        return new Result(false, message);
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
}