package com.gyk.bursa162;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class BottomNavigationActivity extends AppCompatActivity {
    Fragment selectedFragment;

    HomeFragment homeFragment;
    HealthFragment healthFragment;
    DietListFragment listFragment;
    HelpFragment helpFragment;

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        homeFragment = new HomeFragment();
        healthFragment = new HealthFragment();
        listFragment = new DietListFragment();
        helpFragment = new HelpFragment();

        bottomNav = findViewById(R.id.bottomNav_bottom);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        selectedFragment = homeFragment;
                        break;
                    case R.id.navigation_dashboard:

                   // Fragment'e veri göndermek için
                        Bundle veri = new Bundle();
                        veri.putString("sonuc", homeFragment.getSonuc());
                        healthFragment.setArguments(veri);

                        selectedFragment = healthFragment;
                        break;
                    case R.id.navigation_notifications:
                        selectedFragment = listFragment;
                        break;
                    case R.id.navigation_help:
                        selectedFragment = helpFragment;
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLy_bottom_container, selectedFragment);
                transaction.commit();

                return true;
            }
        });

        bottomNav.setSelectedItemId(R.id.navigation_home);
    }
}