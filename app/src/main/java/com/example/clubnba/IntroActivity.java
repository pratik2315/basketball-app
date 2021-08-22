package com.example.clubnba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    private TextView getStarted, infoTv, tvGetStarted, admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getStarted = findViewById(R.id.getStarted);
        tvGetStarted = findViewById(R.id.tvGetStarted);
        infoTv = findViewById(R.id.infoIcon);
        admin = findViewById(R.id.admin);

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, OnBoardingActivity.class));
                finish();
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, HomeActivity.class));
                finish();
            }
        });

        tvGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, OnBoardingActivity.class));
                finish();
            }
        });
        
    }
}