package com.jaime.petagram.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.jaime.petagram.R;

public class DetalleMascota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar miactionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miactionBar);
    }
}
