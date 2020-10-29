package com.saperfumes.dummyrepo;

import com.saperfumes.models.SavedAddress;

import java.util.ArrayList;

public class SavedAddressRepositiory {

    private static SavedAddressRepositiory instance;
    private ArrayList<SavedAddress> savedAddresses;

    public static SavedAddressRepositiory getInstance(){
        if(instance == null){
            instance = new SavedAddressRepositiory();
        }
        return instance;
    }

    private SavedAddressRepositiory(){
        savedAddresses = new ArrayList<>();
        SavedAddress dummyAddress = new SavedAddress();
        dummyAddress.setCity("Pune");
        dummyAddress.setState("Maharashtra");
        dummyAddress.setLandmark("Opposite Masjid");
        dummyAddress.setHouse("Gagan Apartment, Flat no 5");
        dummyAddress.setRoad("Bhairav Nagar, Dhanori Road");
        dummyAddress.setName("Ismail Shaikh");
        dummyAddress.setPincode("411015");
        dummyAddress.setId("0");
        dummyAddress.setPhone("9359294093");
        savedAddresses.add(dummyAddress);
    }

    public ArrayList<SavedAddress> getSavedAddresses() {
        return savedAddresses;
    }

    public void addAddress(SavedAddress address){
        if(address != null){
            savedAddresses.add(address);
        }
    }

    public void removeAddress(String id){
        int position = getPositionOfAddress(id);

        if(position >= 0){
            savedAddresses.remove(position);
        }
    }

    public void updateAddress(SavedAddress savedAddress){
        int position = getPositionOfAddress(savedAddress.getId());

        if(position >= 0){
            savedAddresses.set(position, savedAddress);
        }
    }

    public SavedAddress getAddressFromId(String id){
        int position = getPositionOfAddress(id);

        if(position >=0){
            return savedAddresses.get(position);
        }
        return null;
    }

    public int getPositionOfAddress(String id){
        int position = -1;
        for(int i=0;i< savedAddresses.size();i++){
            SavedAddress address = savedAddresses.get(i);
            if(address.getId().equals(id)){
                position = i;
                break;
            }
        }
        return position;
    }

    public SavedAddress getAddress(int position) {
        if(position < 0 || position >= savedAddresses.size()){
            return null;
        }
        return savedAddresses.get(position);
    }
}
