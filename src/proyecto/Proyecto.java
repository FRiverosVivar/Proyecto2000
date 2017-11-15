/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import proyecto.Ventanas.ventanaLogin;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto.Ventanas.ventanaMenuPrincipal;

/**
 *
 * @author Zekro
 * 1 FUNCIONALIDAD PROPIA + PRINTEO X ARCHIVO.
 */
public class Proyecto {

    /**
     * @param args
     * @throws IOException 
     * @throws NumberFormatException 
     * @throws InterruptedException 
     * @throws java.lang.ClassNotFoundException 
     */
    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException, ClassNotFoundException {
        Empresa bestEmpresa = new Empresa();
        /*Empresa bestEmpresa1;
        try {
            bestEmpresa.cargarTiendas();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
            FileInputStream fi = new FileInputStream(new File("Empresa.txt"));
        
            try(ObjectInputStream oi = new ObjectInputStream(fi)){
               bestEmpresa1 = (Empresa) oi.readObject();
               if(bestEmpresa1 != null)bestEmpresa = bestEmpresa1;
            }catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,"Archivo con datos a cargar no encontrado.");
            } catch (IOException ex) {
                Logger.getLogger(ventanaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        
        bestEmpresa.setCEO("Steve Jobs");
        bestEmpresa.setNombre("EasyShop v1.5a");
    	ventanaLogin ventana = new ventanaLogin(bestEmpresa);
        ventana.setVisible(true);
        }
}
        /*int option;
        do {
        	
        	System.out.println("\tBienvenido al Men� de Administraci�n\n");
        	System.out.println("\tTiendas Actualmente Registradas: "+bestEmpresa.getShops()+"\n");
        	System.out.println("\t[1].-\tAgregar Tienda"
                                   + "\n\t[2].-\tMenu Tienda"
                                   + "\n\t[3].-\tBorrar Tienda"
                                   + "\n\t[4].-\tMostrar Tiendas Registradas"
                                   + "\n\t[0].-\tSalir");
        	option = getOption();
        	switch(option) {
        		case 1:{
        			bestEmpresa.addShop();
        			break;
        		}
        		case 2:{
        			if(bestEmpresa.getShops()<1) {
        				System.out.println("\n\tActualmente no hay ninguna tienda registrada. Volviendo al menu principal");
        				break;
        			}
                                
        			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        			System.out.println("\n\tIngresa la ID de la tienda, para ingresar a su Menu\n");
        			Tienda aux = bestEmpresa.searchShop(br.readLine());
                                
        			if(aux == null) {
        				System.out.println("\n\t No existe tienda asociada a la ID escrita");
        				break;
        			}
                                 System.out.println("\t[Datos de la tienda]"
                                         + "\n ->ID: "+aux.getID()
                                         + "\n->Gerente: "+aux.getGerente().getName()
                                         +" \n->Trabajadores Registrados: "+aux.getStaff()
                                         +" \n->Inventario de la Tienda: "+aux.getInventory()+"\n");
                                        
                                 aux.menuTienda();
                                 
        			break;
        		}
        		case 3:{
        			bestEmpresa.printAllShops();
        			bestEmpresa.deleteShop();
        			break;
        		}
        		case 4:{
        			bestEmpresa.printAllShops();
        			break;
        		}
        	}
        
        }while(option != 0);*/
                
    
    /*public static int getOption() throws NumberFormatException, IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	return Integer.parseInt(br.readLine());
    }*/

