package com.demo.parse;

import com.demo.annotation.Message;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by axes on 2019/9/26.
 */
public class ParseAnnotation {

    public static void main(String[] args) {

        //找到类上的注解
        findAnnotationOnClass();

        //找到方法上的注解
        findAnnotationOnMethod();


    }


    /**
     * 找到方法上的注解
     */
    private static void findAnnotationOnMethod() {
        try {
            //1.类加载器加载类
            Class<?> dogClass = Class.forName("com.demo.bean.Dog");

            //2。找到这个类上的所有方法
            Method[] methods = dogClass.getMethods();

            //3。 采用第一种写法获取注解的值
            getAnnotationValuesOne(methods);

            //4。采用第二种方式获取注解的值
            getAnnotationValuesTwo(methods);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 找到方法上的注解值的第二种写法
     */
    private static void getAnnotationValuesTwo(Method[] methods) {
        //采用第二种方法获取注解的值
        for (Method method : methods) {

            //获取方法上的所有注解
            Annotation[] annotations = method.getAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation instanceof Message) {
                    Message message = (Message) annotation;
                    System.out.print("该方法的描述为：" + message.decr() + "，作者：" + message.author() + "--第二种获取方法上的注解的解析方法");
                }
            }
        }
    }

    /**
     * 遍历获取注解方法的第一种写法
     */
    private static void getAnnotationValuesOne(Method[] methods) {
        //遍历所有方法
        for (Method method : methods) {
            //判断该方法上是否有我们定义的注解
            boolean isExist = method.isAnnotationPresent(Message.class);
            if (isExist) {
                Message message = method.getAnnotation(Message.class);
                System.out.println("该方法的描述为：" + message.decr() + ",作者为：" + message.author() + "--第一种获取方法上的注解的解析方法");
            }

        }
    }


    /**
     * 找到类上的注解
     */
    private static void findAnnotationOnClass() {
        try {
            //1.类加器加载类
            Class aClass = Class.forName("com.demo.bean.Dog");

            //2。找到类上的注解
            boolean isExist = aClass.isAnnotationPresent(Message.class);


            //3。如果存在拿到注解
            if (isExist) {
                Message messageAnnotation = (Message) aClass.getAnnotation(Message.class);
                System.out.println("类的描述为：" + messageAnnotation.decr() + "，作者：" + messageAnnotation.author());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
