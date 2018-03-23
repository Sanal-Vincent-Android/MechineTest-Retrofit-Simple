package com.example.hp.mechinetest;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by hp on 19-11-2017.
 */

public interface Api {
    @FormUrlEncoded
    @POST("vrapi/sub-category")
    Call<JsonObject> datapost(
            @Field(Apitags.KEY) String inf_id);

}
