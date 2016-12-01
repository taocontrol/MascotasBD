package com.jaime.petagram.presentador;

import android.content.Context;


import com.jaime.petagram.Fragments.IReciclerViewfragmentView;
import com.jaime.petagram.Pojo.Mascota;
import com.jaime.petagram.db.ConstructorMascotas;

import java.util.ArrayList;

/**
 * Created by jaime on 28/11/16.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IReciclerViewfragmentView iReciclerViewfragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> contactos;

    public RecyclerViewFragmentPresenter(IReciclerViewfragmentView iReciclerViewfragmentView, Context context) {
        this.iReciclerViewfragmentView = iReciclerViewfragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas =  new ConstructorMascotas(context);
        contactos = constructorMascotas.ObtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iReciclerViewfragmentView.inicializarAdaptadorRV(iReciclerViewfragmentView.crearAdaptador(contactos));
        iReciclerViewfragmentView.generarLineaLayoutVertical();

    }

}
