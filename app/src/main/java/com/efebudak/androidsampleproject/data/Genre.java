package com.efebudak.androidsampleproject.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by efebudak on 26/06/2017.
 */

public class Genre {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }
}
