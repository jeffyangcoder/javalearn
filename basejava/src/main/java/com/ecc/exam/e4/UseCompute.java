package com.ecc.exam.e4;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/6/17-20:56
 */
public class UseCompute {
    public void useCom(ICompute com,int m,int n){
        int compute = com.compute(m, n);
        System.out.println(compute);
    }
}
