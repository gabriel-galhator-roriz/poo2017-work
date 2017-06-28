/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import trabalhofinalpoo.views.CadastroImovelScreen;

public class CadastroImovelController implements ActionListener {
    
    CadastroImovelScreen view;

    public CadastroImovelController(CadastroImovelScreen mView) {
        view = mView;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() instanceof JButton){
            JButton aux = (JButton) ae.getSource();
            if(aux.getText() == CadastroImovelScreen.BUTTON_CLEAR){
                 buttonClearClicked();
            }
            if(aux.getText() == CadastroImovelScreen.BUTTON_SAVE){
                buttonSaveClicked();
            }
        }
    }

    private void buttonClearClicked() {
        view.clearFields();
    }

    private void buttonSaveClicked() {
        if(validateGeneralInfo()){
            view.showMessage("Imóvel cadastrado com sucesso!", false);
        }
    }
    
    public boolean hasTipoSelected(){
        return (view.getTipo() == null ? false : true); 
    }  
    
    private boolean validateGeneralInfo(){
        
         //valida código
        if(!view.getCodigo().equals("")){
            if (!view.getCodigo().matches("[0-9]+")){
            view.showMessage("O código só pode conter números.", true);
            return false;
            }
        } else {
            view.showMessage("Digite um código.", true);
            return false;
        }
        
        //valida o tipo
         if(!hasTipoSelected()){
            view.showMessage("Selecione um tipo de imóvel.", true);
            return false;
        }
        
        //valida descricao
        if(view.getDescricao().equals("")){
            view.showMessage("Digite uma descrição.", true);
            return false;
        }
         
        //valida campo preço 
        if(!view.getPreço().equals("")){
            try {
                float preço = Float.parseFloat(view.getPreço());
            } catch (NumberFormatException ex) {    
                view.showMessage("Digite um preço válido.", true);
                return false;
            }
        } else {
            view.showMessage("Digite um preço.", true);
            return false;
        }
        
        return true;
        
    }
}
