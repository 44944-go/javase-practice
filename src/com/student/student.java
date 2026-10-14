package com.student;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

public class student {
    private String name;
    private int age;
    private String address;
    private String id;

    public student() {
    }

    public student(String name, int age, String address, String id) {

        this.name = name;
        this.age = age;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public static void addStudent(ArrayList<student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生id：");
        String id = sc.next();
        if(!contains(list,id)){
            System.out.println("id存在,请重新输入");
            return;
        }
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.println("请输入学生地址：");
        String address = sc.next();
        list.add(new student(name, age, address, id));
        System.out.println("添加成功");
    }
    public static void deleteStudent(ArrayList<student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入删除的学生id：");
        String id = sc.next();
        if(contains(list,id)){
            System.out.println("id不存在,请重新输入");
            return;
        }
        int inDex = getIndex(list,id);
        list.remove(inDex);
        System.out.println("删除成功");
    }
    public static void updateStudent(ArrayList<student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入修改的学生id：");
        String id = sc.next();
        int inDex = getIndex(list,id);
        if(inDex<0){
            System.out.println("id不存在,请重新输入");
            return;
        }
        student s = list.get(inDex);
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        s.setName(name);
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        s.setAge(age);
        System.out.println("请输入学生地址：");
        String address = sc.next();
        s.setAddress(address);
        System.out.println("修改成功");

    }

    public static void queryStudent(ArrayList<student> list) {
        if (list.size() == 0) {
            System.out.println("当前没有学生");
            return;
        }
        System.out.println("id\t姓名\t年龄\t地址");
        for (student student : list) {
            System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getAge() + "\t" + student.getAddress());
        }
    }
    public static boolean contains(ArrayList<student> list,String id) {
        student s =new student();
        for (int i = 0; i < list.size(); i++) {
            s=list.get(i);
            if(s.getId().equals(id)){
                return false;
            }
        }
        return true;
    }
    public static int getIndex(ArrayList<student> list,String id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
