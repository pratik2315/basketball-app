package com.example.clubnba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends OnboarderActivity {
    List<OnboarderPage> onboarderPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onboarderPages = new ArrayList<OnboarderPage>();

        // Create your first page
        OnboarderPage onboarderPage1 = new OnboarderPage("Welcome to NBA Connect!","Get to Know About Your favourite Players", R.drawable.screen_1);
        OnboarderPage onboarderPage2 = new OnboarderPage("Get All the Live Updates", "About the Basketball World", R.drawable.onboarding_screen_two);
        OnboarderPage onboarderPage3 = new OnboarderPage("Play our Mini Game", "And Get a Chance to Meet Your Favourite Player", R.drawable.screen_3);

        // You can define title and description colors (by default white)
        onboarderPage1.setTitleColor(R.color.black);
        onboarderPage1.setDescriptionColor(R.color.black);

        onboarderPage2.setTitleColor(R.color.black);
        onboarderPage2.setDescriptionColor(R.color.black);

        onboarderPage3.setTitleColor(R.color.black);
        onboarderPage3.setDescriptionColor(R.color.black);

        // Don't forget to set background color for your page
        onboarderPage1.setBackgroundColor(R.color.white);
        onboarderPage2.setBackgroundColor(R.color.white);
        onboarderPage3.setBackgroundColor(R.color.white);

        // Add your pages to the list
        onboarderPages.add(onboarderPage1);
        onboarderPages.add(onboarderPage2);
        onboarderPages.add(onboarderPage3);

        // And pass your pages to 'setOnboardPagesReady' method
        setOnboardPagesReady(onboarderPages);
        setActiveIndicatorColor(android.R.color.black);
        setInactiveIndicatorColor(android.R.color.darker_gray);
        shouldDarkenButtonsLayout(true);
        setDividerColor(Color.YELLOW);
        setDividerHeight(2);
        setDividerVisibility(View.GONE);
        shouldUseFloatingActionButton(true);
        setSkipButtonTitle("Skip");


    }

    @Override
    public void onFinishButtonPressed() {
        startActivity(new Intent(OnBoardingActivity.this, IntroActivity.class));
        finish();
    }

}