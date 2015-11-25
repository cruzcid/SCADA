package com.example.cruzjedi.tesisprojectscada.io.model;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by cruzjedi on 17/11/15.
 */
public class ScadaApiAdapter {
    private static ScadaApiService API_SERVICE;

    //Patron del singleton
    public static ScadaApiService getApiService(){
        //Si no ha sido creado lo crea
        if(API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.SCADA_BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            API_SERVICE = adapter.create(ScadaApiService.class);
        }
        return API_SERVICE;
    }
    public static void getSalonDatosPostyf(String query,String dia, Callback<ScadaDatosSalonResponse> serverResponse){
        getApiService().getSalonDatosPost(query,dia, serverResponse);
    }

}
