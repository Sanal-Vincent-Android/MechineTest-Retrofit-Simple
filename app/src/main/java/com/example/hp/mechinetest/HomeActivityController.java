package com.example.hp.mechinetest;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by acer on 26-10-2017.
 */

public class HomeActivityController implements INavigationdrawerController {
    Context context;
    INavigationdrawerControllerCallback inavigationcallback;
   // Apis apis;

    public HomeActivityController(Context context, INavigationdrawerControllerCallback inavigationcallback) {
        this.context = context;
        this.inavigationcallback = inavigationcallback;
//        apis = App.getClient().create(Apis.class);
    }

    @Override
    public void navigationdrawers(String category_id) {
        Retrofit retrofit = App.getClient();
        Api service = retrofit.create(Api.class);
        service.datapost(category_id).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {

                    JsonObject data;
                    JsonObject responseObject = response.body();
                    if (responseObject.has(Apitags.CATOGORY)) {
                        data = responseObject.getAsJsonObject(Apitags.CATOGORY);
                        JsonArray data2 = data.getAsJsonArray(Apitags.DATA);
                        ArrayList<Data> myorder = getGeneral(data2.toString());
                        inavigationcallback.navigationsuccess(myorder);
                    }

                    else {
                        Toast.makeText(context,"error",Toast.LENGTH_LONG).show();
                    }
                }
                else {

                    Toast.makeText(context, "failed to fetch", Toast.LENGTH_LONG).show();

                }

            }
            private ArrayList<Data> getGeneral(String s) {
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Data>>() {
                }.getType();

                return gson.fromJson(s, listType);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }


}
