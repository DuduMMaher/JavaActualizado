/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.persistencia;

import Tienda.entidades.Producto;

/**
 *
 * @author dudum
 */
public final class ProductoDAO extends DAO {
    
    public void guardarProducto (Producto producto) throws Exception {
        
        try {
            if (producto == null) {
                throw new Exception ("Debe ingresar un Producto");
            }
            
            String sql = "INSERT INTO Producto (nombre, precio, codigo_Fabricante)"
                    + "VALUES ('" + producto.getNombre()+ "', " + producto.getPrecio() + ", " + producto.getCodigoFabricante() + ");";
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void modificarProducto (Producto producto) throws Exception {
        
        try {
            if (producto == null) {
                throw new Exception ("Debe ingresar un Producto a modificar");
            }
            
            String sql = "UPDATE Producto SET "
                    + "precio = " + producto.getPrecio()+ " WHERE nombre = '" + producto.getNombre() +"';";
                    
                    
                    
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
   public void eliminarProducto (Producto producto) throws Exception {
       
       try {
            if (producto == null) {
                throw new Exception ("Debe ingresar un Producto a eliminar");
            }
       
       String sql = "DELETE FROM Producto WHERE nombre LIKE '" + producto.getNombre() +"';";
       
            insertarModificarEliminar(sql);
            
       } catch (Exception e) {
            throw e;
        }
       
       
       
   }
    
}
