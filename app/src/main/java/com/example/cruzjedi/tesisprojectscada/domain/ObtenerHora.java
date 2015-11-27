package com.example.cruzjedi.tesisprojectscada.domain;

import java.util.Calendar;
/**
 * Created by Cruz on 25/11/2015.
 */
public class ObtenerHora {
    private String hora;
    private String minuto;
    private String dia;
    private int horaTotal = 0;
    private Calendar cal1 = Calendar.getInstance();

    public ObtenerHora(){
        hora=Integer.toString(cal1.get(Calendar.HOUR));
        minuto = Integer.toString(cal1.get(Calendar.MINUTE));
        dia = Integer.toString(cal1.get(Calendar.DAY_OF_WEEK) - 1);
    }
    public ObtenerHora(String hora, String minuto, String dia){
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinuto() {
        return minuto;
    }
    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHoraTotal() {
        if (cal1.get(Calendar.HOUR) == 0)
        {
            setHora("12");
        }
        if (getMinuto().length() == 1)
        {
            setMinuto("0" + getMinuto());
        }

        setHoraTotal(Integer.parseInt(getHora() + getMinuto()));

        if (getHoraTotal() >= 700 && getHoraTotal() < 830) {
            horaTotal = 1;
        }

        if (getHoraTotal() >= 830 && getHoraTotal() < 1000) {
            horaTotal = 2;
        }

        if (getHoraTotal() >= 1000 && getHoraTotal() < 1131) {
            horaTotal = 3;
        }

        if (getHoraTotal() >= 1130 && getHoraTotal() <= 1259) {
            horaTotal = 4;
        }

        if (getHoraTotal() >= 100 && getHoraTotal() < 231) {
            horaTotal = 5;
        }
        return horaTotal;
    }
    public void setHoraTotal(int horaTotal) {
        this.horaTotal = horaTotal;
    }
}

