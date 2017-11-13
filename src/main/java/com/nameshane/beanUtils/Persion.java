package com.nameshane.beanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Persion {
	private String username;  
    private int age;  
    private float stature;//身高  
    private boolean sex;//性别  
    @SuppressWarnings("unchecked")  
    private List list = new ArrayList();  
    private String[] friendsNames;  
    private Map<String, String> maps = new HashMap<String, String>();  
    private Address address;  
      
    public String getUsername() {  
        return username;  
    }  
    public void setUsername(String username) {  
        this.username = username;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
    public float getStature() {  
        return stature;  
    }  
    public void setStature(float stature) {  
        this.stature = stature;  
    }  
    public boolean isSex() {  
        return sex;  
    }  
    public void setSex(boolean sex) {  
        this.sex = sex;  
    }  
    @SuppressWarnings("unchecked")  
    public List getList() {  
        return list;  
    }  
    @SuppressWarnings("unchecked")  
    public void setList(List list) {  
        this.list = list;  
    }  
    public Address getAddress() {  
        return address;  
    }  
    public void setAddress(Address address) {  
        this.address = address;  
    }  
    public Map<String, String> getMaps() {  
        return maps;  
    }  
    public void setMaps(Map<String, String> maps) {  
        this.maps = maps;  
    }  
    public String[] getFriendsNames() {  
        return friendsNames;  
    }  
    public void setFriendsNames(String[] friendsNames) {  
        this.friendsNames = friendsNames;  
    }  

}
