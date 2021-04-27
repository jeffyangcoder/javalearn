package com.ecc.javalanguage.datatype.aboutInterface;

public class DoubleEquaRootimpl implements IEquaRoot {
    @Override
    public int[] getIntRoot(int a, int b, int c) {
        return new int[0];
    }
    @Override
    public double[] getDoubleRoot(double a, int b, int c) {
        double[] results = {0.0, 0.0};
        double flag = a*a +4 *b*c;
        if (flag < 0) {
            System.out.println("root,doesn't exit");
        } else {
            results[0] =  ((-b + Math.sqrt(flag)) / (2 * a));
            results[1] =  ((-b - Math.sqrt(flag)) / (2 * a));
        }

        return results;
    }
}
