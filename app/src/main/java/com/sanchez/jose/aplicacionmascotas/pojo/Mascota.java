package com.sanchez.jose.aplicacionmascotas.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by JoseM on 15/11/2016.
 */
public class Mascota implements Serializable{
    private int id;
    private String nombre;
    private int favorito;
    private int rating;
    private int foto;

    public static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    public static ArrayList<Mascota> mascotasFavoritasArray = new ArrayList<Mascota>();
    public static ArrayList<Mascota> mascotasPerfilArray = new ArrayList<Mascota>();

    public Mascota(){

    }

    public Mascota(int id, String nombre, int favorito, int rating, int foto){
        this.id = id;
        this.nombre = nombre;
        this.favorito = favorito;
        this.rating = rating;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int isFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
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
