package com.zerju.weather;

import io.realm.RealmObject;

/**
 * Created by System32 on 6. 03. 2016.
 */
public class Location extends RealmObject {
    private String name;
    private String city;
    private String country;
    private boolean selected;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
