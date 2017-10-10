/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Zekro
 */
public class ListaTiendas {
    private ArrayList<Tienda> listaTiendas;
    
    public ListaTiendas(){
        listaTiendas = new ArrayList();
    }
    
    public Tienda crearTienda(Trabajador Gerente, String DireccionTienda, String IDTienda){
        Tienda tienda = new Tienda(IDTienda);
        tienda.setGerente(Gerente);
        tienda.setDirec(DireccionTienda);
        return tienda;
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
}
