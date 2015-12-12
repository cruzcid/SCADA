package com.example.cruzjedi.tesisprojectscada.io.model;

/**
 * Created by cruzjedi on 17/11/15.
 */
public class ApiConstants {
    //JSON to Reach http://scadaipn.com/json2.php
    //http://scadaipn.com/json1param.php
    public static final String ENVIAR_USER_PASSWORD = "/Login.php";
    public static final String ENVIAR_ASISTENCIA = "/VerificarInsertar.php";
    public static final String ENVIAR_SALON_PARAM = "/jsonG.php";
    public static final String SALON_HORARIO_COMPLETO = "/HorarioCompleto.php";
    public static final String VALUE_JSON2 = "/json2";
    public static final String PHP_EXTENTION = ".php";
    public static final String PETITION = VALUE_JSON2 + PHP_EXTENTION;
    public static final String SCADA_BASE_URL = "http://scadaipn.com";
    public static final String COMPLETE_PATH = SCADA_BASE_URL + VALUE_JSON2 + PHP_EXTENTION;
}
