package proyecto;


import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zekro
 */
public class Factura implements Serializable {
    
    private String ID;
    private int Ganancia;
    ArrayList<Articulo> listaVendidos = new ArrayList<>();
    private Trabajador Vendedor;
    
    
    public Factura(String ID, int Ganancia, Trabajador Vendedor){
        this.ID=ID;
        this.Ganancia=Ganancia;
        this.Vendedor=Vendedor;
    }
     
    public void setID(String ID){
        this.ID=ID;
    }
    
    public String getID(){
        return ID;
    }
     
     public int getGanancia(){
         return Ganancia;
     }
     
     public void setGanancia(int Ganancia){
         this.Ganancia=Ganancia;
     }
     public int getSize(){
         return listaVendidos.size();
     }
     public int addItem(Articulo o){
         if(o.getStock()<1){
             return -1;
         }
         listaVendidos.add(o);
         Ganancia+=(o.getPrecioConDscto() - o.getPrecioCosto());
         return 1;
     }
}
