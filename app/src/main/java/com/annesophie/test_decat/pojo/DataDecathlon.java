package com.annesophie.test_decat.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* Classe créée à l'aide de http://www.jsonschema2pojo.org/ */

public class DataDecathlon {

    @SerializedName("data")
    @Expose
    private Data data;

    /**
     *
     * @return
     * The data
     */
    public Data getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(Data data) {
        this.data = data;
    }

}