package com.sanchez.jose.aplicacionmascotas;

import android.app.Activity;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JoseM on 17/11/2016.
 */
public class MascotasFavoritasAdaptador extends RecyclerView.Adapter<MascotasFavoritasAdaptador.MascotaFavoritaViewHolder>{

    ArrayList<Mascota> mascotasFavoritas;
    Activity activity;



    public MascotasFavoritasAdaptador(ArrayList<Mascota> mascotasFavoritas, Activity activity) {
        this.mascotasFavoritas = Mascota.mascotasFavoritasArray;
        this.activity = activity;
    }

    @Override
    public MascotaFavoritaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas_favoritas, parent, false);
        return new MascotaFavoritaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaFavoritaViewHolder mascotaFavoritaViewHolder, int position) {
        final Mascota mascotaFavorita = mascotasFavoritas.get(position);

        mascotaFavoritaViewHolder.imgFotoFavorita.setImageResource(mascotaFavorita.getFoto());
        Integer rating = mascotaFavorita.getRating();
        mascotaFavoritaViewHolder.tvRatingFavorita.setText(rating.toString());
        mascotaFavoritaViewHolder.tvNombreFavorita.setText(mascotaFavorita.getNombre());

    }

    @Override
    public int getItemCount() {
        return mascotasFavoritas.size();
    }


    public static class MascotaFavoritaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoFavorita;
        private TextView tvRatingFavorita;
        private TextView tvNombreFavorita;


        public MascotaFavoritaViewHolder(View itemView) {
            super(itemView);
            imgFotoFavorita      = (ImageView) itemView.findViewById(R.id.imgFotoFavorita);
            tvRatingFavorita   = (TextView) itemView.findViewById(R.id.tvRatingFavorita);
            tvNombreFavorita = (TextView) itemView.findViewById(R.id.tvNombreFavorita);

        }
    }


}
