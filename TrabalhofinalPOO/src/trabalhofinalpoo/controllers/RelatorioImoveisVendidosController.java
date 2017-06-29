/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.controllers;

import trabalhofinalpoo.dados.Dados;
import trabalhofinalpoo.views.RelatorioImoveisVendidos;

/**
 *
 * @author gabrielroriz
 */
public class RelatorioImoveisVendidosController {
    
    RelatorioImoveisVendidos view;
    
    Dados dados;
    
    public RelatorioImoveisVendidosController(RelatorioImoveisVendidos mView){
        view = mView;
        dados = Dados.getInstance();
    }
    
    public void loadDados(){
        dados.update();
    }
}
