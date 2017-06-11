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
    
   public static int TYPE_HOME = 1; //CASA
   public static int TYPE_APT = 2; //APARTAMENTO
   public static int TYPE_COMMERCIAL_ROOM = 3; //SALA COMERCIAL
   public static int TYPE_LOT = 4; // LOTE
   public static int TYPE_RANCH_MANSION = 5; //CHÁCARA
   public static int TYPE_SITIAR = 6; //SÍTIO
   public static int TYPE_FARM = 7; //FAZENDA
   
   int codigo;
   
   int tipo;
   
   String descricao;
   
   String nome_vendedor;
   
   float preço;
   
   Date dataDeCadastro;
   
   boolean disponibilidade;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
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
}
