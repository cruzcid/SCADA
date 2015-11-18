package com.example.cruzjedi.tesisprojectscada.io.model;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by cruzjedi on 17/11/15.
 */
public interface ScadaApiService {
    @GET(ApiConstants.PETITION)
    void getScadaDatosSalon(Callback<ScadaDatosSalonResponse> serverResponse);
}
