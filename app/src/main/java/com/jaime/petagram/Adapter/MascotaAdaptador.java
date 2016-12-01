package com.jaime.petagram.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaime.petagram.Activity.FavoritosMascota;
import com.jaime.petagram.Pojo.Mascota;
import com.jaime.petagram.R;
import com.jaime.petagram.db.ConstructorMascotas;

import java.util.ArrayList;

/**
 * Created by jaime on 14/11/16.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota =  mascotas.get(position);
        holder.tvNombreCV.setText(mascota.getNombre());
        holder.imgFoto.setImageResource(mascota.getImagen());
        holder.tvRank.setText(String.valueOf(mascota.getRank()));

        //boton de like(hueso banco)
        holder.btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLike(mascota);
                holder.tvRank.setText(String.valueOf(constructorMascotas.obtenerLikes(mascota)));
                Snackbar.make(view, "Has agregado a "+mascota.getNombre()+" a favoritos", Snackbar.LENGTH_LONG)
                        .setAction(view.getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i = new Intent(view.getContext(),FavoritosMascota.class );
                                view.getContext().startActivity(i);
                            }
                        })
                        .setActionTextColor(view.getResources().getColor(R.color.colorPrimary))
                        .show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvRank;
        private ImageButton btLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRank = (TextView) itemView.findViewById(R.id.tvRankingCV);
            btLike = (ImageButton)itemView.findViewById(R.id.btnLike);
        }
    }
}
