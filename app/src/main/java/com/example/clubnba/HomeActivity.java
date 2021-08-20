package com.example.clubnba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.clubnba.Fragments.CardFragment;
import com.example.clubnba.Fragments.GameFragment;
import com.example.clubnba.Fragments.NewsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        setUpNavigationBar();
        setUpBottomNavigation();
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.cardBottomNav); // change to whichever id should be default
        }
    }

    //sets up side navigation bar
    private void setUpNavigationBar(){
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(HomeActivity.this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    //set up bottom navigation
    private void setUpBottomNavigation(){
        Bundle savedInstanceState;

       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment selectedFragment = null;
               switch (item.getItemId()) {
                   case R.id.cardBottomNav:
                       selectedFragment = new CardFragment();
                       break;

                   case R.id.miniGameBottomNav:
                       selectedFragment = new GameFragment();
                       break;

                   case R.id.newsBottomNav:
                       selectedFragment = new NewsFragment();
                       break;


               }
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
               return true;
           }

       });
    }


}