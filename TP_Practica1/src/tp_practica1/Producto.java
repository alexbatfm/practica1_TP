/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108)
 *  Nicolás Pascual Trallero (841142)
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
    Producto(Scanner fichero) {
        codigo = fichero.next();
        nombre = fichero.next();
        existencias = fichero.nextInt();
        fichero.nextLine();
    }

    /**
     * Guarda un producto escribiendolo en un PrintWriter
     */
    void escribir(PrintWriter pw) {
        pw.println(codigo + " " + nombre + " " + existencias);
    }

    /**
     * Aumenta las existencias del producto en num (num puede ser negativo)
     */
    public boolean modificarExistencias(int num) {
        if (num + existencias < 0) {
            return false;
        }

        existencias = existencias + num;
        return true;
    }

    /**
     * Modifica las existencias a existencias - cantidad y devuelve un
     * producto equivalente con tal cantidad de existencias
     */
    public boolean obtenerExistencias(Producto p, int cantidad) {
        if (this.modificarExistencias(-cantidad)) {
            p = new Producto(this.codigo, this.nombre, this.existencias);
            return true;
        }
        return false;
    }

    /**
     * Devuelve la información del producto en formato de cadena de caracteres
     */
    @Override
    public String toString() {
        return this.codigo + " " + this.nombre + " " + this.existencias;
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
