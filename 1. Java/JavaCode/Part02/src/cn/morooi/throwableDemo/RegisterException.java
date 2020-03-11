/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-11 20:02 CST
 */

package cn.morooi.throwableDemo;

/*
 * 自定义异常: java 提供的异常类, 不够使用, 需要自定义一些异常类
 * 格式:
 *   public class XXXException extends Exception | RuntimeException {
 *       添加一个空参数的构造方法
 *       添加一个带异常信息的构造方法
 *   }
 *
 * 注意:
 *   1. 自定义异常类一般都是以 Exception 结尾, 说明该类是一个异常类
 *   2. 自定义异常类, 必须得继承 Exception 或 RuntimeException
 * */

public class RegisterException extends /*Exception*/ RuntimeException {
    // 添加一个空参数的构造方法

    public RegisterException() {
    }

    public RegisterException(String message) {
        super(message);
    }

}
