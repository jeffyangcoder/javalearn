package com.ecc.javalanguage.aboutClass;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Student stu2 = new Student("yangshiwei", "1905110005", "Guangdong", 20);
        Student stu3 = new Student("yangshiwei", "1905110005", "Guangdong", 20);
        Student stu4 = new Student("yangshiwei", "1905110005", "Guangdong", 20);


        System.out.println(stu2.getStuName() + "---" + stu2.getStuAge());

        stu2.setStuAge(21);
        stu3.setStuAge(22);

        System.out.println(stu2.getStuName()+ "---" + stu2.getStuAge());
//

        List<Student> stuList = new ArrayList<Student>();
        stuList.add(stu2);
        stuList.add(stu3);
        stuList.add(stu4);
//        for(int i = 0;i<stuList.size();i++)
//            System.out.println(stu2.getStuName()+ "---" + stu2.getStuAge());
        for (Student op : stuList)
            System.out.println(op.getStuName() + "---" + op.getStuAge());
//
        System.out.println("////////");
        stuList.forEach(op->{
            System.out.println(op.getStuName() + "---" + op.getStuAge());
        });
//
        stuList.remove(0);
        System.out.println("////////");

        stuList.forEach(op->{
            System.out.println(op.getStuName() + "---" + op.getStuAge());
        });

////        @匿名内部类
//        stuList.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getStuAge() - o2.getStuAge();
//            }
//        });
////      lambda 表达式
//        stuList.sort((o1, o2) -> o1.getStuAge() - o2.getStuAge());
////      Comparator 提供的方法
//        stuList.sort(Comparator.comparingInt(Student::getStuAge));
//
//
//        System.out.println("////////");
//
//        stuList.forEach(op->{
//            System.out.println(op.getStuName() + "---" + op.getStuAge());
//        });

        Map<String,Student> stuMap = new HashMap<>();
        stuMap.put("1234", stu2);
        stuMap.put("1235", stu3);
        stuMap.put("1236", stu4);
        System.out.println("stuNO is 1235's information is: "
                + stuMap.get("1235").getStuName() + "---" + stuMap.get("1235").getStuAge());

        Set<Map.Entry<String,Student>> entrySet = stuMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry <String,Student> entry=(Map.Entry<String,Student>)iterator.next();
            String name=entry.getKey();
            Student student1=entry.getValue();
            System.out.println(name+"--"+student1.getStuAge());
        }

        for (Map.Entry<String, Student> entry : entrySet) {
            String name = entry.getKey();
            Student student = entry.getValue();
            System.out.println(name +"---" + student.getStuName() + "---" + student.getStuAge());
        }

//        //迭代器
//        Iterator<Student> iterator = stuList.iterator();
//        while (iterator.hasNext()) {
//            Student student = iterator.next();
//            System.out.println(student.getStuName() + "---" + student.getStuAge());
//        }

   }

}
