package com.example.hp.mechinetest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 19-11-2017.
 */

public class Data {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("category")
    @Expose
    private String category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}

