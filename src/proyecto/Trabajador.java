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
public abstract class Trabajador implements Serializable{
       private String name;
       private String rut;
       protected int sueldo;
       protected boolean pago;
       
       public void setName(String name){
            this.name = name;
       }
       public String getName(){
            return this.name;    
       }
       public void setRut(String rut){
            this.rut=rut;
       }
       public String getRut(){
            return this.rut;   
       }
       public void setSueldo(int sueldo){
           this.sueldo = sueldo;
       }
       public int getSueldo(){
           return this.sueldo;
       }
}