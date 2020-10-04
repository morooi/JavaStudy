package cn.morooi.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {

    private static final long serialVersionUID = 3488976691132439157L;

    private String username;
    private String password;
    private Double money;

//    private User user;
    private List<User> userList;
    private Map<String, User> userMap;

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", userList=" + userList +
                ", userMap=" + userMap +
                '}';
    }

/*    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }
}
