package com.example.restaurantvago;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton faceBookBtn = findViewById(R.id.faceBookBtn);
        ImageButton twitterBtn = findViewById(R.id.twitterBtn);
        ImageButton instagramBtn = findViewById(R.id.instagramBtn);
        ImageButton youtubeBtn = findViewById(R.id.youtubeBtn);


        faceBookBtn.setImageResource(R.drawable.facebook);
        faceBookBtn.setBackgroundDrawable(null);
        twitterBtn.setImageResource(R.drawable.twitter);
        twitterBtn.setBackgroundDrawable(null);
        instagramBtn.setImageResource(R.drawable.instagram);
        instagramBtn.setBackgroundDrawable(null);
        youtubeBtn.setImageResource(R.drawable.youtube);
        youtubeBtn.setBackgroundDrawable(null);
    }

}
