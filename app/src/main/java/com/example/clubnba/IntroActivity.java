package com.example.clubnba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    private TextView getStarted, infoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getStarted = findViewById(R.id.getStarted);
        infoTv = findViewById(R.id.infoIcon);

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, OnBoardingActivity.class));
                //shivam start working from here, go to OnBoardingActivity Aur usme woh yt video ka code add karde
            }
        });
    }
}