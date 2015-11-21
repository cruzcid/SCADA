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
    void getSalonDatos(@Field("salon")String  salonDato, Callback<ScadaDatosSalonResponse> cb);
}
