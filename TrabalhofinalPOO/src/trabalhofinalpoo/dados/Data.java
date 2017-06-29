/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.dados;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gabrielroriz
 */
public class Data implements Serializable{
    
    Integer ano;
    
    Integer mes;
    
    Integer dia;
    
    public Data(Integer Dia, Integer Mes, Integer Ano){
        setDia(Dia);
        setMes(Mes);
        setAno(Ano);
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }
    
    
    public String toString(){
        return String.valueOf(getDia()) + "/"
             + String.valueOf(getMes()) + "/"
             + String.valueOf(getAno());
    }
    
    public static Data getData(Date date){
        
        if(date == null){
            return null;
        }
        
       DateFormat dayFormat = new SimpleDateFormat("dd");
       String day = dayFormat.format(date);
       Integer dia = Integer.valueOf(day);
       
       DateFormat monthFormat = new SimpleDateFormat("MM");
       String month = monthFormat.format(date);
       Integer mes = Integer.valueOf(month);
       
       DateFormat yearFormat = new SimpleDateFormat("YYYY");
       String year = yearFormat.format(date);
       Integer ano = Integer.valueOf(year);
       return new Data(dia, mes, ano);
    }
}
