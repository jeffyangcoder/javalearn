package com.ecc.javalanguage.aboutAnnotation.silumtemvc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 控制器类
 * @author yangshiwei
 * @date 2021/5/21 14:43

 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
