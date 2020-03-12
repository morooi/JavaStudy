/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-12 21:54 CST
 */

package cn.morooi.proxyDemo;

/*
 * 静态代理举例:
 *   特点: 代理类和被代理类在编译期间, 就确定下来了
 *
 * */

interface ClothFactory {
    void produceCloth();
}

class ProxyClothFactory implements ClothFactory {

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂生产衣服....");
        clothFactory.produceCloth();
        System.out.println("代理工厂生产完成....");
    }
}

class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike 工厂生产衣服!");
    }
}

public class Demo01StaticProxy {
    public static void main(String[] args) {
        ClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}
