/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Comparator;

/**
 *
 * @author Nicholas
 */
public class OrdenarTiendaAscendente implements Comparator<Tienda> {

    @Override
    public int compare(Tienda o1, Tienda o2) {
        return o1.getPortentajeGanancia() - o2.getPortentajeGanancia();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
