package com.sanchez.jose.aplicacionmascotas.presentador;

import android.content.Context;
import android.widget.Toast;

import com.sanchez.jose.aplicacionmascotas.db.ConstructorMascotas;
import com.sanchez.jose.aplicacionmascotas.pojo.Mascota;
import com.sanchez.jose.aplicacionmascotas.view.IListaMascotasView;
import com.sanchez.jose.aplicacionmascotas.view.IMascotasFavoritasView;

import java.util.ArrayList;

/**
 * Created by JoseM on 30/11/2016.
 */
public class ListaMascotasFavoritasPresenter implements IListaMascotasFavoritasPresenter{

    private IMascotasFavoritasView iMascotasFavoritasView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotasFavoritas;


    public ListaMascotasFavoritasPresenter(IMascotasFavoritasView iMascotasFavoritasView, Context context){
        this.iMascotasFavoritasView = iMascotasFavoritasView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos(){
        constructorMascotas = new ConstructorMascotas(context);
        mascotasFavoritas = constructorMascotas.obtenerMascotasFavoritas();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iMascotasFavoritasView.inicializarAdaptadorRVFavoritas(iMascotasFavoritasView.crearAdaptador(mascotasFavoritas));
        iMascotasFavoritasView.generarLinearLayoutVertical();
    }
}
