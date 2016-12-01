package com.jaime.petagram.Fragments;


import com.jaime.petagram.Adapter.MascotaAdaptador;
import com.jaime.petagram.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jaime on 28/11/16.
 */

public interface IReciclerViewfragmentView {

    public void generarLineaLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);
    public void inicializarAdaptadorRV(MascotaAdaptador adapatador);


}
