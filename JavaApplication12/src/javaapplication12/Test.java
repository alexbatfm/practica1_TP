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
        Albaran al = new Albaran("a_01", "Manuel");

        try {
            a.leerProductos("productos.txt");
        } catch (Exception e) {
            System.out.println("Error al leer los productos");
            e.printStackTrace();
        }

        try {
            a.guardarProductos("CopiaProductos.txt");
        } catch (Exception e) {
            System.out.println("Error al guardar los productos");
            e.printStackTrace();
        }

        try {
            al.generar();
        } catch (Exception e) {
            System.err.println("Error al generar el albaran");
            e.printStackTrace();
        }
    }
}
