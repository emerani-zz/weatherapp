package com.ezraerani.weatherappc4q;

import com.ezraerani.weatherappc4q.responsemodels.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ezraerani on 9/5/17.
 */

public interface AerisClient {

    @GET("forecasts/{zip}")
    Call<WeatherResponse> forecast(@Path("zip") String zip, @Query("client_id") String client_id,
                                   @Query("client_secret") String client_secret);
}
