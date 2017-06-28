/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author khazyer
 */
public class RelatorioPagamento implements ActionListener, FechamentoTelas {

    JPanel pFaturaPorCorretor;

    public RelatorioPagamento() {
        pFaturaPorCorretor = new JPanel();
    }

    public JPanel getpFaturaPorCorretor() {
        return pFaturaPorCorretor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void closeTela() {
        System.out.println("saiu da tela Relatorio pagamentos");
    }

}
