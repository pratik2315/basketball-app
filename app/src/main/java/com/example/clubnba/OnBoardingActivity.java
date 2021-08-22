package com.example.clubnba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoardingActivity extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mLinearLayout;

    private TextView[] mDots;

    private sliderAdapter mSliderAdapter;
    private Button nextButton;
    private Button backButton;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        mSlideViewPager=(ViewPager)findViewById(R.id.slideviewpager);
        mLinearLayout=(LinearLayout)findViewById(R.id.linearslide);

        nextButton=(Button) findViewById(R.id.button2) ;
        backButton=(Button) findViewById(R.id.button);

        mSliderAdapter= new sliderAdapter(this);
        mSlideViewPager.setAdapter(mSliderAdapter);
        addDots(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(currentPage+1);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(currentPage-1);
            }
        });

    }

    public void addDots(int position){
        mDots=new TextView[3];
        mLinearLayout.removeAllViews();
        for(int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparentWhite));

            mLinearLayout.addView(mDots[i]);
        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float j, int k) {

        }

        @Override
        public void onPageSelected(int i) {
            addDots(i);
            currentPage=i;
            if(i==0){
                nextButton.setEnabled(true);
                backButton.setEnabled(false);
                backButton.setVisibility(View.INVISIBLE);

                nextButton.setText("Next");
                backButton.setText("");
            }
            else if(i==mDots.length-1){
                nextButton.setEnabled(true);
                backButton.setEnabled(true);
                backButton.setVisibility(View.VISIBLE);

                nextButton.setText("Finish");
                backButton.setText("Back");
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(OnBoardingActivity.this, IntroActivity.class));
                    }
                });
            }
            else{
                nextButton.setEnabled(true);
                backButton.setEnabled(true);
                backButton.setVisibility(View.VISIBLE);

                nextButton.setText("Next");
                backButton.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}