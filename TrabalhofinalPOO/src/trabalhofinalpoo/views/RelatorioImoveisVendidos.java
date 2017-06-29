/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import trabalhofinalpoo.controllers.ConsultaImoveisController;
import trabalhofinalpoo.controllers.RelatorioImoveisVendidosController;
import trabalhofinalpoo.models.DateLabelFormatter;
import trabalhofinalpoo.models.Imovel;
import static trabalhofinalpoo.views.ConsultaImoveisScreen.BUTTON_REMOVE;
import static trabalhofinalpoo.views.ConsultaImoveisScreen.BUTTON_RESTAURAR;
import static trabalhofinalpoo.views.ConsultaImoveisScreen.BUTTON_SALVAR;
import static trabalhofinalpoo.views.ConsultaImoveisScreen.BUTTON_VENDER;
import static trabalhofinalpoo.views.ConsultaImoveisScreen.COMBOBOX_TIPOS_CONSULTA;
import static trabalhofinalpoo.views.ConsultaImoveisScreen.COMBOBOX_TIPOS_EDIT;

/**
 *
 * @author khazyer
 */
public class RelatorioImoveisVendidos implements FechamentoTelas {

    JPanel pImoveisVendidos, pOrganize, pConsulta, pEdit;
    JLabel labelConsulta, lLista, labelImovel, labelMensagemConsulta, labelMensagemEdit, lTipo1, lTipo2, lCod, lDesc, lPreco, lDate, lMes, lAno, mensagem;
    JTextField textCod, textPreco, textData, textMes, textAno;
    JTextArea textArea2;
    JButton buscar;
    JScrollPane scrollPane1, scrollPane2;
    JComboBox box2;
    DefaultComboBoxModel comboBoxTipoEditModel, comboBoxTipoConsultaModel;
    JList lista;
    DefaultListModel itensLista;
    GridBagConstraints c;

    RelatorioImoveisVendidosController controller;

    public RelatorioImoveisVendidos() {
        controller = new RelatorioImoveisVendidosController(this);

        pImoveisVendidos = new JPanel(new BorderLayout());
        pOrganize = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        instanceConsulta();
        instanceEdit();
        c.ipadx = 0;
        c.ipady = 0;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);

        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 0;
        labelConsulta = new JLabel("Imóveis Vendidos");
        labelConsulta.setHorizontalAlignment(JLabel.CENTER);
        pOrganize.add(labelConsulta, c);

        c.gridwidth = 1;
        c.gridy++;
        c.gridx = 0;
        lMes = new JLabel("Mes:");
        pOrganize.add(lMes, c);
        c.gridx = 1;
        c.gridwidth = 1;
        textMes = new JTextField();
        pOrganize.add(textMes, c);

        c.gridx = 2;
        c.gridwidth = 1;
        lAno = new JLabel("Ano:");
        pOrganize.add(lAno, c);
        c.gridx = 3;
        c.gridwidth = 1;
        textAno = new JTextField();
        pOrganize.add(textAno, c);

        c.gridwidth = 4;
        c.gridy++;
        c.gridx = 0;
        buscar = new JButton("Buscar");
        //calcular.addActionListener(controler);
        pOrganize.add(buscar, c);

        c.gridx = 0;
        c.gridy += 15;
        c.ipady = 15;
        c.gridwidth = 4;
        mensagem = new JLabel("mensagem");
        mensagem.setHorizontalAlignment(JLabel.CENTER);
        pOrganize.add(mensagem, c);

        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 2;
        pOrganize.add(pConsulta, c);
        c.gridx = 2;
        pOrganize.add(pEdit, c);

        pImoveisVendidos.add(pOrganize, BorderLayout.PAGE_START);
    }

    public void instanceConsulta() {
        pConsulta = new JPanel(new GridBagLayout());
        c.ipadx = 150;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);

        c.gridy++;
        lLista = new JLabel("Lista Imóveis:");
        pConsulta.add(lLista, c);

        c.gridy++;
        c.ipady = 100;
        lista = new JList();
        //lista = new JList(showedImoveis.toArray());
        //showOnlySpecificTipo(boxTiposConsulta.getSelectedItem().toString());
        //lista.addListSelectionListener(controller);
        lista.setBorder(BorderFactory.createEtchedBorder());
        scrollPane1 = new JScrollPane(lista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pConsulta.add(scrollPane1, c);
    }

    public void instanceEdit() {
        pEdit = new JPanel(new GridBagLayout());

        c.ipadx = 100;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);

        //Painel do Cadastro de Imovel        
        pEdit.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        c.ipadx = 150;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        labelImovel = new JLabel("Informações Imóvel");
        labelImovel.setHorizontalAlignment(JLabel.CENTER);
        pEdit.add(labelImovel, c);

        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 2;
        c.ipadx = 100;
        lCod = new JLabel("Cod:");
        pEdit.add(lCod, c);
        lTipo2 = new JLabel("Tipo:");
        c.gridx = 2;
        c.ipadx = 150;
        pEdit.add(lTipo2, c);

        textCod = new JTextField(20);
        textCod.setEnabled(false);
        c.gridx = 0;
        c.gridy++;
        c.ipadx = 100;
        pEdit.add(textCod, c);
        comboBoxTipoEditModel = new DefaultComboBoxModel();
        box2 = new JComboBox(comboBoxTipoEditModel);
        box2.setName(COMBOBOX_TIPOS_EDIT);
        box2.setEnabled(false);
        c.gridx = 2;
        c.ipadx = 150;
        pEdit.add(box2, c);

        lDesc = new JLabel("Descrição:");
        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 1;
        c.ipadx = 100;
        pEdit.add(lDesc, c);
        textArea2 = new JTextArea();
        textArea2.setEnabled(false);
        textArea2.setBorder(BorderFactory.createEtchedBorder());
        scrollPane2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        c.gridx = 1;
        c.gridwidth = 3;
        c.ipadx = 150;
        c.ipady = 50;
        pEdit.add(scrollPane2, c);
        c.ipady = 0;

        lPreco = new JLabel("Preço:");
        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 1;
        c.ipadx = 100;
        pEdit.add(lPreco, c);
        textPreco = new JTextField();
        textPreco.setEnabled(false);
        c.gridx = 1;
        c.gridwidth = 3;
        c.ipadx = 150;
        pEdit.add(textPreco, c);

        lDate = new JLabel("Data:");
        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 1;
        c.ipadx = 100;
        pEdit.add(lDate, c);
        textData = new JTextField();
        textData.setEnabled(false);
        Properties p = new Properties();
        c.gridx = 1;
        c.gridwidth = 3;
        c.ipadx = 150;
        pEdit.add(textData, c);
    }

    public JPanel getpConImoveis() {
        return pImoveisVendidos;
    }

    public void showMessageConsulta(String message, boolean isError) {
        if (isError) {
            labelMensagemConsulta.setForeground(Color.RED);
        } else {
            labelMensagemConsulta.setForeground(Color.GREEN);
        }
        labelMensagemConsulta.setText(message);
    }

    public void showMessageEdit(String message, boolean isError) {
        if (isError) {
            labelMensagemEdit.setForeground(Color.RED);
        } else {
            labelMensagemEdit.setForeground(Color.GREEN);
        }
        labelMensagemEdit.setText(message);
    }

    private void clearFields() {
        ///
    }

    public void changeVisibleEdit(boolean visible) {
        pEdit.setVisible(visible);
    }

    @Override
    public void closeTela() {

    }

    JPanel getpImoveisVendidos() {
        return pImoveisVendidos;
    }

    @Override
    public void abrirTela() {
        controller.loadDados();
    }
}
