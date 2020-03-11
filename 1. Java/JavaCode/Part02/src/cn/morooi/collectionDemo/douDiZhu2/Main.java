/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-11 16:57 CST
 */

package cn.morooi.collectionDemo.douDiZhu2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> cards = Cards.makeCards();

//        System.out.println(cards);
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            indexs.add(i);
        }

        Collections.shuffle(indexs);
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        ArrayList<Integer> three = new ArrayList<>();
        ArrayList<Integer> left = new ArrayList<>();

        for (int i = 0; i < indexs.size(); i++) {
            if (i < 51) {
                if (i % 3 == 0) {
                    one.add(indexs.get(i));
                } else if (i % 3 == 1) {
                    two.add(indexs.get(i));
                } else {
                    three.add(indexs.get(i));
                }
            } else {
                left.add(indexs.get(i));
            }
        }

        Collections.sort(one);
        Collections.sort(two);
        Collections.sort(three);
        Collections.sort(left);

        printCards(one, cards);
        printCards(two, cards);
        printCards(three, cards);
        printCards(left, cards);
    }

    private static void printCards(ArrayList<Integer> indexs, Map<Integer, String> cards) {
        ArrayList<String> card = new ArrayList<>();
        for (Integer index : indexs) {
            String s = cards.get(index);
            card.add(s);
        }
        System.out.println(card);
    }
}
