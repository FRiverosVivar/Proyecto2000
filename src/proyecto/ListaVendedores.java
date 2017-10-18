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
import javax.swing.DefaultListModel;

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
    public int obtenerVentas(){
        Vendedor aux;
        int GananciaTotal=0;
        ListIterator<Vendedor> itr=listaVendedores.listIterator();
        while (itr.hasNext()) {
            aux=itr.next();  
            GananciaTotal=GananciaTotal+aux.getGananciaDeVendedor();
        }
        
        return GananciaTotal;
    }
    public DefaultListModel MdlVentana(){
        DefaultListModel<String> mdl = new DefaultListModel<>();
        String element = "No hay Vendedorxs registradxs actualmente.";
        if(listaVendedores.size()<1){
            mdl.addElement(element);
            return mdl;
        }
        Vendedor aux;
        String szAux;
        ListIterator<Vendedor> itr=listaVendedores.listIterator();        
        while (itr.hasNext()) {
            aux = itr.next();
            element = ("[Nombre: "+aux.getName()+"] - [Rut: "+aux.getRut()+
                    "] - [Sueldo: "+aux.getSueldo()+"]");
            mdl.addElement(element);
        }
        return mdl;
    }
    public void eliminarVendedor(String rut){
        Vendedor aux;
        ListIterator<Vendedor> itr=listaVendedores.listIterator();
        while (itr.hasNext()) {
            aux=itr.next();  
            if(aux.getRut().equals(rut)){
                itr.remove();
            }
        }
    }
}
