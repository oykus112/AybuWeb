package com.example.myapplication;

import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView =findViewById(R.id.navigation);
        final Yemek yemekFrag =new Yemek();
        final Duyuru duyuruFrag = new Duyuru();
        final Haber haberFrag =new Haber();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();
                if(id == R.id.tab1) {
                    setFragment(yemekFrag);
                    return true;
                }
                else if(id == R.id.tab2) {
                    setFragment(duyuruFrag);
                    return true;
                }
                else if (id == R.id.tab3){
                    setFragment(haberFrag);
                    return true;

                }
                return false;
            }
        });
        navigationView.setSelectedItemId(R.id.tab1);
    }


    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();

    }




}
