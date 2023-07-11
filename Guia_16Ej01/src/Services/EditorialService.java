/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Editorial;
import HacksDPackage.Servicios;
import Persistance.EditorialDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dudum
 */
public class EditorialService {
    
    Servicios serv = new Servicios();
    EditorialDAO editD = new EditorialDAO();
    
    
     public Editorial crearEditorial() throws Exception {
        
         Editorial edit = new Editorial();
         
         System.out.print("Nombre Editorial: ");
         String nombre = serv.Editoriales();
         System.out.println(nombre);
         serv.wait(300);
         boolean alta = true;
         
         edit= editD.buscarXEditorial(nombre);
         
         if (edit == null){
             
             edit = new Editorial();
             
             edit.setNombre(nombre);
             edit.setAlta(alta);
             editD.guardar(edit);
             
         }
         
         return edit;
         
     
     }
    
    
}
