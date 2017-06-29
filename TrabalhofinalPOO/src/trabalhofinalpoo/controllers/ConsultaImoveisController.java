package trabalhofinalpoo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import trabalhofinalpoo.dados.Dados;
import trabalhofinalpoo.models.Imovel;
import trabalhofinalpoo.views.ConsultaImoveisScreen;

public class ConsultaImoveisController implements ActionListener, ListSelectionListener{
    
    ConsultaImoveisScreen view;
    
    private Imovel itemSelected;
    
    Dados dados;
    
    public ConsultaImoveisController(ConsultaImoveisScreen mView){
        view = mView;
        dados = Dados.getInstance();
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
            if(aux.getText().equals(ConsultaImoveisScreen.BUTTON_REMOVE)){
                buttonRemoveClicked();
            }
        }
    }
    
    
    public void comboBoxTipoConsultaChanged(String item){
        view.updateList(getFilteredList(Imovel.getTipoInt(item)));
    }
    
    public void comboBoxTipoEditChanged(){ }
    
    public void buttonVenderClicked(){
        if(itemSelected != null){
            view.callTelaDeVenda();
        } else {
            view.showMessageConsulta("Selecione um imóvel para vendê-lo.", true);
        }
        
    }
    
    public void buttonSalvarClicked() {
        if(validateImovelInfo()){
            if(itemSelected != null){
                itemSelected.setDescricao(view.getDescription());
                itemSelected.setPreço(Float.valueOf(view.getPreço()));
                //adicionar DATA
                
                if(dados.updateImovel(itemSelected)){
                    loadDados();
                    view.showMessageEdit("Imóvel editado com sucesso!", false);
                } else {
                    view.showMessageEdit("Erro ao salvar imóvel", true);
                }
                
                
            } else {
                //
            }
        }
    }

    public void buttonRestaurarClicked() {
        view.showImovel(itemSelected);
    }
    
    private void buttonRemoveClicked() {
       if(itemSelected != null){
            
           int dialogResult = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja remover o Imóvel?", "Atenção!",  JOptionPane.YES_NO_OPTION);
           if(dialogResult == JOptionPane.YES_OPTION){
                
               
                if(dados.removeImovel(itemSelected)){
                    loadDados();
                    view.clearFields();
                    view.showMessageConsulta("Remoção realizada com sucesso!", false);
                } else {
                    view.showMessageConsulta("Erro ao remover imóvel.", false);
                }
                
                
            }
        } else {
            view.showMessageConsulta("Selecione um imóvel para removê-lo.", true);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) { 
        JList aux = (JList) lse.getSource();
        
        itemSelected = (Imovel) aux.getSelectedValue();
        if(itemSelected != null){
            view.changeVisibleEdit(true);
            view.showImovel(itemSelected);
        }   
    } 
    
     public ArrayList<String> getAvailableImovelCategories(ArrayList<Imovel> listImoveis){
        
        ArrayList<Boolean> categories
                = new ArrayList<Boolean>(Arrays.asList(true, false, false, false, false, false, false, false));
        
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
     
    public boolean validateImovelInfo(){
        
        if(view.getDescription().equals("")){
            view.showMessageEdit("Digite uma descrição.", true);
            return false;
        }
        
        //valida campo preço 
        if(!view.getPreço().equals("")){
            try {
                float preço = Float.parseFloat(view.getPreço());
            } catch (NumberFormatException ex) {    
                view.showMessageEdit("Digite um preço válido.", true);
                return false;
            }
        } else {
            view.showMessageEdit("Digite um preço.", true);
            return false;
        }
        
        
        return true;
    }
    
    public ArrayList<Imovel> getFilteredList(Integer type){
        ArrayList<Imovel> filtered = new ArrayList<Imovel>();
        for(Imovel imovel : dados.getImoveisDisponiveis()){
            if(type == Imovel.TYPE_NULL){
                filtered.add(imovel);
            } else {
                if(imovel.getTipo() == type){
                    filtered.add(imovel);
                }
            }
        }
        return filtered;
    }

    public void loadDados() {
        view.clearFields();
        dados.update();
        view.updateTipoComboBoxConsulta(getAvailableImovelCategories(dados.getImoveisDisponiveis()));
        comboBoxTipoConsultaChanged(view.getTipoSelected());
    }
        
}
