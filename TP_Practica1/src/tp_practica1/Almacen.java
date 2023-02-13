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
     * En caso de error (return false) codigo error = ( 1 => PRODUCTO NO
     * ENCONTRADO, 2 => EXISTENCIAS INSUFICIENTES, 3 => NO SITIO ALBARAN, 4 =>
     * ERROR FATAL (Inconsistencia Datos))
     */
    public boolean anadirProductoAlbaran(String codigo, int existencias, int codigoError) {
        Producto aux = null;
        int i = 0;
        boolean exito = false;

        // Se obtiene el producto del almacen
        while (i < MAX_PRODUCTOS || !exito) {
            if (productos[i] != null && productos[i].getCodigo().equals(codigo)) {
                exito = productos[i].obtenerExistencias(aux, existencias);
                if (!exito) {
                    codigoError = 2;
                    return false;
                }
            }
            i = i + 1;
        }

        if (i == MAX_PRODUCTOS) {
            // Se ha llegado al final de los productos y no se ha encontrado
            codigoError = 1;
            return false;
        }

        // Y se anota en el albarán
        if (!albaran.anadirProducto(aux)) {
            // Se trata de deshacer la transacción
            if (!productos[i].modificarExistencias(existencias)) {
                codigoError = 4;
                return false;
            }
            codigoError = 3;
            return false;
        }

        return true;
    }

    /**
     * Añade una cantidad (existencias) del producto con el código "codigo"
     * del albraán al almacén
     *
     * En caso de error (return false) codigo error = ( 1 => PRODUCTO NO
     * ENCONTRADO, 2 => EXISTENCIAS INSUFICIENTES, 3 => NO SITIO ALMACÉN, 4 =>
     * ERROR FATAL (Inconsistencia Datos))
     */
    public boolean eliminarProductoAlbaran(String codigo, int existencias, int codigoError) {
        Producto aux;
        int i = 0;
        boolean exito = false;

        aux = albaran.eliminarProducto(codigo, existencias, codigoError);
        if (aux == null) {
            // codigoError ya está actualizado (Será 1 ó 2)
            return false;
        }

        while (i < MAX_PRODUCTOS || !exito) {
            if (productos[i] != null && productos[i].getCodigo().equals(codigo)) {
                exito = productos[i].modificarExistencias(existencias);

                if (exito) {
                    return true;
                } else {
                    codigoError = 4;
                    return false;
                }
            }
            i = i + 1;
        }
        /** No es posible que no haya encontrado un producto con código igual
        * puesto que los productos del albarán antes vienen del almacén y 
        * aunque se anote 0, no se elimina, por lo tanto si se llega aquí
        * es un error fatal igualmente **/
        codigoError = 4;
        return false;
    }
}
