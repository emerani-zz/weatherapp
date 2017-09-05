package com.ezraerani.weatherappc4q;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ezraerani.weatherappc4q.responsemodels.Period;
import com.ezraerani.weatherappc4q.responsemodels.WeatherResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Period> weatherPeriods = new ArrayList<>();

        AerisClient aerisClient = new RetrofitClient().getAerisClient();
        Call<WeatherResponse> weatherResponseCall = aerisClient.forecast("11101",
                getString(R.string.client_id), getString(R.string.client_secret));

        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                weatherPeriods.addAll(response.body().getResponse().get(0).getPeriods());
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("onFailure", t.getMessage());
            }
        });
    }
}
