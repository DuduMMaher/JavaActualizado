/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jarvis;

import Entities.Armadura;
import Entities.BotaDer;
import Entities.BotaIzq;
import Entities.Botas;
import Entities.Casco;
import Entities.GuanteDer;
import Entities.GuanteIzq;
import Exceptions.OwnException;
import HacksDPackage.Servicios;
import Services.JarvisServicios;
import java.util.ArrayList;


/**
 *
 * @author dudum
 */
public class JARVIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws OwnException {

        Servicios serv = new Servicios();

        JarvisServicios jr = new JarvisServicios();
        ArrayList<Armadura> im = new ArrayList();
        boolean encendido = false;
        boolean ref1;
        
        int opc;
        do {
            System.out.println("MENU");
            System.out.println("--------");
            System.out.println("1.- Encendido de IRON MAN");
            System.out.println("2.- Caminar - Parar");
            System.out.println("3.- Correr - Parar");
            System.out.println("4.- ");
            System.out.println("5.- ");
            System.out.println("6.- ");
            System.out.println("7.- Calcular Gasto Energia");
            System.out.println("8.- Mostrar Operatividad");
            System.out.println("9.- Salir");

            opc = serv.validarEntero();

            switch (opc) {
                case 1:
                    if (encendido) {
                        serv.escrituraContinua("JARVIS ya se encuentra encendido");
                    } else {
                        im.add(jr.crearCasco());
                        im.add(jr.crearArmadura());
                        im.add(jr.crearGuanteDer());
                        im.add(jr.crearGuanteIzq());
                        im.add(jr.crearBotaDer());
                        im.add(jr.crearBotaIzq());
                        serv.wait(500);
                        serv.escrituraContinua("IRON MAN ENCENDIDO");
                        System.out.println("");

                        jr.mostrarOperatividad(im);
                        encendido = true;
                    }
                    break;
                case 2:
                    if (!encendido) {
                        System.out.println("IRON MAN se encuentra APAGADO");
                        break;
                    }
                    ref1 = false;
                    for (Object aux : im) {
                        if (aux instanceof Botas) {
                            if (((Botas) aux).isCaminando()) {
                                serv.escrituraContinua("IRON MAN ya se encuentra caminando");
                                ref1 = true;
                                break;
                            } else {
                                if (((Botas) aux).isCorriendo()) {
                                    serv.escrituraContinua("IRON MAN esta corriendo");
                                    ref1 = true;
                                } else {
                                    if (((Botas) aux).isVolando()) {
                                        serv.escrituraContinua("IRON MAN esta volando");
                                        ref1 = true;
                                    }
                                }
                            }
                            jr.caminar(im);
                            break;
                        }
                    }
                    if (ref1) {
                        serv.escrituraContinua("Desea hacerlo frenar/aterrizar? (S/N)");
                        String opc1 = serv.validarSN();
                        if (opc1.equals("S")) {
                            jr.detenerIM(im);
                        }
                    }
                    break;
                case 3:
                    if (!encendido) {
                        System.out.println("IRON MAN se encuentra APAGADO");
                        break;
                    }
                    ref1 = false;
                    for (Object aux : im) {
                        if (aux instanceof Botas) {
                            if (((Botas) aux).isCaminando()) {
                                serv.escrituraContinua("IRON MAN ya se encuentra caminando");
                                ref1 = true;
                                break;
                            } else {
                                if (((Botas) aux).isCorriendo()) {
                                    serv.escrituraContinua("IRON MAN esta corriendo");
                                    ref1 = true;
                                } else {
                                    if (((Botas) aux).isVolando()) {
                                        serv.escrituraContinua("IRON MAN esta volando");
                                        ref1 = true;
                                    }
                                }
                            }
                        }
                    }
                    if (ref1) {
                        serv.escrituraContinua("Desea hacerlo frenar/aterrizar? (S/N)");
                        String opc1 = serv.validarSN();
                        if (opc1.equals("S")) {
                            jr.detenerIM(im);
                        }
                    }
                    break;
                case 7:
                    
                    break;
                case 8:
                    jr.mostrarOperatividad(im);
                    break;
            }

        } while (opc != 9);
    }

}
