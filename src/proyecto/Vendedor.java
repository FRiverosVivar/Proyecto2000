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
    private ListaFacturas listaFacturas;
    public Vendedor(){
        listaFacturas = new ListaFacturas();
    }
    public int añadirFactura(String Rut, String IDFact,Articulo AObj){
        /*Articulo AObj = listaArticulos.buscarArticulo(Codigo);
        Trabajador TObj = listaTrabajadores.buscarTrabajador(Rut);*/
        if(AObj == null )return -1; // en caso de no existir el trabajador o el articulo, se retorna -1
        
        if(listaFacturas.buscarFactura(IDFact) != null)return -1;   //en caso de existir la factura se retorna
                                                                    // ya que la f(x) es dedicada a la creacion de facturas.
        listaFacturas.agregarFactura(IDFact, AObj);
        
        return 1;
    }
    
    
    /*Calcula la ganancia que produjo el vendedor actual y la retorna*/
    public int getGananciaDeVendedor(){
        return listaFacturas.obtenerGanancias();
    }
    public DefaultListModel mdlFacturas(){
        return listaFacturas.mdlFacturas();    
    }
    public int buscarSiExisteFactura(String ID){
        if(listaFacturas.buscarFactura(ID) != null)return -1;
        
        return 1;
    }
    public void añadirArticuloFactura(String IDFact,Articulo AObj){
       listaFacturas.añadirArticuloFactura(AObj, IDFact);
    }

    @Override
    public void recibirPago(boolean pago) {
        this.pago = pago;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void exportarFacturas() throws IOException{
        listaFacturas.exportarFacturas();
    }
}
