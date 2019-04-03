package com.grafixartist.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by myles on 16/02/2019.
 */

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView mImageView;

    GalleryAdapter mAdapter;
    RecyclerView mRecyclerView;

    ArrayList<ImageModel> data = new ArrayList<>();

    public static String IMGS[] = {
            "https://i.imgur.com/Umj1RoB.jpg",
            "https://i.imgur.com/gG3R84W.jpg",
            "https://i.imgur.com/ka8X2Up.jpg",
            "https://i.imgur.com/eyvvpvp.jpg",
            "https://i.imgur.com/z15FSCi.jpg",
            "https://i.imgur.com/DDppWq2.jpg",
            "https://i.imgur.com/ZPMiPn6.jpg",
            "https://i.imgur.com/bIUOD7V.jpg",
            "https://i.imgur.com/9827JDY.jpg",
            "https://i.imgur.com/9827JDY.jpg",
            "https://i.imgur.com/wuAacy6.jpg",
            "https://i.imgur.com/HxlsGF9.jpg",
            "https://i.imgur.com/Umj1RoB.jpg",
            "https://i.imgur.com/gG3R84W.jpg",
            "https://i.imgur.com/ka8X2Up.jpg",
            "https://i.imgur.com/eyvvpvp.jpg",
            "https://i.imgur.com/z15FSCi.jpg",
            "https://i.imgur.com/DDppWq2.jpg",
            "https://i.imgur.com/ZPMiPn6.jpg",
            "https://i.imgur.com/bIUOD7V.jpg",
            "https://i.imgur.com/9827JDY.jpg",
            "https://i.imgur.com/9827JDY.jpg",
            "https://i.imgur.com/wuAacy6.jpg",
            "https://i.imgur.com/HxlsGF9.jpg"

    };

    public boolean onTouchEvent(MotionEvent motionEvent) {
        mScaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f,
                    Math.min(mScaleFactor, 10.0f));
            mImageView.setScaleX(mScaleFactor);
            mImageView.setScaleY(mScaleFactor);
            return true;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        Log.d(TAG, "onCreate: started.");


        for (int i = 0; i < IMGS.length; i++) {

            ImageModel imageModel = new ImageModel();
            imageModel.setName("Image " + i);
            imageModel.setUrl(IMGS[i]);
            data.add(imageModel);

        }


        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setHasFixedSize(true);


        mAdapter = new GalleryAdapter(GalleryActivity.this, data);
        mRecyclerView.setAdapter(mAdapter);
        mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(GalleryActivity.this, DetailActivity.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        startActivity(intent);

                    }
                }));






        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.ic_gallery:
                        Intent intent3 = new Intent(GalleryActivity.this, GalleryActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_profile:
                        Intent intent4 = new Intent(GalleryActivity.this, HomeActivity.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });


    }
}
