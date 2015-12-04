package com.example.cruzjedi.tesisprojectscada.domain;

import java.util.Calendar;
/**
 * Created by Cruz on 25/11/2015.
 */
public class ObtenerHora {

    private Calendar cal1 = Calendar.getInstance();
    private String hora;
    private String minuto;
    private String diaSemana;
    private String amPm;
    private int horaTotal = 0;

    public ObtenerHora(){
        amPm   = Integer.toString(cal1.get(Calendar.AM_PM));
        hora   = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
        minuto = Integer.toString(cal1.get(Calendar.MINUTE));
        diaSemana    = Integer.toString(cal1.get(Calendar.DAY_OF_WEEK) - 1);
    }
    public String getAmPm(){
        return amPm;
    }
    public String getHora() {
        return hora;
    }
    public String getMinuto() {
        return minuto;
    }
    public String getDiaSemana() {
        return diaSemana;
    }
    public int getHoraYminuto() {
        if (cal1.get(Calendar.HOUR) == 0) {
            hora = "12";
        } else if (getMinuto().length() == 1) {
            minuto = "0" + getMinuto();
        }
        horaTotal = Integer.parseInt(getHora() + getMinuto());

        if (horaTotal >= 650 && horaTotal < 830) {
            horaTotal = 1;
        } else if (horaTotal>= 830 && horaTotal < 1000) {
            horaTotal = 2;
        } else if (horaTotal >= 1000 && horaTotal< 1131) {
            horaTotal = 3;
        } else if (horaTotal >= 1130 && horaTotal <= 1259) {
            horaTotal = 4;
        } else if (horaTotal >= 1300 && horaTotal < 1430) {
            horaTotal = 5;
        } else if (horaTotal >= 1430 && horaTotal < 1600) {
            horaTotal = 6;
        } else if (horaTotal >= 1600 && horaTotal < 1730) {
            horaTotal = 7;
        } else if (horaTotal >= 1730 && horaTotal < 1900) {
            horaTotal = 8;
        } else if (horaTotal >= 1900 && horaTotal < 2030) {
            horaTotal = 9;
        } else if (horaTotal >= 2030 && horaTotal < 2210) {
            horaTotal = 10;
        }
        else if (horaTotal >= 2200 && horaTotal < 2400) {
            horaTotal = 11;
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
