/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Zekro
 */
public class ListaTrabajadores {
    private ArrayList<Trabajador> listaTrabajadores;
    
    public ListaTrabajadores(){
         listaTrabajadores = new ArrayList<>();
    }
    public int obtenerTamañoListaTrabajadores(){
        return listaTrabajadores.size();
    }
    public void agregarTrabajador(Trabajador obj){
        
        //BUSCAR TRABAJADOR EN ESTA CLASE
    	listaTrabajadores.add(obj);
    }
    public Trabajador crearTrabajador(String Nombre, String Rut, String Cargo, String Sueldo){
    	Trabajador nuevo = new Trabajador();
    	nuevo.setName(Nombre);
    	nuevo.setRut(Rut);
    	nuevo.setCargo(Cargo);
    	nuevo.setSueldo(Integer.parseInt(Sueldo));
    	return nuevo;
    }
    public Trabajador buscarTrabajador(String rut) {
    	ListIterator<Trabajador> itr=listaTrabajadores.listIterator();
        while (itr.hasNext()) {
            Trabajador aux = itr.next();
            if(aux.getRut().equals(rut)) {
            	return aux;
            }
        }
    	return null;
    }
    public void guardarArchivoTrabajadores() throws IOException {
    	ListIterator<Trabajador> itr=listaTrabajadores.listIterator();
        File file = new File("TrabajadoresRegistrados.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            while (itr.hasNext()) {
                Trabajador aux = itr.next();
                bw.write("\n[Nombre: "+aux.getName()+"]->[Rut: "+aux.getRut()+"]->"
                        + "[Cargo: "+aux.getCargo()+"]->[Sueldo: "+aux.getSueldo()+"]");
            }
        }
    }
}
