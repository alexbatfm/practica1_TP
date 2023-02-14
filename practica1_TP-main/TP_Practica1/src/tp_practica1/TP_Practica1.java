/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108) responsable de calidad
 *  Nicolás Pascual Trallero (841142) responsable de funcionalidad
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
            System.out.println("Error de entrada salida "
                    + "al leer los productos");
            e.printStackTrace();
        }

        try {
            a.nuevoAlbaran("a_01", "Manuel");
            for(int n = 0; n <= 30; n++)
            {
                if(a.insertarProductoAlbaran("1_ALGH") < 0){
                    System.err.println("Error al introducir producto al albaran");
                }
            }
            if(a.insertarProductoAlbaran("2_ALGH") < 0){
                System.err.println("Error al introducir producto al albaran");
            }
            if(a.insertarProductoAlbaran("2_ALGH") < 0){
                System.err.println("Error al introducir producto al albaran");
            }
            if(a.insertarProductoAlbaran("3_ALGH") < 0){
                System.err.println("Error al introducir producto al albaran");
            }
            if(a.eliminarProductoAlbaran("2_ALGH") < 0){
                System.err.println("Error al introducir producto al albaran");
            }
        } catch (Exception e) {
            System.out.println("Error de entrada salida "
                    + "al crear un albaran");
            e.printStackTrace();
        }
        
        try {
            a.nuevoAlbaran("a_02", "Francisco");
        } catch (Exception e) {
            System.out.println("Error de entrada salida "
                    + "al crear un albaran");
            e.printStackTrace();
        }
        
        try {
            a.generarAlbaran();
        } catch (Exception e) {
            System.err.println("Error de entrada salida "
                    + "al generar el albaran");
            e.printStackTrace();
        }
        
        try {
            a.nuevoAlbaran("a_03", "Pepe");
        } catch (Exception e) {
            System.out.println("Error de entrada salida "
                    + "al crear un albaran");
            e.printStackTrace();
        }
        
        try {
            a.generarAlbaran();
        } catch (Exception e) {
            System.err.println("Error de entrada salida "
                    + "al generar el albaran");
            e.printStackTrace();
        }
        
        try {
            a.escribirProductos("CopiaProductos.txt");
        } catch (Exception e) {
            System.out.println("Error de entrada salida "
                    + "al guardar los productos");
            e.printStackTrace();
        }
    }

}
