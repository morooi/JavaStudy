/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-09 21:13 CST
 */

package cn.morooi.mapDemo;

/*
 * java.util.Map<K, V> 集合
 * - HashMap: 作为 Map 的主要实现类, 线程不安全, 效率高. 可以存储 null 的 key 和 value
 * - LinkedHashMap: 保证在遍历 Map 元素时, 可以按照添加的顺序实现遍历 (对于频繁的遍历操作, 此类执行效率高于 HashMap)
 * - TreeMap: 保证按照添加的 key-value 对进行排序, 实现排序遍历. 此时考虑 key 的自然排序或定制排序. 底层使用红黑树
 * - Hashtable: 作为古老的实现类, 线程安全, 效率低. 不能存储 null 的 key 和 value
 * - Properties: 常用来处理配置文件. key 和 value 都是 String 类型
 *
 * 特点:
 *   1. Map 集合是一个双列集合, 一个元素包含两个值(一个 key, 一个 value)
 *   2. Map 集合中的元素, key 和 value 的数据类型可以相同, 也可以不同
 *   3. Map 中的 key 是不允许重复的, 使用 Set 存储所有的 key --> key 所在的类要重写 equals() 和 hashCode() (以 HashMap 为例)
 *   3. Map 中的 value 可以重复, 使用 Collection 存储所有的value  --> value 所在的类要重写 equals()
 *   4. Map 集合中的元素, key 和 value 是一一对应, 构成一个 Entry 对象
 *
 * Map 集合的常用实现类:
 *   - java.util.HashMap<k, v> 集合 implements Map<k, v> 接口
 *      特点:
 *          1. HashMap 集合底层是哈希表, 查询速度特别快
 *          2. HashMap 集合是一个无序的集合, 存储和取出的顺序可能不一致
 *
 *  - java.util.LinkedHashMap<k, v> 集合 extends HashMap<k, v> 集合
 *      特点:
 *          1. LinkedHashMap 集合底层是哈希表 + 链表 (保证迭代的顺序)
 *          2. LinkedHashMap 集合是一个有序的集合, 存储和取出的顺序是一致的
 *
 * Map 集合的常用方法:
 *  - public V put(K key, V value): 把指定的键与指定的值添加到 Map 集合中
 *  - public V remove(Object key): 把指定的键所对应的键值对元素在 Map 集合中删除, 返回被删除元素的值
 *  - public V get(Object key): 根据指定的键, 在 Map 集合中获取对应的值
 *  - boolean containsKey(Object key): 判断集合中是否包含指定的键
 *  - public Set<K> keySet(): 获取 Map 集合中所有的键, 存储到 Set 集合中
 *  - public Set<Map.Entry<K, V>> entrySet(): 获取到 Map 集合中所有的键值对对象的集合(Set 集合)
 * */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo01Map {
    public static void main(String[] args) {
        // 以 HashMap 为例
        demoPut();
        System.out.println("==========");
        demoRemove();
        System.out.println("==========");
        demoGet();
        System.out.println("==========");
        demoContainsKey();
        System.out.println("==========");
        demoKeySet();
        System.out.println("==========");
        demoEntrySet();
    }

    /*
     * Map.Entry<K, V>: 在 Map 接口中有个内部接口 Entry
     * 作用: 当 Map 集合一创建, 那么就会在 Map 集合中创建一个 Entry 对象, 用来记录键与值
     * */
    private static void demoEntrySet() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "111");
        hashMap.put("2", "222");
        hashMap.put("3", "333");

        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        System.out.println(entries);
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(hashMap.get(entry.getKey()));
        }
    }

    private static void demoKeySet() {
        /*
         * 遍历 Map
         * */
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "111");
        hashMap.put("2", "222");
        hashMap.put("3", "333");

        for (String key : hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }

        // 或
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(hashMap.get(it.next()));
        }
    }

    private static void demoContainsKey() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "111");
        hashMap.put("2", "222");
        hashMap.put("3", "333");
        System.out.println(hashMap);

        System.out.println("hashMap.containsKey(\"2\") = " + hashMap.containsKey("2"));
        System.out.println("hashMap.containsKey(\"4\") = " + hashMap.containsKey("4"));
    }


    /*
     * public V get(Object key): 根据指定的键, 在 Map 集合中获取对应的值
     * 返回值 V:
     *      key 存在, V 返回对应的 value
     *      key 不存在, V 返回 null
     * */
    private static void demoGet() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "111");
        hashMap.put("2", "222");
        hashMap.put("3", "333");
        System.out.println(hashMap);

        System.out.println("hashMap.get(\"2\") = " + hashMap.get("2"));
        System.out.println("hashMap.get(\"3\") = " + hashMap.get("3"));
    }


    /*
     * public V remove(Object key): 把指定的键所对应的键值对元素在 Map 集合中删除, 返回被删除元素的值
     * 返回值 V:
     *      key 存在, V 返回被删除的值
     *      key 不存在, V 返回 null
     * */
    private static void demoRemove() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1", 1);
        hashMap.put("2", 2);
        hashMap.put("3", 3);
        System.out.println(hashMap);

        Integer remove = hashMap.remove("2"); // 2
        Integer remove1 = hashMap.remove("4"); // null
        System.out.println(hashMap);
        System.out.println("remove = " + remove);
        System.out.println("remove1 = " + remove1);
    }

    /*
     * public V put(K key, V value): 把指定的键与指定的值添加到 Map 集合中
     * 返回值 V:
     *      存储键值对的时候, key 不重复, 返回值 V 是 null
     *      存储键值对的时候, key 重复, 会使用新的 value 替换 Map 中重复的 value, 返回被替换的 value 值
     * */
    private static void demoPut() {
        Map<String, String> hashMap = new HashMap<>();
        String v1 = hashMap.put("杨颖", "黄晓明");
        System.out.println("v1 = " + v1);
        System.out.println(hashMap);

        String v2 = hashMap.put("杨颖", "黄晓明2");
        System.out.println("v2 = " + v2);
        System.out.println(hashMap);
    }
}
