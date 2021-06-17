package com.ecc.exam.e2;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/6/17-11:24
 */
public class Test {
    public static void main(String[] args) {
        try {
            double num = new DivCompute().getDiv(3.4, 0);
            System.out.println(num);
        } catch (DivException e) {
            e.exceptionInfo();
        }
    }
}
