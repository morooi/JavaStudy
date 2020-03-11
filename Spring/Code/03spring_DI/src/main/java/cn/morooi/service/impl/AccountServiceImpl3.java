package cn.morooi.service.impl;

import cn.morooi.service.AccountService;

import java.util.*;

public class AccountServiceImpl3 implements AccountService {

    private String[] strings;
    private List<String> stringList;
    private Set<String> stringSet;
    private Map<String, String> stringMap;
    private Properties properties;

    @Override
    public void saveUser() {
        System.out.println(Arrays.toString(strings));
        System.out.println(stringList);
        System.out.println(stringSet);
        System.out.println(stringMap);
        System.out.println(properties);
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
