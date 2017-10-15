/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.DefaultListModel;

/**
 *
 * @author Zekro
 */
public class ListaTiendas {
    private ArrayList<Tienda> listaTiendas;
    
    public ListaTiendas(){
        listaTiendas = new ArrayList();
    }
    /*****SOBRECARGA
     * @param Gerente
     * @param DireccionTienda
     * @param IDTienda
     * @return  ******/
    public Tienda crearTienda(Trabajador Gerente, String DireccionTienda, String IDTienda){
        Tienda tienda = new Tienda(IDTienda);
        tienda.setGerente(Gerente);
        tienda.setDirec(DireccionTienda);
        return tienda;
    }
    public Tienda crearTIenda(String DireccionTienda, String IDTienda){
        Tienda tienda = new Tienda(IDTienda);
        tienda.setDirec(DireccionTienda);
        return tienda;
    }
    
    /*****SOBRECARGA
     * @return *****/
    public DefaultListModel modelVentana(){
        DefaultListModel<String> mdl = new DefaultListModel<>();
        String element = "No hay tiendas registradas actualmente.";
        Tienda aux;
        Trabajador worker;
        ListIterator<Tienda> itr=listaTiendas.listIterator();
        
        while (itr.hasNext()) {
            aux = itr.next();
            worker = aux.getGerente();
            element = ("[ID: "+aux.getID()+"] - [Gerente: "+worker.getName()+
                    "] - [Trabajadores Registrados: "+aux.obtenerTamañoListaTrabajadores()+"] - [Inventario de la Tienda: "+aux.obtenerTamañoListaArticulos()+"]");
        }
        
        mdl.addElement(element);
        
        return mdl;
    }
    public int obtenerTamañoListaTiendas(){
        return listaTiendas.size();
    }
    public void agregarTienda(Tienda TObj){
        listaTiendas.add(TObj);
        
    }
    
    public Tienda buscarTienda(String id) {
    	Tienda auxshop;
    	ListIterator<Tienda> itr=listaTiendas.listIterator();
        while (itr.hasNext()) {
        	auxshop = itr.next();
        	if(auxshop.getID().equals(id)){
        		return auxshop;
        	}
        }
    	
    	return null; 
    }
    public Trabajador buscarGerente(String Rut){

        Trabajador ger;
        ListIterator<Tienda> itr=listaTiendas.listIterator();
        while(itr.hasNext()){
            ger = itr.next().getGerente();
            if(ger.getRut().equals(Rut)){
                return ger;
            }
            
        }
        return null;
    }
    public boolean eliminarTienda(String IDTienda){
        if(listaTiendas.size()<1){            
            return false;
        }
        Tienda aux;
    	ListIterator<Tienda> itr=listaTiendas.listIterator();
        while (itr.hasNext()) {
        	aux = itr.next();
        	if(aux.getID().equals(IDTienda)) {
                    itr.remove();
                    return true;
                }
        }
        return false;
    }
    public void guardarTiendasEnArchivo() throws IOException{
        try (FileWriter writer = new FileWriter("TiendasRegistradas.txt")) {
                if(listaTiendas.size()<1){
                    writer.write("No hay tiendas registradas actualemente");
                    writer.close();
                }
                String element;
                Tienda aux;
                Trabajador worker;
                ListIterator<Tienda> itr=listaTiendas.listIterator();
                while (itr.hasNext()) {
                    aux = itr.next();
                    worker = aux.getGerente();
                    element = ("[ID: "+aux.getID()+"] - [Gerente: "+worker.getName()+
                            "] - [Trabajadores Registrados: "+aux.obtenerTamañoListaTrabajadores()+"]"
                            + " - [Inventario de la Tienda: "+aux.obtenerTamañoListaArticulos()+"]");
                    writer.write(element);
                }
            writer.close();
        } catch (IOException ex){}
    }
}
