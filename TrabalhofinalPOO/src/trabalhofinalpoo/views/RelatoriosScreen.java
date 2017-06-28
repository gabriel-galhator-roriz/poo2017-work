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
    JPanel pRelatorios, pFaturaTotal, pLucro, pImoveisVendidos, pImoveisEncalhados, pFaturaPorCorretor, pPagamentoPorCorretor, pCorretorDoMes;

    public RelatoriosScreen() {
        //pega dados sobre o tamanho da tela
        this.tk = Toolkit.getDefaultToolkit();
        dimensao = tk.getScreenSize();
        //configura abas relatorios
        abas = new JTabbedPane();
        this.faturaTotal();
        this.lucro();
        this.imoveisVendidos();
        this.imoveisEncalhados();
        this.faturaPorCorretor();
        this.pagamentoPorCorretor();
        this.corretorDoMes();
        pRelatorios = new JPanel();
        abas.add("Fatura Total", pFaturaTotal);
        abas.add("Lucro", pLucro);
        abas.add("Imóveis Vendidos", pImoveisVendidos);
        abas.add("Imóveis Encalhados", pImoveisEncalhados);
        abas.add("Faturamento por Corretor", pFaturaPorCorretor);
        abas.add("Pagamento por Corretor", pPagamentoPorCorretor);
        abas.add("Corretor do Mês", pCorretorDoMes);
        pRelatorios.add(abas);
    }

    public JPanel getpRelatorios() {
        return pRelatorios;
    }

    public void faturaTotal() {
        RelatorioFaturaTotalScreen faturaTotalPanel = new RelatorioFaturaTotalScreen();
        pFaturaTotal = faturaTotalPanel.getpFaturaTotal();
        pFaturaTotal.setPreferredSize(dimensao);
    }

    public void lucro() {
        RelatorioLucroScreen lucroPanel = new RelatorioLucroScreen();
        pLucro = lucroPanel.getpLucro();
        pLucro.setPreferredSize(dimensao);
    }

    public void imoveisVendidos() {
        RelatorioImoveisVendidosScreen imoveisVendidosPanel = new RelatorioImoveisVendidosScreen();
        pImoveisVendidos = imoveisVendidosPanel.getpImoveisVendidos();
        pImoveisVendidos.setPreferredSize(dimensao);
    }

    public void imoveisEncalhados() {
        RelatorioImoveisEncalhadosScreen imoveisEncalhadosPanel = new RelatorioImoveisEncalhadosScreen();
        pImoveisEncalhados = imoveisEncalhadosPanel.getpImoveisEncalhados();
        pImoveisEncalhados.setPreferredSize(dimensao);
    }

    public void faturaPorCorretor() {
        RelatorioFaturaScreen faturaPanel = new RelatorioFaturaScreen();
        pFaturaPorCorretor = faturaPanel.getpFaturaPorCorretor();
        pFaturaPorCorretor.setPreferredSize(dimensao);
    }

    public void pagamentoPorCorretor() {
        RelatorioPagamento pagamentoCorretorPanel = new RelatorioPagamento();
        pPagamentoPorCorretor = pagamentoCorretorPanel.getpFaturaPorCorretor();
        pPagamentoPorCorretor.setPreferredSize(dimensao);
    }

    public void corretorDoMes() {
        RelatorioCorretorDoMes corretorDoMesPanel = new RelatorioCorretorDoMes();
        pCorretorDoMes = corretorDoMesPanel.getpCorretorDoMes();
        pCorretorDoMes.setPreferredSize(dimensao);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void closeTela() {
        System.out.println("saiu da tela Relatorios screen");
    }

}
