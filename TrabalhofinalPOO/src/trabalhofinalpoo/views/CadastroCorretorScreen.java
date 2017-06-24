/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author khazyer
 */
public class CadastroCorretorScreen implements ActionListener{
    //componentes tela cadastro corretor
    JPanel cPa,pCadCorretor;
    JLabel cNum, cNome;
    JTextField tNum, tNome;
    String[] str = {"Contratado", "Comissionado"};
    JComboBox cb1 = new JComboBox(str);
    JButton bCad, bReturn;

    public CadastroCorretorScreen() {
        pCadCorretor = new JPanel();
        JLabel local = new JLabel(" corretor");
        pCadCorretor.setLayout(new BorderLayout());
        
        cPa = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH; // Preencher nas duas direções

        cNum = new JLabel("Número CRECI");
        cPa.add(cNum, c);
        c.gridheight = 1;
        cNome = new JLabel("Nome");
        c.gridy = 1;
        c.gridheight = 1;
        cPa.add(cNome, c);
        tNum = new JTextField();
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        c.ipadx = 150;
        cPa.add(tNum, c);
        tNome = new JTextField();
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        cPa.add(tNome, c);
        cb1.setSelectedIndex(1);
        cb1.addActionListener(this);
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        cPa.add(cb1, c);
        bCad = new JButton("Salvar");
        c.gridx = 0;
        c.gridy = 4;
        cPa.add(bCad, c);
        bReturn = new JButton("Voltar");
        c.gridx = 1;
        c.gridy = 4;
        cPa.add(bReturn, c);
        pCadCorretor.add(cPa, BorderLayout.PAGE_START);
    }

    public JPanel getpCadCorretor() {
        return pCadCorretor;
    }
 
            

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    
    
}
