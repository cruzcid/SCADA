package com.example.cruzjedi.tesisprojectscada.io.model;

import com.example.cruzjedi.tesisprojectscada.domain.DatosSalon;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 * Created by cruzjedi on 17/11/15.
 */
public class ScadaDatosSalonResponse {
    @SerializedName(JsonKeys.CONSULTA_DATOS)
    ArrayList<DatosSalon> resultadoSalon;

    public ArrayList<DatosSalon> getResultadoSalon(){
        return resultadoSalon;
    }

}
