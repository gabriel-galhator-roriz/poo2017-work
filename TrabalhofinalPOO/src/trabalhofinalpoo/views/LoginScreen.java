/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalpoo.views;

import trabalhofinalpoo.views.MainScreen;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import trabalhofinalpoo.TrabalhofinalPOO;

/**
 *
 * @author khazyer
 */
public class LoginScreen extends JFrame implements ActionListener, Serializable, MouseListener, KeyListener {

    //variáveis 
    private ArrayList<String> names = new ArrayList();
    private ArrayList<String> password = new ArrayList();
    MainScreen main;
    //componentes da interface
    public JTextField campoNome, campoSenha, txNome, txSenha, txConfirmaSenha;
    public JLabel nomeLabel, passwordLabel, cadastro, cadNome, cadSenha, cadConfirmaSenha;
    public JPanel confP, cadP;
    public JButton login, confirma, voltar;
    public Toolkit t;

    public LoginScreen() {
        confP = new JPanel();
        nomeLabel = new JLabel("Nome: ", JLabel.LEFT);
        passwordLabel = new JLabel("Senha: ", JLabel.LEFT);
        campoNome = new JTextField();
        campoNome.addKeyListener(this);
        campoSenha = new JPasswordField();
        campoSenha.addKeyListener(this);
        login = new JButton("Login");
        login.addActionListener(this);
        cadastro = new JLabel("Cadastro");
        cadastro.addMouseListener(this);
        confP.setLayout(new GridLayout(3, 2, 10, 10));
        //preenche painel
        confP.add(nomeLabel);
        confP.add(campoNome);
        confP.add(passwordLabel);
        confP.add(campoSenha);
        confP.add(cadastro);
        confP.add(login);
        //configura JFrame
        t = Toolkit.getDefaultToolkit();
        this.add(confP);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setTitle("Tela de Login");
        this.setVisible(true);
        this.setLocation((t.getScreenSize().width / 2) - 80, (t.getScreenSize().height / 2) - 80);
        this.setResizable(false);
        //carrega dados do arquivo
        try {
            this.getUserPass();
        } catch (Exception ex) {
            Logger.getLogger(TrabalhofinalPOO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//-------------------tela de cadastro-----------------------//

    public JPanel telaCadastro() {
        cadNome = new JLabel("entre com seu nome: ");
        cadSenha = new JLabel("entre com sua senha: ");
        cadConfirmaSenha = new JLabel("confirme sua senha: ");
        txNome = new JTextField();
        txSenha = new JPasswordField();
        txConfirmaSenha = new JPasswordField();
        confirma = new JButton("Confirma");
        confirma.addActionListener(this);
        voltar = new JButton("Voltar");
        voltar.addActionListener(this);
        cadP = new JPanel(new GridLayout(4, 2, 10, 10));
        cadP.add(cadNome);
        cadP.add(txNome);
        cadP.add(cadSenha);
        cadP.add(txSenha);
        cadP.add(cadConfirmaSenha);
        cadP.add(txConfirmaSenha);
        cadP.add(voltar);
        cadP.add(confirma);
        return cadP;
    }
//-----------------verifica se usário cadastrado---------------------//

    public boolean verifyUserAcc(String nome, String senha) {
        String p;
        for (String n : names) {
            if (n.equals(nome)) {
                p = password.get(names.indexOf(n));
                if (p.equals(senha)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
//----------------------serializa dados para um arquivo----------------------//

    public void saveUserPass(String nome, String senha) throws Exception {
        FileOutputStream arquivo = new FileOutputStream("login.txt");
        ObjectOutputStream dados = new ObjectOutputStream(arquivo);
        names.add(nome);
        password.add(senha);
        dados.writeObject(names);
        dados.writeObject(password);
        dados.flush();
        dados.close();
    }
//-------------------- recupera dados serializados do arquivo------------------//  

    public void getUserPass() throws Exception {
        File arquivo = new File("login.txt");
        if (arquivo.exists()) {
            FileInputStream arquivoEntrada = new FileInputStream(arquivo);
            ObjectInputStream dados = new ObjectInputStream(arquivoEntrada);
            names = (ArrayList) dados.readObject();
            password = (ArrayList) dados.readObject();
        }
    }
//--------------tratamento de eventos de botão------------------//

    public void carregaMain() {
        if (verifyUserAcc(campoNome.getText(), campoSenha.getText())) {
            this.setVisible(false);
            main = new MainScreen();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválido");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton aux = (JButton) e.getSource();

            switch (aux.getText()) {
                //botão logintitle
                case "Login":
                    carregaMain();
                    break;
                //botão cadastro
                case "Cadastro":
                    this.remove(confP);
                    this.setTitle("Tela de Cadastro");
                    this.add(this.telaCadastro());
                    break;
                //botão confirma
                case "Confirma":
                    String senha1,
                     senha2;
                    senha1 = txSenha.getText();
                    senha2 = txConfirmaSenha.getText();
                    // verifica se campos nulos
                    if (txNome.getText().equals("") && senha1.equals("") && senha2.equals("")) {
                        JOptionPane.showMessageDialog(null, "Os dados não podem ser vazios");
                    } //verifica se senhas batem 
                    else if (senha1.equals(senha2) && !txNome.getText().equals("")) {
                        if (verifyUserAcc(txNome.getText(), senha1)) {
                            JOptionPane.showMessageDialog(null, "Usuário já cadastrado");
                        } else {
                            try {
                                saveUserPass(txNome.getText(), senha1);
                            } catch (Exception ex) {
                                Logger.getLogger(TrabalhofinalPOO.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            this.remove(cadP);
                            this.add(confP);
                            this.pack();
                        }
                    } else if (!senha1.equals(senha2)) {
                        JOptionPane.showMessageDialog(null, "Senhas não coincidem");
                        txSenha.setText("");
                        txConfirmaSenha.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "O nome não pode ser vasio");
                    }
                    break;
                //botão voltar
                case "Voltar":
                    this.remove(cadP);
                    this.add(confP);
                    this.pack();
                    break;
                default:
                    break;
            }
        } else if (e.getSource() instanceof JTextField) {

            System.out.println(e);
        }
    }
//-----------------------tratamento de eventos de mouse------------------------//

    @Override
    public void mouseClicked(MouseEvent e) {
        this.remove(confP);
        this.add(telaCadastro());
        this.pack();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            carregaMain();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
