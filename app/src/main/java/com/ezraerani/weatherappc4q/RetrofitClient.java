package com.ezraerani.weatherappc4q;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ezraerani on 9/5/17.
 */

public class RetrofitClient {

    private AerisClient aerisClient;

    public RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.aerisapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aerisClient = retrofit.create(AerisClient.class);
    }

    public AerisClient getAerisClient() {
        return aerisClient;
    }
}
