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
public class Guantes extends Armadura {
    
    
    protected boolean usando;
    protected boolean volandoGuantes;
    protected boolean repulsoresG;
    

    public Guantes() {
    }

    public Guantes(boolean usando, boolean volandoGuantes, boolean repulsoresG, String colorP, String colorS, int resistencia, LocalTime encendido, LocalTime apagado) {
        super(colorP, colorS, resistencia, encendido, apagado);
        this.usando = usando;
        this.volandoGuantes = volandoGuantes;
        this.repulsoresG = repulsoresG;
        
    }

    public boolean isUsando() {
        return usando;
    }

    public void setUsando(boolean usando) {
        this.usando = usando;
    }

    public boolean isVolandoGuantes() {
        return volandoGuantes;
    }

    public void setVolandoGuantes(boolean volandoGuantes) {
        this.volandoGuantes = volandoGuantes;
    }

    public boolean isRepulsoresG() {
        return repulsoresG;
    }

    public void setRepulsoresG(boolean repulsoresG) {
        this.repulsoresG = repulsoresG;
    }

    
    @Override
    public String toString() {
        return super.toString3() + "\t " + usando + "\t\t        " + volandoGuantes + "\t" + repulsoresG + "\t";
    }
    
    
}
