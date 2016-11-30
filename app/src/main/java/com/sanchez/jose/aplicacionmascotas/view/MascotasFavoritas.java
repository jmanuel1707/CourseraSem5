package com.sanchez.jose.aplicacionmascotas.view;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.sanchez.jose.aplicacionmascotas.R;
import com.sanchez.jose.aplicacionmascotas.adapter.MascotasFavoritasAdaptador;
import com.sanchez.jose.aplicacionmascotas.db.ConstructorMascotas;
import com.sanchez.jose.aplicacionmascotas.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity{

    ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView rvMascotasFavoritas;
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

        rvMascotasFavoritas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFavoritas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();


    }




    public void inicializarAdaptador(){
        MascotasFavoritasAdaptador adaptador = new MascotasFavoritasAdaptador(mascotasFavoritas, this);
        rvMascotasFavoritas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotasFavoritas = new ArrayList<Mascota>();
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(getBaseContext());
        mascotasFavoritas = constructorMascotas.obtenerMascotasFavoritas();


    }
}
