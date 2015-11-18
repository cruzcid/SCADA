package com.example.cruzjedi.tesisprojectscada.domain;

/**
 * Created by cruzjedi on 16/11/15.
 */
public class DatosSalon {

    private String salon, edificio, piso;

    public DatosSalon(String edificio, String piso, String salon){
        this.edificio = edificio;
        this.salon = salon;
        this.piso = piso;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
}
