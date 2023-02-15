/**
 * Versión 1.0
 *
 * Autores:
 *  Álex Marqués Fernández (846108) responsable de calidad
 *  Nicolás Pascual Trallero (841142) responsable de funcionalidad
 */
package albaranes;

/**
 * Clase de test
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        int codigoError = 0;

        try {
            almacen.leerProductos("productos.txt");
        } catch (Exception e) {
            System.out.println("Error de entrada salida "
                    + "al leer los productos");
            e.printStackTrace();
        }

        try {
            almacen.nuevoAlbaran("a_01", "Manuel");
            if (almacen.insertarProductoAlbaran("1_ALGH") != Almacen.EXITO)
            {
                System.err.println("Error al introducir "
                        + "producto al albaran");
            }
            if (almacen.insertarProductoAlbaran("1_ALGH") != Almacen.EXITO)
            {
                System.err.println("Error al introducir "
                        + "producto al albaran");
            }
            if (almacen.insertarProductoAlbaran("1_ALGH") != Almacen.EXITO)
            {
                System.err.println("Error al introducir "
                        + "producto al albaran");
            }
            if (almacen.insertarProductoAlbaran("1_ALGH") != Almacen.EXITO)
            {
                System.err.println("Error al introducir "
                        + "producto al albaran");
            }
            if(almacen.insertarProductoAlbaran("2_ALGH") < 0){
                System.err.println("Error al introducir "
                        + "producto al albaran");
            }
            if (almacen.insertarProductoAlbaran("2_ALGH") != Almacen.EXITO)
            {
                System.err.println("Error al introducir "
                        + "producto al albaran");
            }
            if (almacen.insertarProductoAlbaran("2_ALGH") != Almacen.EXITO)
            {
                System.err.println("Error al introducir "
                        + "producto al albaran");
            }
            if (almacen.insertarProductoAlbaran("3_ALGH") != Almacen.EXITO)
            {
                System.err.println("Error al introducir "
                        + "producto al albaran");
            }
            if (almacen.eliminarProductoAlbaran("2_ALGH") != Almacen.EXITO)
            {
                System.err.println("Error al introducir " 
                        + "producto al albaran");
            }
        } catch (Exception e) {
            System.out.println("Error de entrada salida "
                    + "al crear un albaran");
            e.printStackTrace();
        }
        
        try {
            almacen.nuevoAlbaran("a_02", "Francisco");
        } catch (Exception e) {
            System.out.println("Error de entrada salida "
                    + "al crear un albaran");
            e.printStackTrace();
        }
        
        try {
            almacen.generarAlbaran();
        } catch (Exception e) {
            System.err.println("Error de entrada salida "
                    + "al generar el albaran");
            e.printStackTrace();
        }
        
        try {
            almacen.nuevoAlbaran("a_03", "Pepe");
        } catch (Exception e) {
            System.out.println("Error de entrada salida "
                    + "al crear un albaran");
            e.printStackTrace();
        }
        
        try {
            almacen.generarAlbaran();
        } catch (Exception e) {
            System.err.println("Error de entrada salida "
                    + "al generar el albaran");
            e.printStackTrace();
        }
        
        try {
            almacen.escribirProductos("CopiaProductos.txt");
        } catch (Exception e) {
            System.out.println("Error de entrada salida "
                    + "al guardar los productos");
            e.printStackTrace();
        }
    }

}
