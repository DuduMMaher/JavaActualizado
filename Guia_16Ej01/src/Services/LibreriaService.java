/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Autor;
import Entities.Editorial;
import Entities.Libro;
import HacksDPackage.Servicios;
import Persistance.AutorDAO;
import Persistance.EditorialDAO;
import Persistance.LibroDAO;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dudum
 */
public class LibreriaService {

    Servicios serv = new Servicios();
    AutorService aus = new AutorService();
    EditorialService eds = new EditorialService();
    LibroDAO libD = new LibroDAO();

    public void crearLibro() throws Exception {
        
        
        int ejemplares;

        System.out.println("");
        System.out.println("INGRESO DE LIBRO");
        System.out.println("----------------");
        System.out.print("isbn: ");
        
        long isbn;
        do{
            isbn = (long) serv.generarDni();
        } while (libD.buscarXIsbn(isbn) != null);
        System.out.println(isbn);
        serv.wait(300);
        System.out.print("Titulo: ");
        String titulo;
        do {
        titulo = serv.titulos();
        } while (libD.buscarXTitulo(titulo) != null);
        System.out.println(titulo);
        serv.wait(300);
        System.out.print("Año: ");
        int anio = serv.anio(1600, 2020);
        System.out.println(anio);
        serv.wait(300);
        System.out.print("Ejemplares: ");
        do {
            ejemplares = serv.numero(10);
        } while (ejemplares == 0);
        System.out.println(ejemplares);
        serv.wait(300);
        System.out.print("Ejemplares Prestados: ");
        int ejemplaresPrestados = 0;
        System.out.println(ejemplaresPrestados);
        serv.wait(300);
        System.out.print("Ejemplares restantes: ");
        int ejemplaresRestantes = ejemplares - ejemplaresPrestados;
        System.out.println(ejemplaresRestantes);
        serv.wait(300);
        boolean alta = true;
        Autor au = aus.crearAutor();
        Editorial edit = eds.crearEditorial();

        Libro lib = new Libro(isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, alta, au, edit);

        libD.guardar(lib);

    }

    public void buscarXIsbn(long bn) throws Exception {

        Libro lib;

        lib = libD.buscarXIsbn(bn);

        if (lib != null) {
            encabezado();
            System.out.println(lib.getId() + "\t" + lib.getTitulo() + "\t" + lib.getAnio() + "\t" + lib.getAutor().getNombre() + "\t" + lib.getEditorial().getNombre() + "\t\t\t" + lib.getEjemplares() + "\t\t" + lib.getEjemplaresPrestados() + "\t\t" + lib.getEjemplaresRestantes());
        } else {
            System.out.println("El libro no se encuentra en Nuestro Stock");
        }

    }

    public void buscarXTitulo(String titulo) throws Exception {

        Libro lib;

        lib = libD.buscarXTitulo(titulo);

        if (lib != null) {
            encabezado();
            System.out.printf("%1s %4s %35s %5s %30s %20s %10s %10s ", lib.getId(), lib.getTitulo(), lib.getAnio(), lib.getAutor().getNombre(), lib.getEditorial().getNombre(),lib.getEjemplares(), lib.getEjemplaresPrestados(),lib.getEjemplaresRestantes());
            System.out.println("");
        } else {
            System.out.println("El libro no se encuentra en Nuestro Stock");
        }

    }

    public void encabezado() {
        System.out.println(" *********************************************************************************************************************************");
        System.out.println("| ID | TITULO                                          | AÑO  | AUTOR                         | EDITORIAL   | CANT | PREST | DISP |");
        System.out.println("|---------------------------------------------------------------------------------------------------------------------------------|");
       
    }

    public void buscarLibrosXAutor(String nombre) throws Exception {

        AutorDAO auD = new AutorDAO();
        Autor au;
        
        au = auD.buscarXNombre(nombre);
        
        
        if (au != null) {
           
            ArrayList<Libro> libArray = new ArrayList();
            
           libArray = libD.buscarXIdAutor(au);
            
           if (libArray != null){
               imprimirListado(libArray);
           } else {
               System.out.println("La lista no dio ningun resultado"); 
           }
           
        } else {
             System.out.println("El Autor ingresado no se encuentra en nuestras Bases");
        }
    }

    private void imprimirListado(ArrayList<Libro> libArray) {
        
        encabezado();
        for (Libro lib : libArray) {
            
            System.out.printf("|%3s | %-47s | %-5d| %-30s| %-12s| %4d | %5d |%5d |\n", lib.getId(), lib.getTitulo(), lib.getAnio(), lib.getAutor().getNombre(), lib.getEditorial().getNombre(), lib.getEjemplares(), lib.getEjemplaresPrestados(), lib.getEjemplaresRestantes());
            
        }
            System.out.println("|    |                                                 |      |                               |             |      |       |      |");
            System.out.println(" *********************************************************************************************************************************");
   
}
    
    
    
    

    
    
    
    public void buscarLibrosXEditorial(String nombre2) throws Exception {
        EditorialDAO editD = new EditorialDAO();
        Editorial edit;
        
        edit = editD.buscarXEditorial(nombre2);
        
        
        if (edit != null) {
           
            ArrayList<Libro> libArray;
            
           libArray = libD.buscarXIdEditorial(edit);
            
           if (libArray != null){
               imprimirListado(libArray);
           } else {
               System.out.println("La lista no dio ningun resultado");
           }
           
        } else {
             System.out.println("La Editorial ingresada no se encuentra en nuestras Bases");
        }
    
    
    }

}
