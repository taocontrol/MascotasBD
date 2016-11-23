package com.jaime.petagram.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.jaime.petagram.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //ocular el boton de favoritos del actionbar
        ImageView fav = (ImageView) findViewById(R.id.imgFav);
        fav.setVisibility(View.INVISIBLE);

        Toolbar miactionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miactionBar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
