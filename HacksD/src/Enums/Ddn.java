/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author dudum
 */
public enum Ddn {
    CABA("11"), ROSARIO("341"), CORDOBA("351"), MENDOZA("261"), SAN_JUAN("264"), SANTA_FE("342");
    
    private String code;

    private Ddn(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
