/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
public class CadastroCorretorScreen {

    public static final String CONTRATADO = "Contratado";
    public static final String COMISSIONADO = "Comissionado";

    public static final String BUTTON_SAVE = "Salvar";

    public static final String JCOMBOX_CATEGORIES = "Categorias";

    JPanel cPa, pCadCorretor, pComissionadoOpt, pContratadoOpt, pCardOpt;
    JLabel cNum, cNome, categoria, labelContratado, labelComissionado;
    JTextField tNum, tNome, textContratado, textComissionado;
    String[] categories = {CONTRATADO, COMISSIONADO};
    JComboBox JComboBoxCategories = new JComboBox(categories);
    JButton bCad, bLimpa;

    CardLayout layout;

    CadastroCorretorController controller;

    public CadastroCorretorScreen() {
        controller = new CadastroCorretorController(this);
        confCard();
        createView();

    }

    public void confCard() {
        layout = new CardLayout();
        pCardOpt = new JPanel();
        pCardOpt.setLayout(layout);
        confContratadoOpt();
        confComissionadoOpt();
        pCardOpt.add(pContratadoOpt, CONTRATADO);
        pCardOpt.add(pComissionadoOpt, COMISSIONADO);

    }

    public JPanel getPanel() {
        return pCadCorretor;
    }

    public void createView() {

        pCardOpt.setLayout(layout);
        pCadCorretor = new JPanel();
        JLabel local = new JLabel(" corretor");
        pCadCorretor.setLayout(new BorderLayout());

        cPa = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);

        categoria = new JLabel("categoria");
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

        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        cPa.add(categoria, c);

        JComboBoxCategories.setSelectedIndex(0);
        JComboBoxCategories.setName(JCOMBOX_CATEGORIES);
        JComboBoxCategories.addActionListener(controller);
        c.gridx = 1;
        c.gridy = 2;
        c.gridheight = 1;
        cPa.add(JComboBoxCategories, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 2;
        c.gridwidth = 2;
        cPa.add(pCardOpt, c);

        bCad = new JButton(BUTTON_SAVE);
        bCad.addActionListener(controller);
        c.gridx = 1;
        c.gridy = 10;
        c.gridwidth = 1;
        cPa.add(bCad, c);

        bLimpa = new JButton("Limpar");
        bLimpa.addActionListener(controller);
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 1;
        cPa.add(bLimpa, c);

        pCadCorretor.add(cPa, BorderLayout.PAGE_START);
    }

    public String getNumeroCRECI() {
        return tNum.getText();
    }

    public String getNome() {
        return tNome.getText();
    }

    public String getTipo() {
        return JComboBoxCategories.getSelectedItem().toString();
    }

    public void confContratadoOpt() {
        pContratadoOpt = new JPanel();
        labelContratado = new JLabel("Salário Fixo");
        textContratado = new JTextField();
        pContratadoOpt.setLayout(new GridLayout(1, 2, 10, 10));
        pContratadoOpt.add(labelContratado);
        pContratadoOpt.add(textContratado);
    }

    public void confComissionadoOpt() {
        pComissionadoOpt = new JPanel();
        labelComissionado = new JLabel("% Comissão");
        textComissionado = new JTextField();
        pComissionadoOpt.setLayout(new GridLayout(1, 2, 10, 10));
        pComissionadoOpt.add(labelComissionado);
        pComissionadoOpt.add(textComissionado);
    }

    public void showContratadoOptions() {
        layout.show(pCardOpt, CONTRATADO);
        System.out.println("Mostrar Informações de Corretores Contratados!");
    }

    public void showComissionadoOptions() {
        layout.show(pCardOpt, COMISSIONADO);
        System.out.println("Mostrar Informações de Corretores Comissionados!");
    }
}
