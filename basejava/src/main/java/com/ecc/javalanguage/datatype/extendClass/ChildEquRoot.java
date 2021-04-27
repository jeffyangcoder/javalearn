package com.ecc.javalanguage.datatype.extendClass;

public abstract class ChildEquRoot extends ParentEquRoot {
    public static void main(String[] args) {
        ChildEquRoot childEquRoot = new ChildEquRoot() {
            @Override
            public void displayInfo2() {

            }
        };
        int[] roots1 = childEquRoot.getRoot(1, 3, 2);
        double[] roots2 = childEquRoot.getRoot(1.0, -3.9, -3.7);
        System.out.println(roots2[0]);
        System.out.println(roots2[1]);
        //childEquRoot.displayInfo();

    }
}
