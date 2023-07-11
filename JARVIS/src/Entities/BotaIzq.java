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
public class BotaIzq extends Botas {
    
    public boolean activoBIzq;
    protected boolean destruccionBIzq;

    public BotaIzq() {
    }

    public BotaIzq(boolean activoBIzq, boolean destruccionBIzq, boolean caminando, boolean corriendo, boolean volando, String colorP, String colorS, int resistencia, LocalTime encendido, LocalTime apagado) {
        super(caminando, corriendo, volando, colorP, colorS, resistencia, encendido, apagado);
        this.activoBIzq = activoBIzq;
        this.destruccionBIzq = destruccionBIzq;
    }

    public boolean isActivoBIzq() {
        return activoBIzq;
    }

    public void setActivoBIzq(boolean activoBIzq) {
        this.activoBIzq = activoBIzq;
    }

    public boolean isDestruccionBIzq() {
        return destruccionBIzq;
    }

    public void setDestruccionBIzq(boolean destruccionBIzq) {
        this.destruccionBIzq = destruccionBIzq;
    }

    @Override
    public String toString() {
        return "BotaIzq " + super.toString() + "\t\t   " + activoBIzq + "\t\t" + destruccionBIzq;
    }
    
    
}
