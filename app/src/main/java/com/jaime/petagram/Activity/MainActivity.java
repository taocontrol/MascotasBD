package com.jaime.petagram.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jaime.petagram.Adapter.PageAdapter;
import com.jaime.petagram.Fragments.PerfilFragment;
import com.jaime.petagram.Pojo.Mascota;
import com.jaime.petagram.R;
import com.jaime.petagram.Fragments.ReciclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout miIndicador;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    //tarea
    ArrayList<Mascota> mascotas= new ArrayList<Mascota>();;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setTitle(null);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        setUpViewPager();

    }

    //refrescar
    public void refrescandoContenido(){
        mascotas.clear();
       // inicializarListaMascotas();
       // inicializarAdaptador();
        miIndicador.setRefreshing(false);
    }

    //boton floating
  /*  public void agregarFav(){
        FloatingActionButton miFav = (FloatingActionButton) findViewById(R.id.mifav);
        miFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.floating_message), Toast.LENGTH_SHORT).show();
                Snackbar.make(view, getResources().getString(R.string.floating_message), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("Snackbar", "Click en snacbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();

            }
        });

    }*/

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments =  new ArrayList<>();
        fragments.add(new ReciclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;

    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.doghouse);
        tabLayout.getTabAt(1).setIcon(R.drawable.dig);
    }

    public void irfavoritos(View v){
        Intent i = new Intent(this,FavoritosMascota.class );
        startActivity(i);
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

}
