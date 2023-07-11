/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dudum
 */
public abstract class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
            
    protected void conectarBase() throws ClassNotFoundException, SQLException {
        
       try{
           Class.forName(DRIVER);
           String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?zeroDateTimeBehavior=CONVERT_TO_NULL";
           conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
           System.out.println("Base de Datos Conectada");
       } catch (ClassNotFoundException | SQLException ex) {
           throw ex;
       }
    }
    
    
// serverTimezone=UTC
// zeroDateTimeBehavior=CONVERT_TO_NULL";
// jdbc:mysql://localhost:3306/perros?serverTimezone=UT
// jdbc:mysql://localhost:3306/perros?serverTimezone=UTC
    
    
    protected void desconectarBase() throws Exception {
        
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            } catch (Exception e) {
                System.out.println("ERROR. NO SE PUDO DESCONECTAR");
                throw e;
            }
    }
    
    protected void insertarModificarEliminar(String sql) throws Exception {
        
        
        try{
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            
        } catch (SQLException ex) {
            // conexion.rollback();
            /*  Descomentar la linea anterior si desean tener en cuenta el rollback.
                Correr el siguiente script en Workbench
            
                SET autocommit=1;
                COMMIT;
            
                **Sin rollback igual anda */
             
            throw ex;
        }
    }
    
    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    
    
    
}
