/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108) responsable de calidad
 *  Nicolás Pascual Trallero (841142) responsable de funcionalidad
 */
package albaranes;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase Almacen
 */
public class Almacen {

    public static final int MAX_PRODUCTOS = 20;
    public static final int EXITO = 0;
    public static final int PRODUCTO_NO_ENCONTRADO = -1;
    public static final int EXISTENCIAS_INSUFICIENTES = -2;
    public static final int NO_SITIO_ALBARAN = -3;
    public static final int ERROR_MODIFICAR_EXISTENCIAS = -2;
    public static final int ERROR_FATAL = -3;
    
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
        if(nombreFichero != null)
        {
            Scanner fichero = new Scanner
                                (new FileInputStream(nombreFichero));
            try {
                while (fichero.hasNext() && n < MAX_PRODUCTOS){
                    productos[n++] = new Producto(fichero);
                }
            } catch (Exception e) {
                System.err.println("Error al leer el producto " + (n + 1));
            }
            fichero.close();
        }else{
            System.err.println("No se ha proporcionado un fichero");
        }
    }
    
    /**
     * Guarda los productos en un fichero en la ruta nombreFichero
     */
    void escribirProductos(String nombreFichero) throws Exception {
        PrintWriter fichero = new PrintWriter
            (new BufferedWriter(new FileWriter(nombreFichero)));
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
    public boolean nuevoAlbaran(String codigo, String cliente) {
        if(albaran != null)
        {
            return false;
        }
        this.albaran = new Albaran(codigo, cliente);
        return true;
    }

    /**
     * Genera el albaran del almacen
     */
    public boolean generarAlbaran() throws Exception {
        if(albaran == null)
        {
            return false;
        }
        
        this.albaran.generar();
        albaran = null;
        return true;
    }

    /**
     * Añade una producto del almacén al albarán.
     */
    public int insertarProductoAlbaran(String codigo) {
        int error = 0;
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (productos[i] != null) {
                if (productos[i].getCodigo().equals(codigo)) {
                    if (productos[i].aumentarExistencias(-1)) {
                        if (albaran.insertarProducto(productos[i])) {
                            return EXITO;
                        } else {
                            productos[i].aumentarExistencias(1);
                            return NO_SITIO_ALBARAN;
                        }
                    } else {
                        return EXISTENCIAS_INSUFICIENTES;
                    }
                }
            }
        }
        return PRODUCTO_NO_ENCONTRADO;
    }

    /**
     * Añade un producto del albarán al almacén
     */
    public int eliminarProductoAlbaran(String codigo) {
        if (albaran.eliminarProducto(codigo)) {
            for (int i = 0; i < MAX_PRODUCTOS; i++) {
                if (productos[i] != null) {
                    if (productos[i].getCodigo().equals(codigo)) {
                        if (productos[i].aumentarExistencias(1)) {
                            return EXITO;
                        } else {
                            return ERROR_MODIFICAR_EXISTENCIAS;
                        }
                    }
                }
            }
            return ERROR_FATAL;
        } else {
            return PRODUCTO_NO_ENCONTRADO;
        }
    }
}