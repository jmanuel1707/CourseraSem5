package com.sanchez.jose.aplicacionmascotas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sanchez.jose.aplicacionmascotas.db.ConstructorMascotas;
import com.sanchez.jose.aplicacionmascotas.pojo.Mascota;
import com.sanchez.jose.aplicacionmascotas.R;

import java.util.ArrayList;

/**
 * Created by JoseM on 15/11/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }



    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());

        Integer rating = mascota.getRating();
        mascotaViewHolder.tvRating.setText(rating.toString());


        mascotaViewHolder.imgFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.actualizarFavorito(mascota);
                Integer numeroFavoritos = constructorMascotas.obtenerDatosMascota(mascota).getRating();
                mascotaViewHolder.tvRating.setText(numeroFavoritos.toString());

                /*
                if (mascota.isFavorito()) {
                    Mascota.mascotasFavoritasArray.remove(mascota);
                    Toast.makeText(activity,"Ya no te gusta "+ mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    mascota.setFavorito(false);
                    mascota.setRating(mascota.getRating()-1);
                    notifyDataSetChanged();
                } else {
                    Mascota.mascotasFavoritasArray.add(mascota);
                    Toast.makeText(activity,"Te ha gustado "+ mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    mascota.setFavorito(true);
                    mascota.setRating(mascota.getRating()+1);
                    notifyDataSetChanged();
                }
                */

            }
        });



    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private ImageButton btnFavorito;
        private TextView tvRating;
        private ImageView imgFavorito;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto      = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre   = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRating   = (TextView) itemView.findViewById(R.id.tvRating);
            imgFavorito = (ImageView) itemView.findViewById(R.id.imgFavorito);

        }
    }

}



