package com.ecc.javalanguage.datatype;

public class EquationRoots {
    //数据成员定义
    private int a;
    private int b;
    private int c;

    static {
        System.out.println("Equation is loading!");
    }
    //构造方法
    public EquationRoots(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //求根公式成员方法
    public int[] getRoot() {
        int[] results = {0, 0};
        int flag = delta();
        if (flag < 0) {
            System.out.println("root,doesn't exit");
        } else {
            results[0] = (int) ((-b + Math.sqrt(flag)) / (2 + a));
            results[1] = (int) ((-b - Math.sqrt(flag)) / (2 + a));

        }

        return results;
    }

    //判别式求值方法
     private final int  delta() {
        return b * b - 4 * a * c;
    }
}
