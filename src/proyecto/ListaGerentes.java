/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.DefaultListModel;

/**
 *
 * @author Zekro
 */
public class ListaGerentes implements Serializable{
    private ArrayList<Gerente> listaGerentes;
    
    public ListaGerentes(){
         listaGerentes = new ArrayList<>();
    }
    public int obtenerTamañoListaGerente(){
        return listaGerentes.size();
    }
    
    public void agregarGerente(Gerente obj){
        listaGerentes.add(obj);
    }
    public Gerente crearGerente(String Nombre, String Rut, String Sueldo){
    	Gerente nuevo = new Gerente();
    	nuevo.setName(Nombre);
    	nuevo.setRut(Rut);
    	nuevo.setSueldo(Integer.parseInt(Sueldo));
    	return nuevo;
    }
    public Gerente buscarGerente(String rut) {
    	ListIterator<Gerente> itr=listaGerentes.listIterator();
        while (itr.hasNext()) {
            Gerente aux = itr.next();
            if(aux.getRut().equals(rut)) {
            	return aux;
            }
        }
    	return null;
    }
    public Gerente eliminarGerente(String rut){
        ListIterator<Gerente> itr=listaGerentes.listIterator();
        while (itr.hasNext()) {
            Gerente aux = itr.next();
            if(aux.getRut().equals(rut)) {
                itr.remove();
            	return aux;
            }
        }
    	return null;
    }
    public ArrayList listaParaCombobox(){
        ArrayList<String> array = new ArrayList<String>();
        ListIterator<Gerente> itr=listaGerentes.listIterator();
        while (itr.hasNext()) {
            Gerente aux = itr.next();
            if(aux.getTiendaACargo()== null){
                //System.out.println(""+aux.getTiendaACargo());
                array.add(aux.getRut());
            } 
        }
        if(array.size()<1)return null;
        
        return array;
    }
    public DefaultListModel modelVentana(){
        DefaultListModel<String> mdl = new DefaultListModel<>();
        String element = "No hay Gerentes registradas actualmente.";
        if(listaGerentes.size()<1){
            mdl.addElement(element);
            return mdl;
        }
        Gerente aux;
        String szAux;
        ListIterator<Gerente> itr=listaGerentes.listIterator();        
        while (itr.hasNext()) {
            aux = itr.next();
            szAux = aux.getTiendaACargo();
            if(szAux == null){
                szAux = "Sin Tienda Asignada";
            }
            element = ("[Nombre: "+aux.getName()+"] - [Rut: "+aux.getRut()+
                    "] - [Sueldo: "+aux.getSueldo()+""
                    + "] - [IDTienda: "+szAux+"]");
            mdl.addElement(element);
        }
        return mdl;
    }
    public void nullTiendaGerente(Gerente obj){
        Gerente aux;
    
        ListIterator<Gerente> itr=listaGerentes.listIterator();        
        while (itr.hasNext()) {
            aux = itr.next();
            if(aux.getRut().equals(obj.getRut())){
                aux.setTiendaACargo(null);
                //System.out.println("nulleandorut");
            }
        }
    }
}
