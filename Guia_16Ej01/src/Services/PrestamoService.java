/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Cliente;
import Entities.Libro;
import HacksDPackage.Servicios;
import Persistance.LibroDAO;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author dudum
 */
public class PrestamoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    LibreriaService ls = new LibreriaService();
    LibroDAO libDAO = new LibroDAO();
    Servicios serv = new Servicios();
    ClienteService cls = new ClienteService();

    public void prestarLibro() throws Exception {

        boolean ref = false;

        System.out.println("Ingrese el libro a pedir prestado");
        String titulo = leer.next();

        Libro libro = libDAO.buscarXTitulo(titulo);

        if (libro == null) {
            System.out.println("El libro solicitado no se encuentra en nuestras bases");
            ref = false;
        } else {
            ref = true;
        }
        if (ref) {
            System.out.println("Ingrese DNI del cliente");
            long dni = serv.validarLong();

            Cliente cliente = cls.buscarXDni(dni);
            
            Date fechaPrestamo;  // Continuar poniendo fecha de prestamo
        
        
        
        
        }
        
    }

}
