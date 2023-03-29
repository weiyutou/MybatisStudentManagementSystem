package vip.coli.test;

import org.apache.ibatis.session.SqlSession;
import vip.coli.aa.Student;
import vip.coli.util.ColiUtils;

import java.awt.*;
import java.util.List;
import java.util.Scanner;


/**
 * @author coli
 */

public class NewTest {
    public static void main(String[] args) throws AWTException {
        boolean flag = true;
        /*设置延时，看起来舒服一点*/
        Robot robot = new Robot();
        while (flag) {
            System.out.println("<***相思湖学院学生管理系统(新)***>");
            robot.delay(200);
            System.out.println("-----------------------------");
            robot.delay(200);
            System.out.println("1.第一题：多条件查询");
            robot.delay(200);
            System.out.println("2.第二题：查找不大于18的学生");
            robot.delay(200);
            System.out.println("3.更改学生信息");
            robot.delay(200);
            System.out.println("4.删除学生信息");
            robot.delay(200);
            System.out.println("5.新增学生信息");
            robot.delay(200);
            System.out.println("6.退出");
            robot.delay(200);
            System.out.println("-----------------------------");
            Scanner choose = new Scanner(System.in);
            robot.delay(600);
            /* 输入啥就是啥...懒得写注释了，赶ddl呢~*/
            System.out.println("请选择功能：");
            boolean flag2 = true;
            int i = choose.nextInt();
            switch (i) {
                case 1:
                    while (flag2) {
                        Scanner input = new Scanner(System.in);
                        robot.delay(500);
                        System.out.print("请输入学生姓名:");
                        String name = input.nextLine();
                        robot.delay(300);
                        System.out.print("请输入学生学号:");
                        String xuehao = input.nextLine();
                        robot.delay(300);
                        System.out.print("请输入学生专业:");
                        String zhuanye = input.nextLine();
                        robot.delay(300);
                        System.out.print("请输入学生年龄:");
                        String age = input.nextLine();
                        robot.delay(300);
                        System.out.print("请输入学生性别:");
                        String sex = input.nextLine();
                        robot.delay(300);
                        SqlSession session = ColiUtils.getSession();
                        Student s = new Student();
                        if (name != null && name.length() > 0) {
                            System.out.println("姓名中包含”" + name + "“的学生如下：");
                            s.setName(name);
                        } else if (xuehao != null && xuehao.length() > 0) {
                            System.out.println("学号为”" + xuehao + "“的学生如下：");
                            s.setXuehao(xuehao);
                        } else if (zhuanye != null && zhuanye.length() > 0) {
                            System.out.println("专业为”" + zhuanye + "“的学生如下：");
                            s.setZhuanye(zhuanye);
                        } else if (age != null && age.length() > 0) {
                            System.out.println("年龄为”" + age + "“的学生如下：");
                            s.setAge(age);
                        } else if (sex != null && sex.length() > 0) {
                            System.out.println("性别为”" + sex + "“的学生如下：");
                            s.setSex(sex);
                        } else {
                            System.out.println("您没有输入学生信息，以下是所有学生信息，请您参考：");
                        }
                        List<Student> list;
                        list = session.selectList("findStudent", s);
                        robot.delay(600);
                        for (Student students : list) {
                            System.out.println(students);
                        }
                        /*退出循环，防止无限卡死搞坏我的电脑*/
                        flag2=false;
                        break;
                    }

                case 2:
                    while (flag2) {
                        SqlSession session = ColiUtils.getSession();
                        Student s = new Student();
                        List<Student> students = session.selectList("findShiba",s);
                        System.out.println("年龄小于18的学生如下：");
                        robot.delay(600);
                        for(Student Student1 : students){
                            System.out.println(Student1);
                        }
                        flag2=false;
                        break;
                    }

                case 3:
                    while (flag2) {
                        SqlSession session = ColiUtils.getSession();
                        Student s = new Student();
                        System.out.println("欢迎打开修改系统，所有学生信息如下：");
                        robot.delay(600);
                        List<Student> list;
                        list = session.selectList("findAll", s);
                        for (Student students : list) {
                            System.out.println(students);
                        }
                        Scanner u = new Scanner(System.in);
                        System.out.println("请输入要修改学生的id：");
                        Integer id = u.nextInt();
                        s.setId(id);
                        u.nextLine(); //清空文本缓冲区
                        System.out.println("请输入要修改的姓名：");
                        String name = u.nextLine();
                        s.setName(name);
                        System.out.println("请输入要修改的学号：");
                        String xuehao= u.nextLine();
                        s.setXuehao(xuehao);
                        System.out.println("请输入要修改的专业：");
                        String zhuanye = u.nextLine();
                        s.setZhuanye(zhuanye);
                        System.out.println("请输入要修改的年龄：");
                        String age = u.nextLine();
                        s.setAge(age);
                        System.out.println("请输入要修改的性别：");
                        String sex = u.nextLine();
                        s.setSex(sex);
                        session.update("update", s);
                        session.commit();
                        robot.delay(1000);
                        System.out.println("修改成功！");
                        SqlSession newsession = ColiUtils.getSession();
                        System.out.println("新的学生信息如下：");
                        robot.delay(600);
                        Student ns = session.selectOne("findById", s);
                        System.out.println(ns);
                        flag2=false;
                        break;
                    }

                case 4:
                    while (flag2) {
                        SqlSession session = ColiUtils.getSession();
                        Student s = new Student();
                        System.out.println("欢迎打开删除系统，所有学生信息如下：");
                        robot.delay(600);
                        List<Student> list;
                        list = session.selectList("findAll", s);
                        for (Student students : list) {
                            System.out.println(students);
                        }
                        Scanner u = new Scanner(System.in);
                        System.out.println("请输入要删除学生的id：");
                        Integer id = u.nextInt();
                        s.setId(id);
                        u.nextLine(); //清空文本缓冲区
                        session.delete("del", s);
                        session.commit();
                        robot.delay(1000);
                        System.out.println("删除成功！");
                        SqlSession newsession = ColiUtils.getSession();
                        System.out.println("新的所有的学生信息如下：");
                        robot.delay(600);
                        Student ns = new Student();
                        List<Student> list1;
                        list1 = session.selectList("findAll", ns);
                        for (Student students : list1) {
                            System.out.println(students);
                        }
                        flag2=false;
                        break;
                    }

                case 5:
                    while (flag2) {
                        SqlSession session = ColiUtils.getSession();
                        Student s = new Student();
                        System.out.println("欢迎打开新增系统，所有学生信息如下：");
                        robot.delay(600);
                        List<Student> list;
                        list = session.selectList("findAll", s);
                        for (Student students : list) {
                            System.out.println(students);
                        }
                        Scanner u = new Scanner(System.in);
                        System.out.println("请输入要增肌学生的id：");
                        Integer id = u.nextInt();
                        s.setId(id);
                        u.nextLine(); //清空文本缓冲区
                        System.out.println("请输入要增加学生的姓名：");
                        String name = u.nextLine();
                        s.setName(name);
                        System.out.println("请输入要增加学生的学号：");
                        String xuehao= u.nextLine();
                        s.setXuehao(xuehao);
                        System.out.println("请输入要增加学生的专业：");
                        String zhuanye = u.nextLine();
                        s.setZhuanye(zhuanye);
                        System.out.println("请输入要增加学生的年龄：");
                        String age = u.nextLine();
                        s.setAge(age);
                        System.out.println("请输入要增加的性别：");
                        String sex = u.nextLine();
                        s.setSex(sex);
                        session.insert("add", s);
                        session.commit();
                        robot.delay(1000);
                        System.out.println("添加成功！");
                        SqlSession newsession = ColiUtils.getSession();
                        System.out.println("新的学生信息如下：");
                        robot.delay(600);
                        Student ns = session.selectOne("findById", s);
                        System.out.println(ns);
                        flag2=false;
                        break;
                        
                    }

                case 6:
                    /*设置退出*/
                    flag=false;
                    break;
                default:
                    flag=true;

            }
        }
        robot.delay(600);
        /*空一行美观点*/
        System.out.println(" ");
        /*总得说声有礼貌的*/
        System.out.println("**********欢迎下次使用**********");
    }
}
