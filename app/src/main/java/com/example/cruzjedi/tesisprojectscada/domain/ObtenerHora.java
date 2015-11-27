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
        hora   = Integer.toString(cal1.get(Calendar.HOUR));
        minuto = Integer.toString(cal1.get(Calendar.MINUTE));
        dia    = Integer.toString(cal1.get(Calendar.DAY_OF_WEEK) - 1);
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
            hora = "12";
        }
        if (getMinuto().length() == 1)
        {
            minuto = "0" + getMinuto();
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

        if (getHoraTotal() >= 1300 && getHoraTotal() < 1430) {
            horaTotal = 5;
        }
        if (getHoraTotal() >= 1430 && getHoraTotal() < 1600) {
            horaTotal = 6;
        }
        if (getHoraTotal() >= 1600 && getHoraTotal() < 1730) {
            horaTotal = 7;
        }
        if (getHoraTotal() >= 1730 && getHoraTotal() < 1900) {
            horaTotal = 8;
        }
        if (getHoraTotal() >= 1900 && getHoraTotal() < 2030) {
            horaTotal = 9;
        }
        if (getHoraTotal() >= 2030 && getHoraTotal() < 2200) {
            horaTotal = 10;
        }
        return horaTotal;
    }
    public void setHoraTotal(int horaTotal) {
        this.horaTotal = horaTotal;
    }

    public String horaNumToHoraStrng(String horaNum){
        if (horaNum.equals("1")) {
            return "7:00-8:30";
        } else if (horaNum.equals("2")) {
            return "8:30-10:00";
        } else if (horaNum.equals("3")) {
            return "10:00-11:30";
        } else if (horaNum.equals("4")) {
            return "11:30-13:00";
        } else if (horaNum.equals("5")) {
            return "13:00-14:30";
        } else if (horaNum.equals("6")) {
            return "14:30-16:00";
        } else if (horaNum.equals("7")) {
            return "16:00-17:30";
        } else if (horaNum.equals("8")) {
            return "17:30-19:00";
        } else if (horaNum.equals("9")) {
            return "19:00-20:30";
        } else if (horaNum.equals("10")) {
            return "20:30-22:00";
        } else {
            return "No hr";
        }
    }
}

