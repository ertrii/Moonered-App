package me.ertrii.moonered.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import me.ertrii.moonered.Fragments.MainFragment;
import me.ertrii.moonered.Fragments.PayFragment;
import me.ertrii.moonered.Fragments.RegisterFragment;
import me.ertrii.moonered.Fragments.StatusFragment;
import me.ertrii.moonered.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.isChecked()) menuItem.setCheckable(false);
                else menuItem.setCheckable(true);

                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()){
                    case R.id.main:
                        setFragment(0);
                        break;
                    case R.id.status:
                        setFragment(1);
                        break;
                    case R.id.pay:
                        setFragment(2);
                        break;
                    case R.id.register:
                        setFragment(3);
                        break;
                }

                return false;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    public void setFragment(int position){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (position){
            case 0:
                MainFragment mainFragment = new MainFragment();
                fragmentTransaction.replace(R.id.fragment_layout, mainFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                StatusFragment statusFragment = new StatusFragment();
                fragmentTransaction.replace(R.id.fragment_layout, statusFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                PayFragment payFragment = new PayFragment();
                fragmentTransaction.replace(R.id.fragment_layout, payFragment);
                fragmentTransaction.commit();
                break;
            case 3:
                RegisterFragment registerFragment = new RegisterFragment();
                fragmentTransaction.replace(R.id.fragment_layout, registerFragment);
                fragmentTransaction.commit();
                break;
        }
    }
}
