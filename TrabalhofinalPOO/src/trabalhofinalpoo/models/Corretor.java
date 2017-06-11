/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.models;

import java.util.ArrayList;

import java.util.Date;  

/**
 * @author gabrielroriz
 */
public abstract class Corretor implements recebeSalario{
    
    int numeroCRECI;
    
    String nome;
    
    ArrayList<Venda> listaDeVendas = new ArrayList<Venda>();

    public int getNumeroCRECI() {
        return numeroCRECI;
    }

    public void setNumeroCRECI(int numeroCRECI) {
        this.numeroCRECI = numeroCRECI;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Venda> getListaDeVendas() {
        return listaDeVendas;
    }

    public void setListaDeVendas(ArrayList<Venda> listaDeVendas) {
        this.listaDeVendas = listaDeVendas;
    }  
}

interface recebeSalario{
    public void calculaSalario();
}
