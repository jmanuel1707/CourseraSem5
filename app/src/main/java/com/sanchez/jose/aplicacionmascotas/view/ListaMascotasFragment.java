package com.sanchez.jose.aplicacionmascotas.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sanchez.jose.aplicacionmascotas.pojo.Mascota;
import com.sanchez.jose.aplicacionmascotas.R;
import com.sanchez.jose.aplicacionmascotas.adapter.MascotaAdaptador;
import com.sanchez.jose.aplicacionmascotas.presentador.IListaMascotasPresenter;
import com.sanchez.jose.aplicacionmascotas.presentador.ListaMascotasPresenter;

import java.util.ArrayList;



public class ListaMascotasFragment extends Fragment implements IListaMascotasView {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IListaMascotasPresenter presenter;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista_mascotas, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        presenter = new ListaMascotasPresenter(this, getContext());


        return v;
    }




    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        if (Mascota.mascotas.size() == 0) {
            Mascota.mascotas.add(new Mascota(1,"Sparky", 0, 3, R.drawable.perro1));
            Mascota.mascotas.add(new Mascota(2,"Munchy", 0, 2, R.drawable.perro2));
            Mascota.mascotas.add(new Mascota(3,"Pirulin", 0, 4, R.drawable.perro3));
            Mascota.mascotas.add(new Mascota(4,"Neron", 0, 1, R.drawable.perro4));
            Mascota.mascotas.add(new Mascota(5,"Milo", 0, 3, R.drawable.perro5));
        }

        mascotas = Mascota.mascotas;

    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
