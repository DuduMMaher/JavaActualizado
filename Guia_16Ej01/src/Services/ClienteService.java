/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Cliente;
import HacksDPackage.Servicios;
import Persistance.ClienteDAO;

/**
 *
 * @author dudum
 */
public class ClienteService {

    ClienteDAO clDAO =new ClienteDAO();
    Servicios serv = new Servicios();
    
    public Cliente buscarXDni(long dni) throws Exception {
        
    Cliente cliente;
    
    
    cliente = clDAO.buscarXDni(dni);
    
    if (cliente == null){
        
        cliente = crearCliente(dni);
    } 
    
    
    
    return cliente;
    }

    private Cliente crearCliente(long dni) {
        
        System.out.println("Usted esta por ingresar un cliente nuevo");
        serv.wait(300);
        System.out.print ("Ingrese el Apellido: ");
        String apellido = serv.apellido();
        System.out.println(apellido);
        serv.wait(300);
        System.out.print("Ingrese el nombre: ");
        String nombre= serv.nombre();
        System.out.println(nombre);
        serv.wait(300);
        System.out.print("Ingrese el telefono: ");
        String tel = serv.telefono();
        System.out.println(tel);
        serv.wait(300);
        return new Cliente(dni, nombre, apellido, tel);
    }
    
}
