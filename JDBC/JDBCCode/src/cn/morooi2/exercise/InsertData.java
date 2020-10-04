package cn.morooi2.exercise;

import cn.morooi2.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入考生的详细信息: ");
        System.out.print("四级/六级: ");
        int type = scanner.nextInt();
        System.out.print("身份证号: ");
        String idCard = scanner.next();
        System.out.print("准考证号: ");
        String examCard = scanner.next();
        System.out.print("学生姓名: ");
        String studentName = scanner.next();
        System.out.print("所在城市: ");
        String location = scanner.next();
        System.out.print("成绩: ");
        int grade = scanner.nextInt();

        String sql = "INSERT INTO examstudent(Type, IDCard, ExamCard, StudentName, Location, Grade)" +
                "VALUES (?, ?, ?, ?, ?, ?) ";
        int result = JDBCUtils.updateData(sql, type, idCard, examCard, studentName, location, grade);
        if (result > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }
}
