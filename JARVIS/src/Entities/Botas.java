/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author dudum
 */
public class Botas extends Armadura {

    protected boolean caminando;
    protected boolean corriendo;
    protected boolean volando;

    public Botas() {
    }

    public Botas(boolean caminando, boolean corriendo, boolean volando, String colorP, String colorS, int resistencia, LocalTime encendido, LocalTime apagado) {
        super(colorP, colorS, resistencia, encendido, apagado);
        this.caminando = caminando;
        this.corriendo = corriendo;
        this.volando = volando;

    }

    public boolean isCaminando() {
        return caminando;
    }

    public void setCaminando(boolean caminando) {
        this.caminando = caminando;
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    public boolean isVolando() {
        return volando;
    }

    public void setVolando(boolean volando) {
        this.volando = volando;
    }

    @Override
    public String toString() {
        return super.toString3() + "\t " + caminando + "\t   " + corriendo + "\t" + volando;
    }

    @Override
    public void gastoEnergia(ArrayList<Armadura> im) {
        super.gastoEnergia(im);

        LocalTime ahora = LocalTime.now();
        boolean refVolar = false;
       
        long segundos = 0;

        for (Armadura aux : im) {
            if (aux instanceof Botas) {
                Duration tiempo = Duration.between(im.get(4).gethEncParaConsumo(), ahora);
                segundos = tiempo.getSeconds();
                if (((Botas) aux).isCaminando()) {

//                ((Botas) aux).setCaminando(false);
//                ((Botas) aux).sethEncParaConsumo(null);
                    break;
                }
                if (((Botas) aux).isCorriendo()) {
                    ((Botas) ((Armadura) aux)).setConsumo(((Botas) ((Armadura) aux)).getConsumo() + (segundos * 30));
//                ((Botas) aux).setCorriendo(false);
//                ((Botas) aux).sethEncParaConsumo(null);
                    break;
                }
            }
        }

        for (Armadura aux : im) {
            
            if (aux instanceof BotaIzq) {
                        if (((BotaIzq) aux).isCaminando()) {
                            im.get(1).setConsumo(im.get(1).getConsumo() + (segundos * 10));
                            System.out.println("BotaIzq " + (segundos*10));
                        }
                        if (((BotaIzq) aux).isCorriendo()) {
                            im.get(1).setConsumo(im.get(1).getConsumo() + (segundos * 15));
                        }
                        if (((BotaIzq) aux).isActivoBIzq()) {
                            im.get(1).setConsumo(im.get(1).getConsumo() + (segundos * 40));
//                        ((BotaIzq) aux).setActivoBIzq(false);
                        }
                    }
            
            
            
            
            
            
            
            if (aux instanceof BotaDer) {
                if (((BotaDer) aux).isCaminando()) {
                    im.get(1).setConsumo(im.get(1).getConsumo() + (segundos * 10));
                    System.out.println("BotaDer " + (segundos*10));
                }
                if (((BotaDer) aux).isCorriendo()) {
                    im.get(1).setConsumo(im.get(1).getConsumo() + (segundos * 15));
                }
                if (((BotaDer) aux).isVolando()) {

                    if (((BotaDer) aux).isActivoBDer()) {
                        im.get(1).setConsumo(im.get(1).getConsumo() + (segundos * 40));
//                        ((BotaDer) aux).setActivoBDer(false);
                    }

                    
                }
            }
        }
    }
}
