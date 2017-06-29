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
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import trabalhofinalpoo.dados.Dados;
import trabalhofinalpoo.dados.Data;
import trabalhofinalpoo.models.Corretor;
import trabalhofinalpoo.models.Imovel;
import trabalhofinalpoo.views.RelatorioCorretores;

/**
 *
 * @author gabrielroriz
 */
public class RelatorioCorretoresController implements ActionListener, ListSelectionListener{
    
    RelatorioCorretores view;
    
    Dados dados;
    
    Corretor corretorSelected;
    
    Data dataSelected;
    
    public RelatorioCorretoresController(RelatorioCorretores mView){
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
             dados.update();
             
             dataSelected = new Data(0, Integer.valueOf(view.getMes()), Integer.valueOf(view.getAno()));
             view.updateCorretorList(dados.getCorretorInInterval(dataSelected));
             
             Corretor doMes = dados.getCorretorDoMes(dataSelected);
             view.setFaturamentoTotalCDM(dados.getFaturamentoTotalCorretor(doMes, dataSelected));
             view.setValorPagoCDM(dados.getValorPagoCorretor(dataSelected, doMes));
             view.setNomeCMD(doMes.getNome());
             
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

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        JList aux = (JList) lse.getSource();
        
        corretorSelected = (Corretor) aux.getSelectedValue();
        if(corretorSelected != null){
            view.updateVendasList(dados.getVendasFromSpecificCorretorInInterval(corretorSelected, dataSelected));
            view.setFaturamentoTotalCorretor(dados.getFaturamentoTotalCorretor(corretorSelected, dataSelected));
            view.setValorPagoCorretor(dados.getValorPagoCorretor(dataSelected, corretorSelected));
        }
    }
}
