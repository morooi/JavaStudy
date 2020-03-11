/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-11 15:52 CST
 */

package cn.morooi.collectionDemo.douDiZhu;

import java.util.ArrayList;
import java.util.Collections;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<String> cards = Cards.makeCards();

        Collections.shuffle(cards);
        ArrayList<String> one = new ArrayList<>();
        ArrayList<String> two = new ArrayList<>();
        ArrayList<String> three = new ArrayList<>();
        ArrayList<String> restCards = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++) {
            if (i >= 51) {
                restCards.add(cards.get(i));
            }

            if (i % 3 == 0) {
                one.add(cards.get(i));
            } else if (i % 3 == 1) {
                two.add(cards.get(i));
            } else {
                three.add(cards.get(i));
            }
        }

        System.out.println("one = " + one);
        System.out.println("two = " + two);
        System.out.println("three = " + three);
        System.out.println("restCards = " + restCards);
        
    }
}
