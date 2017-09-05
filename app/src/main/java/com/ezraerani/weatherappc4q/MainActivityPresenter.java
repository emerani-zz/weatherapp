package com.ezraerani.weatherappc4q;

import android.util.Log;

import com.ezraerani.weatherappc4q.responsemodels.Period;
import com.ezraerani.weatherappc4q.responsemodels.WeatherResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ezraerani on 9/5/17.
 */

public class MainActivityPresenter {

    private MainActivity mainActivity;

    private ArrayList<Period> weatherPeriods;


    public MainActivityPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        weatherPeriods = new ArrayList<>();
        getData();
    }

    private void getData() {

        AerisClient aerisClient = new RetrofitClient().getAerisClient();
        Call<WeatherResponse> weatherResponseCall = aerisClient.forecast("11101",
                mainActivity.getString(R.string.client_id), mainActivity.getString(R.string.client_secret));

        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                weatherPeriods.addAll(response.body().getResponse().get(0).getPeriods());
                mainActivity.onWeatherDataReceived();
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("onFailure", t.getMessage());
            }
        });
    }

    public ArrayList<Period> getWeatherPeriods() {
        return weatherPeriods;
    }
}
