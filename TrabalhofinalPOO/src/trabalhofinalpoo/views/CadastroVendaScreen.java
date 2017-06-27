/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.*;

/**
 *
 * @author khazyer
 */
public class CadastroVendaScreen {

    JPanel pCadVenda;
    JLabel local;
    private JComboBox<String> iJB1;
    private JFormattedTextField iJTDate;
    private JTextField iTCod;
    private JTextField iTComp;
    private JTextField iTValor;
    private JTextField iTVend;
    private JPanel jPanel1;
    private JButton vB1;
    private JButton vB2;
    private JLabel vCod, vData, vNComp, vNVend, vReal, vTipo;
    
    public CadastroVendaScreen() {
        pCadVenda = new JPanel();
        local = new JLabel("venda");
        pCadVenda.add(local);
        GridBagConstraints v;
        jPanel1 = new javax.swing.JPanel();
        vCod = new javax.swing.JLabel();
        vTipo = new javax.swing.JLabel();
        vReal = new javax.swing.JLabel();
        vNComp = new javax.swing.JLabel();
        vData = new javax.swing.JLabel();
        vNVend = new javax.swing.JLabel();
        vB1 = new javax.swing.JButton();
        vB2 = new javax.swing.JButton();
        iTCod = new javax.swing.JTextField();
        iTValor = new javax.swing.JTextField();
        iTComp = new javax.swing.JTextField();
        iTVend = new javax.swing.JTextField();
        iJB1 = new javax.swing.JComboBox<>();
        iJTDate = new javax.swing.JFormattedTextField();

        jPanel1.setLayout(new java.awt.GridBagLayout());

        vCod.setText("Cod:");
        v = new java.awt.GridBagConstraints();
        v.gridx = 0;
        v.gridy = 0;
        v.anchor = java.awt.GridBagConstraints.NORTHWEST;
        v.insets = new java.awt.Insets(43, 12, 0, 0);
        jPanel1.add(vCod, v);

        vTipo.setText("Tipo:");
        v.gridx = 16;
        v.gridy = 0;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(43, 18, 0, 0);
        jPanel1.add(vTipo, v);

        vReal.setText("Valor:");
        v.gridx = 0;
        v.gridy = 3;
        v.gridwidth = 2;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(54, 12, 0, 0);
        jPanel1.add(vReal, v);

        vNComp.setText("Nome Comprador:");
        v.gridx = 0;
        v.gridy = 5;
        v.gridwidth = 6;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(63, 12, 0, 0);
        jPanel1.add(vNComp, v);

        vData.setText("Data:");
        v.gridx = 16;
        v.gridy = 5;
        v.gridwidth = 2;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(63, 18, 0, 0);
        jPanel1.add(vData, v);

        vNVend.setText("Vendedor:");
        v.gridx = 0;
        v.gridy = 7;
        v.gridwidth = 3;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(60, 12, 0, 0);
        jPanel1.add(vNVend, v);

        vB1.setText("Confirmar");
        v.gridx = 0;
        v.gridy = 9;
        v.gridwidth = 4;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(31, 12, 36, 0);
        jPanel1.add(vB1, v);

        vB2.setText("Cancelar");
        v.gridx = 16;
        v.gridy = 9;
        v.gridwidth = 3;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(31, 16, 36, 0);
        jPanel1.add(vB2, v);
        v.gridx = 2;
        v.gridy = 0;
        v.gridwidth = 7;
        v.gridheight = 2;
        v.ipadx = 161;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(41, 2, 0, 0);
        jPanel1.add(iTCod, v);
        v.gridx = 2;
        v.gridy = 3;
        v.gridwidth = 7;
        v.gridheight = 2;
        v.ipadx = 161;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(52, 2, 0, 0);
        jPanel1.add(iTValor, v);
        v.gridx = 8;
        v.gridy = 5;
        v.gridwidth = 8;
        v.gridheight = 2;
        v.ipadx = 355;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(61, 12, 0, 0);
        jPanel1.add(iTComp, v);
        v.gridx = 3;
        v.gridy = 7;
        v.gridwidth = 13;
        v.gridheight = 2;
        v.ipadx = 408;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(58, 12, 0, 0);
        jPanel1.add(iTVend, v);

        iJB1.setModel(new DefaultComboBoxModel<>(new String[] { "Apartamento", "Casa", "Lote", "Chácara","Fazenda" }));
        v.gridx = 18;
        v.gridy = 0;
        v.gridwidth = 4;
        v.gridheight = 3;
        v.ipadx = 77;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(38, 8, 0, 12);
        jPanel1.add(iJB1, v);
        
        v.gridx = 18;
        v.gridy = 5;
        v.gridwidth = 4;
        v.gridheight = 2;
        v.ipadx = 140;
        v.anchor = GridBagConstraints.NORTHWEST;
        v.insets = new Insets(61, 12, 0, 12);
        jPanel1.add(iJTDate, v);
        
        pCadVenda.add(jPanel1);
    
    }

    public JPanel getpCadVenda() {
        return pCadVenda;
    }

}
