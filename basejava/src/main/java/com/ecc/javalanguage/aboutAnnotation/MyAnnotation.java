package com.ecc.javalanguage.aboutAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//标注该注解将使用到类的什么成员上
@Retention(RetentionPolicy.RUNTIME)//标注注解的保保持期限，如编译阶段，运行阶段
public @interface MyAnnotation {
    String myTag() default "my annotation";
    int myNum();
}
