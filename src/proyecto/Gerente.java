/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.Serializable;

/**
 *
 * @author Zekro
 */
public class Gerente extends Trabajador implements Serializable{
    private String IDTienda;
    public Gerente(){
        IDTienda = null;
    }
    public void setTiendaACargo(String IDTienda){
        this.IDTienda = IDTienda;
    }
    public String getTiendaACargo(){
        return IDTienda;
    }
}
