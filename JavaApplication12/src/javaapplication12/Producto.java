/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication12;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author nicop
 */
class Producto 
{
    private String codigo;
    private String nombre;
    private int existencias;
    
    Producto(Scanner fichero) 
    {
        codigo = fichero.next();
        nombre = fichero.next();
        existencias = fichero.nextInt();
        fichero.nextLine();
    }
    
    void guardar(PrintWriter pw)
    {
        pw.println(codigo + " " + nombre + " " + existencias);
    }
    
    int modificarExistencias(int cantidad)
    {
        return 0;
    }
    
    String devuelveCodigo()
    {
        return codigo;
    }
}
