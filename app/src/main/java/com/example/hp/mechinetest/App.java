package com.example.hp.mechinetest;

import android.app.Application;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 19-11-2017.
 */

public class App extends Application {
    public static final String BASE_URL="http://demo.phpwebsites.in/";
   // public static final String IMAGE_URL="http://iroidtech.com/skoolcart/image/";

    static OkHttpClient.Builder httpClient = null;

    private static Retrofit retrofit = null;

    @Override
    public void onCreate() {
        super.onCreate();


    }

    private static OkHttpClient buildClient() {
        return new OkHttpClient
                .Builder()

                .build();




    }

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(buildClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)

                    .build();
        }
        return retrofit;
    }



}
