package com.saperfumes.models;

import android.view.View;

import androidx.annotation.NonNull;

import com.saperfumes.R;

public class SavedAddress implements Cloneable {

    private String id;
    private String name;
    private String city;
    private String state;
    private String house;
    private String road;
    private String landmark;
    private String pincode;
    private String phone;
    private boolean isHome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isHome() {
        return isHome;
    }

    public void setHome(boolean home) {
        isHome = home;
    }

    public String getAddressString(){
        return house + ", " + road + ", " + landmark + ", " + city + ", " + state + " - " + pincode;
    }

    public String getAddressTypeLabel(View view){
        return isHome ? view.getContext().getString(R.string.home) : view.getContext().getString(R.string.office);
    }

    @NonNull
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public SavedAddress createClone(){
        try{
            return (SavedAddress) clone();
        } catch (CloneNotSupportedException e){
            return null;
        }
    }

}
