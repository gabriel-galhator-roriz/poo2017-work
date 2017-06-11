/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import trabalhofinalpoo.models.Imovel;

/**
 *
 * @author khazyer
 */
public class MainScreen extends JFrame implements ActionListener, MouseListener {

    //componentes tela principal
    JPanel p, pScreen, pCadImovel, pCadCorretor, pCadVenda, pConImoveis, pPagamentos, pRelatorios;
    JMenuBar menuBar;
    JMenu cadastra, consultar, pagamentos, relatorios;
    JMenuItem cadImovel, cadCorretor, cadVenda, conImoveis;
    CardLayout layout;
    //componentes tela cadastro corretor
    JPanel cPa;
    JLabel cNum, cNome;
    JTextField tNum, tNome;
    String[] str = {"Contratado", "Comissionado"};
    JComboBox cb1 = new JComboBox(str);
    JButton bCad, bReturn;
    

    //tela de relatorio
    JTabbedPane abas;
    JPanel mPanelRelatorio, pFaturaTotal, pLucro, pImoveisVendidos, pImoveisEncalhados, pFaturaPorCorretor, pPagamentoPorCorretor, pCorretorDoMes;

    public MainScreen() {
        mainScreen();
    }

    public void mainScreen() {
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
        pagamentos.addMouseListener(this);
        menuBar.add(pagamentos);
        relatorios = new JMenu("Relatórios", true);
        relatorios.addMouseListener(this);
        menuBar.add(relatorios);
        p.add(menuBar, BorderLayout.PAGE_START);
        //configura abas relatorios
        abas = new JTabbedPane();
        this.faturaTotal();
        this.lucro();
        this.imoveisVendidos();
        this.imoveisEncalhados();
        this.faturaPorCorretor();
        this.pagamentoPorCorretor();
        this.corretorDoMes();
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

    public void relatorios() {
        pRelatorios = new JPanel();
        abas.add("Fatrua Total", pFaturaTotal);
        abas.add("Lucro",pLucro);
        abas.add("Imóveis Vendidos",pImoveisVendidos);
        abas.add("Imóveis Encalhados", pImoveisEncalhados);
        abas.add("Faturamento por Corretor", pFaturaPorCorretor);
        abas.add("Pagamento por Corretor",pPagamentoPorCorretor);
        abas.add("Corretor do Mês",pCorretorDoMes);
        pRelatorios.add(abas, BorderLayout.PAGE_START);

    }

    public void faturaTotal() {
        pFaturaTotal = new JPanel();
        pFaturaTotal.setSize(10,200);
    }

    public void lucro() {
        pLucro = new JPanel();
    }

    public void imoveisVendidos() {
        pImoveisVendidos = new JPanel();
    }

    public void imoveisEncalhados() {
        pImoveisEncalhados = new JPanel();
    }

    public void faturaPorCorretor() {
        pFaturaPorCorretor = new JPanel();
    }

    public void pagamentoPorCorretor() {
        pPagamentoPorCorretor = new JPanel();
    }

    public void corretorDoMes() {
        pCorretorDoMes = new JPanel();
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
