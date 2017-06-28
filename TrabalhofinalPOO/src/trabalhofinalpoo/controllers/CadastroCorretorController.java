package trabalhofinalpoo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import trabalhofinalpoo.dados.Dados;
import trabalhofinalpoo.models.Comissionado;
import trabalhofinalpoo.models.Contratado;
import trabalhofinalpoo.models.Corretor;
import trabalhofinalpoo.views.CadastroCorretorScreen;

public class CadastroCorretorController implements ActionListener, Serializable{
    
    public CadastroCorretorScreen view;
    
    Dados dados;
    
    public CadastroCorretorController(CadastroCorretorScreen mView){
        view = mView;
        
        dados = Dados.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() instanceof JButton){
            JButton buttonClicked = (JButton) ae.getSource();
            if(buttonClicked.getText().equals(CadastroCorretorScreen.BUTTON_SAVE)){
                buttonSaveClicked();
            }
            if(buttonClicked.getText().equals(CadastroCorretorScreen.BUTTON_CLEAR)){
                buttonClearClicked();
            }
        }
        
        if(ae.getSource() instanceof JComboBox){
            JComboBox jcomboBoxSelected = (JComboBox) ae.getSource();
            if(jcomboBoxSelected.getName().equals(CadastroCorretorScreen.JCOMBOX_CATEGORIES)){
                changeCategory();
            }
        }
    }
    
    public void buttonSaveClicked(){
        if(!validateGeneralInfo())
            return;
        
        if(view.getTipo().equals(CadastroCorretorScreen.COMISSIONADO)){
            
            if(validatePorcentagemComissionada()){         
                Integer nCRECI = Integer.valueOf(view.getNumeroCRECI());
                Float percentage = Float.valueOf(view.getPorcentagemComissionada());

                if(dados.addCorretor(new Comissionado(nCRECI, view.getNome(), percentage))){
                    view.showMessage("Corretor comissionado cadastrado com sucesso!", false);
                } else {
                    view.showMessage("Erro ao cadastrar corretor", true);
                }
            }
            
        } else if(view.getTipo().equals(CadastroCorretorScreen.CONTRATADO)){
            
            if(validateSalarioFixo()){
                 Integer nCRECI = Integer.valueOf(view.getNumeroCRECI());
                 
                 Float salario = Float.valueOf(view.getSalarioFixo());
                 
                 if(dados.addCorretor(new Contratado(nCRECI, view.getNome(), salario))){
                      view.showMessage("Corretor Contratado cadastrado com sucesso!", false);
                 } else {
                      view.showMessage("Erro ao cadastrar corretor", true);
                 }
            }
            
        }
    }
    
    public boolean validateGeneralInfo(){
        if(view.getNome().equals("")){
            view.showMessage("Digite um nome.", true);
            return false;
        }
        
        if(!view.getNumeroCRECI().equals("")){
            if (!view.getNumeroCRECI().matches("[0-9]+")){
            view.showMessage("O Número CRECI só pode conter números.", true);
            return false;
            }
        } else {
            view.showMessage("Digite um número CRECI.", true);
            return false;
        }
        
        return true;     
    }
    
    public boolean validatePorcentagemComissionada(){
        if(!view.getPorcentagemComissionada().equals("")){
            try {
                float porcentagemComissionada = Float.parseFloat(view.getPorcentagemComissionada());
                System.out.print(porcentagemComissionada);
                if(porcentagemComissionada >= 0f && porcentagemComissionada <= 3f){
                    return true;
                } else {
                    view.showMessage("Digite uma porcentagem entre 1% e 3%", true);
                    return false;
                }
            } catch (NumberFormatException ex) {    
                view.showMessage("Digite uma porcentagem válida.", true);
                return false;
            }
        } else {
            view.showMessage("Digite uma porcentagem.", true);
            return false;
        }
    }
    
    public boolean validateSalarioFixo(){
        
        
        if(!view.getSalarioFixo().equals("")){
            try {
                System.out.println(view.getSalarioFixo());
                float salarioFixo = Float.parseFloat(view.getSalarioFixo());
            } catch (NumberFormatException ex) {    
                view.showMessage("Digite um salário válido.", true);
                return false;
            }
        } else {
            view.showMessage("Digite um salário.", true);
            return false;
        }

        return true;
    }
    
    public void changeCategory(){
        if(view.getTipo().equals(CadastroCorretorScreen.COMISSIONADO)){
            view.showComissionadoOptions();
        } else if(view.getTipo().equals(CadastroCorretorScreen.CONTRATADO)){
            view.showContratadoOptions();
        }
    }

    private void buttonClearClicked() {
        view.clearFields();
    }
    
    public void loadDados() {
        dados.update();
    }
}
