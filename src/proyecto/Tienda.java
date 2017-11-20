
package proyecto;
import java.util.*;
import java.io.*;
import javax.swing.DefaultListModel;
/*
*
*   CAMBIOS EN LA CLASE:
*       Clase dedicada a la verificación, manejará todos las listas desde 'arriba' y se dedicará a la verificación de
*       condiciones antes de agregar ciertos obj's a c/lista.
*
*
*/
public class Tienda implements Serializable, Comparable<Tienda>{
    
    private String direc;
    private String id;
    private int porcentajeGanancia; /*no se le asigna valor inicial, se modifica*/
    private Gerente GerenteTienda;
    private ListaVendedores listaVendedores;
    private ListaArticulos listaArticulos;
    
    public Tienda(String id){
        this.id = id;
        listaVendedores = new ListaVendedores();
        listaArticulos = new ListaArticulos();
        
    }
    public void setPorcentajeGanancia(int porcentajeGanancia){
        this.porcentajeGanancia=porcentajeGanancia;
    }
    public Gerente getGerente(){
        return GerenteTienda;
    }
    public void setGerente(Gerente Grnt){
        this.GerenteTienda = Grnt;
    }
    public void setDirec (String direc){
        this.direc = direc;
    }
    public void setID(String id){
        this.id=id;
    }
    public String getID(){
        return id;
    }
    public String getDirecc() {
    	return direc;
    }
    public int getPortentajeGanancia() {
    	return porcentajeGanancia;
    }
    public int obtenerTamañoListaVendedores(){
        return listaVendedores.obtenerTamañoListaVendedores();
    }
    public int obtenerTamañoListaArticulos(){
        return listaArticulos.obtenerTamañoListaArticulos();
    }
    public int añadirVendedorTienda(String Nombre, String Rut, String Sueldo){
        if(listaVendedores.buscarVendedor(Rut) != null)return -1;
        
        Vendedor aux = listaVendedores.crearVendedor(Nombre, Rut,Sueldo);
        listaVendedores.agregarVendedor(aux);
        
        return 1;
        
    }
    public int añadirVendedorTienda(String Nombre, String Rut){
        if(listaVendedores.buscarVendedor(Rut) != null)return -1;
        
        Vendedor aux = listaVendedores.crearVendedor(Nombre, Rut, "0");
        listaVendedores.agregarVendedor(aux);
        
        return 1;
        
    } 
    public int añadirArticulosTienda(String Codigo,String Nombre, String PrecioVenta, String PrecioCosto, String Stock, String Descuento){
        if(listaArticulos.buscarArticulo(Codigo) != null)return -1;
        
        Articulo aux = listaArticulos.crearArticulo(Codigo, Nombre, PrecioVenta, PrecioCosto, Stock, Descuento);
        listaArticulos.agregarArticulo(aux);
        
        return 1;
    }
    public int eliminarArticulo(String codigo){
        if(listaArticulos.buscarArticulo(codigo)==null)return -1;
        
        listaArticulos.eliminarArticulo(codigo);
        return 1;
    }
    public int modificarArticulo(String Codigo,String Nombre, String PrecioVenta, String PrecioCosto, String Stock, String Descuento,String codigoNuevo){
        if(listaArticulos.buscarArticulo(Codigo)== null || listaArticulos.buscarArticulo(codigoNuevo) != null)return -1;
        
        listaArticulos.modificarArticulo(Codigo,Nombre, PrecioVenta, PrecioCosto, Stock, Descuento,codigoNuevo);
        return 1;
    }
    public int calcularGananciaTienda(){
       // listaVendedores es la clase que encapsula a los vendedores.
       return listaVendedores.obtenerVentas();    
    }
    public DefaultListModel modelVentana(){
        return listaVendedores.MdlVentana();
    }
    public int añadirVendedor(String nombre,String rut,String sueldo){
        if(listaVendedores.buscarVendedor(rut)!=null)return -1;
        Vendedor aux = listaVendedores.crearVendedor(nombre, rut, sueldo);
        listaVendedores.agregarVendedor(aux);
        
        return 1;
    }
    public int eliminarVendedor(String rut){
        if(listaVendedores.buscarVendedor(rut)==null)return -1;
        
        listaVendedores.eliminarVendedor(rut);
        return 1;
    }
    public int modificarVendedor(String nombre,String rut,String sueldo,String rutnuevo){
        if(listaVendedores.buscarVendedor(rut)==null)return -1;
        
        Vendedor aux = listaVendedores.buscarVendedor(rut);
        aux.setName(nombre);
        aux.setRut(rutnuevo);
        aux.setSueldo(Integer.parseInt(sueldo));
        return 1;
    }
    public Vendedor buscarVendedor(String rut){
        return listaVendedores.buscarVendedor(rut);
    }
    public Articulo buscarArticulo(String codigo){
        return listaArticulos.buscarArticulo(codigo);
    }
    public DefaultListModel modelVentanaArticulo(){
        return listaArticulos.MdlVentana();
    }
    public ArrayList obtenerArticulos(){
       ArrayList<Articulo> listaDuplicada;
        listaDuplicada=listaArticulos.duplicarArrayListArticulos();
        return listaDuplicada;
    }
    public void exportarArticulos() throws IOException{
        listaArticulos.guardarArchivoArticulos();
    }

    @Override
    public int compareTo(Tienda o) {
        return this.id.compareTo(o.id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public DefaultListModel modelAgregarFacturaArticulo(){
        return listaArticulos.modelAgregarFacturaArticulo();
    }
    
}

