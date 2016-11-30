package com.sanchez.jose.aplicacionmascotas.presentador;

import android.content.Context;

import com.sanchez.jose.aplicacionmascotas.db.ConstructorMascotas;
import com.sanchez.jose.aplicacionmascotas.pojo.Mascota;
import com.sanchez.jose.aplicacionmascotas.view.IListaMascotasView;

import java.util.ArrayList;

/**
 * Created by JoseM on 30/11/2016.
 */
public class ListaMascotasPresenter implements IListaMascotasPresenter {

    private IListaMascotasView iListaMascotasView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;


    public ListaMascotasPresenter(IListaMascotasView iListaMascotasView,Context context ){
        this.iListaMascotasView = iListaMascotasView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }



    @Override
    public void obtenerMascotasBaseDatos(){
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iListaMascotasView.inicializarAdaptadorRV(iListaMascotasView.crearAdaptador(mascotas));
        iListaMascotasView.generarLinearLayoutVertical();
    }
}
