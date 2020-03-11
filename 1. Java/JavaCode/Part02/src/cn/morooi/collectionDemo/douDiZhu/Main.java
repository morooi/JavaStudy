/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-10 15:45 CST
 */

package cn.morooi.collectionDemo.douDiZhu;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cards = Cards.makeCards();
//        for (String card : cards) {
//            System.out.println(card);
//        }

        ArrayList<String> one = new ArrayList<>();
        ArrayList<String> two = new ArrayList<>();
        ArrayList<String> three = new ArrayList<>();

        while (cards.size() > 3) {
            sendCard(one, cards);
            sendCard(two, cards);
            sendCard(three, cards);
        }
        System.out.println("one = " + one);
        System.out.println("=========");
        System.out.println("two = " + two);
        System.out.println("=========");
        System.out.println("three = " + three);
    }

    private static void sendCard(ArrayList<String> person, ArrayList<String> cards) {
        int index = new Random().nextInt(cards.size());
        person.add(cards.get(index));
        cards.remove(index);
    }
}
