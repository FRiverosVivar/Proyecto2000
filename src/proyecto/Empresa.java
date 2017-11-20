/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
//import java.util.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.DefaultListModel;

/**
 *
 * @author Zekro
 */
public class Empresa implements Serializable{
    
    private String Nombre;
    private String CEO;
    private ListaTiendas listaTiendas;
    private ListaGerentes listaGer;
    
    public Empresa(){
        listaTiendas = new ListaTiendas();
        listaGer = new ListaGerentes();
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    public String getCEO(){
        return CEO;
    }
    public void setCEO(String CEO){
        this.CEO = CEO;
    }
    public int agregarTienda(String ID,String dir,Gerente ger){
        //EL GERENTE GER LO ENTREGARÁ EL COMBOBOX 
        if(listaTiendas.buscarTienda(ID) != null){
            return -1;
        }
        if(listaGer.buscarGerente(ger.getRut()) == null || listaTiendas.buscarGerente(ger.getRut()) != null){
            return -1;
        }
        
        /*Vendedor VObj = new Vendedor();
        VObj.setName(nomGer);
        VObj.setRut(rut);
        VObj.setSueldo(Integer.parseInt(sueldo));*/
        
        
        listaTiendas.agregarTienda(listaTiendas.crearTienda(ger, dir, ID));
        return 1;
        
    }
    public Tienda buscarTienda(String ID){
        Tienda aux = listaTiendas.buscarTienda(ID);
        
        return aux;
    }
    public int eliminarTienda(String ID){
        if(listaTiendas.buscarTienda(ID) == null)return -1;
        
        listaTiendas.eliminarTienda(ID);
        
        return 1;
    }
    public DefaultListModel crearMdlTiendas(){        
        DefaultListModel<String> mdl = listaTiendas.modelVentana();        
        return mdl;
    }
    public DefaultListModel crearMdlGerentes(){        
        DefaultListModel<String> mdl = listaGer.modelVentana();        
        return mdl;
    }
    public DefaultListModel crearMdlVendedores(String ID){        
        DefaultListModel<String> mdl = listaTiendas.modelVendedores(ID);        
        return mdl;
    }
    public void mostrarTiendasEnArchivo() throws IOException{
        listaTiendas.setOrdenarArray(new OrdenDesc());
        listaTiendas.mostrarTiendasEnArchivo();           
    }
    public void mostrarTiendasEnArchivoOrdenadoPorGananciasAscendente() throws IOException{
        listaTiendas.setOrdenarArray(new OrdenarAsc());
        listaTiendas.mostrarTiendasEnArchivo();           
    }
    public void mostrarTiendasEnArchivoOrdenadoPorGananciasDescendentes() throws IOException{        
        listaTiendas.mostrarTiendasEnArchivo();           
    }
    public void guardarTiendas() throws IOException{
        listaTiendas.guardarTiendas();
    }
    public void cargarTiendas() throws IOException, FileNotFoundException, ClassNotFoundException{
        listaTiendas.cargarTiendas();
    }
    public int agregarGerente(String Nombre, String Rut, String Sueldo){
        
        if(listaGer.buscarGerente(Rut)!=null)return -1;
        
        Gerente aux = listaGer.crearGerente(Nombre, Rut, Sueldo);
        
        listaGer.agregarGerente(aux);
        return 1;
    }
    public Gerente buscarGerente(String rut){
        return listaGer.buscarGerente(rut);
    }
    public int eliminarGerente(String rut){
        if(listaGer.buscarGerente(rut)==null)return -1;
        
        if(listaGer.buscarGerente(rut).getTiendaACargo() != null){
            Tienda aux = listaTiendas.buscarTienda(listaGer.buscarGerente(rut).getTiendaACargo());
            aux.setGerente(null);
        }
        
        listaGer.eliminarGerente(rut);        
        
        return 1;
    }
    public String[] arrayGerentesParaComboBox(){
        String array[];
        ArrayList<String> gerLista = listaGer.listaParaCombobox();
        
        if(gerLista == null){
            //System.out.println("gerlista null");
            array = new String[1];
            array[0] = "00.000.000-0";
            return array;
        }
        
        //array = new String[gerLista.size()];
        array = gerLista.toArray(new String[0]);
        return array;
    }
    public String[] arrayTiendasParaComboBox(){
        String array[];
        ArrayList<String> tiendaLista = listaTiendas.listaParaCombobox();
        
        if(tiendaLista == null){
            //System.out.println("gerlista null");
            array = new String[1];
            array[0] = "Null/SinTiendas";
            return array;
        }
        
        //array = new String[gerLista.size()];
        array = tiendaLista.toArray(new String[0]);
        return array;
    }
    public void calcularPorcentajesDeGanancia(){
        int gananciaTotal=0;
        gananciaTotal=listaTiendas.gananciaTotalTiendas();
        listaTiendas.calcularPorcentajesDeGanancia(gananciaTotal);
    }
    public void nullTiendaGerente(Gerente obj){
        listaGer.nullTiendaGerente(obj);
    }
    public int agregarVendedor(String nombre, String rut, String sueldo,String IDTienda){
        return listaTiendas.agregarVendedor(nombre, rut, sueldo,IDTienda);
    }
    public int eliminarVendedor(String rut, String IDTienda){
        return listaTiendas.eliminarVendedor(rut,IDTienda);
    }
    public int modificarVendedor(String nombre, String rut, String sueldo,String rutnuevo,String IDTienda){
        return listaTiendas.modificarVendedor(nombre, rut, sueldo,rutnuevo,IDTienda);
    }

}
/*
    public Tienda obtenerTiendaMayorGanancia(){
     ListIterator<Tienda> itr=listaTiendas.listIterator();
     int total=0;
     Tienda mayor=null;
     Tienda aux=null;
     while (itr.hasNext()) {
         if(mayor==null){
             mayor=itr.next();
             total=aux.calcularGananciaTienda();
         }else{
             aux=itr.next();
             if(aux.calcularGananciaTienda()>mayor.calcularGananciaTienda){
              mayor=aux;
              total=total+mayor.calcularGananciaTienda();
             }
         
        }
     }
     mayor.setPorcentajeGanancia((100*(mayor.calcularGananciaTienda()))/total);
     return mayor;
  }*/