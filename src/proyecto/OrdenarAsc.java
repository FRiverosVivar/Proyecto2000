/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Nicholas
 */
public class OrdenarAsc implements Serializable,IOrdenarArray {

    @Override
    public void OrdenarArrayL(ArrayList Lista) {
     Collections.sort(Lista, (Comparator<Tienda>) new OrdenarTiendaAscendente());
     
    }
    
}
