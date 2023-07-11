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
public class GuanteDer extends Guantes {
    
    
    public boolean activoGDer;
    protected boolean destruccionGDer;

    public GuanteDer() {
    }

    public GuanteDer(boolean activoGDer, boolean destruccionGDer, boolean usando, boolean volandoGuantes, boolean repulsoresG, String colorP, String colorS, int resistencia, LocalTime encendido, LocalTime apagado) {
        super(usando, volandoGuantes, repulsoresG, colorP, colorS, resistencia, encendido, apagado);
        this.activoGDer = activoGDer;
        this.destruccionGDer = destruccionGDer;
    }

    public boolean isActivoGDer() {
        return activoGDer;
    }

    public void setActivoGDer(boolean activoGDer) {
        this.activoGDer = activoGDer;
    }

    public boolean isDestruccionGDer() {
        return destruccionGDer;
    }

    public void setDestruccionGDer(boolean destruccionGDer) {
        this.destruccionGDer = destruccionGDer;
    }

    @Override
    public String toString() {
        return "GuanteDer" + super.toString() +  "   " + activoGDer + "\t\t" + destruccionGDer;
    }
    
    
}
