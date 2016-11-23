package com.jaime.petagram.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaime.petagram.Pojo.Mascota;
import com.jaime.petagram.R;

import java.util.ArrayList;

/**
 * Created by jaime on 23/11/16.
 */

public class PerfilMascotaAdapter extends RecyclerView.Adapter<PerfilMascotaAdapter.PerfilMascotaAdapterViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public PerfilMascotaAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }

    @Override
    public PerfilMascotaAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota, parent, false);
        return new PerfilMascotaAdapter.PerfilMascotaAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilMascotaAdapterViewHolder holder, int position) {
        Mascota mascota =  mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getImagen());
//        holder.tvRank.setText(mascota.getRank());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PerfilMascotaAdapterViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvRank;


        public PerfilMascotaAdapterViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgPerfilMascota);
            tvRank = (TextView) itemView.findViewById(R.id.tvPerfilRankingCV);

        }
    }
}
