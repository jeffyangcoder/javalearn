package com.ecc.javalanguage.datatype;

public class EquationRoots2 {


    //求根公式成员方法
    public static double[] getRoot(int a, int b, int c) {
        double[] results = {0, 0};
        double flag = delta(a, b, c);
        if (flag < 0) {
            System.out.println("root,doesn't exit");
        } else {
            results[0] =  ((-b + Math.sqrt(flag)) / (2 * a));
            results[1] =  ((-b - Math.sqrt(flag)) / (2 * a));
        }

        return results;
    }

    //判别式求值方法
    private  static double delta(int a, int b, int c) {
        return (b * b) - (4 * a * c);
    }
}
