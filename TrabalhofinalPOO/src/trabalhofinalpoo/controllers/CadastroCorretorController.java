package trabalhofinalpoo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import trabalhofinalpoo.views.CadastroCorretorScreen;

public class CadastroCorretorController implements ActionListener{
    
    public CadastroCorretorScreen view;
    
    public CadastroCorretorController(CadastroCorretorScreen mView){
        view = mView;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() instanceof JButton){
            JButton buttonClicked = (JButton) ae.getSource();
            if(buttonClicked.getText().equals(CadastroCorretorScreen.BUTTON_SAVE)){
                buttonSaveClicked();
            }
        }
        
        if(ae.getSource() instanceof JComboBox){            
        }
    }
    
    public void buttonSaveClicked(){
        String nome = view.getNome();
        String numeroCRECI = view.getNumeroCRECI();
        
        if(view.getTipo().equals(CadastroCorretorScreen.COMISSIONADO)){
            
        } else if(view.getTipo().equals(CadastroCorretorScreen.CONTRATADO)){
            
        }
    }
    
    public void changeCategory(){
        if(view.getTipo().equals(CadastroCorretorScreen.COMISSIONADO)){
            view.showComissionadoOptions();
        } else if(view.getTipo().equals(CadastroCorretorScreen.CONTRATADO)){
            view.showContratadoOptions();
        }
    }
}
