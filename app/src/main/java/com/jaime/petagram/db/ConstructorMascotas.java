package com.jaime.petagram.db;

import android.content.ContentValues;
import android.content.Context;


import com.jaime.petagram.Pojo.Mascota;
import com.jaime.petagram.R;

import java.util.ArrayList;

/**
 * Created by jaime on 28/11/16.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> ObtenerDatos(){
        ArrayList<Mascota> mascotas =  new ArrayList<>();


        BaseDatos db = new BaseDatos(context);
        insertarContactos(db);
        mascotas = db.obtenerAllMascotas();

        return mascotas;
    }

    public void insertarContactos(BaseDatos db){

        ContentValues contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE , "Scooby");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NUMERO_LIKES , 1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO , R.drawable.pit2);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE , "Pluto");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NUMERO_LIKES , 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO , R.drawable.pit3);

        db.insertarMascota(contentValues);

         contentValues =  new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE , "Astro");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NUMERO_LIKES , 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO , R.drawable.pit4);

        db.insertarMascota(contentValues);



    }

    public void darLike(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        bd.insertarLikes(mascota);


    }

    public int obtenerLikes(Mascota mascota){

        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerLikes(mascota);
    }

    public ArrayList<Mascota> ObtenerMascotasFavoritas(){
        ArrayList<Mascota> mascotas =  new ArrayList<>();


        BaseDatos db = new BaseDatos(context);
        insertarContactos(db);
        mascotas = db.obtenerfavoritos();

        return mascotas;
    }
}
