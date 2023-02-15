/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108) responsable de calidad
 *  Nicolás Pascual Trallero (841142) responsable de funcionalidad
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
        PrintWriter fichero = new PrintWriter(new BufferedWriter
                    (new FileWriter(codigo + ".txt")));

        fichero.println("Numero de Albaran: " + codigo
                + "                       Cliente: " + cliente
                + "                       Fecha: " + fecha.format(date));

        for (int n = 0; n < MAX_PRODUCTOS; n++) {
            if (productos[n] != null) {
                fichero.println(productos[n].toString());
            }
        }


        fichero.close();
    }

    /**
     * Añade un producto al albarán Devuelve true en caso de que quepa el
     * producto en el albarán y false en caso contrario.
     */
    public boolean insertarProducto(Producto p) {
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (productos[i] == null) {
                productos[i] = p;
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un producto del albarán 
     * Devuelve true en caso de éxito y false 
     * en caso de no encontrar el producto
     */
    public boolean eliminarProducto(String codigo) {
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (productos[i] != null){
                if (productos[i].getCodigo().equals(codigo)){
                    productos[i] = null;
                    return true;                    
                }
            }
        }
        return false;
    }
}
