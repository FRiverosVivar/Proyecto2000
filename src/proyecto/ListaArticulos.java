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
public class ListaArticulos implements Serializable {
    private ArrayList<Articulo> listaArticulos;
    
    public ListaArticulos(){
        listaArticulos = new ArrayList<>();
    }
    public int obtenerTamañoListaArticulos(){
        return listaArticulos.size();
    }
    public int eliminarArticulo(String ID){
        if(buscarArticulo(ID)== null){
            return -1;
        }
        
        ListIterator<Articulo> itr=listaArticulos.listIterator();
        while (itr.hasNext()) {
            Articulo aux = itr.next();
            if(aux.getCodigo().equals(ID)){
                itr.remove();
            }
        }
        
        return 1;
    }
    public void modificarArticulo(String Codigo,String Nombre, String PrecioVenta, String PrecioCosto, String Stock, String Descuento,String codigoNuevo){
        Articulo aux = buscarArticulo(Codigo);

        aux.setCodigo(codigoNuevo);
        aux.setNombre(Nombre);
        aux.setPrecio(Integer.parseInt(PrecioVenta));
        aux.setPrecioCosto(Integer.parseInt(PrecioCosto));
        aux.setStock(Integer.parseInt(Stock));
        aux.setDscto(Integer.parseInt(Descuento));
        
    }
    public Articulo buscarArticulo(String codigo) {
    	ListIterator<Articulo> itr=listaArticulos.listIterator();
        while (itr.hasNext()) {
            Articulo aux = itr.next();
            if(aux.getCodigo().equals(codigo)) {
            	return aux;
            }
        }
        return null;
    }
    public int agregarArticulo (Articulo obj){
        Articulo item = obj;
       
        if(buscarArticulo(item.getCodigo())!=null) {
        	return -1;
        }
        listaArticulos.add(item);
        return 1;
    }
    public Articulo crearArticulo
    (String Codigo,String Nombre, String PrecioVenta, String PrecioCosto, String Stock, String Descuento){
        Articulo item = new Articulo();
        item.setCodigo(Codigo);
        item.setNombre(Nombre);
        item.setPrecio(Integer.parseInt(PrecioVenta));
        item.setPrecioCosto(Integer.parseInt(PrecioCosto));
        item.setStock(Integer.parseInt(Stock));
        item.setDscto(Integer.parseInt(Descuento));
        
        return item;    
    }
    public void guardarArchivoArticulos() throws IOException {
    	ListIterator<Articulo> itr=listaArticulos.listIterator();
        File file = new File("ArticulosRegistrados.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        if(listaArticulos.size()<1){
                    fw.write("No hay Articulos registradas actualemente");
                    fw.close();
                }
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            while (itr.hasNext()) {
                Articulo aux = itr.next();
                bw.write("\n\t[Nombre: "+aux.getNombre()+"]->[Codigo: "+aux.getCodigo()+"]->[Stock: "+aux.getStock()+"]"
                        + "->[Precio Original: "+aux.getPrecio()+"]->[% de descuento: "+aux.getDscto()+"]");
            }
        }
    }
    public DefaultListModel MdlVentana(){
        DefaultListModel<String> mdl = new DefaultListModel<>();
        String element = "No hay Articulos registrados actualmente.";
        if(listaArticulos.size()<1){
            mdl.addElement(element);
            return mdl;
        }
        Articulo aux;
        String szAux;
        ListIterator<Articulo> itr=listaArticulos.listIterator();        
        while (itr.hasNext()) {
            aux = itr.next();
            element = ("[Nombre: "+aux.getNombre()+"] - [Codigo: "+aux.getCodigo()+
                    "] - [Precio Venta: "+aux.getPrecio()+"] - [Precio Costo: "+aux.getPrecioCosto()+""
                    + "] - [Stock: "+aux.getStock()+"] - [Descuento: "+aux.getDscto());
            mdl.addElement(element);
        }
        return mdl;
    }
    public ArrayList duplicarArrayListArticulos(){
        Articulo aux,item;
        ArrayList<Articulo> duplicado;
        duplicado= new ArrayList<>();
        
    	ListIterator<Articulo> itr=listaArticulos.listIterator();
        while(itr.hasNext()){
         aux=itr.next();
         
        item=new Articulo();
        item.setCodigo(aux.getCodigo());
        item.setNombre(aux.getNombre());
        item.setPrecio(aux.getPrecio());
        item.setPrecioCosto(aux.getPrecioCosto());
        item.setStock(aux.getStock());
        item.setDscto(aux.getDscto());
         
         duplicado.add(item);
        }
      
        return duplicado;
    }
}
