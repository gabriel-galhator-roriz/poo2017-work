package trabalhofinalpoo.controllers;

import trabalhofinalpoo.dados.Dados;
import trabalhofinalpoo.views.RelatorioFinanceiro;


public class RelatorioFinanceiroController {
    
    RelatorioFinanceiro view;
    
    Dados dados;
    
    public RelatorioFinanceiroController(RelatorioFinanceiro mView){
        
        view = mView;
        
        dados = Dados.getInstance();
    }
    
    
    public void loadDados(){
        dados.update();
    }
    
}
