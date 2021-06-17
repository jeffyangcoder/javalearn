package com.ecc.exam.e2;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/6/17-11:22
 */
public class DivCompute {
    public double getDiv(double a, double b) throws DivException {
        if (b == 0) {
            throw new DivException();
        }
        return a / b;
    }
}
