package com.example.a45mph;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TripDataLog t = new TripDataLog(50, 2.5);
        t.setEntry();
    }

    // TODO: add event handlers here
    // main activity events focus on jumping to the other activities.
    public void jumpToFuelCosts(View view) { }
    public void jumpToHypotheticalBuyableFuel(View view) { }
    public void jumpToTrip(View view) { }

}