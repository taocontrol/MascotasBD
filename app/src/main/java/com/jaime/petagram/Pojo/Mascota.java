package com.jaime.petagram.Pojo;

/**
 * Created by jaime on 14/11/16.
 */
public class Mascota {

    private String nombre;
    private int imagen;
    private int rank;

    public Mascota(String nombre, int imagen, int rank) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.rank = rank;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
