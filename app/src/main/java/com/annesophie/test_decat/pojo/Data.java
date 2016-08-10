package com.annesophie.test_decat.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/* Classe créée à l'aide de http://www.jsonschema2pojo.org/ */

public class Data {

    @SerializedName("stores")
    @Expose
    private ArrayList<Store> stores = new ArrayList<Store>();

    /**
     *
     * @return
     * The stores
     */
    public ArrayList<Store> getStores() {
        return stores;
    }

    /**
     *
     * @return
     * The stores' names
     */
    public ArrayList<String> getStoresDecathlonNames() {
        ArrayList<String> nameStoresDecathlon = new ArrayList<String>();
        for ( Store s : stores ) {
            if(s.getOpeningStore() == false && s.getCountry().equals("FRANCE")) {
                nameStoresDecathlon.add(s.getName());
            }
        }
        return nameStoresDecathlon;
    }

    /**
     *
     * @return
     * The stores information with name
     */
    public ArrayList<String> getStoreInformation(String nameDecat) {
        ArrayList<String> informationStore = new ArrayList<>();
        for ( Store s : stores ) {
            if(s.getName().equals(nameDecat)) {
                informationStore.add(s.getAddress());
                informationStore.add(s.getCity());
                informationStore.add(s.getCountry());
            }
        }
        return informationStore;
    }

    /**
     *
     * @param stores
     * The stores
     */
    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

}

