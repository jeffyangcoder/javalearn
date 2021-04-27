package com.ecc.javalanguage.datatype.aboutInterface;

public class TestInterface {
    public static void main(String[] args) {
        IEquaRoot intEquaRoot = new IntEquaRootimpl();
        IEquaRoot doubleEquaRoot = new DoubleEquaRootimpl();

        int[] roots1 = intEquaRoot.getIntRoot(1, 3, 2);
        double[] roots2 = intEquaRoot.getDoubleRoot(1.0, 3, 2);

        System.out.println(roots1[0]);
        System.out.println(roots1[1]);
        System.out.println(roots2[0]);
        System.out.println(roots2[1]);

    }
}
