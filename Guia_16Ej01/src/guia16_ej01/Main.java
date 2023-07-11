/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia16_ej01;

import Entities.Libro;
import HacksDPackage.Servicios;
import Services.AutorService;
import Services.EditorialService;
import Services.LibreriaService;
import Services.PrestamoService;
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

        LibreriaService ls = new LibreriaService();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Servicios serv = new Servicios();
        PrestamoService ps = new PrestamoService();

        int opc;

        do {

            System.out.println("Menu");
            System.out.println("----");
            System.out.println("");
            System.out.println("1.- Ingresar Libro");
            System.out.println("2.- Buscar Libro x ISBN");
            System.out.println("3.- Buscar Libro x Nombre");
            System.out.println("4.- Buscar Libros por Autor");
            System.out.println("5.- Buscar Libros por Editorial");
            System.out.println("6.- Prestar Libro");
            System.out.println("1.-");
            System.out.println("8.-");

            opc = serv.validarEntero();

            switch (opc) {

                case 1:
                    System.out.println("Cuantos libros va a ingresar");
                    int cantLib = serv.validarEntero();
                    for (int i = 0; i < cantLib; i++) {
                        ls.crearLibro();
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el ISBN del libro a buscar");
                    long isbn = serv.validarLong();
                    ls.buscarXIsbn(isbn);
                    break;
                case 3:
                    System.out.println("Ingrese el Titulo del libro a buscar");
                    String titulo = serv.validarString();
                    ls.buscarXTitulo(titulo);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del Autor");
                    String nombre = serv.validarString();
                    ls.buscarLibrosXAutor(nombre);
                    break;
                case 5:
                    System.out.println("Ingrese el nombre de la Editorial");
                    String nombre2 = serv.validarString();
                    ls.buscarLibrosXEditorial(nombre2);
                    break;
                case 6:
                    ps.prestarLibro();
                case 8:
                    
                    break;
            }
        } while (opc != 9);

    }

}
