/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 23:25 CST
 */

package cn.morooi.genericDemo;

/*
 * 含有泛型的接口, 第一种使用方式: 定义接口的实现类, 实现接口, 指定接口的泛型
 * public interface Iterator<E> {
 *     E next();
 * }
 *
 * Scanner 类实现了 Iterator 接口, 并指定接口的泛型为 String, 所以重写的 next 方法泛型默认就是 String
 * public final class Scanner implements Iterator<String> {
 *     public String next() { ... }
 * }
 *
 * */

public class GenericInterfaceImpl1 implements GenericInterface<String> {
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
