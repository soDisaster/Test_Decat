package com.annesophie.test_decat;
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
     * @param stores
     * The stores
     */
    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

}

