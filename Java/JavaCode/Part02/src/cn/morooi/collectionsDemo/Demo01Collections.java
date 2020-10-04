/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-09 22:16 CST
 */

package cn.morooi.collectionsDemo;

/*
 * Collections: 操作 Collection 和 Map 的工具类
 *
 * reverse(List list): 反转 list 中元素的顺序
 * shuffle(List list): 随机排序 list 中的元素
 * sort(List list): 根据元素的自然顺序对指定 list 集合元素按升序排序
 * sort(List list, Comparator): 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 * swap(List list, int i, int j): 将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 * Object max(Collection)
 * Object max(Collection, Comparator)
 * Object min(Collection)
 * Object min(Collection, Comparator)
 *
 * int frequency(Collection, Object): 返回指定集合中元素出现的频率
 * void copy(List dest, List src): 将 src 中的内容复制到 dest 中
 * boolean replaceAll(List list, Object oldVal, Object newVal): 使用新值替换 List 对象
 *
 * Collections 类中提供了多个 synchronizedXxx() 方法, 该方法可使将指定集合包装成线程同步的集合,
 *      从而可以解决多线程并发访问集合时的线程安全问题
 * */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo01Collections {
    @Test
    public void copyTest() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(123);
        integers.add(456);
        integers.add(-1287);
        integers.add(0);
        integers.add(43);

        List<Integer> list = Arrays.asList(new Integer[integers.size()]);
        Collections.copy(list, integers);
        System.out.println(list);
    }

    @Test
    public void synchronizedTest() {
        // 返回的 list 即为线程安全的 List
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(list);
    }
}
