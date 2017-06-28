/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.*;
import java.util.Properties;
import javax.swing.*;
import javax.swing.JPanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import trabalhofinalpoo.models.DateLabelFormatter;

/**
 *
 * @author khazyer
 */
public class ConsultaImoveisScreen implements FechamentoTelas {
    
    JPanel pConImoveis, pOrganize, pConsulta, pEdit;
    JLabel labelConsulta, lLista, labelImovel, labelMensagem1, labelMensagem2, lTipo1, lTipo2, lCod, lDesc, lPreco, lDate;
    JTextField textCod, textPreco;
    JTextArea textArea2;
    JScrollPane scrollPane1, scrollPane2;
    JButton bReset, bSalvar, bVenda;
    JComboBox box1, box2;
    JList lista;
    DefaultListModel itensLista;
    GridBagConstraints c;
    
    UtilDateModel model;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;
    
    String str[] = {"Apartamento", "Sala Comercial", "Lote", "Chácara", "Sítio", "Fazenda"};
    
    public ConsultaImoveisScreen() {
        pConImoveis = new JPanel(new BorderLayout());
        pOrganize = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        this.instanceConsulta();
        this.instanceEdit();
        
        c.ipadx = 0;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);
        
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        labelConsulta = new JLabel("Consulta Imóveis");
        labelConsulta.setHorizontalAlignment(JLabel.CENTER);
        pOrganize.add(labelConsulta, c);
        
        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 1;
        pOrganize.add(pConsulta, c);
        c.gridx = 1;
        pOrganize.add(pEdit, c);
        
        pConImoveis.add(pOrganize, BorderLayout.PAGE_START);
    }
    
    public void instanceConsulta() {
        pConsulta = new JPanel(new GridBagLayout());
        c.ipadx = 150;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        lTipo1 = new JLabel("Tipo:");
        pConsulta.add(lTipo1, c);
        
        c.gridy++;
        box1 = new JComboBox(str);
        pConsulta.add(box1, c);
        
        c.gridy++;
        lLista = new JLabel("Lista Imóveis:");
        pConsulta.add(lLista, c);
        
        c.gridy++;
        c.ipady = 100;
        itensLista = new DefaultListModel();
        itensLista.addElement("imóvel 1");
        itensLista.addElement("imóvel 2");
        itensLista.addElement("imóvel 3");
        itensLista.addElement("imóvel 4");
        itensLista.addElement("imóvel 5");
        itensLista.addElement("imóvel 6");
        itensLista.addElement("imóvel 7");
        itensLista.addElement("imóvel 8");
        itensLista.addElement("imóvel 9");
        itensLista.addElement("imóvel 10");
        itensLista.addElement("imóvel 11");
        itensLista.addElement("imóvel 12");
        lista = new JList(itensLista);
        //lista.addListSelectionListener(controller);
        lista.setBorder(BorderFactory.createEtchedBorder());
        scrollPane1 = new JScrollPane(lista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pConsulta.add(scrollPane1, c);
        
        c.gridy++;
        c.ipady = 0;
        bVenda = new JButton("Vender");
        pConsulta.add(bVenda, c);
        
        c.gridy++;
        c.ipady = 10;
        labelMensagem1 = new JLabel("mensagem");
        labelMensagem1.setHorizontalAlignment(JLabel.CENTER);
        pConsulta.add(labelMensagem1, c);
        
    }
    
    public void instanceEdit() {
        pEdit = new JPanel(new GridBagLayout());
        c.ipadx = 100;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);

        //Painel do Cadastro de Imovel        
        pEdit.setLayout(new GridBagLayout());
        GridBagConstraints i = new GridBagConstraints();
        i.fill = GridBagConstraints.BOTH;
        i.insets = new Insets(10, 10, 10, 10);
        i.ipadx = 150;
        
        i.gridx = 0;
        i.gridy = 0;
        i.gridwidth = 4;
        labelImovel = new JLabel("Editar Imóvel");
        labelImovel.setHorizontalAlignment(JLabel.CENTER);
        pEdit.add(labelImovel, i);
        
        i.gridx = 0;
        i.gridy++;
        i.gridwidth = 2;
        i.ipadx = 100;
        lCod = new JLabel("Cod:");
        pEdit.add(lCod, i);
        lTipo2 = new JLabel("Tipo:");
        i.gridx = 2;
        i.ipadx = 150;
        pEdit.add(lTipo2, i);
        
        textCod = new JTextField(20);
        i.gridx = 0;
        i.gridy++;
        i.ipadx = 100;
        pEdit.add(textCod, i);
        box2 = new JComboBox(str);
        i.gridx = 2;
        i.ipadx = 150;
        pEdit.add(box2, i);
        
        lDesc = new JLabel("Descrição:");
        i.gridx = 0;
        i.gridy++;
        i.gridwidth = 1;
        i.ipadx = 100;
        pEdit.add(lDesc, i);
        textArea2 = new JTextArea();
        textArea2.setBorder(BorderFactory.createEtchedBorder());
        scrollPane2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        i.gridx = 1;
        i.gridwidth = 3;
        i.ipadx = 150;
        i.ipady = 50;
        pEdit.add(scrollPane2, i);
        i.ipady = 0;
        
        lPreco = new JLabel("Preço:");
        i.gridx = 0;
        i.gridy++;
        i.gridwidth = 1;
        i.ipadx = 100;
        pEdit.add(lPreco, i);
        textPreco = new JTextField();
        i.gridx = 1;
        i.gridwidth = 3;
        i.ipadx = 150;
        pEdit.add(textPreco, i);
        
        lDate = new JLabel("Data:");
        i.gridx = 0;
        i.gridy++;
        i.gridwidth = 1;
        i.ipadx = 100;
        pEdit.add(lDate, i);
        model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        i.gridx = 1;
        i.gridwidth = 3;
        i.ipadx = 150;
        pEdit.add(datePicker, i);
        
        bReset = new JButton("Restaurar");
        i.gridx = 0;
        i.gridy++;
        i.gridwidth = 2;
        i.ipadx = 100;
        pEdit.add(bReset, i);
        bSalvar = new JButton("Salvar");
        i.gridx = 2;
        i.ipadx = 150;
        pEdit.add(bSalvar, i);
        
        labelMensagem2 = new JLabel("mensagem");
        labelMensagem2.setHorizontalAlignment(JLabel.CENTER);
        i.gridy = +15;
        i.gridx = 0;
        i.gridwidth = 4;
        pEdit.add(labelMensagem2, i);
    }
    
    public JPanel getpConImoveis() {
        return pConImoveis;
    }
    
    @Override
    public void closeTela() {
        datePicker.setVisible(false);
        System.out.println("saiu da tela consulta imoveis screen");
    }
    
}
