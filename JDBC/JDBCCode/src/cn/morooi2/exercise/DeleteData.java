package cn.morooi2.exercise;

import cn.morooi2.util.JDBCUtils;

import java.util.Scanner;

public class DeleteData {

    public static void main(String[] args) {
        while (true) {
            System.out.print("请输入学生的考号:");
            Scanner scanner = new Scanner(System.in);
            String examCard = scanner.next();
            String sql = "DELETE FROM examstudent WHERE ExamCard=?";
            int result = JDBCUtils.updateData(sql, examCard);
            if (result > 0) {
                System.out.println("删除成功");
                break;
            } else {
                System.out.println("查无此人, 请重新输入");
            }
        }
    }
}
