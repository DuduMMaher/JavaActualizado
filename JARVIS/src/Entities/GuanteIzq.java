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
public class GuanteIzq extends Guantes {
    
    
    public boolean activoGIzq;
    protected boolean destruccionGIzq;

    public GuanteIzq() {
    }

    public GuanteIzq(boolean activoGIzq, boolean destruccionGIzq, boolean usando, boolean volandoGuantes, boolean repulsoresG, String colorP, String colorS, int resistencia, LocalTime encendido, LocalTime apagado) {
        super(usando, volandoGuantes, repulsoresG, colorP, colorS, resistencia, encendido, apagado);
        this.activoGIzq = activoGIzq;
        this.destruccionGIzq = destruccionGIzq;
    }

    public boolean isActivoGIzq() {
        return activoGIzq;
    }

    public void setActivoGIzq(boolean activoGIzq) {
        this.activoGIzq = activoGIzq;
    }

    public boolean isDestruccionGIzq() {
        return destruccionGIzq;
    }

    public void setDestruccionGIzq(boolean destruccionGIzq) {
        this.destruccionGIzq = destruccionGIzq;
    }

    @Override
    public String toString() {
        return "GuanteIzq" + super.toString() +  "   " + activoGIzq + "\t\t" + destruccionGIzq;
    }
    
    
}
