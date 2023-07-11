/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tienda;

import Tienda.entidades.Producto;
import Tienda.persistencia.ProductoDAO;
import java.util.Scanner;

/**
 *
 * @author dudum
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ProductoDAO pr = new ProductoDAO();
        
        
        
        
//        System.out.println("Insertar Producto");
//        System.out.print("Descripcion: ");
//        String nombre = leer.next();
//        System.out.print("Precio: ");
//        double precio = leer.nextDouble();
//        System.out.print("Codigo Fabricante: ");
//        String codigoFabricante = leer.next();
//        
//        Producto producto = new Producto ( nombre, precio, codigoFabricante);
//        
//        try {
//        pr.guardarProducto(producto);
//        } catch (Exception e) {
//            throw e;
//        }
        
//        System.out.println("Insertar Producto a Modificar");
//        System.out.print("Descripcion: ");
//        String nombre = leer.next();
//        System.out.print("Precio: ");
//        double precio = leer.nextDouble();
//        
//        Producto producto = new Producto ( nombre, precio, null);
//        
//        pr.modificarProducto(producto);
        
        
        System.out.println("Insertar Producto a Eliminar");
        System.out.print("Descripcion: ");
        String nombre = leer.next();
        
        
        Producto producto = new Producto (nombre, 0.00, null);
        
        pr.eliminarProducto(producto);
    }
    
}
