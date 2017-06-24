/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalhofinalpoo.controllers.CadastroCorretorController;

/**
 *
 * @author khazyer
 */
public class CadastroCorretorScreen{
    
    
    public static final String CONTRATADO = "Contratado";
    public static final String COMISSIONADO = "Comissionado";
    
    
    public static final String BUTTON_SAVE = "Salvar";
    
    
    JPanel cPa,pCadCorretor;
    JLabel cNum, cNome;
    JTextField tNum, tNome;
    String[] categories = {CONTRATADO, COMISSIONADO};
    JComboBox JComboBoxCategories = new JComboBox(categories);
    JButton bCad, bReturn;
    
    CadastroCorretorController controller;

    public CadastroCorretorScreen(){
        controller = new CadastroCorretorController(this);
        createView();
    }

    public JPanel getPanel() {
        return pCadCorretor;
    } 
    
    public void createView(){
        pCadCorretor = new JPanel();
        JLabel local = new JLabel(" corretor");
        pCadCorretor.setLayout(new BorderLayout());
        
        cPa = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções

        cNum = new JLabel("Número CRECI");
        cPa.add(cNum, c);
        c.gridheight = 1;
        cNome = new JLabel("Nome");
        c.gridy = 1;
        c.gridheight = 1;
        cPa.add(cNome, c);
        tNum = new JTextField();
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        c.ipadx = 150;
        cPa.add(tNum, c);
        tNome = new JTextField();
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        cPa.add(tNome, c);
        JComboBoxCategories.setSelectedIndex(1);
        JComboBoxCategories.addActionListener(controller);
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        cPa.add(JComboBoxCategories, c);
        
        bCad = new JButton(BUTTON_SAVE);
        bCad.addActionListener(controller);
        c.gridx = 0;
        c.gridy = 4;
        cPa.add(bCad, c);
        bReturn = new JButton("Voltar");
        bReturn.addActionListener(controller);
        c.gridx = 1;
        c.gridy = 4;
        cPa.add(bReturn, c);
        pCadCorretor.add(cPa, BorderLayout.PAGE_START);
    }
    
    public String getNumeroCRECI(){
        return tNum.getText();
    }  
    
    public String getNome(){
        return tNome.getText();
    }
    
    public String getTipo(){
        return JComboBoxCategories.getSelectedItem().toString();
    }        

    public void showContratadoOptions() {
        System.out.println("Mostrar Informações de Corretores Contratados!");
    }

    public void showComissionadoOptions() {
        System.out.println("Mostrar Informações de Corretores Comissionados!");
    }
}
