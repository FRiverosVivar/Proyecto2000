/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.IOException;
import java.io.Serializable;
import java.util.ListIterator;
import javax.swing.DefaultListModel;

/**
 *
 * @author Zekro
 */
public class Vendedor extends Trabajador implements Serializable,IPagable{    
    private MapaFacturas mapaFacturas;
    public Vendedor(){
        mapaFacturas = new MapaFacturas();
    }
    public int añadirFactura(String IDFact,Articulo AObj){
        /*Articulo AObj = listaArticulos.buscarArticulo(Codigo);
        Trabajador TObj = listaTrabajadores.buscarTrabajador(Rut);*/
        if(AObj == null )return -1; // en caso de no existir el trabajador o el articulo, se retorna -1
                                                                            // ya que la f(x) es dedicada a la creacion de facturas.
        System.out.println("agregando fact sin cantidad");
        mapaFacturas.agregarFactura(IDFact,AObj);
        
        return 1;
    }
    public int añadirFactura(String IDFact,Articulo AObj,int cantidad){
        /*Articulo AObj = listaArticulos.buscarArticulo(Codigo);
        Trabajador TObj = listaTrabajadores.buscarTrabajador(Rut);*/
        if(AObj == null )return -1; // en caso de no existir el trabajador o el articulo, se retorna -1
                                                                            // ya que la f(x) es dedicada a la creacion de facturas.
        System.out.println("agregando fact sin cantidad");
        mapaFacturas.agregarFactura(IDFact,AObj,cantidad);
        
        return 1;
    }
    
    /*Calcula la ganancia que produjo el vendedor actual y la retorna*/
    public int getGananciaDeVendedor(){
        return mapaFacturas.obtenerGanancias();
    }
    public DefaultListModel mdlFacturas(){
        return mapaFacturas.mdlFacturas();    
    }
    public int buscarSiExisteFactura(String IDFact){
        if(mapaFacturas.buscarFactura(IDFact) == null){
            System.out.println("no fact");
            return -1;
        }
        
        return 1;
    }
    public void añadirArticuloFactura(String IDFact,Articulo AObj){
        System.out.println("anañadir arituclo sin cantida");
       mapaFacturas.añadirArticuloFactura(AObj, IDFact);
    }
    public void añadirArticuloFactura(String IDFact,Articulo AObj,int cantidad){
        System.out.println("anañadir arituclo cantida");
       mapaFacturas.añadirArticuloFactura(AObj, IDFact,cantidad);
    }

    @Override
    public void recibirPago(boolean pago) {
        this.pago = pago;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void exportarFacturas() throws IOException{
        mapaFacturas.exportarFacturas();
    }
}
