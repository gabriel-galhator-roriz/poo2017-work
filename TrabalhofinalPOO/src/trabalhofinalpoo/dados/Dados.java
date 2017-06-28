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
import trabalhofinalpoo.models.Comissionado;
import trabalhofinalpoo.models.Contratado;
import trabalhofinalpoo.models.Corretor;

public class Dados {
   
    private static Dados mInstance;
    
    public ArrayList<Corretor> corretores = new ArrayList<Corretor>();

    public static Dados getInstance() {
        if (mInstance == null)
            mInstance = new Dados();

        return mInstance;
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
        try{
            FileOutputStream arquivo = new FileOutputStream("contratados.txt");
            ObjectOutputStream dados = new ObjectOutputStream(arquivo);
            dados.writeObject(corretores);
            dados.flush();
            dados.close();
            return true;
        } catch(Exception e){
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
        try{
            FileOutputStream arquivo = new FileOutputStream("corretores.txt");
            ObjectOutputStream dados = new ObjectOutputStream(arquivo);
            dados.writeObject(corretores);
            dados.flush();
            dados.close();
            return true;
        } catch(Exception e){
            return false;
        }
    }
    
    public void update(){
        updateCorretorList();
    }
    
    public void updateCorretorList(){
        
        corretores = new ArrayList<Corretor>();
        
        try{
            ArrayList<Contratado> contratados = getContratados();
            for(Contratado contratado : contratados){
                corretores.add(contratado);
            }
            
            ArrayList<Comissionado> comissionados = getComissionados();
            for(Comissionado comissionado : comissionados){
                corretores.add(comissionado);
            }
            
        } catch(Exception e){
            
        }
    }

    public boolean addCorretor(Corretor corretor) {
        
        if(corretor instanceof Contratado){
            try{
                ArrayList<Contratado> contratados = getContratados();
                contratados.add((Contratado)corretor);
                saveContratado(contratados);
            } catch (Exception e){
                return false;
            }
            
            
        } else if (corretor instanceof Comissionado){
            try{
                ArrayList<Comissionado> comissionados = getComissionados();
                comissionados.add((Comissionado)corretor);
                saveComissionados(comissionados);
            } catch (Exception e){
                return false;
            } 
        }
        
        updateCorretorList();
        return true;
    }
 
}
