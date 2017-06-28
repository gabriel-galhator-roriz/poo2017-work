/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author khazyer
 */
public class RelatorioFinanceiro implements ActionListener, FechamentoTelas {

    JPanel pFinanceiro,pConf;
    GridBagConstraints c;

    public RelatorioFinanceiro() {
        pFinanceiro = new JPanel();
        pFinanceiro.setLayout(new BorderLayout());
        pConf = new JPanel(new GridBagLayout());
        c.ipadx = 0;
        c.ipady = 0;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);
        
        
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

}
