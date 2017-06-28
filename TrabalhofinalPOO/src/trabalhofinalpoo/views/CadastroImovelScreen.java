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
import java.util.Properties;
import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import trabalhofinalpoo.controllers.CadastroImovelController;
import trabalhofinalpoo.models.DateLabelFormatter;

/**
 *
 * @author khazyer
 */
public class CadastroImovelScreen {

    public static String BUTTON_CLEAR = "Limpar";
    
    public static final String BUTTON_SAVE = "Salvar";

    JPanel pCadImovel, imov;
    JLabel labelImovel, local, iCod, iTipo, iDesc, iPreco, iDate, labelMensagem;
    JTextField tCod, tPreco, tDia, tMes, tAno;
    JButton b1, limpar;
    JComboBox iJB;
    JTextArea textArea;
    JScrollPane scrollPane;
    String str[] = {"--", "Apartamento", "Sala Comercial", "Lote", "Chácara", "Sítio", "Fazenda"};

    CadastroImovelController controller;

    public CadastroImovelScreen() {
        controller = new CadastroImovelController(this);
        instanceView();
    }

    public void instanceView() {
        pCadImovel = new JPanel();
        pCadImovel.setLayout(new BorderLayout());
        //Painel do Cadastro de Imovel        
        imov = new JPanel();
        pCadImovel.add(imov, BorderLayout.PAGE_START);
        imov.setLayout(new GridBagLayout());
        GridBagConstraints i = new GridBagConstraints();
        i.fill = GridBagConstraints.BOTH;
        i.insets = new Insets(10, 10, 10, 10);
        i.ipadx = 150;

        i.gridx = 0;
        i.gridy = 0;
        i.gridwidth = 4;
        labelImovel = new JLabel("Cadastro de Imóvel");
        labelImovel.setHorizontalAlignment(JLabel.CENTER);
        imov.add(labelImovel, i);

        i.gridx = 0;
        i.gridy++;
        i.gridwidth = 2;
        i.ipadx = 100;
        iCod = new JLabel("Cod:");
        imov.add(iCod, i);
        iTipo = new JLabel("Tipo:");
        i.gridx = 2;
        i.ipadx = 150;
        imov.add(iTipo, i);

        tCod = new JTextField(20);
        i.gridx = 0;
        i.gridy++;
        i.ipadx = 100;
        imov.add(tCod, i);
        iJB = new JComboBox(str);
        i.gridx = 2;
        i.ipadx = 150;
        imov.add(iJB, i);

        iDesc = new JLabel("Descrição:");
        i.gridx = 0;
        i.gridy++;
        i.gridwidth = 1;
        i.ipadx = 100;
        imov.add(iDesc, i);
        textArea = new JTextArea();
        textArea.setBorder(BorderFactory.createEtchedBorder());
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        i.gridx = 1;
        i.gridwidth = 3;
        i.ipadx = 150;
        i.ipady = 50;
        imov.add(scrollPane, i);
        i.ipady = 0;

        iPreco = new JLabel("Preço:");
        i.gridx = 0;
        i.gridy++;
        i.gridwidth = 1;
        i.ipadx = 100;
        imov.add(iPreco, i);
        tPreco = new JTextField();
        i.gridx = 1;
        i.gridwidth = 3;
        i.ipadx = 150;
        imov.add(tPreco, i);

        iDate = new JLabel("Data:");
        i.gridx = 0;
        i.gridy++;
        i.gridwidth = 1;
        i.ipadx = 100;
        imov.add(iDate, i);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        i.gridx = 1;
        i.gridwidth = 3;
        i.ipadx = 150;
        imov.add(datePicker, i);

        limpar = new JButton(BUTTON_CLEAR);
        limpar.addActionListener(controller);
        i.gridx = 0;
        i.gridy++;
        i.gridwidth = 2;
        i.ipadx = 100;
        imov.add(limpar, i);
        b1 = new JButton(BUTTON_SAVE);
        b1.addActionListener(controller);
        i.gridx = 2;
        i.ipadx = 150;
        imov.add(b1, i);

        labelMensagem = new JLabel();
        labelMensagem.setHorizontalAlignment(JLabel.CENTER);
        i.gridy = +15;
        i.gridx = 0;
        i.gridwidth = 4;
        imov.add(labelMensagem, i);
    }

    public JPanel getPanel() {
        return pCadImovel;
    }
    
    public void clearFields() {
        labelMensagem.setText("");
        tCod.setText("");
        tPreco.setText("");
        textArea.setText("");
        iJB.setSelectedItem("--");
    }
    
    public void showMessage(String message, boolean isError) {
        if (isError) {
            labelMensagem.setForeground(Color.RED);
        } else {
            clearFields();
            labelMensagem.setForeground(Color.GREEN);
        }
        labelMensagem.setText(message);
    }

    public String getTipo() {
          if(iJB.getSelectedItem().toString().equals("--")){
            return null;
            
        } else {
            return iJB.getSelectedItem().toString();
        }
    }

    public String getPreço() {
        return tPreco.getText();
    }

    public Object getDescricao() {
        return textArea.getText();
    }

    public String getCodigo() {
        return tCod.getText();
    }
}
