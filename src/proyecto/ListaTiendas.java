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
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

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
     * @param GerenteTienda
     * @param DireccionTienda
     * @param IDTienda
     * @return  ******/
    public Tienda crearTienda(Gerente GerenteTienda, String DireccionTienda, String IDTienda){
        Tienda tienda = new Tienda(IDTienda);
        tienda.setGerente(GerenteTienda);
        tienda.setDirec(DireccionTienda);
        GerenteTienda.setTiendaACargo(IDTienda);
        return tienda;
    }
    public DefaultListModel modelVentana(){
        DefaultListModel<String> mdl = new DefaultListModel<>();
        String element = "No hay tiendas registradas actualmente.";
        if(listaTiendas.size()<1){
            mdl.addElement(element);
            return mdl;
        }
        Tienda aux;
        Gerente worker;
        ListIterator<Tienda> itr=listaTiendas.listIterator();        
        while (itr.hasNext()) {
            aux = itr.next();
            worker = aux.getGerente();
            element = ("[ID: "+aux.getID()+"] - [Gerente: "+worker.getName()+
                    "] - [Vendedores Registrados: "+aux.obtenerTamañoListaVendedores()+""
                    + "] - [Inventario de la Tienda: "+aux.obtenerTamañoListaArticulos()+"]");
            mdl.addElement(element);
        }
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
    public Gerente buscarGerente(String Rut){

        Gerente ger;
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
                    aux.getGerente().setTiendaACargo(null);
                    itr.remove();
                    return true;
                }
        }
        return false;
    }
    public void mostrarTiendasEnArchivo() throws IOException{
        try (FileWriter writer = new FileWriter("TiendasRegistradas.txt")) {
                if(listaTiendas.size()<1){
                    writer.write("No hay tiendas registradas actualemente");
                    writer.close();
                }
                String element;
                Tienda aux;
                Gerente worker;
                ListIterator<Tienda> itr=listaTiendas.listIterator();
                while (itr.hasNext()) {
                    aux = itr.next();
                    worker = aux.getGerente();
                    element = ("[ID: "+aux.getID()+"] - [Gerente: "+worker.getName()+
                            "] - [Trabajadores Registrados: "+aux.obtenerTamañoListaVendedores()+"]"
                            + " - [Inventario de la Tienda: "+aux.obtenerTamañoListaArticulos()+"]");
                    writer.write(element);
                }
            writer.close();
        } catch (IOException ex){}
    }
    public void guardarTiendas() throws FileNotFoundException, IOException{ 
        Tienda aux;
        ListIterator<Tienda> itr=listaTiendas.listIterator();           
        FileOutputStream fos = new FileOutputStream(new File("Tiendas.txt"));
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            while (itr.hasNext()) {
                aux = itr.next();
                oos.writeObject(aux);
                System.out.println(""+aux.getID());
            }
            oos.close();
        }
	fos.close();
    }
    public void cargarTiendas() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        FileInputStream fi = new FileInputStream(new File("Tiendas.txt"));
        
        try(ObjectInputStream oi = new ObjectInputStream(fi)){
            Tienda aux;
            while((aux = (Tienda) oi.readObject()) != null){
                System.out.println(""+aux.getID());
                listaTiendas.add(aux);
            }
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Archivo con datos a cargar no encontrado.");
        }catch (EOFException e) {
            
	}
    }
    public int gananciaTotalTiendas(){
           
        int total=0; 
     	Tienda auxshop;
    	ListIterator<Tienda> itr=listaTiendas.listIterator();
        while (itr.hasNext()) {
        	auxshop = itr.next();
                total=total+auxshop.calcularGananciaTienda();
        }
    	
    	return total;     
  
     }
     
    public void calcularPorcentajesDeGanancia(int total){
      
        Tienda auxshop;
    	ListIterator<Tienda> itr=listaTiendas.listIterator();
        while (itr.hasNext()) {
        	auxshop = itr.next();
                auxshop.setPorcentajeGanancia((auxshop.calcularGananciaTienda()*100)/total);
        }
        
        
    } 
}
