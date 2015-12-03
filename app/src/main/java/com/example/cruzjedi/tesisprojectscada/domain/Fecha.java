package com.example.cruzjedi.tesisprojectscada.domain;

import java.util.Calendar;

/**
 * Created by Cruz on 02/12/2015.
 */
public class Fecha {
    private Calendar cal1 = Calendar.getInstance();
    private String year,diaMes, mes, yearMonthDay;

    public Fecha(){
        this.year =Integer.toString(cal1.get(Calendar.YEAR));
        this.mes = Integer.toString(cal1.get(Calendar.MONTH)+1);
        this.diaMes  = Integer.toString( cal1.get(Calendar.DAY_OF_MONTH) );
    }

    public String getYearMonthDay(){
        int date = cal1.get(Calendar.DAY_OF_MONTH);
        if( date >=1 && date <=9) yearMonthDay = year +"-"+ mes +"-0"+ diaMes;
        else yearMonthDay = year +"-"+ mes +"-"+ diaMes;
        return yearMonthDay;
    }
}
