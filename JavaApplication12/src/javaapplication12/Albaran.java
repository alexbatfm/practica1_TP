/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nicop
 */
public class Albaran 
{
    public static final int MAX_PRODUCTOS = 100;
    
    private String codigo;
    private Producto[] productos;
    private String cliente;
    private Date date = new Date();
    private SimpleDateFormat fecha;
    private final String patron = "E, dd MM yyyy h:mm";
    
    Albaran(String codigo, String cliente) 
    {
        this.codigo = codigo;
        this.productos = new Producto[MAX_PRODUCTOS];
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            productos[i] = null;
        }
        this.cliente = cliente;
        fecha = new SimpleDateFormat(patron);
    }
    
    public void generar() throws Exception
    {
        PrintWriter fichero = new PrintWriter(new BufferedWriter
                             (new FileWriter(codigo + ".txt")));
        
        fichero.println("Numero de Albaran: " + codigo +
                        "                       Cliente: " + cliente);
        
        for(int n = 0; n < MAX_PRODUCTOS; n++)
        {
            if(productos[n] != null)
            {
                productos[n].guardar(fichero);
            }
        }
        
        fichero.println("\n" + "Fecha: " + fecha.format(date));
        
        fichero.close();
    }
}
