package com.ecc.javalanguage.datatype.functionuse;

public class TestFunction {
    public double getTestSum(IDoubleSum iDoubleSum,double a,double b){return iDoubleSum.getDoubleSum(a,b );}
    public static void main(String[] args) {
        IDoubleSum iDoubleSum = (IDoubleSum) new DoubleSumImpl();
        double result0 = iDoubleSum.getDoubleSum(2, 3);
        System.out.println("result is " + result0);

        //完整的类实现
        double result2 = new IDoubleSum() {
            @Override
            public double getDoubleSum(double a, double b) {
                return a+b;
            }
        }.getDoubleSum(2, 3);
        System.out.println("result2 is " + result2);

        //匿名内部类
        IDoubleSum iDoubleSum1 = new IDoubleSum() {
            @Override
            public double getDoubleSum(double a, double b) {
                return a + b;
            }
        };
        double result3 = iDoubleSum1.getDoubleSum(2, 3);
        System.out.println("result3 is " + result3);

        //lambda表达式
        double result4 = new TestFunction().getTestSum(new IDoubleSum() {
            @Override
            public double getDoubleSum(double a, double b) {
                return a + b;
            }
        }, 2, 3);
        System.out.println("result4 is "+ result4);

        double result5 = new TestFunction().getTestSum((x,y) -> {
            return x + y;
        },2,3);

        System.out.println("result4 is "+ result5);

        double result6 = new TestFunction().getTestSum((x,y) -> x+y,2,3 );
        System.out.println("result6 is " + result6);
    }
}
