/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistance;

import Entities.Autor;
import Entities.Editorial;
import Entities.Libro;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author dudum
 */
public class LibroDAO extends DAO<Libro> {

    @Override
    public void eliminar(Libro objeto) {
        super.eliminar(objeto);
    }

    @Override
    public void editar(Libro objeto) {
        super.editar(objeto);
    }

    @Override
    public void guardar(Libro objeto) {
        super.guardar(objeto);
    }

    public Libro buscarXIsbn(long isbn) throws NullPointerException, Exception {
        conectar();

        Libro lib;

        try {
            lib = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.isbn = :ISBN").setParameter("ISBN", isbn).getSingleResult();
        } catch (Exception e) {
            lib = null;
        }
        desconectar();
        return lib;
    }

    public Libro buscarXTitulo(String titulo) {
        
        conectar();

        Libro lib;
        
        titulo = "%" + titulo + "%";
                
        try {
            lib = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.titulo like :titulo").setParameter("titulo", titulo).getSingleResult();
        } catch (Exception e) {
            lib = null;
        }
        desconectar();
        return lib;
    }

    public ArrayList buscarXIdAutor(Autor au) throws Exception {
        
        int idAutor = au.getId();
        
        
        conectar();
        
        Vector<Libro> libVector;
        
        
        try {
            libVector =  (Vector<Libro>) em.createQuery("SELECT a FROM Libro a WHERE a.autor.id = :idAutor").setParameter("idAutor", idAutor).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            libVector = null;
        }
        ArrayList<Libro> libArray = new ArrayList<>(libVector);
        return libArray;
    }

    public ArrayList<Libro> buscarXIdEditorial(Editorial edit) {
        
        int idEditorial = edit.getId();
        
        conectar();
        
        Vector<Libro> libVector2;
        
        try {
            libVector2 =  (Vector<Libro>) em.createQuery("SELECT a FROM Libro a WHERE a.editorial.id = :idEditorial").setParameter("idEditorial", idEditorial).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            libVector2 = null;
        }
        ArrayList<Libro> libArray = new ArrayList<>(libVector2);
        return libArray;
        
        
    }

}
