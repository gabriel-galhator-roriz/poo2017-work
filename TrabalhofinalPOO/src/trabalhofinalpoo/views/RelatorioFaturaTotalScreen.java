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
public class RelatorioFaturaTotalScreen implements ActionListener{

    JPanel pFaturaTotal;

    public RelatorioFaturaTotalScreen() {
        pFaturaTotal = new JPanel();
    }

    public JPanel getpFaturaTotal() {
        return pFaturaTotal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}