package com.sanchez.jose.aplicacionmascotas;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity{

    ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView listaMascotasFavoritas;
    Activity activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);


        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBarFavoritos);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);


        listaMascotasFavoritas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFavoritas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();


    }


    public void inicializarAdaptador(){
        MascotasFavoritasAdaptador adaptador = new MascotasFavoritasAdaptador(mascotasFavoritas, this);
        listaMascotasFavoritas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotasFavoritas = new ArrayList<Mascota>();
        mascotasFavoritas.add(new Mascota("Sparky",false, 3, R.drawable.perro1));
        mascotasFavoritas.add(new Mascota("Munchy",false, 2, R.drawable.perro2));
        mascotasFavoritas.add(new Mascota("Puppy",false, 4, R.drawable.perro3));
        mascotasFavoritas.add(new Mascota("Neron",false, 1, R.drawable.perro4));
        mascotasFavoritas.add(new Mascota("Milo",false, 3, R.drawable.perro5));


    }
}
