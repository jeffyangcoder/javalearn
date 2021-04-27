package com.ecc.javalanguage.aboutClass.compara;

import com.ecc.javalanguage.aboutClass.Student;
import com.ecc.javalanguage.aboutClass.compara.SortImpl;

import java.util.ArrayList;
import java.util.List;

public class TestISort {
    public static void main(String[] args) {
        Student stu1 = new Student("zhang","111", "HuBei", 29);
        Student stu2 = new Student("li","111", "HuBei", 21);
        Student stu3 = new Student("wang","111", "HuBei", 22);
        Student stu4 = new Student("yang","111", "HuBei", 23);

        List<Student> studentList = new ArrayList<>();
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);
        studentList.add(stu4);
        new SortImpl().sortInt(studentList);

        studentList.forEach(op->{
            System.out.println(op.getStuName() + "---" + op.getStuAge());
        });
    }
}
