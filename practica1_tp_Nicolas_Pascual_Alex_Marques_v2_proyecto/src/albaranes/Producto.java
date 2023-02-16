/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108) responsable de calidad
 *  Nicolás Pascual Trallero (841142) responsable de funcionalidad
 */
package albaranes;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase producto
 */
class Producto {

    private String codigo;
    private String nombre;
    private int existencias;

    /**
     * Constructor de la clase Producto
     */
    Producto(String codigo, String nombre, int existencias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.existencias = existencias;
    }

    /**
     * Constructor de la clase Producto a partir de un Scanner
     */
    Producto(Scanner fichero){
        try{
            codigo = fichero.next();
            nombre = fichero.next();
            existencias = fichero.nextInt();
        }catch(Exception e){
            System.err.println("Codigo encontrado: " + codigo + "\n" +
                               "Nombre encontrado: " + nombre + "\n" + 
                               "Existencias encontradas: " + existencias);
        }
    }

    /**
     * Guarda un producto escribiendolo en un PrintWriter
     */
    void escribir(PrintWriter pw) {
        pw.println(codigo + " " + nombre + " " + existencias);
    }

    /**
     * Aumenta las existencias del producto en cantidad
     */
    public boolean aumentarExistencias(int cantidad) {
        if (existencias + cantidad < 0) {
            return false;
        }

        existencias = existencias + cantidad;
        return true;
    }
    
    /**
     * Disminuye las existencias del producto en cantidad
     */
    public boolean disminuirExistencias(int cantidad){
        if (existencias - cantidad < 0){
            return false;
        }
        
        existencias = existencias - cantidad;
        return true;
    }

    /**
     * Devuelve la información del producto en 
     * formato de cadena de caracteres
     */
    @Override
    public String toString() {
        return (this.codigo + " " + this.nombre);
    }

    /**
     * Devuelve el codigo del producto
     */
    String devuelveCodigo() {
        return this.codigo;
    }
}
