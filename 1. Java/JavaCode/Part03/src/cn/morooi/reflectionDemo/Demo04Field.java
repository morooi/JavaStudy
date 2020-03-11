/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-11 22:37 CST
 */

package cn.morooi.reflectionDemo;

/*
 * 获取当前运行时类的属性结构
 * */

import cn.morooi.reflectionDemo.demo.Human;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Demo04Field {
    @Test
    public void test01() {
        Class<Human> clazz = Human.class;

        // 获取属性结构
        // getFields(): 获取当前运行时类及其父类中声明为 public 访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("===================");
        // getDeclaredFields(): 获取当前运行时类中声明的所有属性(不包含父类中的)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }

    // 权限修饰符, 数据类型, 变量名
    @Test
    public void test02() {
        Class<Human> clazz = Human.class;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            // 1. 权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            // 2. 数据类型
            Class<?> type = declaredField.getType();
            System.out.print(type.getName() + "\t");

            // 3. 变量名
            String name = declaredField.getName();
            System.out.println(name);
        }
    }
}
