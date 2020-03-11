/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:22 CST
 */

package com.morooi.interfaceDemo.privateDemo;

public class MyInterfacePrivateImplA implements MyInterfacePrivate {
    public void methodAnother() {
        // 直接访问到了接口中的默认方法，这样是错误的！不应该这样
//        methodCommon();
    }
}
