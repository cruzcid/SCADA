package com.example.cruzjedi.tesisprojectscada.io.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cruz on 10/12/2015.
 */
public class AsistenciaResponse {
    @SerializedName(JsonKeys.ASISTENCIA_NO_REGISTRADA)
    private String asistenicia_no_registrada;

    public String getAsistenicia_no_registrada(){
        return asistenicia_no_registrada;
    }
}
