package com.jaime.petagram.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.jaime.petagram.Adapter.MascotaAdaptador;
import com.jaime.petagram.Pojo.Mascota;
import com.jaime.petagram.R;

import java.util.ArrayList;

public class FavoritosMascota extends AppCompatActivity {
    ArrayList<Mascota> mascotas= new ArrayList<Mascota>();;
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ocular el boton de favoritos del actionbar
        setContentView(R.layout.activity_favoritos_mascota);
        ImageView fav = (ImageView) findViewById(R.id.imgFav);
        fav.setVisibility(View.INVISIBLE);

        //agrega el action bar
        Toolbar miactionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miactionBar);

        //ocultar el nombre de la app que muestra por defecto
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //creando reciclerview
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFav);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


    }

    //se infla el menu en el mainactivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    //se controla los items del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.mabout:

                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);


                break;

            case R.id.mcontacto:
                Intent i = new Intent(this, ContactoActivity.class);
                startActivity(i);

                break;

        }

        return super.onOptionsItemSelected(item);
    }

    //carga 5 elementos en el recyclerview
    public void inicializarListaMascotas(){

        mascotas.add(new Mascota("Scooby", R.drawable.scooby, 3));
        mascotas.add(new Mascota("Pluto", R.drawable.pluto,2));
        mascotas.add(new Mascota("Ayudante de Santa", R.drawable.ayudantedesanta,6));
        mascotas.add(new Mascota("Astro", R.drawable.astro,1));
        mascotas.add(new Mascota("Odie", R.drawable.odish,3));


    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);

    }
}
