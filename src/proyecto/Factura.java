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
    
    private int Ganancia;
    private ArrayList<Articulo> listaVendidos;
    
    
    public Factura(int Ganancia){
        listaVendidos = new ArrayList<>();
        this.Ganancia=Ganancia;
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
        o.setVecesVendido((o.getVecesVendido())+1);
        return 1;
    }
     /*public void sumaDeArrayLists(ArrayList items){
         
     }*/
}
