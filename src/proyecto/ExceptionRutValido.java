/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Zekro
 */
public class ExceptionRutValido extends Exception{
    public ExceptionRutValido() { 
        super(); 
    }
    public ExceptionRutValido(String message)
    {
         super(message);
    }   
}
