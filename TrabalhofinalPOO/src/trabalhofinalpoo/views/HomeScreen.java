/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author khazyer
 */
public class HomeScreen implements FechamentoTelas {

    JPanel home;
    JLabel wellcome;

    public HomeScreen(String nome) {
        home = new JPanel(new BorderLayout());
        wellcome = new JLabel("Bem vindo, " + nome + ".");
        wellcome.setHorizontalAlignment(JLabel.CENTER);
        home.add(wellcome, BorderLayout.CENTER);
    }

    public JPanel getHome() {
        return home;
    }

    public JLabel getWellcome() {
        return wellcome;
    }

    @Override
    public void closeTela() {
        System.out.println("saindo da home screen");
    }

    @Override
    public void abrirTela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
