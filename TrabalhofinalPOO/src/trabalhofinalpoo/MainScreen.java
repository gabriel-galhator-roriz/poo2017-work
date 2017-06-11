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

    JPanel p, pScreen, pCadImovel, pCadCorretor, pCadVenda, pConImoveis, pPagamentos, pRelatorios;
    JMenuBar menuBar;
    JMenu cadastra, consultar, pagamentos, relatorios;
    JMenuItem cadImovel, cadCorretor, cadVenda, conImoveis;
    CardLayout layout;

    public MainScreen() {
        mainScreen();
    }

    public final void mainScreen() {
        layout = new CardLayout();
        pScreen = new JPanel();
        pScreen.setLayout(layout);
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
        conImoveis = new JMenuItem("Imóveis");
        conImoveis.addActionListener(this);
        consultar.add(conImoveis);
        pagamentos = new JMenu("Pagamentos", true);
        pagamentos.addActionListener(this);
        menuBar.add(pagamentos);
        relatorios = new JMenu("Relatórios", true);
        relatorios.addActionListener(this);
        menuBar.add(relatorios);
        p.add(menuBar, BorderLayout.PAGE_START);
        //configura card layout
        this.cadCorretor();
        this.cadImovel();
        this.cadVenda();
        pScreen.add(pCadImovel, "cadImovel");
        pScreen.add(pCadCorretor, "cadCorretor");
        pScreen.add(pCadVenda, "cadVenda");
        p.add(pScreen, BorderLayout.CENTER);
        //configuraJFrame
        this.add(p);
        this.setTitle("Software de Gerenciamento");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void cadImovel() {
        pCadImovel = new JPanel();
        JLabel local = new JLabel(" imovel");
        pCadImovel.add(local);
    }

    public void cadCorretor() {
        pCadCorretor = new JPanel();
        JLabel local = new JLabel(" corretor");
        pCadCorretor.add(local);
    }

    public void cadVenda() {
        pCadVenda = new JPanel();
        JLabel local = new JLabel("venda");
        pCadVenda.add(local);
    }

    public void conImoveis() {
        pConImoveis = new JPanel();
        JLabel local = new JLabel("consulta imovel");
        pConImoveis.add(local);
    }

    public void pagamentos() {
        pPagamentos = new JPanel();
        JLabel local = new JLabel("pagamentos");
        pPagamentos.add(local);
    }

    public void Realatorios() {
        pRelatorios = new JPanel();
        JLabel local = new JLabel("relatorios");
        pRelatorios.add(local);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem aux = (JMenuItem) e.getSource();
        //sub menus
        switch (aux.getText()) {
            //cadastro imovel
            case "Imóvel":
                layout.show(pScreen,"cadImovel" );
                System.out.println(aux.getText());
                break;

            case "Corretor":
                layout.show(pScreen,"cadCorretor");
                System.out.println(aux.getText());
                break;

            case "Venda":
                layout.show(pScreen, "cadVenda");
                System.out.println(aux.getText());
                break;

            default:
                System.out.println(aux.getText());
                break;
        }        
    }

}
