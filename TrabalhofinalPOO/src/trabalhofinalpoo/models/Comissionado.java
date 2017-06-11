/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.models;

/**
 *
 * @author gabrielroriz
 */
public class Comissionado extends Corretor{
    
    float porcentagemComssiondada;

    public float getPorcentagemComssiondada() {
        return porcentagemComssiondada;
    }

    public void setPorcentagemComssiondada(float porcentagemComssiondada) {
        if(porcentagemComssiondada <= 0.01 || porcentagemComssiondada >= 0.03){
            //return error
        } else {
            this.porcentagemComssiondada = porcentagemComssiondada;
        }
    }

    @Override
    public void calculaSalario() {
        //calula salario comissionado
    }
}
