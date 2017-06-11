/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author khazyer
 */
public class MainScreen extends JFrame implements ActionListener {

    JPanel p;
    JMenuBar menuBar;
    JMenu cadastra, consultar, pagamentos, relatorios;
    JMenuItem cadImovel, cadCorretor, cadVenda, imoveis;

    public MainScreen() {
        mainScreen();
    }

    public final void mainScreen() {
        p = new JPanel();
        p.setLayout(new BorderLayout());
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        cadastra = new JMenu("Cadastrar", true);
        menuBar.add(cadastra);
        cadImovel = new JMenuItem("Imóvel");
        cadImovel.addActionListener(this);
        cadCorretor = new JMenuItem("Corretor");
        cadCorretor.addActionListener(this);
        cadVenda = new JMenuItem("Venda");
        cadVenda.addActionListener(this);
        cadastra.add(cadImovel);
        cadastra.add(cadCorretor);
        cadastra.add(cadVenda);
        consultar = new JMenu("Consultar", true);
        menuBar.add(consultar);
        imoveis = new JMenuItem("Imóveis");
        imoveis.addActionListener(this);
        consultar.add(imoveis);
        pagamentos = new JMenu("Pagamentos", true);
        pagamentos.addActionListener(this);
        menuBar.add(pagamentos);
        relatorios = new JMenu("Relatórios", true);
        relatorios.addActionListener(this);
        menuBar.add(relatorios);
        p.add(menuBar, BorderLayout.PAGE_START);
        this.add(p);
        this.setTitle("Software de Gerenciamento");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
