/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-09 16:33 CST
 */

package cn.morooi.annotationDemo;

/*
 * 注解的使用:
 *   JDK 5.0 新增的
 *
 * 如何自定义注解:
 *   1. 注解声明为: @interface
 *   2. 内部定义成员变量, 通常使用 value 表示
 *   3. 可以指定成员的默认值, 使用 default 定义
 *   4. 如果自定义注解没有成员, 表明是一个标识作用
 *
 *   如果注解有成员, 在使用注解时, 需要指明成员的值
 *   自定义注解必须配上注解的信息处理流程(使用反射)才有意义
 *   自定义注解通常都会指明两个元注解: Retention, Target
 *
 * JDK 提供的 4 种元注解
 *   元注解: 对现有的注解进行解释说明的注解
 *   ★ Retention: 指定所修饰的 Annotation 的生命周期: SOURCE / CLASS (默认) / RUNTIME
 *                 只有声明为 RUNTIME 生命周期的注解, 才能通过反射获取
 *   ★ Target: 用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 *   Documented: 表示所修饰的注解在被 javadoc 解析时, 保留下来
 *   Inherited: 被它修饰的 Annotation 将具有继承性
 *
 * JDK 8 的注解新特性: 可重复注解, 类型注解
 *      可重复注解:
 *          1. 在 MyAnnotation 上声明 @Repeatable, 成员值为 MyAnnotations.class
 *          2. MyAnnotation 的 Target, Retention 等元注解和 MyAnnotations 相同
 *      类型注解:
 *          ElementType.TYPE_PARAMETER: 表示该注解能写在类型变量的声明语句中
 *          ElementType.TYPE_USE: 表示该注解能写在使用类型的任何语句中
 * */

@MyAnnotation(value = "Hi")
public class Demo01Annotation {
}
