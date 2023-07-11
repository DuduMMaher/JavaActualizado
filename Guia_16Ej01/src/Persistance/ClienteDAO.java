/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistance;

import Entities.Cliente;

/**
 *
 * @author dudum
 */
public class ClienteDAO extends DAO<Cliente> {

    public Cliente buscarXDni(long dni) throws NullPointerException, Exception {

        Cliente cliente;
        conectar();

        try {
            cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.dni = :dni").setParameter("dni", dni).getSingleResult();
        } catch (Exception e) {
            cliente = null;
        }
        return cliente;
    }
    
    
    
    
}
