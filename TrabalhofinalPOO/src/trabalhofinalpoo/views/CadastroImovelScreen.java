/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import trabalhofinalpoo.controllers.CadastroImovelController;

/**
 *
 * @author khazyer
 */
public class CadastroImovelScreen{

    JPanel pCadImovel, imov;
    JLabel local, iCod, iTipo, iDesc, iPreco, iNome, iDate;
    JTextField tCod, tPreco, tNome, tDia, tMes, tAno;
    JButton b1;
    JComboBox iJB;
    JTextArea textArea;
    JScrollPane scrollPane;
    String str[] = {"Apartamento", "Sala Comercial", "Lote", "Chácara", "Sítio", "Fazenda"};
    
    CadastroImovelController controller;
    

    public CadastroImovelScreen() {
        controller = new CadastroImovelController(this);
        instanceView();
    }
    
    
    public void instanceView(){
        
        pCadImovel = new JPanel();
        pCadImovel.setLayout(new BorderLayout());
        //Painel do Cadastro de Imovel        
        imov = new JPanel();
        pCadImovel.add(imov, BorderLayout.PAGE_START);
        imov.setLayout(new GridBagLayout());
        GridBagConstraints i = new GridBagConstraints();
        i.fill = GridBagConstraints.BOTH;
        iCod = new JLabel("Cod:");
        imov.add(iCod, i);
        tCod = new JTextField(20);
        i.gridx = 1;
        i.gridy = 0;
        imov.add(tCod, i);
        iTipo = new JLabel("Tipo:");
        i.gridx = 2;
        i.gridy = 0;
        imov.add(iTipo, i);
        iJB = new JComboBox(str);
        i.gridx = 3;
        i.gridy = 0;
        imov.add(iJB, i);
        iDesc = new JLabel("Descrição:");
        i.gridx = 0;
        i.gridy = 1;
        imov.add(iDesc, i);
        textArea = new JTextArea();
        textArea.setBorder(BorderFactory.createEtchedBorder());
        scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        i.gridx = 1;
        i.gridy = 1;
        imov.add(textArea, i);
        i.gridx = 2;
        i.gridy = 1;
        imov.add(scrollPane, i);
        iPreco = new JLabel("Preço:");
        i.gridx = 0;
        i.gridy = 2;
        imov.add(iPreco, i);
        tPreco = new JTextField();
        i.gridx = 1;
        i.gridy = 2;
        imov.add(tPreco, i);
        iNome = new JLabel("Nome:");
        i.gridx = 0;
        i.gridy = 3;
        imov.add(iNome, i);
        tNome = new JTextField();
        i.gridx = 1;
        i.gridy = 3;
        imov.add(tNome, i);
        iDate = new JLabel("Data:");
        i.gridx = 0;
        i.gridy = 4;
        imov.add(iDate, i);
        DateFormat format = new SimpleDateFormat("dd/MM/yyy");
        JFormattedTextField dateTextField = new JFormattedTextField(format);
        i.gridx = 1;
        i.gridy = 4;
        imov.add(dateTextField, i);
        b1 = new JButton("Cadastrar");
        i.gridx = 0;
        i.gridy = 5;
        imov.add(b1, i);
    }

    public JPanel getPanel() {
        return pCadImovel;
    }
}
