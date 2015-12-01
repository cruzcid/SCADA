package com.example.cruzjedi.tesisprojectscada.io.model;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by cruzjedi on 17/11/15.
 */
public interface ScadaApiService {
    @GET(ApiConstants.PETITION)
    void getScadaDatosSalon(Callback<ScadaDatosSalonResponse> serverResponse);

    @FormUrlEncoded
    @POST(ApiConstants.ENVIAR_SALON_PARAM)
    void getSalonDatosPostHorario(@Field("salon")String  salonDato,
                           @Field("dia")String  dia,
                           @Field("hora")String  hora,
                           Callback<ScadaDatosSalonResponse> cb);
    @FormUrlEncoded
    @POST(ApiConstants.ENVIAR_ASISTENCIA)
    void getSalonDatosPostAsistencia(@Field("fecha")String  fecha,
                           @Field("grupo")String  grupo,
                           @Field("asistencia")String  asistencia,
                           @Field("idmateria")String  idmateria,
                           @Field("idprofesor")String  idprofesor,
                           @Field("periodo")String  periodo,
                           Callback<ScadaDatosSalonResponse> cb);

}
/*
  Horario.php


  InsertarAsistencia.php
  fecha, grupo, asistencia, idmateria, idprofesor, periodo
 */