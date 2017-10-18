/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Zekro
 */
public class ListaVendedores implements Serializable {
    private ArrayList<Vendedor> listaVendedores;
    
    public ListaVendedores(){
         listaVendedores = new ArrayList<>();
    }
    public int obtenerTamañoListaVendedores(){
        return listaVendedores.size();
    }
    public void agregarVendedor(Vendedor obj){
        
        //BUSCAR Vendedor EN ESTA CLASE
    	listaVendedores.add(obj);
    }
    public Vendedor crearVendedor(String Nombre, String Rut, String Sueldo){
    	Vendedor nuevo = new Vendedor();
    	nuevo.setName(Nombre);
    	nuevo.setRut(Rut);
    	nuevo.setSueldo(Integer.parseInt(Sueldo));
    	return nuevo;
    }
    public Vendedor buscarVendedor(String rut) {
    	ListIterator<Vendedor> itr=listaVendedores.listIterator();
        while (itr.hasNext()) {
            Vendedor aux = itr.next();
            if(aux.getRut().equals(rut)) {
            	return aux;
            }
        }
    	return null;
    }
    public void guardarArchivoVendedores() throws IOException {
    	ListIterator<Vendedor> itr=listaVendedores.listIterator();
        File file = new File("VendedoresRegistrados.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            while (itr.hasNext()) {
                Vendedor aux = itr.next();
                bw.write("\n[Nombre: "+aux.getName()+"]->[Rut: "+aux.getRut()+"]->"
                        + "[Sueldo: "+aux.getSueldo()+"]");
            }
        }
    }
}
