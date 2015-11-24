package com.example.cruzjedi.tesisprojectscada.io.model;

import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Cruz on 22/11/2015.
 */
public class PostDataSalonOk {


    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    /*
    //Crear un builder que va en body para agregar valores en la peticion
    //no probado aun, probarlo*/
    RequestBody fe = new FormEncodingBuilder()
            .add("salon", "5101")
            .build();

    public String post(String url) throws IOException {
        //RequestBody body = RequestBody.create(JSON, json); Parametro String json eliminado
        Request request = new Request.Builder()
                .url(url)
                .post(fe)
                .build();
        Response response = client.newCall(request).execute();
        //para probar con fe line 26
        if(!response.isSuccessful()){
            //throw new IOException("Codigo inesperado" + response);
            Log.e("Error cadena :", response.body().string());
        }
        return response.body().string();
    }

    public String bowlingJson(String salon) {
        /*return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";*/
        return "{'consulta':["
                + "{'salon':'" + salon + ",'nombre:''MERCADO MORENO ROSA','grupo':'9cm11'}"
                + "]}";
    }
    /*public static void main(String[] args) throws IOException {
        PostDataSalonOk example = new PostDataSalonOk();
        String json = example.bowlingJson("Jesse", "Jake");
        String response = example.post("http://www.roundsapp.com/post", json);
        System.out.println(response);
    }*/
}
