package trabalhofinalpoo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import trabalhofinalpoo.dados.Dados;
import trabalhofinalpoo.views.PagamentosScreen;
import trabalhofinalpoo.views.RelatorioFinanceiro;

public class RelatorioFinanceiroController implements ActionListener {

    RelatorioFinanceiro view;

    Dados dados;

    public RelatorioFinanceiroController(RelatorioFinanceiro mView) {

        view = mView;

        dados = Dados.getInstance();
    }

    public void loadDados() {
        dados.update();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton aux = (JButton) e.getSource();
            if (aux.getText().equals(RelatorioFinanceiro.BUTTON_BUSCAR)) {
                view.setTextFaturamento(dados.getFaturamentoTotal().toString());
                System.out.println(dados.getFaturamentoTotal().toString());
            }
        }
    }

}
