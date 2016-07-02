package com.zerju.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Prikaz extends AppCompatActivity {


    final String POVEZAVA = "http://api.worldweatheronline.com/free/v2/weather.ashx?key=ec06deb22584093c8a148ccf77836";
    String format = "xml";
    String pridobi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prikaz);


       // pridobi = POVEZAVA + "&q=" + mesto + "&num_of_days=" + dnevi + "&format=json";


    }
}
