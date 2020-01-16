package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double grade) {
        for (Student student : students) {
            if (student.getAverageGrade() == grade) {
                return student;
            }
        }

        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student maxStudent = students.get(0);
        for (int i = 1; i < students.size(); i ++) {
            if (maxStudent.getAverageGrade() < students.get(i).getAverageGrade()) {
                maxStudent = students.get(i);
            }
        }

        return maxStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        Student minStudent = students.get(0);
        for (int i = 1; i < students.size(); i ++) {
            if (minStudent.getAverageGrade() > students.get(i).getAverageGrade()) {
                minStudent = students.get(i);
            }
        }

        return minStudent;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}