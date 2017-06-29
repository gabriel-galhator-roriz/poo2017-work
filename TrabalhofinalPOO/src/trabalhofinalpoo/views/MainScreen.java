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
    JPanel mainP, pScreen, pCadImovel, pCadCorretor, pCadVenda, pConImoveis, pPagamentos, pRelatorios, pHome;
    JMenuBar menuBar;
    JMenu home, cadastra, consultar, pagamentos, relatorios;
    JMenuItem cadImovel, cadCorretor, cadVenda, conImoveis;
    CardLayout layout;
    //clases das views
    HomeScreen homePanel;
    CadastroImovelScreen cadImovelPanel;
    CadastroCorretorScreen cadCorretorPanel;
    CadastroVendaScreen cadVendaPanel;
    ConsultaImoveisScreen conImoveisPanel;
    PagamentosScreen pagamentosPanel;
    RelatoriosScreen relatoriosPanel;

    public MainScreen(String user) {
        mainScreen(user);
    }

    public void mainScreen(String user) {
        layout = new CardLayout();
        pScreen = new JPanel();
        pScreen.setLayout(layout);
        mainP = new JPanel();
        mainP.setLayout(new BorderLayout());
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        home = new JMenu("Home", true);
        home.addMouseListener(this);
        menuBar.add(home);
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
        this.home(user);
        this.cadCorretor();
        this.cadImovel();
        this.cadVenda();
        this.conImoveis();
        this.pagamentos();
        this.relatorios();
        pScreen.add(pHome, "home");//index = 0
        pScreen.add(pCadImovel, "cadImovel");//index = 1
        pScreen.add(pCadCorretor, "cadCorretor");//index = 2
        pScreen.add(pCadVenda, "cadVenda");//index = 3
        pScreen.add(pConImoveis, "conImoveis");//index = 4
        pScreen.add(pPagamentos, "pagamentos");//index = 5
        pScreen.add(pRelatorios, "relatorios");//index = 6
        mainP.add(pScreen, BorderLayout.CENTER);//index = 7

        //configuraJFrame
        this.setMinimumSize(new Dimension(800, 600));
        this.add(mainP);
        this.setTitle("Software de Gerenciamento");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void home(String user) {
        homePanel = new HomeScreen(user);
        pHome = homePanel.getHome();
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
        conImoveisPanel = new ConsultaImoveisScreen(this);
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
    
    public void callTelaDeVenda(Imovel imovel){
           this.fecharTela();
           layout.show(pScreen, "cadVenda");
           cadVendaPanel.abrirTela();
           cadVendaPanel.setImovel(imovel);
           
           
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
                cadImovelPanel.abrirTela();
                break;

            case "Corretor":
                this.fecharTela();
                layout.show(pScreen, "cadCorretor");
                System.out.println(aux.getText());
                cadCorretorPanel.abrirTela();
                break;

            case "Venda":
                this.fecharTela();
                layout.show(pScreen, "cadVenda");
                cadVendaPanel.abrirTela();
                break;
                
            case "Imóveis":
                this.fecharTela();
                conImoveisPanel.datePicker.setVisible(true);
                layout.show(pScreen, "conImoveis");
                conImoveisPanel.abrirTela();
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
            case "Home":
                this.fecharTela();
                layout.show(pScreen, "home");
                break;
            case "Pagamentos":
                this.fecharTela();
                layout.show(pScreen, "pagamentos");
                pagamentosPanel.abrirTela();
                break;
            case "Relatórios":
                this.fecharTela();
                layout.show(pScreen, "relatorios");
                relatoriosPanel.abrirTela();
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
                homePanel.closeTela();
                break;
            case 1:
                cadImovelPanel.closeTela();
                break;
            case 2:
                cadCorretorPanel.closeTela();
                break;
            case 3:
                cadVendaPanel.closeTela();
                break;
            case 4:
                conImoveisPanel.closeTela();
                break;
            case 5:
                pagamentosPanel.closeTela();
                break;
            case 6:
                relatoriosPanel.closeTela();
                break;
            default:
                break;
        }
    }

    @Override
    public void abrirTela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
