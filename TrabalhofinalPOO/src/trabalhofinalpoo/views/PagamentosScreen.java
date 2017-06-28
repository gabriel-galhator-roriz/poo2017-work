/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.*;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author khazyer
 */
public class PagamentosScreen implements FechamentoTelas {

    JPanel pPagamentos, pConf, pCard, pContratado, pComissionado;
    JLabel labelPagamento, lCorretor, lMes, lAno, lVendaRealizadaContratado, lVendaRealizadaComissionado, lValorComissao, lValorComissionado, lSalarioFixo, lTotalRecebido;
    JComboBox boxCorretor;
    JTextField textMes, textAno;
    JButton calcular;
    CardLayout layout;
    GridBagConstraints c;

    public PagamentosScreen() {
        pPagamentos = new JPanel(new BorderLayout());
        this.instaceConf();
        pPagamentos.add(pConf, BorderLayout.PAGE_START);
    }

    public void instaceConf() {
        pConf = new JPanel(new GridBagLayout());
        layout = new CardLayout();
        pCard = new JPanel(layout);
        c = new GridBagConstraints();

        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 80;
        c.ipady = 30;
        c.gridwidth = 4;
        labelPagamento = new JLabel("Gerar Pagamentos");
        labelPagamento.setHorizontalAlignment(JLabel.CENTER);
        pConf.add(labelPagamento, c);

        c.ipady = 0;
        c.gridwidth = 2;
        c.gridy++;
        lCorretor = new JLabel("Corretor:");
        pConf.add(lCorretor, c);
        c.gridx = 2;
        c.gridwidth = 2;
        boxCorretor = new JComboBox();
        pConf.add(boxCorretor, c);

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
        calcular = new JButton("Calcular");
        //calcular.addActionListener(controler);
        pConf.add(calcular, c);

        this.instanceComissionado();
        this.instanceContratado();
        pCard.add(pContratado, "contratado");
        pCard.add(pComissionado, "comissionado");

        c.gridy = 5;
        c.gridx = 0;
        c.gridwidth = 4;
        pConf.add(pCard, c);

    }

    public void instanceContratado() {
        pContratado = new JPanel(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;
        lVendaRealizadaComissionado = new JLabel("venda realizada comissionado");
        lVendaRealizadaComissionado.setHorizontalAlignment(JLabel.CENTER);
        pContratado.add(lVendaRealizadaComissionado, c);

        c.gridy++;
        lValorComissao = new JLabel("Valor Comissão");
        lValorComissao.setHorizontalAlignment(JLabel.CENTER);
        pContratado.add(lValorComissao);
    }

    public void instanceComissionado() {
        pComissionado = new JPanel(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;
        lVendaRealizadaContratado = new JLabel("venda realizada contratado");
        lVendaRealizadaContratado.setHorizontalAlignment(JLabel.CENTER);
        pComissionado.add(lVendaRealizadaContratado, c);

        c.gridy++;
        lValorComissionado = new JLabel("valor comissionado");
        lValorComissionado.setHorizontalAlignment(JLabel.CENTER);
        pComissionado.add(lValorComissionado, c);

        c.gridy++;
        lSalarioFixo = new JLabel("salário fixo");
        lSalarioFixo.setHorizontalAlignment(JLabel.CENTER);
        pComissionado.add(lSalarioFixo, c);

        c.gridy++;
        lTotalRecebido = new JLabel("total recebido");
        lTotalRecebido.setHorizontalAlignment(JLabel.CENTER);
        pComissionado.add(lTotalRecebido, c);
    }

    public JPanel getpPagamentos() {
        return pPagamentos;
    }

    @Override
    public void closeTela() {
        System.out.println("saiu da tela pagamentosScreen");
    }

    @Override
    public void abrirTela() {
        //
    }

}
