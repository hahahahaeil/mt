package com.li.mapper;

import com.li.pojo.Student;
import java.util.List;

public interface userMapper {

    // 查询所有学生
    List<Student> selectStudent();

    // 插入学生
    void insertStudent(Student student);

    // 删除学生
    void deleteStudent(int id);

    // 更新学生信息
    void updateStudent(Student student);

    // 根据姓名查询学生（可选）
    List<Student> selectStudentByName(String name);
}
