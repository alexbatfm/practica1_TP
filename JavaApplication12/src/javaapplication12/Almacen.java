/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication12;

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
            while (fichero.hasNextLine()) {
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
     * POR IMPLEMENTAR Añade un producto al albaran
     */
    public boolean anadirProducto(int codigo, int cantidad) {
        return true;
    }

    /**
     * POR IMPLEMENTAR Elimina un producto del albaran
     */
    public boolean eliminarProducto(int codig, int cantidad) {
        return true;
    }

    /**
     * PENDIENTE DE REVISAR
     */
    int modificarExistencias(int cantidad, String codigo) {
        for (int n = 0; n < MAX_PRODUCTOS; n++) {
            if (productos[n].getCodigo().equals(codigo)) {
                productos[n].modificarExistencias(cantidad);
                return 0;
            }
        }
        return 1;
    }
}
