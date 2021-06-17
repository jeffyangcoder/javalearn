package com.ecc.exam.e1;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/6/17-11:11
 */
public class Circle {
    private int r;
    private final double PI = 3.14;

    public Circle(int r) {
        this.r = r;
    }

    public double getArea() {
        double area;
        area = r * r * PI;
        return area;
    }

    public int getGirth() {
        return r * 2;
    }
}
