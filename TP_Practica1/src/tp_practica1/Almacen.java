/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108)
 *  Nicolás Pascual Trallero (841142)
 */
package tp_practica1;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Clase Almacen
 */
public class Almacen {

    public static final int MAX_PRODUCTOS = 10000;

    private Producto[] productos;

    /**
     * Constructor de la clase Almacen
     */
    Almacen() {
        this.productos = new Producto[MAX_PRODUCTOS];
    }

    /**
     * Añade los productos almacenados en un fichero a el Almacén
     *
     * @param rutaCompletaFichero -> Ubicación del fichero a leer
     * @return -> 0 => Éxito && not 0 => Error
     */
    public int leerProductos(String rutaCompletaFichero) {
        return 0;
    }

    /**
     * Guarda los cambios en los productos en un fichero
     *
     * @param ruta -> Ubicación del fichero a modificar
     * @return -> 0 => Éxito && not 0 => Error
     */
    public int escribirProductos(String ruta) {
        return 0;
    }

    /**
     * Modifica las existencias (si es posible) del producto con el código
     * dado con la cantidad dada
     *
     * @param codigo -> Codigo asociado al producto a modificar
     * @param cantidad -> Cantidad por la que se modificará el producto
     * @return -> 0 => Éxito && not 0 => Error
     */
    public int modificarExistencias(int codigo, int cantidad) {
        return 0;
    }
}
