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
    public static void getSalonDatosPostAsistencia(String fecha, String grupo, String asistencia,
                                                String idmateria, String idprofesor, String periodo,
                                                Callback<ScadaDatosSalonResponse> serverResponse){
        getApiService().getSalonDatosPostAsistencia(fecha, grupo, asistencia, idmateria,
                                                    idprofesor, periodo, serverResponse);
    }
    public static void getSalonDatosPostHorario(String fecha, String dia, String hora,
                                                  Callback<ScadaDatosSalonResponse> serverResponse){
        getApiService().getSalonDatosPostHorario(fecha, dia, hora, serverResponse);
    }

}
