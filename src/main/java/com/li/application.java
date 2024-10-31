package com.li;

import com.li.mapper.userMapper;
import com.li.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import com.li.utils.MybatisUtils;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class application {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("请选择功能：");
            System.out.println("1. 查询所有学生");
            System.out.println("2. 添加学生");
            System.out.println("3. 删除学生");
            System.out.println("4. 更新学生信息");
            System.out.println("5. 退出");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除缓冲区

            try (SqlSession session = MybatisUtils.getSqlSession()) {
                userMapper mapper = session.getMapper(userMapper.class);

                switch (choice) {
                    case 1: // 查询所有学生
                        List<Student> students = mapper.selectStudent();
                        for (Student student : students) {
                            System.out.println(student);
                        }
                        break;

                    case 2: // 添加学生
                        System.out.println("输入学生ID:");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // 清除缓冲区
                        System.out.println("输入学生姓名:");
                        String name = scanner.nextLine();
                        System.out.println("输入学生年龄:");
                        Integer age = scanner.nextInt(); // 使用 Integer
                        System.out.println("输入学生分数:");
                        BigDecimal score = scanner.nextBigDecimal(); // 直接获取 BigDecimal
                        scanner.nextLine(); // 清除缓冲区
                        System.out.println("输入学生性别:");
                        String gender = scanner.nextLine();

                        Student newStudent = new Student(id, name, score, age, gender);
                        mapper.insertStudent(newStudent);
                        session.commit(); // 提交事务
                        System.out.println("学生添加成功！");
                        break;

                    case 3: // 删除学生
                        System.out.println("输入要删除的学生ID:");
                        int deleteId = scanner.nextInt();
                        mapper.deleteStudent(deleteId);
                        session.commit(); // 提交事务
                        System.out.println("学生删除成功！");
                        break;

                    case 4: // 更新学生信息
                        System.out.println("输入要更新的学生ID:");
                        int updateId = scanner.nextInt();
                        scanner.nextLine(); // 清除缓冲区
                        System.out.println("输入新学生姓名:");
                        String updateName = scanner.nextLine();
                        System.out.println("输入新学生年龄:");
                        Integer updateAge = scanner.nextInt(); // 使用 Integer
                        System.out.println("输入新学生分数:");
                        BigDecimal updateScore = scanner.nextBigDecimal(); // 直接获取 BigDecimal
                        scanner.nextLine(); // 清除缓冲区
                        System.out.println("输入新学生性别:");
                        String updateGender = scanner.nextLine();

                        Student updateStudent = new Student(updateId, updateName, updateScore, updateAge, updateGender);
                        mapper.updateStudent(updateStudent);
                        session.commit(); // 提交事务
                        System.out.println("学生信息更新成功！");
                        break;

                    case 5: // 退出
                        System.out.println("退出程序");
                        return;

                    default:
                        System.out.println("无效选择，请重试。");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
