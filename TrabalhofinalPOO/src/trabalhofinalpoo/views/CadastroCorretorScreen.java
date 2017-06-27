/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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
    public static final String BUTTON_CLEAR = "Limpar";

    public static final String JCOMBOX_CATEGORIES = "Categorias";

    JPanel cPa, pCadCorretor, pComissionadoOpt, pContratadoOpt, pCardOpt;
    JLabel labelCorretor, cNum, cNome, categoria, labelSalarioFixo, labelPorcentagemComissionada, labelMensagem;
    JTextField tNum, tNome, txtSalarioFixo, txtPorcentagemComissionada;
    String[] categories = {CONTRATADO, COMISSIONADO};
    JComboBox JComboBoxCategories = new JComboBox(categories);
    JButton bCad, bLimpa;

    CardLayout layout;

    CadastroCorretorController controller;

    public CadastroCorretorScreen() {
        controller = new CadastroCorretorController(this);
        confCard();
        instanceCadCorretor();

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

    public void instanceCadCorretor() {

        pCardOpt.setLayout(layout);
        pCadCorretor = new JPanel();
        pCadCorretor.setLayout(new BorderLayout());

        cPa = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);
        c.ipadx = 150;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        labelCorretor = new JLabel("Cadastro de Corretor");
        labelCorretor.setHorizontalAlignment(JLabel.CENTER);
        cPa.add(labelCorretor, c);

        c.gridy++;
        c.gridwidth = 1;
        cNum = new JLabel("Número CRECI");
        cPa.add(cNum, c);
        tNum = new JTextField();
        c.gridx = 1;
        cPa.add(tNum, c);

        c.gridx = 0;
        c.gridy++;
        cNome = new JLabel("Nome");
        cPa.add(cNome, c);
        tNome = new JTextField();
        c.gridx = 1;
        cPa.add(tNome, c);

        categoria = new JLabel("Categoria:");
        c.gridx = 0;
        c.gridy++;
        cPa.add(categoria, c);
        JComboBoxCategories.setSelectedIndex(0);
        JComboBoxCategories.setName(JCOMBOX_CATEGORIES);
        JComboBoxCategories.addActionListener(controller);
        c.gridx = 1;
        cPa.add(JComboBoxCategories, c);

        c.gridx = 0;
        c.gridy++;
        c.gridheight = 2;
        c.gridwidth = 2;
        cPa.add(pCardOpt, c);

        bLimpa = new JButton("Limpar");
        bLimpa.addActionListener(controller);
        c.gridx = 0;
        c.gridy = +6;
        c.gridwidth = 1;
        cPa.add(bLimpa, c);
        bCad = new JButton(BUTTON_SAVE);
        bCad.addActionListener(controller);
        c.gridx = 1;
        cPa.add(bCad, c);

        labelMensagem = new JLabel();
        labelMensagem.setHorizontalAlignment(JLabel.CENTER);
        c.gridx = 0;
        c.gridy = +10;
        c.gridwidth = 3;
        cPa.add(labelMensagem, c);

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
        labelSalarioFixo = new JLabel("Salário Fixo");
        txtSalarioFixo = new JTextField();
        pContratadoOpt.setLayout(new GridLayout(1, 2, 10, 10));
        pContratadoOpt.add(labelSalarioFixo);
        pContratadoOpt.add(txtSalarioFixo);
    }

    public void confComissionadoOpt() {
        pComissionadoOpt = new JPanel();
        labelPorcentagemComissionada = new JLabel("% Comissão");
        txtPorcentagemComissionada = new JTextField();

        pComissionadoOpt.setLayout(new GridLayout(1, 2, 10, 10));
        pComissionadoOpt.add(labelPorcentagemComissionada);
        pComissionadoOpt.add(txtPorcentagemComissionada);
    }

    public String getPorcentagemComissionada() {
        return txtPorcentagemComissionada.getText();
    }

    public String getSalarioFixo() {
        return txtSalarioFixo.getText();
    }

    public void showContratadoOptions() {
        layout.show(pCardOpt, CONTRATADO);
    }

    public void showComissionadoOptions() {
        layout.show(pCardOpt, COMISSIONADO);
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

    public void clearFields() {
        labelMensagem.setText("");
        tNum.setText("");
        tNome.setText("");
        txtPorcentagemComissionada.setText("");
        txtSalarioFixo.setText("");
    }
}
