package com.ecc.javalanguage.datatype.aboutexception;

/**
 * @author yangshiwei
 * @Description 考虑两数相除，除数为0的情况
 * @date 2021/5/7-14:28
 */
public class IntDivByException {
    public int getIntDiv(int a, int b) throws DefDivByException {
        int result;
        if (b == 0) {
            throw new DefDivByException();
        }
        result = a / b;
        return result;
    }
}
