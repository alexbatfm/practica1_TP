/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108)
 *  Nicolás Pascual Trallero (841142)
 */
package tp_practica1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase albaran
 */
public class Albaran {

    public static final int MAX_PRODUCTOS = 100;

    private String codigo;
    private Producto[] productos;
    private String cliente;
    private Date date = new Date();
    private SimpleDateFormat fecha;
    private final String patron = "E, dd MM yyyy h:mm";

    /**
     * Constructor de la clase albaran
     */
    Albaran(String codigo, String cliente) {
        this.codigo = codigo;
        this.productos = new Producto[MAX_PRODUCTOS];
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            productos[i] = null;
        }
        this.cliente = cliente;
        fecha = new SimpleDateFormat(patron);
    }

    /**
     * Genera el albrarán con el nombre del mismo
     */
    public void generar() throws Exception {
        PrintWriter fichero = new PrintWriter(new BufferedWriter(new FileWriter(codigo + ".txt")));

        fichero.println("Numero de Albaran: " + codigo
                + "                       Cliente: " + cliente);

        for (int n = 0; n < MAX_PRODUCTOS; n++) {
            if (productos[n] != null) {
                productos[n].escribir(fichero);
            }
        }

        fichero.println("\n" + "Fecha: " + fecha.format(date));

        fichero.close();
    }

    /**
     * Añade un producto al albarán
     */
    public boolean anadirProducto(Producto p) {
        //Buscamos a ver si el producto existe ya
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (productos[i] != null) {
                if (productos[i].getCodigo() == codigo) {
                    productos[i].modificarExistencias(p.getExistencias());
                    return true;
                }
            }
        }

        //En caso de que no estuviera, se añade en el primer hueco disponible 
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (productos[i] == null) {
                productos[i] = p;
                return true;
            }
        }

        // Ni estaba en la lista ya, ni había sitio
        return false;
    }

    /**
     * Elimina un producto del albarán return null <=> codigoError: 1 =>
     * PROUCTO NO ENCONTRADO 2 => EXISTENCIAS INSUFICIENTES
     */
    public Producto eliminarProducto(String codigo, int existencias, int codigoError) {
        Producto aux = null;
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (productos[i] != null && productos[i].getCodigo() == codigo) {
                if (productos[i].obtenerExistencias(aux, existencias)) {
                    if (productos[i].getExistencias() == 0) {
                        productos[i] = null;
                    }
                    return aux;
                } else {
                    codigoError = 2;
                    return null;
                }
            }
        }

        //No se ha encontrado el producto a eliminar
        codigoError = 1;
        return null;
    }
}
