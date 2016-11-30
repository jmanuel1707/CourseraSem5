package com.sanchez.jose.aplicacionmascotas.view;

import com.sanchez.jose.aplicacionmascotas.adapter.MascotaAdaptador;
import com.sanchez.jose.aplicacionmascotas.adapter.MascotasFavoritasAdaptador;
import com.sanchez.jose.aplicacionmascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by JoseM on 30/11/2016.
 */
public interface IMascotasFavoritasView {
    public void generarLinearLayoutVertical();
    public MascotasFavoritasAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRVFavoritas(MascotasFavoritasAdaptador adaptador);

}
