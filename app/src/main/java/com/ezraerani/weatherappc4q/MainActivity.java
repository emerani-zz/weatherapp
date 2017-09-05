package com.ezraerani.weatherappc4q;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MainActivityPresenter presenter;
    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    private boolean isFahrenheit = true;
    Button changeUnitsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);
        initViews();

    }

    private void initViews(){
        changeUnitsButton = (Button) findViewById(R.id.changeUnitsButton);
        changeUnitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleUnits();
            }
        });

        adapter = new RecyclerViewAdapter(presenter.getWeatherPeriods(), this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
    }

    private void toggleUnits() {
        isFahrenheit = !isFahrenheit();
        String buttonText;
        if (isFahrenheit) {
            buttonText = getString(R.string.show_celsius);
        } else {
            buttonText = getString(R.string.show_fahrenheit);
        }
        changeUnitsButton.setText(buttonText);
        adapter.notifyDataSetChanged();
    }

    public boolean isFahrenheit() {
        return isFahrenheit;
    }


    public void onWeatherDataReceived() {
        adapter.notifyDataSetChanged();
    }
}
