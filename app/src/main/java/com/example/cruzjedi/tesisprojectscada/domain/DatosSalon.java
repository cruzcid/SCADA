package com.example.cruzjedi.tesisprojectscada.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cruzjedi on 16/11/15.
 */
public class DatosSalon {

    private String edificio;
    private String piso;

    @SerializedName("salon")
    private String salon;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("grupo")
    private String grupo;

    @SerializedName("materia")
    private String materia;

    @SerializedName("hora")
    private String hora;

    @SerializedName("idprofesor")
    private String idprofesor;

    @SerializedName("idmateria")
    private String idmateria;


    public DatosSalon(){}
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getMateria(){return materia;}
    public void setMateria(String materia){ this.materia = materia; }

    public String getHora() {
        return hora;
    }
    public String getIdmateria(){
        return idmateria;
    }
    public String getIdProfesor() {
        return idprofesor;
    }
}