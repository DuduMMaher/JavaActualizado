/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;

/**
 *
 * @author dudum
 */
public class Armadura {

    protected String colorP;
    protected String colorS;
    protected int resistencia;
    protected float bateria;
    protected int bateriaPje;
    protected LocalTime hEncendido;
    protected LocalTime hEncParaConsumo;
    protected LocalTime apagado;
    protected float consumo;
    protected boolean encendido = false;

    public Armadura() {
    }

    public Armadura(String colorP, String colorS, int resistencia, float bateria, LocalTime hEncendido, LocalTime apagado) {
        this.colorP = colorP;
        this.colorS = colorS;
        this.resistencia = resistencia;
        this.bateria = bateria;
        this.hEncendido = hEncendido;
        this.hEncParaConsumo = this.hEncendido;
        this.apagado = apagado;
        this.consumo = 0;
        this.encendido = true;
    }

    public Armadura(String colorP, String colorS, int resistencia, LocalTime hEncendido, LocalTime apagado) {
        this.colorP = colorP;
        this.colorS = colorS;
        this.resistencia = resistencia;
        this.hEncendido = hEncendido;
        this.hEncParaConsumo = this.hEncendido;
        this.apagado = apagado;
        this.consumo = 0;
        this.encendido = true;
    }

    public String getColorP() {
        return colorP;
    }

    public void setColorP(String colorP) {
        this.colorP = colorP;
    }

    public String getColorS() {
        return colorS;
    }

    public void setColorS(String colorS) {
        this.colorS = colorS;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public float getBateria() {
        return bateria;
    }

    public void setBateria(float bateria) {
        this.bateria = bateria;
    }

    public int getBateriaPje() {
        return bateriaPje;
    }

    public void setBateriaPje(int bateriaPje) {
        this.bateriaPje = bateriaPje;
    }

    public LocalTime gethEncendido() {
        return hEncendido;
    }

    public void sethEncendido(LocalTime hEncendido) {
        this.hEncendido = hEncendido;
    }

    public LocalTime gethEncParaConsumo() {
        return hEncParaConsumo;
    }

    public void sethEncParaConsumo(LocalTime hEncParaConsumo) {
        this.hEncParaConsumo = hEncParaConsumo;
    }

    public LocalTime getApagado() {
        return apagado;
    }

    public void setApagado(LocalTime apagado) {
        this.apagado = apagado;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public String toString3() {
        LocalTime ahora = LocalTime.now();

        if (hEncParaConsumo == null) {
            if (bateria == 0) {
                return "\t" + resistencia + "\t" + "\t   " + "\t    " + "\t\t";
            } else {
                return "\t" + resistencia + "\t" + bateriaPje + "\t   " + "\t    " + "\t\t";
            }
        } else {

            Duration tiempo = Duration.between(hEncParaConsumo, ahora);
            long segundos = tiempo.getSeconds();
            if (bateria == 0) {
                return "\t" + resistencia + "\t" + "\t   " + hEncParaConsumo + "\t    " + segundos + "seg";
            } else {
                return "\t" + resistencia + "\t" + consumo + "\t   " + hEncParaConsumo + "\t    " + segundos + "seg";
            }
        }
    }

    @Override
    public String toString() {
        LocalTime ahora = LocalTime.now();

//        float cons = (float)this.consumo;        
//        this.bateriaPje= (int)(((this.bateria-(cons))/this.bateria))*100;
        Duration tiempo = Duration.between(hEncParaConsumo, ahora);
        long segundos = tiempo.getSeconds();

        return "Armadura\t" + resistencia + "\t" + consumo + "\t   " + hEncendido + "\t    " + segundos + "seg";
    }

    public void gastoEnergia(ArrayList<Armadura> im) {

        LocalTime horaConsumo;
        
        if (im.get(1).isEncendido()) {

            
            LocalTime ahora = LocalTime.now();
            System.out.println("Consumo de Energia al momento");
            
            horaConsumo =  im.get(1).gethEncParaConsumo();
           
            Duration tiempo = Duration.between(horaConsumo, ahora);
            long segundos = tiempo.getSeconds();
            System.out.println("Tiempo Armadura " + segundos);
            im.get(1).setConsumo(im.get(1).getConsumo() + (segundos * 10));
            im.get(1).sethEncParaConsumo(ahora);
        }

    }

}
