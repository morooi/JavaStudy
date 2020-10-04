/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-10 15:45 CST
 */

package cn.morooi.collectionDemo.douDiZhu;

import java.util.ArrayList;
import java.util.Arrays;

public class Cards {
    private static String[] huaSe = {"♠", "❤", "♣", "♦"};
    private static String[] shuZi = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
    private static String[] wang = {"大王", "小王"};

    public static ArrayList<String> makeCards() {

        ArrayList<String> cards = new ArrayList<>();
        for (String s : huaSe) {
            for (String value : shuZi) {
                String card = s + value;
                cards.add(card);
            }
        }
        cards.addAll(Arrays.asList(wang));

        return cards;
    }
}
