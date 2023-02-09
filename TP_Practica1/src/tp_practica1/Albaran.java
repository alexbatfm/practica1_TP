/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108)
 *  Nicolás Pascual Trallero (841142)
 */
package tp_practica1;

import java.util.Date;

/**
 * Clase Albarán
 */
public class Albaran {

    public static final int MAX_PRODUCTOS = 100;

    private int codigo;
    private Producto[] productos;
    private String cliente;
    private Date fecha;

    /**
     * Constructor para la clase Albarán
     *
     * @param codigo
     * @param cliente
     */
    Albaran(int codigo, String cliente) {
        this.codigo = codigo;
        this.productos = new Producto[MAX_PRODUCTOS];
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            productos[i] = null;
        }
        this.cliente = cliente;
        this.fecha = new Date();
    }

    /**
     * Añade un producto (si es posible) a la lista de productos de un albarán
     *
     * @param p -> Producto a añadir
     * @return -> FALSE en caso de error
     *            TRUE en caso de éxito
     */
    public boolean anadirProducto(Producto p) {
        return true;
    }

    /**
     * Elimina existencias (si es posible) a los productos de un albarán
     *
     * @param codigo -> Codigo del producto a eliminar
     * @param cantidad -> Numero de existencias a eliminar de dicho producto
     * @return -> 0 => Éxito && not 0 => Error
     */
    public int eliminarProducto(int codigo, int cantidad) {
        return 0;
    }

    /**
     * Genera un fichero con la información del albarán en la ubicacion:
     * ./albaranes/al_[codigo].txt
     */
    public void generar() {
    }

}
