package com.ecc.javalanguage.datatype.aboutInterface;

public class IntEquaRootimpl implements IEquaRoot {
    @Override
    public int[] getIntRoot(int a, int b, int c) {

        int[] results = {0, 0};
        int flag = a * a + 4 * b * c;
        if (flag < 0) {
            System.out.println("root,doesn't exit");
        } else {
            results[0] = (int) ((-b + Math.sqrt(flag)) / (2 * a));
            results[1] = (int) ((-b - Math.sqrt(flag)) / (2 * a));
        }

        return results;
    }

    @Override
    public double[] getDoubleRoot(double a, int b, int c) {
        return new double[0];
    }
}
