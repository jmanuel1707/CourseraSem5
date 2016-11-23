package com.sanchez.jose.aplicacionmascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JoseM on 22/11/2016.
 */
public class PerfilMascotaAdaptador extends RecyclerView.Adapter<PerfilMascotaAdaptador.PerfilMascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;


    public PerfilMascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;

    }

    @Override
    public PerfilMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_perfil_mascota, parent, false);
        return new PerfilMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilMascotaViewHolder perfilMascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        perfilMascotaViewHolder.imgFotoPerfil.setImageResource(mascota.getFoto());

        Integer rating = mascota.getRating();
        perfilMascotaViewHolder.tvRatingPerfil.setText(rating.toString());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class PerfilMascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoPerfil;
        //private TextView tvNombre;
        //private ImageButton btnFavorito;
        private TextView tvRatingPerfil;
        //private ImageView imgFavorito;

        public PerfilMascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoPerfil      = (ImageView) itemView.findViewById(R.id.imgFotoPerfil);
            //tvNombre   = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRatingPerfil   = (TextView) itemView.findViewById(R.id.tvRatingPerfil);
            //imgFavorito = (ImageView) itemView.findViewById(R.id.imgFavorito);

        }
    }




}
