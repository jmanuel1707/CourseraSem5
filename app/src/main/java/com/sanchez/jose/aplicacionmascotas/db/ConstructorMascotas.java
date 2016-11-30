package com.sanchez.jose.aplicacionmascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.sanchez.jose.aplicacionmascotas.R;
import com.sanchez.jose.aplicacionmascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by JoseM on 30/11/2016.
 */
public class ConstructorMascotas {
    private Context context;

    public ConstructorMascotas(Context context){
        this.context = context;
    }


    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarCincoMascotas(db);
        return db.obtenerTodasLasMascotas();
    }


    public void insertarCincoMascotas(BaseDatos db){

        if (db.existenMascotas()){
            return;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre","Sparky");
        contentValues.put("favorito",0);
        contentValues.put("rating",4);
        contentValues.put("foto", R.drawable.perro1);
        db.insertarMascota(contentValues);

        contentValues.put("nombre","Munchy");
        contentValues.put("favorito",0);
        contentValues.put("rating",3);
        contentValues.put("foto", R.drawable.perro2);
        db.insertarMascota(contentValues);

        contentValues.put("nombre","Pirulin");
        contentValues.put("favorito",0);
        contentValues.put("rating",7);
        contentValues.put("foto", R.drawable.perro3);
        db.insertarMascota(contentValues);

        contentValues.put("nombre","Neron");
        contentValues.put("favorito",0);
        contentValues.put("rating",5);
        contentValues.put("foto", R.drawable.perro4);
        db.insertarMascota(contentValues);

        contentValues.put("nombre","Milo");
        contentValues.put("favorito",0);
        contentValues.put("rating",9);
        contentValues.put("foto", R.drawable.perro5);
        db.insertarMascota(contentValues);

    }


    public void actualizarFavorito(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        db.actualizarFavorito(mascota);
    }

    public Mascota obtenerDatosMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerDatosMascota(mascota);
    }



    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasFavoritas();
    }


}
