/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.*;
import javax.swing.*;
import trabalhofinalpoo.controllers.CadastroVendaController;

/**
 *
 * @author khazyer
 */
public class CadastroVendaScreen {

    JPanel pCadVenda, pCad;
    JLabel labelCadVenda, lNomeComprador, lValorVenda, lCorretor, lImovel, labelMensagem;
    JTextField textNomeComprador, textValorVenda;
    JComboBox boxCorretor, boxImovel;
    JButton limpar, cadastrar;
    GridBagConstraints c;

    CadastroVendaController controller;

    public CadastroVendaScreen() {
        controller = new CadastroVendaController(this);
        this.confPanel();

    }

    public void confPanel() {
        pCadVenda = new JPanel();
        pCadVenda.setLayout(new BorderLayout());
        pCad = new JPanel();
        pCad.setLayout(new GridBagLayout());

        labelCadVenda = new JLabel("Cadastro de Venda");
        labelCadVenda.setHorizontalTextPosition(SwingConstants.CENTER);
        lNomeComprador = new JLabel("Nome Comprador:");
        lValorVenda = new JLabel("Valor da Venda");
        lCorretor = new JLabel("Corretor:");
        lImovel = new JLabel("Imovel");
        labelMensagem = new JLabel("mensagem");

        textNomeComprador = new JTextField();
        textValorVenda = new JTextField();

        String[] cat1 = {"joão", "Maria", "José"};
        boxCorretor = new JComboBox(cat1);
        boxCorretor.addActionListener(controller);
        String[] cat2 = {"AP 125", "Casa Branca", "Kitnet 106"};
        boxImovel = new JComboBox(cat2);
        boxImovel.addActionListener(controller);

        limpar = new JButton("Limpar");
        limpar.addActionListener(controller);
        cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(controller);

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        //c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        pCad.add(labelCadVenda, c);

        c.gridx = 0;
        c.gridy++;
        c.gridheight = 1;
        c.gridwidth = 1;
        pCad.add(lNomeComprador, c);
        c.gridx = 1;
        pCad.add(textNomeComprador, c);

        c.gridx = 0;
        c.gridy++;
        pCad.add(lImovel, c);
        c.gridx = 1;
        pCad.add(boxImovel, c);

        c.gridx = 0;
        c.gridy++;
        pCad.add(lValorVenda, c);
        c.gridx = 1;
        pCad.add(textValorVenda, c);

        c.gridx = 0;
        c.gridy++;
        pCad.add(lCorretor, c);
        c.gridx = 1;
        pCad.add(boxCorretor, c);

        c.gridx = 1;
        c.gridy = 10;
        pCad.add(limpar, c);
        c.gridx = 0;
        pCad.add(cadastrar);

        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 2;
        pCad.add(labelMensagem);
        pCadVenda.add(pCad, BorderLayout.PAGE_START);
    }

    public JPanel getPanel() {
        return pCadVenda;
    }

}
