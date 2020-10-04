/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 20:50 CST
 */

package com.morooi.extendsDemo.hongBao;

import java.util.ArrayList;
import java.util.Random;

public class NormalUser extends User{

    public NormalUser() {
    }

    public NormalUser(String name, double account) {
        super(name, account);
    }

    public void receiveMoney(ArrayList<Double> money) {

        int index = new Random().nextInt(money.size());
        double hongBao = money.remove(index);

        double beforeHongBao = this.getBalance();
        double afterHongBao = beforeHongBao + hongBao;
        this.setBalance(afterHongBao);

        System.out.printf("%s原有余额：%.2f，收到红包%.2f元，现有余额：%.2f\n",
                this.getName(), beforeHongBao, hongBao, afterHongBao);
    }
}
