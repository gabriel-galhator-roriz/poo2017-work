/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author khazyer
 */
public class CadastroImovelScreen implements ActionListener{
    JPanel pCadImovel;
    JLabel local;

    public CadastroImovelScreen() {
        pCadImovel = new JPanel();
        local = new JLabel(" imovel");
        pCadImovel.add(local);
    }

    public JPanel getpCadImovel() {
        return pCadImovel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    
}
