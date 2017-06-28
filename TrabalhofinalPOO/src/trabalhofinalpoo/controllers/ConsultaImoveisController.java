package trabalhofinalpoo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import trabalhofinalpoo.models.Imovel;
import trabalhofinalpoo.views.ConsultaImoveisScreen;

public class ConsultaImoveisController implements ActionListener, ListSelectionListener{
    
    ConsultaImoveisScreen view;
    
    private Integer indexListSelected;
    
    public ConsultaImoveisController(ConsultaImoveisScreen mView){
        view = mView;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //
        if(ae.getSource() instanceof JComboBox){
            JComboBox aux = (JComboBox) ae.getSource();
            if(aux.getName().equals(ConsultaImoveisScreen.COMBOBOX_TIPOS_CONSULTA)){
                comboBoxTipoConsultaChanged((String) aux.getSelectedItem());
            }
            if(aux.getName().equals(ConsultaImoveisScreen.COMBOBOX_TIPOS_EDIT)){
                comboBoxTipoEditChanged();
            }
        }
        
        if(ae.getSource() instanceof JButton){
            JButton aux = (JButton) ae.getSource();
            if(aux.getText().equals(ConsultaImoveisScreen.BUTTON_VENDER)){
                buttonVenderClicked();
            }
            if(aux.getText().equals(ConsultaImoveisScreen.BUTTON_SALVAR)){
                buttonSalvarClicked();
            }
            if(aux.getText().equals(ConsultaImoveisScreen.BUTTON_RESTAURAR)){
                buttonRestaurarClicked();
            }
        }
    }
    
    
    public void comboBoxTipoConsultaChanged(String item){
        view.showOnlySpecificTipo(item);
    }
    
    public void comboBoxTipoEditChanged(){
        view.showMessageConsulta("comboBoxTipoEditChanged", false);
    }
    
    public void buttonVenderClicked(){
        view.showMessageConsulta("venderClicked", false);
    }
    
    public void buttonSalvarClicked() {
        view.showMessageEdit("buttonSalvarClicked", false);
    }

    public void buttonRestaurarClicked() {
        view.showImovel(indexListSelected);
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) { 
        JList aux = (JList) lse.getSource();
        indexListSelected = aux.getSelectedIndex();
        
        view.changeVisibleEdit(true);
        view.showImovel(indexListSelected);
        view.showMessageConsulta(Integer.toString(aux.getSelectedIndex()), true);
    } 
    
     public ArrayList<String> getAvailableImovelCategories(ArrayList<Imovel> listImoveis){
        
        ArrayList<Boolean> categories
                = new ArrayList<Boolean>(Arrays.asList(false, false, false, false, false, false, false, false));
        
        for(int i = 0; i < listImoveis.size(); i++){
            categories.set(listImoveis.get(i).getTipo(), true);
        }
        
        ArrayList<String> categoriesString = new ArrayList<String>();
        
        for(int i = 0; i < 8; i++){
            if(categories.get(i)){
                categoriesString.add(Imovel.getTipoString(i));
            }
        }
            
        return categoriesString;
    }
}
