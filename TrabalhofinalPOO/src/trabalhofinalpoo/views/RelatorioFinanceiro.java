/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author khazyer
 */
public class RelatorioFinanceiro implements ActionListener, FechamentoTelas {

    JPanel pFinanceiro, pConf;
    JLabel lFinanceiro, lFaturamento, lLucro, lMes, lAno;
    JTextField textFaturamento, textLucro, textMes, textAno;
    JButton buscar;
    GridBagConstraints c;

    public RelatorioFinanceiro() {
        pFinanceiro = new JPanel();
        pFinanceiro.setLayout(new BorderLayout());
        pConf = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        c.ipadx = 80;
        c.ipady = 0;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);

        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 0;
        lFinanceiro = new JLabel("Financeiro");
        lFinanceiro.setHorizontalAlignment(JLabel.CENTER);
        pConf.add(lFinanceiro, c);

        c.gridwidth = 1;
        c.gridy++;
        c.gridx = 0;
        lMes = new JLabel("Mes:");
        pConf.add(lMes, c);
        c.gridx = 1;
        c.gridwidth = 1;
        textMes = new JTextField();
        pConf.add(textMes, c);

        c.gridx = 2;
        c.gridwidth = 1;
        lAno = new JLabel("Ano:");
        pConf.add(lAno, c);
        c.gridx = 3;
        c.gridwidth = 1;
        textAno = new JTextField();
        pConf.add(textAno, c);

        c.gridwidth = 4;
        c.gridy++;
        c.gridx = 0;
        buscar = new JButton("Buscar");
        //calcular.addActionListener(controler);
        pConf.add(buscar, c);

        c.gridy++;
        c.gridx = 0;
        c.gridwidth = 2;
        lFaturamento = new JLabel("Faturamento Total:");
        pConf.add(lFaturamento, c);

        c.gridx = 2;
        textFaturamento = new JTextField();
        textFaturamento.setEnabled(false);
        pConf.add(textFaturamento, c);

        c.gridy++;
        c.gridx = 0;
        lLucro = new JLabel("Lucro Imobiliária");
        pConf.add(lLucro, c);

        c.gridx = 2;
        textLucro = new JTextField();
        textLucro.setEnabled(false);
        pConf.add(textLucro, c);

        pFinanceiro.add(pConf, BorderLayout.PAGE_START);

    }

    public JPanel getpFaturaTotal() {
        return pFinanceiro;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void closeTela() {
        System.out.println("saiu da tela Relatoio financeiro");
    }

    @Override
    public void abrirTela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
