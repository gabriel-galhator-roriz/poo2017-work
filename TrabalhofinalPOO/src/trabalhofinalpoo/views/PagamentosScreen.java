/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author khazyer
 */
public class PagamentosScreen {

    JPanel pPagamentos;
    JLabel local;

    public PagamentosScreen() {
        pPagamentos = new JPanel();
        local = new JLabel("pagamentos");
        pPagamentos.add(local);
    }

    public JPanel getpPagamentos() {
        return pPagamentos;
    }

}
