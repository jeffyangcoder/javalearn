package com.ecc.javalanguage.datatype.extendClass;

public abstract class ParentEquRoot {

    //求根公式成员方法
    public int[] getRoot(int a, int b, int c) {
        int[] results = {0, 0};
        int flag = delta(a, b, c);
        if (flag < 0) {
            System.out.println("root,doesn't exit");
        } else {
            results[0] = (int) ((-b + Math.sqrt(flag)) / (2 * a));
            results[1] = (int) ((-b - Math.sqrt(flag)) / (2 * a));
        }

        return results;
    }

    public double[] getRoot(double a, double b, double c) {
        double[] results = {0.0, 0.0};
        double flag = delta(a, b, c);
        if (flag < 0) {
            System.out.println("root,doesn't exit");
        } else {
            results[0] = ((-b + Math.sqrt(flag)) / (2 * a));
            results[1] = ((-b - Math.sqrt(flag)) / (2 * a));
        }

        return results;
    }

    //判别式求值方法
    private static int delta(int a, int b, int c) {
        return (b * b) - (4 * a * c);
    }

    private static double delta(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }

    protected void displayInfo() {
        System.out.println("aaa");
    }

    public abstract void displayInfo2();
}
