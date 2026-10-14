package com.learn;

public class test {
    public static void main(String[] args) {
        对象数组手机jBean p1 = new 对象数组手机jBean("小米17pro",5999,"陨石黑");
        对象数组手机jBean p2 = new 对象数组手机jBean("华为Mate40Pro",19999,"鸭屎黄");
        对象数组手机jBean p3 = new 对象数组手机jBean("苹果18pro",9999,"玫瑰红");
        对象数组手机jBean[] arr = {p1,p2,p3};
        int sum = 0;
        for (对象数组手机jBean i : arr) {
            sum += i.getPrice();
        }
        double avg = sum*1.0/arr.length;
        System.out.println("手机平均价格为  " + avg);
    }
}
