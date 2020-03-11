/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 20:47 CST
 */

package com.morooi.extendsDemo.hongBao;

import java.util.ArrayList;

public class MasterUser extends User {

    public MasterUser() {
    }

    public MasterUser(String name, double balance) {
        super(name, balance);
    }

    public ArrayList<Double> sendMoney(int count, double money) {
        ArrayList<Double> moneyList = new ArrayList<>();

        double beforeHongBao = this.getBalance();
        if (beforeHongBao < money) {
            System.out.println("余额不足！");
            return moneyList;
        }

        double eachMoney = money / count;
        for (int i = 0; i < count; i++) {
            moneyList.add(eachMoney);
        }

        double afterHongBao = beforeHongBao - money;
        this.setBalance(afterHongBao);
        System.out.printf("%s原有余额：%.2f，发放红包%d个，共%.2f元，现有余额：%.2f\n",
                this.getName(), beforeHongBao, count, money, afterHongBao);

        return moneyList;
    }
}
