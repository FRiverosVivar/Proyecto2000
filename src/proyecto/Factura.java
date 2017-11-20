package proyecto;


import java.io.Serializable;
import java.util.ArrayList;


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
    public int addItem(Articulo o, int cantidad){
        for(int i=0;i<cantidad;i++){
            if(o.getStock()<1){
                 return -1;
            }
            listaVendidos.add(o);
            System.out.println("añadido correctamente");
            Ganancia+=(o.getPrecioConDscto() - o.getPrecioCosto());
            o.setVecesVendido((o.getVecesVendido())+1);
        }
        return 1;
    }

}
