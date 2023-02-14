/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108)
 *  Nicolás Pascual Trallero (841142)
 */
package tp_practica1;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase Almacen
 */
public class Almacen {

    public static final int MAX_PRODUCTOS = 10000;

    private Producto[] productos;
    private Albaran albaran;

    /**
     * Constructor de la clase Almacen
     */
    Almacen() {
        productos = new Producto[MAX_PRODUCTOS];
    }

    /**
     * Lee los productos de un fichero en la ruta nombreFichero
     */
    void leerProductos(String nombreFichero) throws Exception {
        int n = 0;
        Scanner fichero = new Scanner(new FileInputStream(nombreFichero));

        if (n != MAX_PRODUCTOS) {
            while (fichero.hasNext()) {
                productos[n++] = new Producto(fichero);
            }
        }
        fichero.close();
    }

    /**
     * Guarda los productos en un fichero en la ruta nombreFichero
     */
    void escribirProductos(String nombreFichero) throws Exception {
        PrintWriter fichero = new PrintWriter(new BufferedWriter(new FileWriter(nombreFichero)));
        for (int n = 0; n < MAX_PRODUCTOS; n++) {
            if (productos[n] != null) {
                productos[n].escribir(fichero);
            }
        }
        fichero.close();
    }

    /**
     * Crea el albaran para anotar los movimientos del almacen
     */
    public void nuevoAlbaran(String codigo, String cliente) {
        this.albaran = new Albaran(codigo, cliente);
    }

    /**
     * Genera el albaran del almacen
     */
    public void generarAlbaran() throws Exception {
        this.albaran.generar();
    }

    /**
     * Añade una cantidad (existencias) del producto con el código "codigo"
     * del almacén al albarán
     *
     * En caso de éxito devuelve 0 En caso de error (return false) devuelve (
     * -1 => PRODUCTO NO ENCONTRADO, -2 => EXISTENCIAS INSUFICIENTES, -3 => NO
     * SITIO ALBARAN
     */
    public int insertarProductoAlbaran(String codigo, int existencias) {
        int error = 0;
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (productos[i] != null) {
                if (productos[i].getCodigo().equals(codigo)) {
                    if (productos[i].modificarExistencias(-1)) {
                        if (albaran.insertarProducto(productos[i])) {
                            return 0;
                        } else {
                            productos[i].modificarExistencias(1);
                            return -3;
                        }
                    } else {
                        return -2;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Añade una cantidad (existencias) del producto con el código "codigo"
     * del albraán al almacén
     *
     * En caso de éxito devuelve 0. En caso de error devuelve ( -1 => PRODUCTO
     * NO ENCONTRADO, -2 => ERROR AL MODIFICAR EXISTENCIAS, -3 => ERROR FATAL
     * (PRODUCTO ANOTADO EN EL ALBARÁN QUE NO CONSTA EN EL ALMACÉN
     */
    public int eliminarProductoAlbaran(String codigo, int existencias) {
        if (albaran.eliminarProducto(codigo)) {
            for (int i = 0; i < MAX_PRODUCTOS; i++) {
                if (productos[i] != null) {
                    if (productos[i].getCodigo().equals(codigo)) {
                        if (productos[i].modificarExistencias(1)) {
                            return 0;
                        } else {
                            return -2;
                        }
                    }
                }
            }
            return -3;
        } else {
            return -1;
        }
    }
}