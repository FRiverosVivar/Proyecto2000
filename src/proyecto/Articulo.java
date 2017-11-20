package proyecto;

import java.io.Serializable;

/**
 *
 * @author Proyect X 2.0 next level of Greatness
 */
public class Articulo implements Serializable {
    private String nombre;
    private String codigo;
    private int stock;
    private int precioVenta;
    private int precioCosto;
    private int dscto;
    private int vecesVendido;
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public void setStock (int stock){
        this.stock = stock;
    }
    public void setPrecio(int precioVenta){
        this.precioVenta = precioVenta;
    }
    public void setPrecioCosto(int precioCosto){
        this.precioCosto = precioCosto;
    }
    public void setDscto(int dscto){
        this.dscto = dscto;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCodigo(){
        return codigo;
    }
    public int getStock(){
        return stock;
    }
    public int getPrecio(){
        return precioVenta;
    }
    public int getPrecioCosto(){
        return precioCosto;
    }
    public int getDscto(){
        return dscto;
    }
    
    public int getPrecioConDscto(){   
        float prcio = (float) precioVenta;
        float dsct = (float) dscto;
        float s;
        s = 100-dsct;
        float monto;
        monto = (s*prcio)/100;
        int preciofinal = (int) monto;
        return preciofinal;   
    }
    public int getVecesVendido(){
        return vecesVendido;
    }
    public void setVecesVendido(int vecesVendido){
        this.vecesVendido=vecesVendido;
    }

}
