/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-11 22:49 CST
 */

package cn.morooi.reflectionDemo;

import cn.morooi.reflectionDemo.demo.Human;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Demo05Method {
    @Test
    public void test01() {
        Class<Human> humanClass = Human.class;

        // getMethods(): 获取当前运行时类及其所有父类中声明为 public 权限的方法
        Method[] methods = humanClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("===============");
        // getDeclaredMethods(): 获取当前运行时类中声明的所有方法(不包含父类中声明的方法)
        Method[] declaredMethods = humanClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    // @Xxxx
    // 权限修饰符, 返回值类型, 方法名(形参.....), throws XxxException{}
    @Test
    public void test02() {
        Class<Human> humanClass = Human.class;

        Method[] declaredMethods = humanClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            // 1. 获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            // 2. 获取权限修饰符
            int modifiers = m.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            // 3. 返回值类型
            Class<?> returnType = m.getReturnType();
            System.out.print(returnType.getName() + "\t");

            // 4. 方法名
            System.out.print(m.getName());
            System.out.print("(");

            // 5. 形参
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (parameterTypes.length > 0) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_" + i + ", ");
                }
            }
            System.out.print(")");

            // 6. 抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ", ");
                }
            }
            System.out.println();
        }
    }
}
