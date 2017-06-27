/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author khazyer
 */
public class ConsultaImoveisScreen {

    JPanel pConImoveis, pOrganize, pConsulta, pEdit;
    JLabel labelConsulta, lTipo1, lTipo2, lCod;
    GridBagConstraints c;

    public ConsultaImoveisScreen() {
        pConImoveis = new JPanel(new BorderLayout());
        pOrganize = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        this.instanceConsulta();
        this.instanceEdit();

        c.ipadx = 300;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);
        c.gridwidth = 2;
        labelConsulta = new JLabel("Consulta Imóveis");
        labelConsulta.setHorizontalAlignment(JLabel.CENTER);
        pOrganize.add(labelConsulta, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        pOrganize.add(pConsulta, c);
        c.gridx = 1;
        c.gridy = 1;
        pOrganize.add(pEdit, c);
        pConImoveis.add(pOrganize, BorderLayout.PAGE_START);
    }

    public void instanceConsulta() {
        pConsulta = new JPanel(new GridBagLayout());
        c.ipadx = 150;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);
    }

    public void instanceEdit() {
        pEdit = new JPanel(new GridBagLayout());
        c.ipadx = 150;
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções
        c.insets = new Insets(10, 10, 10, 10);
    }

    public JPanel getpConImoveis() {
        return pConImoveis;
    }

}
