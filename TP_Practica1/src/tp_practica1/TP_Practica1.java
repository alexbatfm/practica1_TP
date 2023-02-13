/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108)
 *  Nicolás Pascual Trallero (841142)
 */
package tp_practica1;

/**
 * Clase de test de la práctica 1
 */
public class TP_Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Almacen a = new Almacen();
        int codigoError = 0;

        try {
            a.leerProductos("productos.txt");
        } catch (Exception e) {
            System.out.println("Error al leer los productos");
            e.printStackTrace();
        }

        try {
            a.nuevoAlbaran("a_01", "Manuel");
            a.anadirProductoAlbaran("1_ALGH", 20, codigoError);
            a.anadirProductoAlbaran("2_ALGH", 3, codigoError);
            a.anadirProductoAlbaran("2_ALGH", 4, codigoError);
            a.anadirProductoAlbaran("3_ALGH", 3, codigoError);
            a.eliminarProductoAlbaran("2_ALGH", 2, codigoError);

        } catch (Exception e) {
            System.out.println("Error en proceso intermedio");
            e.printStackTrace();
        }

        try {
            a.escribirProductos("CopiaProductos.txt");
        } catch (Exception e) {
            System.out.println("Error al guardar los productos");
            e.printStackTrace();
        }

        try {
            a.generarAlbaran();
        } catch (Exception e) {
            System.err.println("Error al generar el albaran");
            e.printStackTrace();
        }
    }

}
