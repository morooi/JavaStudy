/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-11 21:54 CST
 */

package cn.morooi.reflectionDemo;

/*
 * 通过反射创建对应的运行时类的对象
 * */

import org.junit.jupiter.api.Test;

import java.util.Random;

public class Demo03NewInstance {
    @Test
    public void test1() throws Exception {
        Class<Person> personClass = Person.class;
        /*
         * newInstance(): 调用此方法, 创建对应的运行时类的对象. 内部调用了运行时类的空参构造器
         *  要求:
         *      1. 运行时类必须提供空参构造器
         *      2. 空参的构造器的访问权限得够, 通常为 public
         *
         * JDK 9 后: getDeclaredConstructor().newInstance()
         * */
        Person person = personClass.getDeclaredConstructor().newInstance();
        System.out.println(person);
    }

    @Test
    public void test2() {
        String classPath = "";
        int i = new Random().nextInt(3); // 0, 1, 2
        switch (i) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.String";
                break;
            case 2:
                classPath = "cn.morooi.reflectionDemo.Person";
                break;
        }
        Object instance = null;
        try {
            instance = getInstance(classPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instance);
    }

    /*
     * 创建一个指定类的对象:
     *   classPath: 指定类的全类名
     * */
    public Object getInstance(String classPath) throws Exception {
        Class<?> aClass = Class.forName(classPath);
        return aClass.getDeclaredConstructor().newInstance();
    }
}
