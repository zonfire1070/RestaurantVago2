package com.example.restaurantvago;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(Main2Activity.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#ffffff"))
                .withLogo(R.mipmap.ic_launcher_foreground)
                .withHeaderText("Connect, Eat and Enjoy")
                .withFooterText("Copyright 2019");
        //Text Color
        config.getHeaderTextView().setTextColor(android.graphics.Color.BLACK);
        config.getFooterTextView().setTextColor(android.graphics.Color.BLACK);

        //set to view

        View view = config.create();

        //Set view to content view
        setContentView(view);
    }
}
