/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import javax.swing.DefaultListModel;

/**
 *
 * @author Zekro
 */
public class MapaFacturas implements Serializable{
    private Map<String,Factura> mapadeFacturas;
    public MapaFacturas(){
        //listaDeFacturas = new ArrayList<>();
        mapadeFacturas = new HashMap<>();
    }
    /**
     * Funcion VOID, recibe la ID de la factura y un OBJ articulos
     * para posteriormente ser agregado a un hashmap.
     * @param IDFact
     * @param AObj 
     */
    public void agregarFactura(String IDFact, Articulo AObj){
        //TOBJ Y AOBJ DEBE SER VERIFICADO EN TIENDA
        //BUSCAR IDFACT PARA EVITAR ID'S IGUALES
        //BUSCARFACTURA(IDFACT);
        Factura nuevo = new Factura(0);
        nuevo.addItem(AObj);
        mapadeFacturas.put(IDFact, nuevo);
        
    }
    /**
     * Sobrecarga de metodo. Esta f(x) recibe como parametro 1 Articulo y la cantidad de veces que se compró
     * siendo mayor a 1.
     * @param IDFact
     * @param AObj1
     * @param Cantidad 
     */
    public void agregarFactura(String IDFact, Articulo AObj1, int Cantidad){
        //TOBJ Y AOBJ DEBE SER VERIFICADO EN TIENDA
        //BUSCAR IDFACT PARA EVITAR ID'S IGUALES
        //BUSCARFACTURA(IDFACT);
        Factura nuevo = new Factura(0);
        for(int i = 0; i<Cantidad;i++){
            nuevo.addItem(AObj1);
        }
        mapadeFacturas.put(IDFact, nuevo);
        
    }
    /**
     * Verifica que la factura exista y añade el articulo recibido como parametro.
     * @param AObj
     * @param IDFact
     * @return 
     */
    public int añadirArticuloFactura(Articulo AObj, String IDFact){
        //verificar existencia de AObj(ListaArticulos)en Tienda.java
        Factura aux = buscarFactura(IDFact);
        
        if(aux == null)
            return -1;
        
        if(aux.addItem(AObj) == -1){
            return -1;
        }
        //aux.addItem(AObj);
        return 1;
    }
    /**
     * Remueve la factura del mapa, nada más que explicar.
     * @param ID
     * @return 
     */
    public int eliminarFactura(String ID){
        if(mapadeFacturas.remove(ID) == null)
            return -1;
        
        return 1;
    }
    /**
     * Obtener factura, recibe una ID y retorna un Objeto Factura.
     * @param ID
     * @return 
     */
    public Factura buscarFactura(String ID){
        return mapadeFacturas.get(ID);
    }
    /**
     * Recorre el mapa calculando la ganancia de los objetos vendidos por cada factura
     * el valor final es retornado, en caso de no tener ninguna factura, retorna 0.
     * @return 
     */
    public int obtenerGanancias(){
        int profit = 0;
        Iterator<Map.Entry<String, Factura>> entries = mapadeFacturas.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Factura> entry = entries.next();
            Factura aux = entry.getValue();
            profit += aux.getGanancia();
        }
        return profit;
    }

    public DefaultListModel mdlFacturas(){
        DefaultListModel<String> mdl = new DefaultListModel<>();
        String element = "No hay facturas registradas actualmente.";
        if(mapadeFacturas.size()<1){
            mdl.addElement(element);
            return mdl;
        }
        Iterator<Map.Entry<String, Factura>> entries = mapadeFacturas.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Factura> entry = entries.next();
            Factura aux = entry.getValue();
        
            element = ("[IDFactura: "+entry.getKey()+"] - [Ganancia: "+aux.getGanancia()+
                    "] - [Cantidad de Articulos Vendidos: "+aux.getSize()+"]");
            mdl.addElement(element);
        }
        return mdl;
    }
    public void exportarFacturas() throws IOException{
        try (FileWriter writer = new FileWriter("FacturasRegistradas.txt")) {
            if(mapadeFacturas.size()<1){
                writer.write("No hay Facturas registradas actualemente");
                writer.close();
            }
            
            String element;
            Iterator<Map.Entry<String, Factura>> entries = mapadeFacturas.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, Factura> entry = entries.next();
                Factura aux = entry.getValue();
                element = ("[ID: "+entry.getKey()+"] - [Ganancia: "+aux.getGanancia()+"]"
                    + " - [Articulos vendidos: "+aux.getSize()+"]");
                writer.write(element);
            }
            writer.close();
            
        } catch (IOException ex){}
    }
}
