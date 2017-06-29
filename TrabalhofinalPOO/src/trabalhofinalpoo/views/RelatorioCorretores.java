/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import trabalhofinalpoo.controllers.RelatorioCorretoresController;
import trabalhofinalpoo.models.Corretor;
import trabalhofinalpoo.models.Imovel;
import trabalhofinalpoo.models.Venda;

/**
 *
 * @author khazyer
 */
public class RelatorioCorretores implements ActionListener, FechamentoTelas {

    public static final String BUTTON_BUSCAR = "Buscar";
        
    JPanel pCorretores, pConf;
    JLabel lCorretores, lFaturamento, lValorPago, lNomeCorretorDoMes, lCorretorDoMes, lNomeFuncionário, mensagem, lMes, lAno, lVendas;
    JTextField textValorPago, textFaturamento, textCDMValorPago, textCDMFAturamento, textAno, textMes;
    JList listCorretor, listVendas;
    JButton buscar;
    JScrollPane scrollCorretor, scrollVendas;
    GridBagConstraints c;

    RelatorioCorretoresController controller;

    public RelatorioCorretores() {
        controller = new RelatorioCorretoresController(this);
        pCorretores = new JPanel(new BorderLayout());
        pConf = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        c.ipadx = 0;
        c.ipady = 0;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        lCorretores = new JLabel("Relatório Corretores");
        lCorretores.setHorizontalAlignment(JLabel.CENTER);
        pConf.add(lCorretores, c);

        c.gridwidth = 1;
        c.gridy++;
        c.gridx = 0;
        lMes = new JLabel("Mes:");
        pConf.add(lMes, c);
        c.gridx = 1;
        textMes = new JTextField();
        pConf.add(textMes, c);

        c.gridx = 2;
        c.gridwidth = 1;
        lAno = new JLabel("Ano:");
        pConf.add(lAno, c);
        c.gridx = 3;
        textAno = new JTextField();
        pConf.add(textAno, c);

        c.gridwidth = 4;
        c.gridy++;
        c.gridx = 0;
        buscar = new JButton(BUTTON_BUSCAR);
        buscar.addActionListener(controller);
        pConf.add(buscar, c);

        c.ipady = 15;
        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 4;
        mensagem = new JLabel();
        mensagem.setHorizontalAlignment(JLabel.CENTER);
        pConf.add(mensagem, c);

        c.gridy++;
        c.gridwidth = 2;
        c.gridheight = 5;
        c.ipadx = 0;
        listCorretor = new JList();
        scrollCorretor = new JScrollPane(listCorretor, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pConf.add(scrollCorretor, c);

        c.ipady = 0;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        lFaturamento = new JLabel("Faturamento Total:");
        pConf.add(lFaturamento, c);
        c.gridx = 3;
        c.ipadx = 100;
        textFaturamento = new JTextField();
        textFaturamento.setEnabled(false);
        pConf.add(textFaturamento, c);

        c.ipadx = 0;
        c.gridy++;
        c.gridx = 2;
        lValorPago = new JLabel("Valor Pago:");
        pConf.add(lValorPago, c);
        c.gridx = 3;
        c.ipady = 0;
        c.ipadx = 100;
        textValorPago = new JTextField();
        textValorPago.setEditable(false);
        pConf.add(textValorPago, c);

        c.gridx = 2;
        c.gridy++;
        c.gridwidth = 2;
        lVendas = new JLabel("Vendas:");
        pConf.add(lVendas, c);

        c.gridy++;
        c.gridwidth = 1;
        c.gridwidth = 2;
        listVendas = new JList();
        scrollVendas = new JScrollPane(listVendas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pConf.add(scrollVendas, c);

        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy += 30;
        lCorretorDoMes = new JLabel("Corretor do Mês");
        lCorretorDoMes.setHorizontalAlignment(JLabel.CENTER);
        pConf.add(lCorretorDoMes, c);

        c.gridy++;
        lNomeCorretorDoMes = new JLabel("Laércio Baldochi");
        lNomeCorretorDoMes.setHorizontalAlignment(JLabel.CENTER);
        lNomeCorretorDoMes.setFont(new Font("Dialog", Font.PLAIN, 14));
        pConf.add(lNomeCorretorDoMes, c);

        c.ipady = 0;
        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 2;
        c.gridheight = 1;
        lFaturamento = new JLabel("Faturamento Total:");
        lFaturamento.setHorizontalAlignment(JLabel.RIGHT);
        pConf.add(lFaturamento, c);
        c.gridx = 2;
        c.ipadx = 100;
        textCDMFAturamento = new JTextField();
        textCDMFAturamento.setHorizontalAlignment(JTextField.LEFT);
        textCDMFAturamento.setEnabled(false);
        pConf.add(textCDMFAturamento, c);

        c.ipadx = 0;
        c.gridy++;
        c.gridx = 0;
        lValorPago = new JLabel("Valor Pago:");
        lValorPago.setHorizontalAlignment(JLabel.RIGHT);
        pConf.add(lValorPago, c);
        c.gridx = 2;
        c.ipadx = 100;
        textCDMValorPago = new JTextField();
        textCDMValorPago.setHorizontalAlignment(JTextField.LEFT);
        textCDMValorPago.setEnabled(false);
        pConf.add(textCDMValorPago, c);

        pCorretores.add(pConf, BorderLayout.PAGE_START);

    }

    public JPanel getpFaturaPorCorretor() {
        return pCorretores;
    }
    
     public void updateCorretorList(ArrayList<Corretor> novaLista) {
        DefaultListModel modeloLista = new DefaultListModel<Corretor>();
        for (Corretor corretor : novaLista) {   
            modeloLista.addElement(corretor);
        }
        
        listCorretor.setModel(modeloLista);
    }
     
     public void updateVendasList(ArrayList<Venda> novaLista) {
        DefaultListModel modeloLista = new DefaultListModel<Venda>();
        for (Venda venda : novaLista) {
            modeloLista.addElement(venda);
        }
        
        listVendas.setModel(modeloLista);
    }
    
    public void showMessage(String message, boolean isError) {
        if (isError) {
            mensagem.setForeground(Color.RED);
        } else {
            mensagem.setForeground(Color.GREEN);
        }
        mensagem.setText(message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void closeTela() {
    }

    @Override
    public void abrirTela() {
        controller.loadDados();
    }
    
    public String getAno(){
        return textAno.getText();
    }
    
    public String getMes(){
        return textMes.getText();
    }

}
