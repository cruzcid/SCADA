package com.example.cruzjedi.tesisprojectscada.ui.fragments.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cruzjedi.tesisprojectscada.R;
import com.example.cruzjedi.tesisprojectscada.domain.DatosSalon;
import com.example.cruzjedi.tesisprojectscada.domain.ObtenerHora;

import java.util.ArrayList;

/**
 * Created by cruzjedi on 17/11/15.
 */
public class ScadaDatosSalonAdapter extends RecyclerView.Adapter<ScadaDatosSalonAdapter.ScadaDatosSalonViewHolder> {
    int position;
    Context context;
    ArrayList<DatosSalon> datosSalonArrayList;
    ObtenerHora obtenerHora;

    public ScadaDatosSalonAdapter(Context context){
        this.context = context;
        datosSalonArrayList = new ArrayList<DatosSalon>(); //Para no dejar null
    }

    @Override
    public ScadaDatosSalonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_scada_salon, parent, false);
        return new ScadaDatosSalonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ScadaDatosSalonViewHolder holder, int position) {
        obtenerHora = new ObtenerHora();
        DatosSalon currentDatosSalon = datosSalonArrayList.get(position);
        holder.setNombreProf(currentDatosSalon.getNombre());
        holder.setGrupo(currentDatosSalon.getGrupo());
        holder.setSalon(currentDatosSalon.getSalon());
        holder.setMateria(currentDatosSalon.getMateria());
        holder.setHorario(obtenerHora.horaNumToHoraStrng(currentDatosSalon.getHora()));
        //this.position = position;
    }

    @Override
    public int getItemCount() {
        return datosSalonArrayList.size();
    }

    public void addAll (@NonNull ArrayList<DatosSalon> datosSalons){
        if(datosSalons == null){
            throw new NullPointerException("No puede ser nulo el arreglo");
        }
        this.datosSalonArrayList.clear();
        this.datosSalonArrayList.addAll(datosSalons);
        notifyDataSetChanged();//ha cambiado la informacion
    }
    public class ScadaDatosSalonViewHolder extends RecyclerView.ViewHolder {

        TextView nombreProf, salon, grupo, horario, materia;

        public ScadaDatosSalonViewHolder(View itemView) {
            super(itemView);
            nombreProf = (TextView) itemView.findViewById(R.id.txt_itm_profe);
            salon = (TextView) itemView.findViewById(R.id.txt_itm_salon);
            grupo = (TextView) itemView.findViewById(R.id.txt_itm_grupo);
            horario = (TextView) itemView.findViewById(R.id.txt_itm_hora);
            materia = (TextView) itemView.findViewById(R.id.txt_itm_materia);
        }

        public void setNombreProf(String nombreProf) {
            this.nombreProf.setText(nombreProf);
        }

        public void setSalon(String salon) {
            this.salon.setText(salon);
        }

        public void setGrupo(String grupo) {
            this.grupo.setText(grupo);
        }

        public void setHorario(String horario) {
            this.horario.setText(horario);
        }

        public void setMateria(String materia) {
            this.materia.setText(materia);
        }

        //this.position = position devolver en geter function
    }
}
