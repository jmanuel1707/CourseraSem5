package com.sanchez.jose.aplicacionmascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sanchez.jose.aplicacionmascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by JoseM on 29/11/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context, "Mascotas", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE IF NOT EXISTS mascotas ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nombre TEXT, "+
                "favorito INTEGER, "+
                "rating INTEGER,  " +
                "foto INTEGER" +
        ")";

        db.execSQL(queryCrearTablaMascota);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS mascotas");
    }


    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM mascotas";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFavorito(registros.getInt(2));
            mascotaActual.setRating(registros.getInt(3));
            mascotaActual.setFoto(registros.getInt(4));
            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;
    }


    public boolean existenMascotas(){

        String query = "SELECT * FROM mascotas";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        if (registros.moveToNext()){
            return true;
        }
        else{
            return false;
        }
    }


    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("mascotas",null,contentValues);
        db.close();
    }



    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM mascotas where favorito = 1";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFavorito(registros.getInt(2));
            mascotaActual.setRating(registros.getInt(3));
            mascotaActual.setFoto(registros.getInt(4));
            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;

    }

    public void actualizarFavorito(Mascota mascota){
        int favorito = 0;
        int rating = 0;

        String query = "SELECT favorito, rating FROM mascotas where id = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        if(registros.moveToNext()){
            favorito = registros.getInt(0);
            rating = registros.getInt(1);
        }

        if (favorito == 1){
            db.execSQL("UPDATE mascotas set favorito = 0, rating = "+ (rating-1) +" where id =" + mascota.getId());
        }
        else{
            db.execSQL("UPDATE mascotas set favorito = 1, rating = " + (rating+1) + " where id =" + mascota.getId());
        }

        db.close();

    }


    public Mascota obtenerDatosMascota(Mascota mascota){
        String query = "SELECT * FROM mascotas where id = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        Mascota mascotaActual = new Mascota();
        if(registros.moveToNext()){
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFavorito(registros.getInt(2));
            mascotaActual.setRating(registros.getInt(3));
            mascotaActual.setFoto(registros.getInt(4));
        }

        db.close();

        return mascotaActual;

    }



}
