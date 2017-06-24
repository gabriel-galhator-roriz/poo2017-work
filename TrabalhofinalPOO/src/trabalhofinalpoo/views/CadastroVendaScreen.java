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
public class CadastroVendaScreen {

    JPanel pCadVenda;
    JLabel local;

    public CadastroVendaScreen() {
        pCadVenda = new JPanel();
        local = new JLabel("venda");
        pCadVenda.add(local);
    }

    public JPanel getpCadVenda() {
        return pCadVenda;
    }

}
