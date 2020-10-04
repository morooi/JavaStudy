/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 23:55 CST
 */

package cn.morooi.enumDemo;

/*
 * 枚举类的使用
 *   1. 枚举类的理解: 类的对象只有有限个, 确定的.
 *   2. 当需要定义一组常量时, 强烈建议使用枚举类
 *   3. 如果枚举类中只有一个对象, 则可以作为单例模式的实现方式
 *
 * 如何定义枚举类
 *   方式一: JDK 5.0 之前, 自定义枚举类
 *
 *   方式二: JDK 5.0 后, 可以使用 enum 关键字自定义枚举类
 *       说明: 默认集成 java.lang.Enum 类
 *
 * Enum 类中的常用方法
 *    values(): 返回枚举类型的对象数组, 该方法可以很方便地遍历所有的枚举值
 *    valueOf(String str): 可以把一个字符串转为对应的枚举类对象. 要求字符串必须是枚举类对象的
 *    toString(): 返回当前枚举类对象的常量名称
 * */

public class Demo01Enum {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
    }
}

// 自定义枚举类
class Season1 {
    // 1. 声明 Season 对象的属性: private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2. 私有化类的构造器, 并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3. 提供当前枚举类的多个对象: public static final
    public static final Season1 SPRING = new Season1("春天", "春暖花开");
    public static final Season1 SUMMER = new Season1("夏天", "夏日炎炎");
    public static final Season1 AUTUMN = new Season1("秋天", "秋高气爽");
    public static final Season1 WINTER = new Season1("冬天", "冰天雪地");

    // 4. 其他诉求1: 获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 5. 其他诉求2: 通提供 toString()
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}