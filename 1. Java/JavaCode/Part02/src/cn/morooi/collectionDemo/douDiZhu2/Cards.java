/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-11 16:51 CST
 */

package cn.morooi.collectionDemo.douDiZhu2;

import java.util.*;

public class Cards {
    public static Map<Integer, String> makeCards() {
        List<String> colors = List.of("♠", "❤", "♣", "♦");
        List<String> numbers = List.of("3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2");
        List<String> pokes = List.of("小王", "大王");

        Map<Integer, String> map = new HashMap<>();
        int index = 0;
        for (String s : numbers) {
            for (String value : colors) {
                String card = value + s;
                map.put(index++, card);
            }
        }
        for (String poke : pokes) {
            map.put(index++, poke);
        }

        return map;
    }
}
