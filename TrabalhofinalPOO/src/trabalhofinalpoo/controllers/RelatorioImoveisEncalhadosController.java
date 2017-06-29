/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.controllers;

import trabalhofinalpoo.dados.Dados;
import trabalhofinalpoo.views.RelatorioImoveisEncalhadosScreen;

    
public class RelatorioImoveisEncalhadosController {
    
    RelatorioImoveisEncalhadosScreen view;
    
    Dados dados;
    
    public RelatorioImoveisEncalhadosController(RelatorioImoveisEncalhadosScreen mView){
        view = mView; 
        dados = Dados.getInstance();
    }
    
    public void loadDados(){
        dados.update();
    }
}
