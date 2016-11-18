package com.sanchez.jose.aplicacionmascotas;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by JoseM on 15/11/2016.
 */
public class Mascota implements Serializable{
    private String nombre;
    private boolean favorito;
    private int rating;
    private int foto;
    public static ArrayList<Mascota> mascotasFavoritasArray = new ArrayList<Mascota>();

    public Mascota( String nombre, boolean favorito, int rating, int foto){
        this.nombre = nombre;
        this.favorito = favorito;
        this.rating = rating;
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
