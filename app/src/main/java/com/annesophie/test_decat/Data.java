package com.annesophie.test_decat;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* Créé à l'aide de http://www.jsonschema2pojo.org/ */

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
     * @param stores
     * The stores
     */
    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

}