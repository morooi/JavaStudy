package cn.morooi.service.impl;

import cn.morooi.service.AccountService;

import java.util.Date;

public class AccountServiceImpl2 implements AccountService {

    // 如果是经常变化的数据, 并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public void saveUser() {
        System.out.println("serivce 中的 saveAccount 方法执行了: " + name + ", " + age + ", " + birthday);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
