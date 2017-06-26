/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import trabalhofinalpoo.controllers.CadastroCorretorController;
import trabalhofinalpoo.models.Imovel;

/**
 *
 * @author khazyer
 */
public class MainScreen extends JFrame implements ActionListener, MouseListener {

    //componentes tela principal
    JPanel mainP, pScreen, pCadImovel, pCadCorretor, pCadVenda, pConImoveis, pPagamentos, pRelatorios;
    JMenuBar menuBar;
    JMenu cadastra, consultar, pagamentos, relatorios;
    JMenuItem cadImovel, cadCorretor, cadVenda, conImoveis;
    CardLayout layout;
    
    public MainScreen() {
        mainScreen();
    }
    
    public void mainScreen() {
        layout = new CardLayout();
        pScreen = new JPanel();
        pScreen.setLayout(layout);
        mainP = new JPanel();
        mainP.setLayout(new BorderLayout());
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
        pagamentos.addMouseListener(this);
        menuBar.add(pagamentos);
        relatorios = new JMenu("Relatórios", true);
        relatorios.addMouseListener(this);
        menuBar.add(relatorios);
        mainP.add(menuBar, BorderLayout.PAGE_START);
        //configura card layout
        this.cadCorretor();
        this.cadImovel();
        this.cadVenda();
        this.conImoveis();
        this.pagamentos();
        this.relatorios();
        pScreen.add(pCadImovel, "cadImovel");
        pScreen.add(pCadCorretor, "cadCorretor");
        pScreen.add(pCadVenda, "cadVenda");
        pScreen.add(pConImoveis, "conImoveis");
        pScreen.add(pPagamentos, "pagamentos");
        pScreen.add(pRelatorios, "relatorios");
        mainP.add(pScreen, BorderLayout.CENTER);

        //configuraJFrame
        this.setMinimumSize(new Dimension(800, 600));
        this.add(mainP);
        this.setTitle("Software de Gerenciamento");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void cadImovel() {
        CadastroImovelScreen cadImovelPanel = new CadastroImovelScreen();
        pCadImovel = cadImovelPanel.getpCadImovel();
        
    }
    
    public void cadCorretor() {
        CadastroCorretorScreen cadCorretorPanel = new CadastroCorretorScreen();
        pCadCorretor = cadCorretorPanel.getPanel();
    }
    
    public void cadVenda() {
        CadastroVendaScreen cadVendaPanel = new CadastroVendaScreen();
        pCadVenda = cadVendaPanel.getpCadVenda();
        
    }
    
    public void conImoveis() {
        ConsultaImoveisScreen pConImoveisPanel = new ConsultaImoveisScreen();
        pConImoveis = pConImoveisPanel.getpConImoveis();
    }
    
    public void pagamentos() {
        PagamentosScreen pagamentosPanel = new PagamentosScreen();
        pPagamentos = pagamentosPanel.getpPagamentos();
    }
    
    public void relatorios() {
        RelatoriosScreen relatoriosPanel = new RelatoriosScreen();
        pRelatorios = relatoriosPanel.getpRelatorios();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem aux = (JMenuItem) e.getSource();
        if (e.getSource() == pagamentos) {
            layout.show(pScreen, "pagamentos");
        }
        //sub menus
        switch (aux.getText()) {
            //cadastro imovel
            case "Imóvel":
                layout.show(pScreen, "cadImovel");
                System.out.println(aux.getText());
                break;
            
            case "Corretor":
                layout.show(pScreen, "cadCorretor");
                System.out.println(aux.getText());
                break;
            
            case "Venda":
                layout.show(pScreen, "cadVenda");
                break;
            case "Imóveis":
                layout.show(pScreen, "conImoveis");
                break;
            default:
                break;
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        JMenu aux = (JMenu) e.getSource();
        switch (aux.getText()) {
            case "Pagamentos":
                layout.show(pScreen, "pagamentos");
                break;
            case "Relatórios":
                layout.show(pScreen, "relatorios");
                break;
            default:
                break;
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
