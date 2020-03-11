/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-09 13:23 CST
 */

package cn.morooi.annotationDemo;

public @interface MyAnnotation {
    String value() default "hello";
}
