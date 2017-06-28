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
public class MainScreen extends JFrame implements ActionListener, MouseListener, FechamentoTelas {

    //componentes tela principal
    JPanel mainP, pScreen, pCadImovel, pCadCorretor, pCadVenda, pConImoveis, pPagamentos, pRelatorios;
    JMenuBar menuBar;
    JMenu cadastra, consultar, pagamentos, relatorios;
    JMenuItem cadImovel, cadCorretor, cadVenda, conImoveis;
    CardLayout layout;
    //clases das views
    CadastroImovelScreen cadImovelPanel;
    CadastroCorretorScreen cadCorretorPanel;
    CadastroVendaScreen cadVendaPanel;
    ConsultaImoveisScreen conImoveisPanel;
    PagamentosScreen pagamentosPanel;
    RelatoriosScreen relatoriosPanel;

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
        pScreen.add(pCadImovel, "cadImovel");//index = 0
        pScreen.add(pCadCorretor, "cadCorretor");//index = 1
        pScreen.add(pCadVenda, "cadVenda");//index = 2
        pScreen.add(pConImoveis, "conImoveis");//index = 3
        pScreen.add(pPagamentos, "pagamentos");//index = 4
        pScreen.add(pRelatorios, "relatorios");//index = 5
        mainP.add(pScreen, BorderLayout.CENTER);//index = 6

        //configuraJFrame
        this.setMinimumSize(new Dimension(800, 600));
        this.add(mainP);
        this.setTitle("Software de Gerenciamento");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void cadImovel() {
        cadImovelPanel = new CadastroImovelScreen();
        pCadImovel = cadImovelPanel.getPanel();

    }

    public void cadCorretor() {
        cadCorretorPanel = new CadastroCorretorScreen();
        pCadCorretor = cadCorretorPanel.getPanel();
    }

    public void cadVenda() {
        cadVendaPanel = new CadastroVendaScreen();
        pCadVenda = cadVendaPanel.getPanel();

    }

    public void conImoveis() {
        conImoveisPanel = new ConsultaImoveisScreen();
        pConImoveis = conImoveisPanel.getpConImoveis();
    }

    public void pagamentos() {
        pagamentosPanel = new PagamentosScreen();
        pPagamentos = pagamentosPanel.getpPagamentos();
    }

    public void relatorios() {
        relatoriosPanel = new RelatoriosScreen();
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
                this.fecharTela();
                cadImovelPanel.datePicker.setVisible(true);
                layout.show(pScreen, "cadImovel");
                System.out.println(aux.getText());
                break;

            case "Corretor":
                this.fecharTela();
                layout.show(pScreen, "cadCorretor");
                System.out.println(aux.getText());
                break;

            case "Venda":
                this.fecharTela();
                layout.show(pScreen, "cadVenda");
                break;
            case "Imóveis":
                this.fecharTela();
                conImoveisPanel.datePicker.setVisible(true);
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
                this.fecharTela();
                layout.show(pScreen, "pagamentos");
                break;
            case "Relatórios":
                this.fecharTela();
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

    @Override
    public void closeTela() {
        System.out.println("saiu da tela mainScreen");
    }

    public void fecharTela() {
        Integer indice = 0;
        for (Component comp : pScreen.getComponents()) {
            if (comp.isVisible() == true) {
                indice = pScreen.getComponentZOrder(comp);
            }
        }
        switch (indice) {
            case 0:
                cadImovelPanel.closeTela();
                break;
            case 1:
                cadCorretorPanel.closeTela();
                break;
            case 2:
                cadVendaPanel.closeTela();
                break;
            case 3:
                conImoveisPanel.closeTela();
                break;
            case 4:
                pagamentosPanel.closeTela();
                break;
            case 5:
                relatoriosPanel.closeTela();
                break;
        }
    }
}
