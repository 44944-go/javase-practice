package com.student;

import java.util.ArrayList;
import java.util.Scanner;


public class StudentSy {
    public static void main(String[] args) {
        ArrayList<student> list= new ArrayList<>();
        list.add(new student("张三", 18, "北京", "1001"));
        list.add(new student("李四", 19, "上海", "1002"));
        list.add(new student("王五", 20, "广州", "1003"));
        list.add(new student("赵六", 21, "深圳", "1004"));

        loop: while(true) {
             System.out.println("-------------学生管理系统--------------");
             System.out.println("1.添加学生");
             System.out.println("2.删除学生");
             System.out.println("3.查询学生");
             System.out.println("4.修改学生");
             System.out.println("5.退出系统");
             System.out.println("请输入您的选择：");
             Scanner sc  = new Scanner(System.in);
             String choice = sc.next();
             switch (choice) {
                 case "1":
                     System.out.println("添加学生");
                     student.addStudent(list);
                     break;
                 case "2":
                     System.out.println("删除学生");
                     student.deleteStudent(list);
                     break;
                 case "3":
                     System.out.println("查询学生");
                     student.queryStudent(list);
                     break;
                 case "4":
                     System.out.println("修改学生");
                     student.updateStudent(list);
                     break;
                 case "5":
                     System.out.println("退出系统");
//                     break loop;
                     System.exit(0);//停止虚拟机
                 default:
                     System.out.println("输入错误");
                     break;
             }

         }

    }
}
