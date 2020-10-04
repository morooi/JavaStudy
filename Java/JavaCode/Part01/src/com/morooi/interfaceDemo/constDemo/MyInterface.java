/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:30 CST
 */

package com.morooi.interfaceDemo.constDemo;

/*
 * 接口当中也可以定义"成员变量"，但是必须使用public static final三个关键字进行修饰
 * 从效果上看，这就是接口的【常量】
 *
 * 格式：
 * public static final 数据类型 常量名称 = 数据值;
 *
 * 备注：
 * 一旦使用final关键字进行修饰，说明不可改变
 *
 * 注意事项：
 * 1、接口当中的常量，可以省略public static final，注意：不写也照样是这样
 * 2、接口当中的常量，必须进行赋值，不能不赋值
 * 3、接口当中的常量名称，使用完全大写的字母，用下划线进行分隔(推荐)
 * */

public class MyInterface {
    public static void main(String[] args) {
        // 访问接口当中的常量
        System.out.println(MyInterfaceConst.NUM_OF_MY_CLASS);
    }
}
