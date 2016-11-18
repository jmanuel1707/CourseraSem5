package com.sanchez.jose.aplicacionmascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public static ArrayList<Mascota> mascotasFavoritasArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        ImageView imagenFavoritos = (ImageView) findViewById(R.id.imagenFavoritos);
        imagenFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
                MainActivity.this.startActivity(intent);
            }
        });



    }


    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Sparky",false, 3, R.drawable.perro1));
        mascotas.add(new Mascota("Munchy",false, 2, R.drawable.perro2));
        mascotas.add(new Mascota("Pirulin",false, 4, R.drawable.perro3));
        mascotas.add(new Mascota("Neron",false, 1, R.drawable.perro4));
        mascotas.add(new Mascota("Milo",false, 3, R.drawable.perro5));

    }




}
