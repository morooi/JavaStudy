/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 20:49 CST
 */

package com.morooi.extendsDemo.hongBao;

import java.util.ArrayList;

public class HongBao {
    public static void main(String[] args) {
        MasterUser masterUser = new MasterUser("群主", 2000.0);
        NormalUser normalUser01 = new NormalUser("吃瓜群众1", 0);
        NormalUser normalUser02 = new NormalUser("吃瓜群众2", 200.0);
        NormalUser normalUser03 = new NormalUser("吃瓜群众3", 10.0);


        ArrayList<Double> hongBao = masterUser.sendMoney(3, 500);
        normalUser01.receiveMoney(hongBao);
        normalUser02.receiveMoney(hongBao);
        normalUser03.receiveMoney(hongBao);

    }
}
