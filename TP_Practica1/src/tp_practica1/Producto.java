/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108)
 *  Nicolás Pascual Trallero (841142)
 */
package tp_practica1;

/**
 * Clase Producto
 */
public class Producto {

    private String codigo;
    private String nombre;
    private int existencias;

    /**
     * Constructor de la clase Producto
     *
     * @param codigo
     * @param nombre
     * @param existencias
     */
    Producto(String codigo, String nombre, int existencias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.existencias = existencias;
    }
    
    /**
     * Compara el producto llamador con el producto p
     * @param p -> el producto con el que se compara el producto llamador
     * @return -> TRUE en caso de que coincida el codigo 
     *            FALSE en caso contrario
     */
    public boolean esIgual(Producto p){
        return this.codigo == p.codigo;
    }

    /**
     * Modifica las existencias de un producto en base a un número
     *
     * @param num -> Simboliza el número de unidades a retirar/añadir.
     * @return -> FALSE si la operacion hace que las existencias sean
     * negativas TRUE en caso contrario
     */
    public boolean modificarExistencias(int num) {
        if (num + existencias < 0) {
            return false;
        }

        existencias = existencias + num;
        return true;
    }
    
    /**
     * Modifica las existencias del producto llamador con el numero de 
     * existencias del producto pasado por parametro
     * @param p -> Producto del que obtener las existencias
     * @return -> TRUE en caso de éxito
     *            FALSE en caso de que no this.esIgual(p) ó no se puedan 
     *            modificar las existencias;
     */
    public boolean modificarExistencias(Producto p){
        if (this.esIgual(p)){
            if (modificarExistencias(p.existencias)){
                return true;
            }
            return false;
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
}
