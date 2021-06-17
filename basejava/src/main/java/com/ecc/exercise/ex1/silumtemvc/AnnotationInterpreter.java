package com.ecc.exercise.ex1.silumtemvc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/21-14:46
 */
public class AnnotationInterpreter {
//    public void interpreter(Class<T> clazz)
    public void interpreter() {
        Class<MyController> myControllerClass = MyController.class;
//        1.判断MyController是否有@Contorller存在
        if (myControllerClass.isAnnotationPresent(Controller.class)) {
            //        2.存在，则获取MyController的所有声明的方法数组Method[]
            Method[] methods = myControllerClass.getDeclaredMethods();
            //        3.遍历Method[]，判断每一个Method是否存在@RequsetMapping注解
            for (Method method : methods) {
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    String value = method.getAnnotation(RequestMapping.class).value();
                    if (value.equals("addPerson")) {
                        try {
                            //        4.如果存在，则反射调用该方法
                            MyController myController = myControllerClass.newInstance();
                            try {
                                method.invoke(myController); //反射调用存在RequestMapping的方法
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
