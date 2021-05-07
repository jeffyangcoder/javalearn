package com.ecc.javalanguage.datatype.aboutexception;

/**
 * @author yangshiwei
 * @Description 考虑两数相除，除数为0的情况
 * @date 2021/5/7-14:25
 */
public class DefDivByException extends Exception{
    public void exceptionInfo(){
        System.out.println("除数异常");
    }

}
