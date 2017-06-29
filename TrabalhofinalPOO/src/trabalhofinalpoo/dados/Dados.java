/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import trabalhofinalpoo.models.Comissionado;
import trabalhofinalpoo.models.Contratado;
import trabalhofinalpoo.models.Corretor;
import trabalhofinalpoo.models.Imovel;
import trabalhofinalpoo.models.Venda;

public class Dados {

    private static Dados mInstance;

    public ArrayList<Corretor> corretores = new ArrayList<Corretor>();
    public ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
    public ArrayList<Venda> vendas = new ArrayList<Venda>();

    public static Dados getInstance() {
        if (mInstance == null) {
            mInstance = new Dados();
        }

        return mInstance;
    }

    public Float getFaturamentoTotalCorretor(Corretor corretor, Data data) {
        ArrayList<Venda> vendasDoCorretorNoMes = getVendasFromSpecificCorretorInInterval(corretor, data);

        Float valor = new Float(0);
        for (Venda v : vendasDoCorretorNoMes) {
            if (v.getNumeroCRECIResponsavel() == corretor.getNumeroCRECI()) {
                valor += v.getValor() * 0.5f;
            }
        }
        return valor - this.getValorPagoCorretor(data, corretor);
    }

    public Corretor getCorretorDoMes(Data data) {
        Corretor corretor = null;
        Float valor = new Float(0);
        for (Corretor c : getCorretorInInterval(data)) {
            if (valor < this.getValorPagoCorretor(data, c)) {
                corretor = c;
                valor = this.getValorPagoCorretor(data, c);
            }
        }
        return corretor;
    }

    public Float getValorPagoCorretor(Data data, Corretor corretor) {
        
        ArrayList<Venda> vendasDoCorretorNoIntervalo = getVendasFromSpecificCorretorInInterval(corretor, data);
        
        Float valor = new Float(0);
        for (Venda v : vendasDoCorretorNoIntervalo) {
            if (corretor instanceof Comissionado) {
                valor += v.getValor() * (((Comissionado) corretor).getPorcentagemComssiondada()/100);
            } else {
                valor += v.getValor() * (float) 0.01;
            }

        }
        return valor;
    }

    public ArrayList<Imovel> getImoveis() throws Exception {
        ArrayList<Imovel> imovel;

        File arquivo = new File("imoveis.txt");
        if (arquivo.exists()) {
            FileInputStream arquivoEntrada = new FileInputStream(arquivo);
            ObjectInputStream dados = new ObjectInputStream(arquivoEntrada);
            imovel = (ArrayList<Imovel>) dados.readObject();

            return imovel;
        } else {
            return null;
        }
    }

    public Double getFaturamentoInInterval(Data data) {

        Double faturamento = new Double("0");
        ArrayList<Venda> vendasEmUmIntervalo = getVendasInInterval(data);

        for (Venda p : vendas) {
            faturamento += p.getValor() * 0.5;
        }
        return faturamento;
    }

    public boolean creciDisponivel(Integer numeroCRECI) {
        for (Corretor corretor : corretores) {
            if (corretor.getNumeroCRECI() == numeroCRECI) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Imovel> getImoveisDisponiveis() {
        ArrayList<Imovel> imoveisDisponiveis = new ArrayList<Imovel>();

        for (Imovel imovel : imoveis) {
            if (imovel.isDisponibilidade()) {
                imoveisDisponiveis.add(imovel);
            }
        }

        return imoveisDisponiveis;
    }

    public boolean saveImoveis() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream("imoveis.txt");
            ObjectOutputStream dados = new ObjectOutputStream(arquivo);
            dados.writeObject(imoveis);
            dados.flush();
            dados.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addImovel(Imovel imovel) {
        try {
            imoveis.add(imovel);
            if (saveImoveis()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean removeImovel(Imovel imovel) {
        try {
            for (int i = 0; i < imoveis.size(); i++) {
                if (imovel.getCodigo().equals(imoveis.get(i).getCodigo())) {
                    imoveis.remove(i);
                }
            }
            saveImoveis();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateImovel(Imovel imovel) {
        try {
            for (int i = 0; i < imoveis.size(); i++) {
                if (imovel.getCodigo().equals(imoveis.get(i).getCodigo())) {
                    imoveis.set(i, imovel);
                }
            }
            saveImoveis();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean codDisponivel(Long cod) {
        for (Imovel imovel : imoveis) {
            if (imovel.getCodigo().equals(cod)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Contratado> getContratados() throws Exception {
        ArrayList<Contratado> corretores;

        File arquivo = new File("contratados.txt");
        if (arquivo.exists()) {
            FileInputStream arquivoEntrada = new FileInputStream(arquivo);
            ObjectInputStream dados = new ObjectInputStream(arquivoEntrada);
            corretores = (ArrayList<Contratado>) dados.readObject();

            return corretores;
        } else {
            return null;
        }
    }

    public boolean saveContratado(ArrayList<Contratado> corretores) throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream("contratados.txt");
            ObjectOutputStream dados = new ObjectOutputStream(arquivo);
            dados.writeObject(corretores);
            dados.flush();
            dados.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Comissionado> getComissionados() throws Exception {
        ArrayList<Comissionado> corretores;

        File arquivo = new File("corretores.txt");
        if (arquivo.exists()) {
            FileInputStream arquivoEntrada = new FileInputStream(arquivo);
            ObjectInputStream dados = new ObjectInputStream(arquivoEntrada);
            corretores = (ArrayList<Comissionado>) dados.readObject();

            return corretores;
        } else {
            return null;
        }
    }

    public boolean saveComissionados(ArrayList<Comissionado> corretores) throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream("corretores.txt");
            ObjectOutputStream dados = new ObjectOutputStream(arquivo);
            dados.writeObject(corretores);
            dados.flush();
            dados.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Venda> getVendasInInterval(Data data) {
        ArrayList<Venda> vendasInInterval = new ArrayList<Venda>();

        for (Venda venda : vendas) {

            Data dataDaVenda = venda.getDataDaVenda();

            if (data.getAno().equals(dataDaVenda.getAno())
                    && data.getMes().equals(dataDaVenda.getMes())) {
                vendasInInterval.add(venda);
            }
        }

        return vendasInInterval;
    }

    public ArrayList<Corretor> getCorretorInInterval(Data data) {
        ArrayList<Corretor> corretorDoIntervalo = new ArrayList<Corretor>();
        ArrayList<Venda> vendasInInterval = getVendasInInterval(data);

        for (Corretor c : corretores) {
            for (Venda v : vendasInInterval) {
                System.out.println(v.getDataDaVenda());
                if (v.getNumeroCRECIResponsavel() == c.getNumeroCRECI()) {
                    corretorDoIntervalo.add(c);
                    break;
                }
            }
        }
        return corretorDoIntervalo;
    }

    public boolean addCorretor(Corretor corretor) {

        if (corretor instanceof Contratado) {
            try {
                ArrayList<Contratado> contratados = getContratados();
                if (contratados == null) {
                    contratados = new ArrayList<Contratado>();
                }
                contratados.add((Contratado) corretor);
                saveContratado(contratados);
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }

        } else if (corretor instanceof Comissionado) {
            try {

                ArrayList<Comissionado> comissionados = getComissionados();
                if (comissionados == null) {
                    comissionados = new ArrayList<Comissionado>();
                }
                comissionados.add((Comissionado) corretor);
                saveComissionados(comissionados);
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }

        updateCorretorList();
        return true;
    }

    public boolean addVenda(Venda venda) {

        try {
            for (int i = 0; i < imoveis.size(); i++) {
                Long comp1 = venda.getCodigoImovel();
                Long comp2 = imoveis.get(i).getCodigo();

                if (comp1.equals(comp2)) {
                    imoveis.get(i).setDisponibilidade(false);
                    saveImoveis();
                    break;
                }
            }

            vendas.add(venda);
            if (saveVendas()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        //
    }

    private boolean saveVendas() {
        try {
            FileOutputStream arquivo = new FileOutputStream("vendas.txt");
            ObjectOutputStream dados = new ObjectOutputStream(arquivo);
            dados.writeObject(vendas);
            dados.flush();
            dados.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public void updateVendasList() {
        try {
            ArrayList<Venda> updatedVendas = getVendas();
            if (updatedVendas != null) {
                vendas = updatedVendas;
            }

        } catch (Exception e) {

        }
    }

    public ArrayList<Venda> getVendas() throws Exception {

        File arquivo = new File("vendas.txt");
        if (arquivo.exists()) {
            FileInputStream arquivoEntrada = new FileInputStream(arquivo);
            ObjectInputStream dados = new ObjectInputStream(arquivoEntrada);
            return (ArrayList<Venda>) dados.readObject();

        } else {
            return null;
        }
    }

    public ArrayList<Venda> getVendasFromSpecificCorretor(Corretor corretor) {
        ArrayList<Venda> vendasDoCorretor = new ArrayList<Venda>();
        for (Venda venda : vendas) {
            if (venda.getNumeroCRECIResponsavel() == corretor.getNumeroCRECI()) {
                vendasDoCorretor.add(venda);
            }
        }

        return vendasDoCorretor;
    }

    public ArrayList<Venda> getVendasFromSpecificCorretorInInterval(Corretor corretor, Data data) {
        ArrayList<Venda> vendasDoCorretor = new ArrayList<Venda>();
        ArrayList<Venda> vendasDoIntervalo = getVendasInInterval(data);
        for (Venda venda : vendasDoIntervalo) {
            if (venda.getNumeroCRECIResponsavel() == corretor.getNumeroCRECI()) {
                vendasDoCorretor.add(venda);
            }
        }

        return vendasDoCorretor;
    }

    public void update() {
        updateCorretorList();
        updateImovelList();
        updateVendasList();
    }

    public void updateImovelList() {
        try {
            ArrayList<Imovel> updatedImoveis = getImoveis();
            if (updatedImoveis != null) {
                imoveis = updatedImoveis;
            }

        } catch (Exception e) {

        }
    }

    public void updateCorretorList() {

        corretores = new ArrayList<Corretor>();

        try {
            ArrayList<Contratado> contratados = getContratados();
            for (Contratado contratado : contratados) {
                corretores.add(contratado);
            }

            ArrayList<Comissionado> comissionados = getComissionados();
            for (Comissionado comissionado : comissionados) {
                corretores.add(comissionado);
            }

        } catch (Exception e) {

        }
    }

}
