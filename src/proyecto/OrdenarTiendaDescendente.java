/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.Serializable;

/**
 *
 * @author Nicholas
 */
public class OrdenarTiendaDescendente implements Serializable{
      public int compare(Tienda o2, Tienda o1) {
        return o2.getPortentajeGanancia() - o1.getPortentajeGanancia();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
