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
public class ExceptionSoloLetras extends Exception{
    public ExceptionSoloLetras() { 
        super(); 
    }
    public ExceptionSoloLetras(String message)
    {
         super(message);
    }
}
