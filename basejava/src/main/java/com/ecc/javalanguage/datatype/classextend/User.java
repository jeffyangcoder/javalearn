package com.ecc.javalanguage.datatype.classextend;

public class User {
    protected String userName;
    protected String password;

    public User(String userName,String password) {
        this.userName=userName;
        this.password=password;
    }
    public User(){}

    class Student extends User implements IAverage{
        protected String stuNo;

        public String getStuNo() {
            return stuNo;
        }

        public void setStuNo(String stuNo) {
            this.stuNo = stuNo;
        }

        public Student(String userName, String password, String stuno) {
            super(userName, password);
            this.stuNo = stuno;
        }


        @Override
        public double getAverage(double a, double b, double c) {
            return (a+b+c)/3;
        }
    }
    //第一种
    class Salary implements ISalarySum{
        @Override
        public double getSum(double a, double b, double c) {
            return a+b+c;
        }
    }
    //第二种
//    class Worker {
//        public  double getSalarySum(double a ,double b,double c){
//            double salarySum = new ISalarySum(){
//
//                @Override
//                public double getSum(double a, double b, double c) {
//                    return a+b+c;
//                }
//            }.getSum(a,b,c);
//
//            return salarySum;
//        }
//
//        public double getSalarySum2(double a,double b,double c){
//            return new Salary().getSum(a, b,c );
//        }
//
//        public  double getSalarySum3(double a , double b, double c){
//            double salarySum = new ISalarySum(){
//                    return (a,b,c) -> a+b+c;
//            }
//            }.getSum(a,b,c);
//
//            return salarySum;
//        }
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
