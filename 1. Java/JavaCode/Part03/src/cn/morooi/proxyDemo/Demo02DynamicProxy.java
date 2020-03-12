/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-12 19:46 CST
 */

package cn.morooi.proxyDemo;

/*
 * 实现动态代理, 需要解决的问题
 *   1. 如何根据加载到内存中的被代理类, 动态的创建一个代理类及其对象
 *   2. 当通过代理类的对象调用方法时, 如何动态的去调用被代理类中的同名方法
 * */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    String getBelief();

    void eat(String food);
}

// 被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃:" + food);
    }
}

class ProxyFactory {
    // 解决问题一: 调用一个方法, 返回一个代理类的对象
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj; // 需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 通过代理类对象调用方法 a 时, 就会自动调用如下的方法: invoke()
    // 将被代理类要执行的方法 a 的功能就声明在 invoke() 中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method: 代理类对象调用的方法, 此方法也就作为了被代理类对象要调用的方法
        // obj: 被代理类的对象
        return method.invoke(obj, args);
    }
}

public class Demo02DynamicProxy {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyHuman = (Human)ProxyFactory.getProxyInstance(superMan);
        String belief = proxyHuman.getBelief();
        System.out.println(belief);
        proxyHuman.eat("肉肉");

        System.out.println("=====================");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory)ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}
