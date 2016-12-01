package com.jaime.petagram.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.jaime.petagram.Adapter.MascotaAdaptador;
import com.jaime.petagram.Pojo.Mascota;
import com.jaime.petagram.R;
import com.jaime.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.jaime.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by jaime on 16/11/16.
 */

public class RecyclerviewFragment extends Fragment implements IReciclerViewfragmentView{

    ArrayList<Mascota> contactos= new ArrayList<Mascota>();;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        // se asocia la clase al fragment
        View v = inflater.inflate(R.layout.fragment_recicler_view, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());


        return v;

    }

    /*
    public void inicializarListaContactos(){
        contactos.add(new Contacto ("Jaime Ferreira", "098654554", "jaimeferreira@gmail.com", R.drawable.androidmikeklo, 0));
        contactos.add(new Contacto ("Maria Gonzalez", "098654554", "fsjhdfj@hotmail.com",R.drawable.andygaming, 0));
        contactos.add(new Contacto ("Juan Perez", "0987414111", "fdgdfgn@gmail.com", R.drawable.images, 0));
        contactos.add(new Contacto ("Raul Benitez", "086154545", "fsjhdfj@hotmail.com", R.drawable.images2, 0));
        contactos.add(new Contacto ("Luis Lopez", "09884512", "fsjhdfj@hotmail.com", R.drawable.android_skyte, 0));
        contactos.add(new Contacto ("Luis Lopez", "09884512", "fsjhdfj@hotmail.com", R.drawable.android_opera_robot, 0));
        contactos.add(new Contacto ("Luis Lopez", "09884512", "fsjhdfj@hotmail.com", R.drawable.apple_touch, 0));


    }*/



    @Override
    public void generarLineaLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adapatador = new MascotaAdaptador(mascotas, getActivity());

        return adapatador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adapatador) {
        listaMascotas.setAdapter(adapatador);

    }
}
