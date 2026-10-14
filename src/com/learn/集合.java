package com.learn;

import java.util.ArrayList;

public class 集合 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //添加元素
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");

        System.out.println(list);

//删除元素
        list.remove("bbbb");
        System.out.println(list);
        String remove = list.remove(0);
        //删除索引为0的元素,返回删除的元素
        System.out.println(remove);
        System.out.println(list);

        //修改元素
        String old = list.set(0, "xxxx");
        //修改索引为0的元素,返回旧的元素
        System.out.println(old);
        System.out.println(list);

       String get = list.get(0);
       //获取索引为0的元素
       System.out.println(get);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
