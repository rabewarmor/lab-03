package com.example.listycitylab3;

import java.io.Serializable;

public class City implements Serializable {
    private String name;
    private String province; // final var acts as a constant. value cannot be changed

    public City(String name1, String province1) {
        this.name = name1;
        this.province = province1;
    }

    // getters
    public String getName(){
        return name;
    }
    public String getProvince() {
        return province;
    }


    // setters

    public void setName(String name1) {
        this.name = name1;
    }

    public void setProvince(String province1) {
        this.province = province1;

    }

}
