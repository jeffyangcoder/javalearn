package com.ecc.javalanguage.datatype.aboutexception;

import org.apache.log4j.Logger;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/7-14:21
 */
public class TestIntDiv {
    private static Logger logger = Logger.getLogger(TestIntDiv.class);

    public static void main(String[] args) {
        int result = 0;
        try {
            result = new IntDivByException().getIntDiv(6, 0);
//            System.out.println("发生异常后");
        } catch (DefDivByException e) {
//            e.exceptionInfo();
            logger.info("除数为0");
//            e.printStackTrace();
        } finally {
//            System.out.println("发生异常后本语句也会执行");
        }
        System.out.println("result is " + result);
    }
}
