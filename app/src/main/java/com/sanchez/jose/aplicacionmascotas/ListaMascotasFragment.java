package com.sanchez.jose.aplicacionmascotas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



public class ListaMascotasFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }




    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        if (Mascota.mascotas.size() == 0) {
            Mascota.mascotas.add(new Mascota("Sparky", false, 3, R.drawable.perro1));
            Mascota.mascotas.add(new Mascota("Munchy", false, 2, R.drawable.perro2));
            Mascota.mascotas.add(new Mascota("Pirulin", false, 4, R.drawable.perro3));
            Mascota.mascotas.add(new Mascota("Neron", false, 1, R.drawable.perro4));
            Mascota.mascotas.add(new Mascota("Milo", false, 3, R.drawable.perro5));
        }

        mascotas = Mascota.mascotas;

    }




}
