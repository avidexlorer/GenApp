package com.grafixartist.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    List<Apprentice> lstapprentice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lstapprentice = new ArrayList<>();
        lstapprentice.add(new Apprentice("Brock","Mega Industries","He Cool",R.drawable.brock1));
        lstapprentice.add(new Apprentice("Carl","Vampire Aids","I Got Balls",R.drawable.carl2));
        lstapprentice.add(new Apprentice("Casper","Gateway Anus","Looking for a good time honey?",R.drawable.casper1));
        lstapprentice.add(new Apprentice("Janet","Finance for Squirrels","FFS Janet",R.drawable.janer1));
        lstapprentice.add(new Apprentice("Mark","Fidelity","I Wear Pink Jumpers and like sports. Basically a cripple",R.drawable.mark1));
        lstapprentice.add(new Apprentice("Olivia","Dublin is shite","Olivia is a shit name",R.drawable.olivia1));
        lstapprentice.add(new Apprentice("Zane","Zanecorp","Zane what a fucking class name",R.drawable.tanya1));
        lstapprentice.add(new Apprentice("Brock","Mega Industries","He Cool",R.drawable.brock1));
        lstapprentice.add(new Apprentice("Carl","Vampire Aids","I Got Balls",R.drawable.carl2));
        lstapprentice.add(new Apprentice("Casper","Gateway Anus","Looking for a good time honey?",R.drawable.casper1));
        lstapprentice.add(new Apprentice("Janet","Finance for Squirrels","FFS Janet",R.drawable.janer1));
        lstapprentice.add(new Apprentice("Mark","Fidelity","I Wear Pink Jumpers and like sports. Basically a cripple",R.drawable.mark1));
        lstapprentice.add(new Apprentice("Olivia","Dublin is shite","Olivia is a shit name",R.drawable.olivia1));
        lstapprentice.add(new Apprentice("Zane","Zanecorp","Zane what a fucking class name",R.drawable.tanya1));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstapprentice);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);

        //Bottom Navigation view
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.ic_profile:
                        Intent intent2 = new Intent(HomeActivity.this, HomeActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_gallery:
                        Intent intent3 = new Intent(HomeActivity.this, GalleryActivity.class);
                        startActivity(intent3);
                        break;
                }

                return false;
            }
        });
    }


    }


