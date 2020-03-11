package cn.morooi2.exercise;

import cn.morooi2.util.JDBCUtils;

import java.util.Scanner;

public class QueryData {
    public static void main(String[] args) {
        Student student;
        System.out.println("请选择要输入的类型:");
        System.out.println("a. 准考证号");
        System.out.println("b. 身份证号");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("输入: ");
            String type = scanner.next();
            if ("a".equalsIgnoreCase(type)) {
                System.out.print("请输入准考证号: ");
                String examCard = scanner.next();
                String sql = "SELECT FlowID flowID, Type type, IDCard, ExamCard examCard, StudentName name," +
                        " Location location, Grade grade FROM examstudent WHERE examCard=?";
                student = JDBCUtils.getInstance(Student.class, sql, examCard);
                break;
            } else if ("b".equalsIgnoreCase(type)) {
                System.out.print("请输入身份证号: ");
                String IDCard = scanner.next();
                String sql = "SELECT FlowID flowID, Type type, IDCard, ExamCard examCard, StudentName name," +
                        " Location location, Grade grade FROM examstudent WHERE IDCard=?";
                student = JDBCUtils.getInstance(Student.class, sql, IDCard);
                break;
            } else {
                System.out.println("请输入正确的选项!");
            }
        }
        if (student == null) {
            System.out.println("查无此人!");
        } else {
            System.out.println("===========查询结果===========");
            System.out.println(student);
        }
    }
}