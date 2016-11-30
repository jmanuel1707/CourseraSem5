package com.sanchez.jose.aplicacionmascotas.view;

import com.sanchez.jose.aplicacionmascotas.adapter.MascotaAdaptador;
import com.sanchez.jose.aplicacionmascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by JoseM on 30/11/2016.
 */
public interface IListaMascotasView {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
