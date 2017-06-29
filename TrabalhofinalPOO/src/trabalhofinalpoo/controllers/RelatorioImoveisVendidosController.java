/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import trabalhofinalpoo.dados.Dados;
import trabalhofinalpoo.dados.Data;
import trabalhofinalpoo.views.RelatorioCorretores;
import trabalhofinalpoo.views.RelatorioImoveisVendidos;

/**
 *
 * @author gabrielroriz
 */
public class RelatorioImoveisVendidosController implements ActionListener{
    
    RelatorioImoveisVendidos view;
    
    Dados dados;
    
    public RelatorioImoveisVendidosController(RelatorioImoveisVendidos mView){
        view = mView;
        dados = Dados.getInstance();
    }
    
    public void loadDados(){
        dados.update();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() instanceof JButton){
            JButton aux = (JButton)ae.getSource();
            if(aux.getText().equals(RelatorioCorretores.BUTTON_BUSCAR)){
                buttonBuscarClicked();
            }
        }
    }
    
    private void buttonBuscarClicked() {
         if(validateData()){
             view.showMessage("Busca realizada!", false);
         }
    }
    
    public boolean validateData(){
        
        if(!view.getMes().equals("")){
            if (!view.getMes().matches("[0-9]+")){
                view.showMessage("Utilize apenas números para caracterizar um mês.", true);
                return false;
                
            } else {
                Integer mes = Integer.valueOf(view.getMes());
                
                if(mes <= 0 || mes > 12){
                    view.showMessage("Digite um mês entre Janeiro (1) e Dezembro (12).", true);
                    return false;
                }
            }        
        } else {
            view.showMessage("Digite um mês.", true);
            return false;
        }
        
        if(!view.getAno().equals("")){
            if (!view.getAno().matches("[0-9]+")){
                view.showMessage("Utilize apenas números para caracterizar um ano.", true);
                return false;
            } else {
                Integer ano = Integer.valueOf(view.getAno());
                
                Data actualDate = Data.getData(new Date());
                Integer actualAno = actualDate.getAno();
                
                System.out.println(actualAno);
                System.out.println(ano);
                if(ano <= 0 || ano > actualAno){
                    view.showMessage("Digite um ano maior que sero e que represente o presente/passado.", true);
                    return false;
                }
            }        
        } else {
            view.showMessage("Digite um ano.", true);
            return false;
        }
        
        return true;
    }
}
