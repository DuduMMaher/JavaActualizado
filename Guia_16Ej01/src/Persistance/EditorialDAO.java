/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistance;

import Entities.Editorial;

/**
 *
 * @author dudum
 */
public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void eliminar(Editorial objeto) {
        super.eliminar(objeto);
    }

    @Override
    public void editar(Editorial objeto) {
        super.editar(objeto);
    }

    @Override
    public void guardar(Editorial objeto) {
        super.guardar(objeto);
    }

    public Editorial buscarXEditorial(String nombre) throws NullPointerException, Exception {

        conectar();

        Editorial edit;

        try {
            edit = (Editorial) em.createQuery("SELECT a FROM Editorial a WHERE a.nombre like :nombre").setParameter("nombre", nombre).getSingleResult();
        } catch (Exception e) {
            edit = null;
        }
        desconectar();
        return edit;
    }

    

}
