/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 23:31 CST
 */

package cn.morooi.genericDemo;

/*
 * 含有泛型的接口, 第二种使用方式: 接口使用什么类型, 实现类就使用什么类型, 类跟着接口走
 * 就相当于定义了一个含有泛型的类, 创建对象的时候确定泛型的类型
 * public interface List<E> {
 *     boolean add(E e);
 *     E get(int index);
 * }
 *
 * ArrayList 类实现了 List 接口
 * public ArrayList<E> implements List<E> {
 *     public boolean add(E e) { ... }
 *     public E get(int index) { ... }
 * }
 *
 * */

public class GenericInterfaceImpl2<I> implements GenericInterface<I> {

    @Override
    public void method(I i) {
        System.out.println(i);
    }
}
