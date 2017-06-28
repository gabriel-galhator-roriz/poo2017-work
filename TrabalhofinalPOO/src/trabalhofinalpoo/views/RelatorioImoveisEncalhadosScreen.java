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
public class RelatorioImoveisEncalhadosScreen implements ActionListener, FechamentoTelas {

    JPanel pImoveisEncalhados;

    public RelatorioImoveisEncalhadosScreen() {
        pImoveisEncalhados = new JPanel();
    }

    public JPanel getpImoveisEncalhados() {
        return pImoveisEncalhados;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void closeTela() {
        System.out.println("saiu da tela relatoio imoveis encalhados");
    }

    @Override
    public void abrirTela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
