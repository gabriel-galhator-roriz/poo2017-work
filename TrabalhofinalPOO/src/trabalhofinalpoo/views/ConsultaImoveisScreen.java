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
public class ConsultaImoveisScreen {

    JPanel pConImoveis;
    JLabel local;

    public ConsultaImoveisScreen() {
        pConImoveis = new JPanel();
        local = new JLabel("consulta imovel");
        pConImoveis.add(local);
    }

    public JPanel getpConImoveis() {
        return pConImoveis;
    }

}
