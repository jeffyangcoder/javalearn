package com.ecc.javalanguage.aboutClass;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SubStudent extends Student implements Comparable {
    public SubStudent(String stuName, String stuNo, String stuHome, int stuAge) {
        super(stuName, stuNo, stuHome, stuAge);
    }

    static void sort(List<Student> sortArray){//List<Student>
        if (sortArray == null || sortArray.size() < 2) return;

        for(int i = 0;i<sortArray.size();i++){
            int minIndex = i;
            for (int j = i + 1;j < sortArray.size() ;j++){
                if (sortArray.get(i).getStuAge() < sortArray.get(minIndex).getStuAge()){
                    minIndex  = j;
                }
            }
            if (minIndex!=i){
                Student student = sortArray.get(i);
                sortArray.set(i,sortArray.get(minIndex));
                sortArray.set(minIndex,student);
            }
        }
    }
    public int compareTo(@NotNull Object o){
//        return -( this.getStuAge() - ((Student)o).getStuAge());
        return -(this.getStuName().compareTo(((SubStudent)o).getStuName()));
    }

    public static void main(String[] args) {

        SubStudent substu1 = new SubStudent("zhang","111", "HuBei", 29);
        SubStudent substu2 = new SubStudent("li","111", "HuBei", 21);
        SubStudent substu3 = new SubStudent("wang","111", "HuBei", 22);
        SubStudent substu4 = new SubStudent("yang","111", "HuBei", 23);

        List<SubStudent> subStudentList = new ArrayList<>();

        subStudentList.add(substu1);
        subStudentList.add(substu2);
        subStudentList.add(substu3);
        subStudentList.add(substu4);

        Collections.sort(subStudentList);

        subStudentList.forEach(op->{
            System.out.println(op.getStuName() + "---" + op.getStuAge());
        });

//        Student stu1 = new Student("zhang","111", "HuBei", 29);
//        Student stu2 = new Student("li","111", "HuBei", 21);
//        Student stu3 = new Student("wang","111", "HuBei", 22);
//        Student stu4 = new Student("yang","111", "HuBei", 23);
//
//        System.out.println("/////////");
//
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(stu1);
//        studentList.add(stu2);
//        studentList.add(stu3);
//        studentList.add(stu4);
//
//
//        //使用匿名内部类
//        Collections.sortInt(studentList, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return -(o1.getStuAge() - o2.getStuAge());
//            }
//        });
//
//        //lambda 表达式
//        Collections.sortInt(studentList, (o1, o2) -> {
//            return -(o1.getStuName().compareTo(o2.getStuName()));
//        });
//
////        studentList.sortInt((o1, o2) -> {
////            return -(o1.getStuName().compareTo(o2.getStuName()));
////        });
//
//        studentList.sortInt(Comparator.comparing(Student::getStuName));
//
//
//        studentList.forEach(op->{
//            System.out.println(op.getStuName() + "---" + op.getStuAge());
//        });
//
//        Map<String,Student> stuMap = new HashMap<>();
//        stuMap.put("1234", stu2);
//        stuMap.put("1235", stu3);
//        stuMap.put("1236", stu4);
//        System.out.println("stuNO is 1235's information is: "
//                + stuMap.get("1235").getStuName() + "---" + stuMap.get("1235").getStuAge());
//
//        Set<Map.Entry<String,Student>> entrySet = stuMap.entrySet();
//        Iterator iterator = entrySet.iterator();
//
//
//        for (Map.Entry<String, Student> entry : entrySet) {
//            String name = entry.getKey();
//            Student student = entry.getValue();
//            System.out.println(name +"---" + student.getStuName() + "---" + student.getStuAge());
//        }
    }
}
