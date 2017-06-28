/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.models;

import java.util.Date;

/**
 * @author gabrielroriz
 */

public class Imovel {
   
   public static final int TYPE_NULL = 0; //CASA
   public static final int TYPE_HOME = 1; //CASA
   public static final int TYPE_APT = 2; //APARTAMENTO
   public static final int TYPE_COMMERCIAL_ROOM = 3; //SALA COMERCIAL
   public static final int TYPE_LOT = 4; // LOTE
   public static final int TYPE_RANCH_MANSION = 5; //CHÁCARA
   public static final int TYPE_SITIAR = 6; //SÍTIO
   public static final int TYPE_FARM = 7; //FAZENDA
   
   public static final String TYPE_NULL_STRING = "--";
   public static final String TYPE_HOME_STRING = "Casa";
   public static final String TYPE_APT_STRING = "Apartamento";
   public static final String TYPE_COMMERCIAL_ROOM_STRING = "Sala Comercial";
   public static final String TYPE_LOT_STRING = "Lote";
   public static final String TYPE_RANCH_MANSION_STRING = "Chácara";
   public static final String TYPE_SITIAR_STRING = "Sítio";
   public static final String TYPE_FARM_STRING = "Fazenda";
   
   
   int codigo;
   
   int tipo;
   
   String descricao;
   
   String nome_vendedor;
   
   float preço;
   
   Date dataDeCadastro;
   
   boolean disponibilidade;
   
   public Imovel(){
       
   }

    public Imovel(int codigo, int tipo, String descricao, float preço, boolean disponibilidade) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.preço = preço;
        this.disponibilidade = disponibilidade;
    }

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }
    
    public String getTipoString(){
        return getTipoString(getTipo());
    }
       
    public static String getTipoString(int tipo){
        String returnString = "";
        
        switch(tipo){
            
            case TYPE_NULL:
                returnString = TYPE_NULL_STRING;
                break;
                
            case TYPE_HOME: //CASA
                returnString = TYPE_HOME_STRING;
                break;

            case TYPE_APT: //APT
                returnString = TYPE_APT_STRING;
                break;

            case TYPE_COMMERCIAL_ROOM: //SALA COMERCIAL
                returnString = TYPE_COMMERCIAL_ROOM_STRING;
                break;

            case TYPE_LOT: // LOTE
                returnString = TYPE_LOT_STRING;
                break;

            case TYPE_RANCH_MANSION: //CHÁCARA
                returnString = TYPE_RANCH_MANSION_STRING;
                break;

            case Imovel.TYPE_SITIAR: //SÍTIO
                returnString = TYPE_SITIAR_STRING;
                break;

            case Imovel.TYPE_FARM: //FAZENDA
                returnString = TYPE_FARM_STRING;
                break;
        }
        return returnString;
    }
    
    
    public static Integer getTipoInt(String tipo){
        if(tipo.equals(TYPE_HOME_STRING)){
            return TYPE_HOME;
        }
        if(tipo.equals(TYPE_APT_STRING)){
            return TYPE_APT;
        }
        if(tipo.equals(TYPE_COMMERCIAL_ROOM_STRING)){
            return TYPE_COMMERCIAL_ROOM;
        }
        if(tipo.equals(TYPE_LOT_STRING)){
            return TYPE_LOT;
        }
        if(tipo.equals(TYPE_RANCH_MANSION_STRING)){
            return TYPE_RANCH_MANSION;
        }
        if(tipo.equals(TYPE_SITIAR_STRING)){
            return TYPE_SITIAR;
        }
        if(tipo.equals(TYPE_FARM_STRING)){
            return TYPE_FARM;
        }
        
        return 0;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome_vendedor() {
        return nome_vendedor;
    }

    public void setNome_vendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

    public float getPreço() {
        return preço;
    }

    public void setPreço(float preço) {
        this.preço = preço;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
   
    
    public String toString(){
        return getDescricao();
    }
}
