package com.example.responsi_andhika.view.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.responsi_andhika.R;
import com.example.responsi_andhika.view.fragment.kasusfragment;
import com.example.responsi_andhika.view.fragment.rsrujukanframent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment = new kasusfragment();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.activity_main_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_nav_movie:
                selectedFragment = new kasusfragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_nav_tv:
                selectedFragment = new rsrujukanframent();
                loadFragment(selectedFragment);
                break;

        }

        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main_fragmentcontainer, selectedFragment)
                    .commit();

            return true;
        }
        return false;
    }
}