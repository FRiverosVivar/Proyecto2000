/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import proyecto.Ventanas.ventanaLogin;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Zekro
 */
public class Proyecto {

    /**
     * @param args
     * @throws IOException 
     * @throws NumberFormatException 
     * @throws InterruptedException 
     * @throws java.lang.ClassNotFoundException 
     */
    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException, ClassNotFoundException {
        Empresa bestEmpresa;
        bestEmpresa= new Empresa();
        FileInputStream fi = new FileInputStream(new File("Empresa.txt"));
        
        try(ObjectInputStream oi = new ObjectInputStream(fi)){            
            while((bestEmpresa = (Empresa) oi.readObject()) != null){
                System.out.println(""+bestEmpresa.getCEO());
                //System.out.println(""+bestEmpresa.buscarGerente("123"));
            }
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Archivo con datos a cargar no encontrado.");
        }catch (EOFException e) {
            
	}
        
        
        bestEmpresa.setCEO("Steve Jobs");
        bestEmpresa.setNombre("EasyShop v1.5a");
    	ventanaLogin ventana = new ventanaLogin(bestEmpresa);
        ventana.setVisible(true);
    }
}