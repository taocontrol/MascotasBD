package com.jaime.petagram.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaime.petagram.Adapter.MascotaAdaptador;
import com.jaime.petagram.Pojo.Mascota;
import com.jaime.petagram.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReciclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas= new ArrayList<Mascota>();;
    private RecyclerView listaMascotas;


    public ReciclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recicler_view, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        //ver en lista vertical
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
    }



    //cargar la lista de mascotas
    public void inicializarListaMascotas(){
        mascotas.add(new Mascota("Snoopy", R.drawable.clip_art_snoopy_157680, 5));
        mascotas.add(new Mascota("Scooby", R.drawable.scooby, 3));
        mascotas.add(new Mascota("Pluto", R.drawable.pluto,2));
        mascotas.add(new Mascota("Ayudante de Santa", R.drawable.ayudantedesanta,6));
        mascotas.add(new Mascota("Astro", R.drawable.astro,1));
        mascotas.add(new Mascota("Dalmata", R.drawable.dalmata,0));
        mascotas.add(new Mascota("Odie", R.drawable.odish,3));


    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }


}
