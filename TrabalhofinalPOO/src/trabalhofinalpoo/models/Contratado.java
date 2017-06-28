/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gabrielroriz
 */
public class Contratado extends Corretor implements Serializable{
    
    float salarioFixo;
    
    Date dataDeAdmissao;
    
    public Contratado(int numeroCRECI, String nome, float salarioFixo){
        setNumeroCRECI(numeroCRECI);
        setNome(nome);
        setSalarioFixo(salarioFixo);
    }

    public float getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(float salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public Date getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(Date dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    @Override
    public void calculaSalario() {
        //calula salario contratado
    }
    
}
