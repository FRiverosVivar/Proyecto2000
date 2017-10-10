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
public class ListaFacturas {
    private ArrayList<Factura> listaDeFacturas;
    public ListaFacturas(){
        listaDeFacturas = new ArrayList<>();
    }
    public void agregarFactura(Trabajador TObj, String IDFact, Articulo AObj){
        //TOBJ Y AOBJ DEBE SER VERIFICADO EN SHOP
        //BUSCAR IDFACT PARA EVITAR ID'S IGUALES
        //BUSCARFACTURA(IDFACT);
        Factura nuevo = new Factura(IDFact,0,TObj);
        nuevo.addItem(AObj);
        listaDeFacturas.add(nuevo);
        
    }
    public int eliminarFactura(String ID){
        if(buscarFactura(ID)== null){
            return -1;
        }
        
        ListIterator<Factura> itr=listaDeFacturas.listIterator();
        while (itr.hasNext()) {
            Factura aux = itr.next();
            if(aux.getID().equals(ID)){
                itr.remove();
            }
        }
        
        return 1;
    }
    public Factura buscarFactura(String ID){
        ListIterator<Factura> itr=listaDeFacturas.listIterator();
        while (itr.hasNext()) {
            Factura aux = itr.next();
            if(aux.getID().equals(ID))
                   return aux;
        }
        
        return null;
    }
    public int getProfitFacturas(){
        int profit = 0;
        ListIterator<Factura> itr=listaDeFacturas.listIterator();
        while (itr.hasNext()) {
            Factura aux = itr.next();
            profit += aux.getGanancia();
        }
    
        return profit;
    }
}
