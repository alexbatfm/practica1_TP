/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108) responsable de calidad
 *  Nicolás Pascual Trallero (841142) responsable de funcionalidad
 */
package tp_practica1;

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
    Producto(Scanner fichero) throws Exception {
        try{
        codigo = fichero.next();
        nombre = fichero.next();
        existencias = fichero.nextInt();
        }catch(Exception e){
            throw new Exception("Error en la lectura del producto");
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
     * (cantidad puede ser nagativo)
     */
    public boolean modificarExistencias(int cantidad) {
        if (cantidad + existencias < 0) {
            return false;
        }

        existencias = existencias + cantidad;
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
    String getCodigo() {
        return this.codigo;
    }

    /**
     * Devuelve las existencias del producto
     */
    int getExistencias() {
        return this.existencias;
    }
}
