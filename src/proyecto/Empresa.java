/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
//import java.util.*;

import java.io.IOException;
import javax.swing.DefaultListModel;

/**
 *
 * @author Zekro
 */
public class Empresa {
    
    private String Nombre;
    private String CEO;
    private ListaTiendas listaTiendas;
    
    public Empresa(){
        listaTiendas = new ListaTiendas();
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    public String getCEO(){
        return CEO;
    }
    public void setCEO(String CEO){
        this.CEO = CEO;
    }
    public int agregarTienda(String ID,String nomGer,String dir,String sueldo,String rut){
        
        if(listaTiendas.buscarTienda(ID) != null){
            return -1;
        }
          
        if(listaTiendas.buscarGerente(rut) != null){
            return -1;
        }
        
        Trabajador TObj = new Trabajador();
        TObj.setName(nomGer);
        TObj.setRut(rut);
        TObj.setCargo("Administrador Tienda [ID: "+ID+"]");
        TObj.setSueldo(Integer.parseInt(sueldo));
        
        
        listaTiendas.agregarTienda(listaTiendas.crearTienda(TObj, dir, ID));
        return 1;
        
    }
    public Tienda buscarTienda(String ID){
        Tienda aux = listaTiendas.buscarTienda(ID);
        
        return aux;
    }
    public int eliminarTienda(String ID){
        if(listaTiendas.buscarTienda(ID) == null)return -1;
        
        listaTiendas.eliminarTienda(ID);
        
        return 1;
    }
    public DefaultListModel crearMdl(){        
        DefaultListModel<String> mdl = listaTiendas.modelVentana();        
        return mdl;
    }
    public void guardarTiendasEnArchivo() throws IOException{        
        listaTiendas.guardarTiendasEnArchivo();           
    }
    /*public int getShops() {
    	return listaDeShop.size();
    }*/
    /*public Tienda searchShop(String id) {
    	Tienda auxshop;
    	ListIterator<Tienda> itr=listaDeShop.listIterator();
        while (itr.hasNext()) {
        	auxshop = itr.next();
        	if(auxshop.getID().equals(id)){
        		return auxshop;
        	}
        }
    	
    	return null; 
    }*/
    /*public void printAllShops() throws InterruptedException {    	
    	if(listaDeShop.size() < 1) {
    		System.out.println("\n\tActualmente no hay ninguna tienda registrada. Volviendo al menu principal.\n");
    		//Thread.sleep(2000);
    		return;
    	}
    	int i = 1;
    	Tienda aux;
    	Trabajador worker;
        ListIterator<Tienda> itr=listaDeShop.listIterator();
        while (itr.hasNext()) {
        	aux = itr.next();
        	worker = aux.getGerente();
        	System.out.println("\t["+i+"] ->ID: "+aux.getID()+" ->Gerente: "+worker.getName()+
        	" ->Trabajadores Registrados: "+aux.getStaff()+" ->Inventario de la Tienda: "+aux.getInventory()+"\n");
        }
    }*//*
    public void addShopVentana(String id,String nomGer,String dir,String sueldo,String rut){
        Tienda tienda = new Tienda(id);
        Trabajador Gerente = new Trabajador();
        Gerente.setName(nomGer);
        Gerente.setRut(rut);
        Gerente.setCargo("Administrador Tienda [ID: "+tienda.getID()+"]");
        Gerente.setSueldo(Integer.parseInt(sueldo));
        tienda.setGerente(Gerente);
        tienda.setDirec(dir);
        
        listaDeShop.add(tienda);
        
    }*/
    /*public void addShop () throws IOException{
    	Tienda tienda = crearShop();
        
    	if(searchShop(tienda.getID()) != null) {
    		System.out.println("\n\t Ya existe una tienda con la misma ID.");
    		return;
    	}
    	
        System.out.println("\n\tTienda agregada exitosamente\n");
        listaDeShop.add(tienda);    
    }*/
    
   /* private Tienda crearShop() throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el id de la tienda a agregar: \n");
        Tienda tienda = new Tienda(br.readLine());
        Trabajador Gerente = new Trabajador();
        System.out.println("\tIngrese el nombre del gerente a cargo: \n");
        Gerente.setName(br.readLine());
        System.out.println("\tIngrese el rut del gerente encargado: \n");
        Gerente.setRut(br.readLine());
        Gerente.setCargo("Administrador Tienda [ID: "+tienda.getID()+"]");
        System.out.println("\tIngrese el sueldo del gerente a cargo: \n");
        Gerente.setSueldo(Integer.parseInt(br.readLine()));
        tienda.setGerente(Gerente);
        System.out.println("\tIngrese la direccion de la tienda: \n");
        tienda.setDirec(br.readLine());
        
        return tienda;        
    }*/
    /*public boolean deleteShopVentana(String id){
        if(listaDeShop.size()<1){            
            return false;
        }
        Tienda aux;
    	ListIterator<Tienda> itr=listaDeShop.listIterator();
        while (itr.hasNext()) {
        	aux = itr.next();
        	if(aux.getID().equals(id)) {
                    itr.remove();
                    return true;
                }
        }
        return false;
    }*/
    /*public void deleteShop() throws IOException, InterruptedException {
    	if(listaDeShop.size() < 1) {
    		//Thread.sleep(2000);
    		System.out.println("\n\tActualmente no hay ninguna tienda registrada. Volviendo al menu principal.\n");
    		return;
    	}
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("\t\n Ingresa la ID de la tienda a borrar: ");
    	String id = br.readLine();
    	int option = 0;
    	Tienda aux;
    	ListIterator<Tienda> itr=listaDeShop.listIterator();
        while (itr.hasNext()) {
        	aux = itr.next();
        	if(aux.getID().equals(id)) {
        		do{
        			
            		System.out.println("\t\n Tienda encontrada - desea eliminar al tienda permanentemente?\n\t [1] SI\n\t [2] NO");
            		option = Integer.parseInt(br.readLine());  
            		
        			switch(option) {
        				case 1:{
        					System.out.println("\n\t Eliminando Tienda - Espere por favor");
        					Thread.sleep(1000);
        					System.out.println(".");
        					Thread.sleep(1000);
        					System.out.println(".");
        					Thread.sleep(1000);
        					System.out.println(".");
        					Thread.sleep(1000);
        					itr.remove();
        					System.out.println("\n\tTienda eliminada exitosamente\n");
        					break;
        				}
        			}
        		}while(option >2 && option <1);
        	}
        }

    }*/
}