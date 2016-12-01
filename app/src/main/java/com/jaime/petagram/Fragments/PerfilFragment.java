package com.jaime.petagram.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaime.petagram.Adapter.MascotaAdaptador;
import com.jaime.petagram.Adapter.PerfilMascotaAdapter;
import com.jaime.petagram.Pojo.Mascota;
import com.jaime.petagram.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    ArrayList<Mascota> mascotas= new ArrayList<Mascota>();;
    private RecyclerView listaMascotas;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        // Imagen circukar
        CircularImageView circularImageView = (CircularImageView) v.findViewById(R.id.imagCircular);
        // Set Border
        circularImageView.setBorderColor(getResources().getColor(R.color.colorIcons));
        circularImageView.setBorderWidth(10);
        // Add Shadow with default param
        circularImageView.addShadow();
        // or with custom param
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(getResources().getColor(R.color.colorPrimaryLigth));

        //creando reciclerview
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascota);
      //  LinearLayoutManager llm = new LinearLayoutManager(getActivity());
      //  llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);

        listaMascotas.setLayoutManager(glm);


        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
    }

    //carga 5 elementos en el recyclerview
    public void inicializarListaMascotas(){

        mascotas.add(new Mascota("Scooby", R.drawable.pit2, 3));
        mascotas.add(new Mascota("Pluto", R.drawable.pit3,2));
        mascotas.add(new Mascota("Ayudante de Santa", R.drawable.pit4,6));
        mascotas.add(new Mascota("Astro", R.drawable.pit5,1));
        mascotas.add(new Mascota("Odie", R.drawable.pit6,3));
        mascotas.add(new Mascota("Pluto", R.drawable.pit,2));
        mascotas.add(new Mascota("Ayudante de Santa", R.drawable.pit2,6));
        mascotas.add(new Mascota("Astro", R.drawable.pit3,1));
        mascotas.add(new Mascota("Odie", R.drawable.pit4,3));


    }

    public void inicializarAdaptador(){
        PerfilMascotaAdapter adaptador = new PerfilMascotaAdapter(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }

}
