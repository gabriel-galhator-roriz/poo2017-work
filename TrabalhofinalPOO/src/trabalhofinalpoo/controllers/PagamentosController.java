package trabalhofinalpoo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import trabalhofinalpoo.dados.Dados;
import trabalhofinalpoo.views.PagamentosScreen;

public class PagamentosController implements ActionListener{
    
    PagamentosScreen view;
    
    Dados dados;
    
    public PagamentosController(PagamentosScreen mView){
        view = mView;
        dados = Dados.getInstance();
    }

    public void loadDados() {
       dados.update();
       view.updateCorretorComboBox(dados.corretores);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() instanceof JButton){
            JButton aux = (JButton) ae.getSource();
            if(aux.getText().equals(PagamentosScreen.BUTTON_CALCULAR)){
                buttonCalcularClicked();
            }
        }
    }

    private void buttonCalcularClicked() {
        System.out.println("Button Clicked!!");
    }
}
