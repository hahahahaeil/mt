package com.li.pojo;

import java.math.BigDecimal;

public class Student { // 类名改为单数形式
    private int id;
    private String name;
    private BigDecimal score; // 使用 BigDecimal 以确保精确度
    private int age; // 使用包装类，以支持 null 值
    private String gender; // 自定义枚举类型

    // 构造方法
    public Student(int id, String name, BigDecimal score, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
        this.gender = gender;
    }

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // 自定义枚举类型
    public enum Gender {
        MALE, FEMALE, OTHER
    }

    @Override
    public String toString() {
        return "Student{" + // 类名改为 Student
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
