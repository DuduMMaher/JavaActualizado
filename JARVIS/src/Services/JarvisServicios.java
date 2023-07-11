/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Armadura;
import Entities.BotaDer;
import Entities.BotaIzq;
import Entities.Botas;
import Entities.Casco;
import Entities.GuanteDer;
import Entities.GuanteIzq;
import Entities.Guantes;
import HacksDPackage.Servicios;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.time.format.*;
import java.util.Random;

/**
 *
 * @author dudum
 */
public class JarvisServicios {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Servicios serv = new Servicios();
    Botas bot = new Botas();
    Guantes guant = new Guantes();

    public GuanteDer crearGuanteDer() {

        return new GuanteDer(true, false, false, false, false, "Rojo", "Dorado", 100, null, null);

    }

    public GuanteIzq crearGuanteIzq() {
        LocalTime ahora = LocalTime.now();
        return new GuanteIzq(true, false, false, false, false, "Rojo", "Dorado", 100, null, null);
    }

    public BotaDer crearBotaDer() {

        LocalTime ahora = LocalTime.now();
        return new BotaDer(true, false, false, false, false, "Rojo", "Dorado", 100, null, null);

    }

    public BotaIzq crearBotaIzq() {

        LocalTime ahora = LocalTime.now();
        return new BotaIzq(true, false, false, false, false, "Rojo", "Dorado", 100, null, null);
    }

    public Casco crearCasco() {

        LocalTime ahora = LocalTime.now();
        return new Casco("Rojo", "Dorado", 100, null, null);
    }

    public Armadura crearArmadura() {

        LocalTime ahora = LocalTime.now();
        float x = 100000;
        return new Armadura("Rojo", "Dorado", 100, x, ahora, null);
    }

    public void mostrarOperatividad(ArrayList<Armadura> im) {

        //  System.out.println("Estado de Operatividad");
        serv.escrituraContinua("Estado de Operatividad");
        System.out.println("\t                                                        Usando/");
        System.out.println("\t|Resistencia | Consumo | Hora Encendido | Tiempo Uso | Caminando | Corriendo | Volando | Disparando |Funciona | Destruido | ");
        for (Object aux : im) {
            System.out.println(aux);
        }
        System.out.println("");
    }

    public void caminar(ArrayList<Armadura> im) {

        System.out.println("");
        boolean botaD = false;
        boolean botaI = false;
        for (Object aux : im) {

            if (aux instanceof BotaDer) {
                if (funciona(30)) {
                    ((BotaDer) aux).setActivoBDer(true);
                    botaD = true;
                }
            }
            if (aux instanceof BotaIzq) {
                if (funciona(30)) {
                    ((BotaIzq) aux).setActivoBIzq(true);
                    botaI = true;
                }
            }
        }
        if (botaD && botaI) {
            serv.escrituraContinua("IRON MAN CAMINANDO");
            System.out.println("");
            for (Object aux : im) {
                if (aux instanceof Botas) {
                    ((Botas) aux).sethEncParaConsumo(LocalTime.now());
                    ((Botas) aux).setCaminando(true);
                }
            }
        } else {
            if (!botaD) {
                serv.escrituraContinua("La bota DERECHA esta dañada");
            }
            if (!botaI) {
                serv.escrituraContinua("La bota IZQUIERDA esta dañada");
            }
        }
        mostrarOperatividad(im);
    }

    public boolean funciona(int i) {

        Random ran = new Random();

        int a = ran.nextInt(100);
        if (a < i) {
            return false;
        }
        return true;
    }

    // Duration tiempo = Duration.between(encendido, ahora);
    //    long minutos = tiempo.toMinutes();
    //    long segundos = tiempo.getSeconds();
    public void detenerIM(ArrayList<Armadura> im) {

        bot.gastoEnergia(im);

        for (Armadura aux : im) {
            if (aux instanceof Botas) {
                ((Botas) aux).sethEncParaConsumo(null);
                break;
            }

        }
        for (Armadura aux : im) {
            if (aux instanceof BotaDer) {
                ((BotaDer) aux).setCaminando(false);
                ((BotaDer) aux).setCorriendo(false);
                ((BotaDer) aux).setVolando(false);
                ((BotaDer) aux).setActivoBDer(false);
                ((BotaDer) aux).sethEncParaConsumo(null);
            }
            if (aux instanceof BotaIzq) {
                ((BotaIzq) aux).setCaminando(false);
                ((BotaIzq) aux).setCorriendo(false);
                ((BotaIzq) aux).setVolando(false);
                ((BotaIzq) aux).setActivoBIzq(false);
                ((BotaIzq) aux).sethEncParaConsumo(null);
            }
        }
    }

    public void calcularGastoTotal(ArrayList<Armadura> im) {

        bot.gastoEnergia(im);
        guant.gastoEnergia(im);

    }

    public void revisarEstado(ArrayList<Armadura> im) {

        String opc1 = "N";
        String opc2 = "N";
        boolean ref1 = false;
        boolean refGDer = false;
        boolean refGIzq = false;

        boolean ref3 = false;
        String accion = "";
        String accion1 = "";

        for (Armadura aux : im) {
            if (aux instanceof Botas) {
                if (((Botas) aux).isCaminando()) {
                    accion = "CAMINANDO";
                    accion1 = "CAMINAR";
                    ref1 = true;
                }
                if (((Botas) aux).isCorriendo()) {
                    accion = "CORRIENDO";
                    accion1 = "CORRER";
                    ref1 = true;
                }
                if (((Botas) aux).isVolando()) {
                    accion = "VOLANDO";
                    accion1 = "VOLAR";
                    ref1 = true;
                }
            }
        }
        
        for (Armadura aux : im) {
            if (aux instanceof GuanteDer) {
                if (((GuanteDer) aux).isRepulsoresG()) {
                    refGDer = true;
                }
                if (((GuanteIzq) aux).isRepulsoresG()) {
                    refGIzq = true;
                }
            }
        }
       
        
        
        
        
        
        if (ref1) {
            System.out.print("ESTADO ACTUAL -> " + accion);
            ref3 = true;
            opc1 = serv.validarSN();
        }
        if (ref2) {
            if (ref3) {
                System.out.print("                   DISPARANDO");
            } else {
                System.out.print("ESTADO ACTUAL -> DISPARANDO");
            }
            opc2 = serv.validarSN();
        }

        if (opc1.equalsIgnoreCase("S")) {
            bot.gastoEnergia(im);
            for (Armadura aux : im) {
                if (aux instanceof Botas) {
                    ((Botas) aux).setCaminando(false);
                    ((Botas) aux).setCorriendo(false);
                    ((Botas) aux).setVolando(false);
                }
                if (aux instanceof BotaDer) {
                    ((BotaDer) aux).setActivoBDer(false);
                }
            }

        }

    }

}
