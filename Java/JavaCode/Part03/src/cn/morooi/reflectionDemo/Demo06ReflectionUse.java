/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-12 17:45 CST
 */

package cn.morooi.reflectionDemo;

/*
 * 调用运行时类中指定的结构: 属性, 方法, 构造器
 * */

import cn.morooi.reflectionDemo.demo.Human;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo06ReflectionUse {

    /*
     * 获取指定的属性
     * */
    @Test
    public void test01() throws Exception {
        Class<Human> humanClass = Human.class;
        // 创建运行时类的对象
        Human human = humanClass.getDeclaredConstructor().newInstance();
        // 获取指定的属性: getField() 要求运行时类中的属性声明为 public (通常不用此方法)
        Field id = humanClass.getField("id");
        // 设置当前属性: set(), 参数一指明设置哪个对象的属性, 参数二将此属性值设置为多少
        id.set(human, 22);
        // 获取当前属性的值: get()
        System.out.println(id.get(human));
    }

    /*
     * 获取指定的属性 -- 推荐使用
     * */
    @Test
    public void test02() throws Exception {
        Class<Human> humanClass = Human.class;
        // 创建运行时类的对象
        Human human = humanClass.getDeclaredConstructor().newInstance();
        // 1. 获取运行时类的指定的属性: getDeclaredField(String fieldName)
        Field name = humanClass.getDeclaredField("name");
        // 2. 保证当前属性是可访问的
        name.setAccessible(true);
        // 3. 获取, 设置指定对象的属性: set(), 参数一指明设置哪个对象的属性, 参数二将此属性值设置为多少
        name.set(human, "Tim");
        // 获取当前属性的值: get()
        System.out.println(name.get(human));
    }

    /*
     * 获取指定的方法 -- 需要掌握
     * */
    @Test
    public void test03() throws Exception {
        Class<Human> humanClass = Human.class;
        // 创建运行时类的对象
        Human human = humanClass.getDeclaredConstructor().newInstance();
        // 1. 获取运行时类的指定的方法: getDeclaredMethod(), 参数一指明获取的方法名称, 参数二指明获取的方法的形参列表
        Method show = humanClass.getDeclaredMethod("show", String.class);
        // 2. 保证当前属性是可访问的
        show.setAccessible(true);
        // 3. 调用方法的 invoke(): 参数一方法的调用者, 参数二给方法形参赋值的实参
        //    返回值即为对应类中调用的方法的返回值
        Object returnValue = show.invoke(human, "China");
        System.out.println(returnValue);

        System.out.println("=========调用静态方法=========");
        Method showDesc = humanClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        // 如果调用的运行时类中的方法没有返回值, 则此 invoke() 返回 null
        Object invoke = showDesc.invoke(Human.class); // 或 null
        System.out.println(invoke);
    }

    /*
     * 获取指定的构造器
     * */
    @Test
    public void test04() throws Exception {
        Class<Human> humanClass = Human.class;
        // 1. 创建指定的构造器 private Human(String name)
        //    参数: 指明构造器的参数列表
        Constructor<Human> constructor = humanClass.getDeclaredConstructor(String.class);
        // 2. 保证当前属性是可访问的
        constructor.setAccessible(true);
        // 3. 创建运行时对象
        Human human = constructor.newInstance("Tom");
        System.out.println(human);
    }
}
