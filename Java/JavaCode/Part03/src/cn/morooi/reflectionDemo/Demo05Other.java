/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-12 16:55 CST
 */

package cn.morooi.reflectionDemo;

import cn.morooi.reflectionDemo.demo.Human;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Demo05Other {
    /*
     * 获取构造器结构
     * */
    @Test
    public void test01() {
        Class<Human> humanClass = Human.class;

        // getConstructors(): 获取当前运行时类中声明为 public 的构造器
        Constructor<?>[] constructors = humanClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("===============");
        // getDeclaredConstructors(): 获取当前运行时类中声明的所有构造器
        Constructor<?>[] declaredConstructors = humanClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    /*
     * 获取运行时类的父类
     * */
    @Test
    public void test02() {
        Class<Human> humanClass = Human.class;
        Class<? super Human> superclass = humanClass.getSuperclass();
        System.out.println(superclass);
    }

    /*
     * 获取运行时类的带泛型的父类
     * */
    @Test
    public void test03() {
        Class<Human> humanClass = Human.class;
        Type genericSuperclass = humanClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /*
     * 获取运行时类的带泛型的父类的泛型
     * */
    @Test
    public void test04() {
        Class<Human> humanClass = Human.class;
        Type genericSuperclass = humanClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class<?>)actualTypeArguments[0]).getName());
    }

    /*
     * 获取运行时类实现的接口
     * */
    @Test
    public void test05() {
        Class<Human> humanClass = Human.class;
        Class<?>[] interfaces = humanClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        // 获取运行时类的父类实现的接口
        Class<?>[] interfaces1 = humanClass.getSuperclass().getInterfaces();
        for (Class<?> aClass : interfaces1) {
            System.out.println(aClass);
        }
    }

    /*
     * 获取运行时类所在的包
     * */
    @Test
    public void test06() {
        Class<Human> humanClass = Human.class;
        Package humanClassPackage = humanClass.getPackage();
        System.out.println(humanClassPackage);
    }

    /*
     * 获取运行时类声明的注解
     * */
    @Test
    public void test07() {
        Class<Human> humanClass = Human.class;
        Annotation[] annotations = humanClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }


}
