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
        //CREAR TRABAJADOR Y SUS REESTRICCIONES EN CLASE EMPRESA.
        Tienda tienda = new Tienda(IDTienda);
        tienda.setGerente(Gerente);
        tienda.setDirec(DireccionTienda);
        return tienda;
    }
    
    public void agregarTienda(Tienda TObj){
        //VERIFICAR QUE NO ESTÉ LA TIENDA EN CLASE EMPRESA.
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
