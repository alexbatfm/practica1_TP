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
    void guardarProductos(String nombreFichero) throws Exception {
        PrintWriter fichero = new PrintWriter(new BufferedWriter(new FileWriter(nombreFichero)));
        for (int n = 0; n < MAX_PRODUCTOS; n++) {
            if (productos[n] != null) {
                productos[n].guardar(fichero);
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
     * POR IMPLEMENTAR Añade un producto al albaran
     */
    public boolean anadirProducto(String codigo, int cantidad) {
        return true;
    }

    /**
     * POR IMPLEMENTAR Elimina un producto del albaran
     */
    public boolean eliminarProducto(String codigo, int cantidad) {
        return true;
    }

    /**
     * PENDIENTE DE REVISAR
     */
    boolean modificarExistencias(int cantidad, String codigo) {
        for (int n = 0; n < MAX_PRODUCTOS; n++) {
            if (productos[n].getCodigo().equals(codigo)) {
                if (productos[n].modificarExistencias(cantidad)){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
