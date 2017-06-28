/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author khazyer
 */
public class RelatoriosScreen implements ActionListener, FechamentoTelas {

    Toolkit tk;
    Dimension dimensao;

    //tela de relatorio
    JTabbedPane abas;
    JPanel pRelatorios, pFinanceiro, pLucro, pImoveisVendidos, pImoveisEncalhados, pCorretores, pPagamentoPorCorretor, pCorretorDoMes;

    public RelatoriosScreen() {
        //pega dados sobre o tamanho da tela
        this.tk = Toolkit.getDefaultToolkit();
        dimensao = tk.getScreenSize();
        //configura abas relatorios
        abas = new JTabbedPane();
        this.financeiro();
        this.imoveisVendidos();
        this.imoveisEncalhados();
        this.corretores();
        pRelatorios = new JPanel();
        abas.add("Finaceiro", pFinanceiro);
        abas.add("Imóveis Vendidos", pImoveisVendidos);
        abas.add("Imóveis Encalhados", pImoveisEncalhados);
        abas.add("Corretores", pCorretores);
        pRelatorios.add(abas);
    }

    public JPanel getpRelatorios() {
        return pRelatorios;
    }

    public void financeiro() {
        RelatorioFinanceiro financeiro = new RelatorioFinanceiro();
        pFinanceiro = financeiro.getpFaturaTotal();
        pFinanceiro.setPreferredSize(dimensao);
    }

    public void imoveisVendidos() {
        RelatorioImoveisVendidos imoveisVendidosPanel = new RelatorioImoveisVendidos();
        pImoveisVendidos = imoveisVendidosPanel.getpImoveisVendidos();
        pImoveisVendidos.setPreferredSize(dimensao);
    }

    public void imoveisEncalhados() {
        RelatorioImoveisEncalhadosScreen imoveisEncalhadosPanel = new RelatorioImoveisEncalhadosScreen();
        pImoveisEncalhados = imoveisEncalhadosPanel.getpImoveisEncalhados();
        pImoveisEncalhados.setPreferredSize(dimensao);
    }

    public void corretores() {
        RelatorioCorretores corretores = new RelatorioCorretores();
        pCorretores = corretores.getpFaturaPorCorretor();
        pCorretores.setPreferredSize(dimensao);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void closeTela() {
        System.out.println("saiu da tela Relatorios screen");
    }

    @Override
    public void abrirTela() {
        //
    }

}
