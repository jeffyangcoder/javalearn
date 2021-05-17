package com.ecc.javalanguage.aboutAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/17-9:29
 */

public class TestWorkerClassInfo {
    public static void main(String[] args) {
        Class<Worker> clazz = Worker.class;
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);

        System.out.println("num: "+annotation.myNum() + "  tag: " + annotation.myTag());

        for (Field field:fields){
            System.out.println(field.getName());
        }

        System.out.println("////////////");

        for (Method method:methods){
            System.out.println(method.getName());
        }

    }
}
