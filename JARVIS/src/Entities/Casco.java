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
public class Casco extends Armadura {
    
    
    

    public Casco() {
    }

    public Casco(String colorP, String colorS, int resistencia, LocalTime encendido, LocalTime apagado) {
        super(colorP, colorS, resistencia, encendido, apagado);
        
    }

    
    @Override
    public String toString() {
        return "Casco\t" + super.toString3();
    }
    
    
}
