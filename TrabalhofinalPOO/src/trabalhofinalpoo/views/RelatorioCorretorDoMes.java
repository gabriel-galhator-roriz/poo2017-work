/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author khazyer
 */
public class RelatorioCorretorDoMes implements ActionListener, FechamentoTelas {

    JPanel pCorretorDoMes;

    public RelatorioCorretorDoMes() {
        pCorretorDoMes = new JPanel();
    }

    public JPanel getpCorretorDoMes() {
        return pCorretorDoMes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void closeTela() {
        System.out.println("saiu da tela Relatorio corretor do mes");
    }

}
