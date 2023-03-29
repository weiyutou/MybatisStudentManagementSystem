package vip.coli.test;

import org.apache.ibatis.session.SqlSession;
import vip.coli.aa.Student;
import vip.coli.util.ColiUtils;

import java.util.List;
import java.util.Scanner;

/*这是旧版的我觉得不好看而且还要注释掉其他的我觉得丑所以我弄了个新版*/
                     /*其实代码都一样*/

/*                        **                          */
/*                      ******                        */
/*                    **********                      */
/*                  **************                    */
/*                        **                          */
/*                        **                          */
/*                        **                          */
/*                        **                          */

public class TestFk {
    /*多条件查询*/
    /*
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入学生姓名:");
        String name = input.nextLine();
        System.out.print("请输入学生学号:");
        String xuehao = input.nextLine();
        System.out.print("请输入学生专业:");
        String zhuanye = input.nextLine();
        System.out.print("请输入学生年龄:");
        String age = input.nextLine();
        System.out.print("请输入学生性别:");
        String sex = input.nextLine();


        SqlSession session = ColiUtils.getSession();
        Student s = new Student();
        if (name != null && name.length() > 0){
            System.out.println("姓名中包含”"+name+"“的学生如下：");
            s.setName(name);
        }else if (xuehao!= null && xuehao.length() > 0){
            System.out.println("学号为”"+xuehao+"“的学生如下：");
            s.setXuehao(xuehao);
        }else if (zhuanye!= null && zhuanye.length() > 0){
            System.out.println("专业为”"+zhuanye+"“的学生如下：");
            s.setZhuanye(zhuanye);
        }else if (age != null && age.length() > 0){
            System.out.println("年龄为”"+age+"“的学生如下：");
            s.setAge(age);
        }else if (sex!= null && sex.length() > 0){
            System.out.println("性别为”"+sex+"“的学生如下：");
            s.setSex(sex);
        }else{
            System.out.println("您没有输入学生信息，以下是所有学生信息，请您参考：");
        }
        List<Student> list;
        list = session.selectList("findStudent", s);
        for (Student students : list) {
            System.out.println(students);
        }
    }
*/

    /*查找18岁以下的学生信息*/
/*    public static void main(String[] args) {
        SqlSession session = ColiUtils.getSession();
        Student s = new Student();
        List<Student> students = session.selectList("findShiba",s);
        System.out.println("年龄小于18的学生如下");
        for(Student Student1 : students){
            System.out.println(Student1);
        }
    }*/

    /*更新学生信息*/
    public static void main(String[] args) {
        SqlSession session = ColiUtils.getSession();
        Student s = new Student();
        System.out.println("欢迎打开修改系统，所有学生信息如下：");
        List<Student> list;
        list = session.selectList("findStudent", s);
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
        System.out.println("修改成功！");
    }
}


