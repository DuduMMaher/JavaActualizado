/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author dudum
 */
public class BotaDer extends Botas {

    public boolean activoBDer; //
    protected boolean destruccionBDer;

    public BotaDer() {
    }

    public BotaDer(boolean activoBDer, boolean destruccionBDer, boolean caminando, boolean corriendo, boolean volando, String colorP, String colorS, int resistencia, LocalTime encendido, LocalTime apagado) {
        super(caminando, corriendo, volando, colorP, colorS, resistencia, encendido, apagado);
        this.activoBDer = activoBDer;
        this.destruccionBDer = destruccionBDer;
    }

    public boolean isActivoBDer() {
        return activoBDer;
    }

    public void setActivoBDer(boolean activoBDer) {
        this.activoBDer = activoBDer;
    }

    public boolean isDestruccionBDer() {
        return destruccionBDer;
    }

    public void setDestruccionBDer(boolean destruccionBDer) {
        this.destruccionBDer = destruccionBDer;
    }

    @Override
    public String toString() {
        return "BotaDer " + super.toString() + "\t\t   " + activoBDer + "\t\t" + destruccionBDer;
    }

    
    
}
