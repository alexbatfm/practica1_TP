/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication12;

/**
 *
 * @author nicop
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Almacen a = new Almacen();
       
        try{
            a.leerProductos("productos.txt");
        }catch(Exception e){
            System.out.println("Error al leer los productos");
            e.printStackTrace();
        }
        
        try{
            a.guardarProductos(" etdhg.txt");
        }catch(Exception e){
            System.out.println("Error al guardar los productos");
            e.printStackTrace();
        }
    }
}
