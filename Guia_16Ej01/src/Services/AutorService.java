/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Autor;
import HacksDPackage.Servicios;
import Persistance.AutorDAO;
import Persistance.DAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dudum
 */
public class AutorService {

    Servicios serv = new Servicios();
    AutorDAO auD = new AutorDAO();

    public Autor crearAutor() throws Exception {

        Autor au = new Autor();
        System.out.print("Nombre del Autor: ");
        String nombre = serv.Autores();
        System.out.println(nombre);
        serv.wait(300);
        boolean alta = true;

        au = buscarAutor(nombre);

        

        if (au == null) {

            au = new Autor();
            
            au.setNombre(nombre);
            au.setAlta(alta);
           auD.guardar(au);
            
        } 
           
       
        
        return au;
    }

    public Autor buscarAutor(String nombre) throws Exception {

        try {
            return auD.buscarXNombre(nombre);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            serv.wait(500);
            return null;
        }

    }

}
