package com.example.cruzjedi.tesisprojectscada.io.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cruz on 03/12/2015.
 */
public class LoginResponse {
    @SerializedName(JsonKeys.LOGIN_VERIFICACION)
    String respuestaLogin;

    @SerializedName(JsonKeys.USUARIO)
    String usuarioLogin;

    public String getRespuestaLogin(){
        return respuestaLogin;
    }

    public String getRespuestaUsuario(){
        return usuarioLogin;
    }
}
