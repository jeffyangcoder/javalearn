package com.ecc.javalanguage.datatype.classextend;

public class TestUesr {
    public static void main(String[] args) {
        //yangshiwei swsw 90,92,93
        User user =new User("zhangsan","zszs");
        User.Student student = user.new Student("zhangsan","zzss","1901");
        User.Student student1 = new User().new Student("","","1901");
        double averageScore = student1.getAverage(90, 92, 93);
        System.out.printf("student's average score is %.2f\n",averageScore);


    }


}
