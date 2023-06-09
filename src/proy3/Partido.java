package proy3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author camii
 */
public class Partido {
    private Equipo eq1;
    private Equipo eq2;
    private int golesEq1;
    private int golesEq2;

    public Partido(Equipo eq1, Equipo eq2, int golesEq1, int golesEq2) {
        this.eq1 = eq1;
        this.eq2 = eq2;
        this.golesEq1 = golesEq1;
        this.golesEq2 = golesEq2;
    }
    
    public ResultadoEnum resultado(){
        if(this.golesEq1 == this.golesEq2){
            return ResultadoEnum.EMPATE;
        }else if(this.golesEq1< this.golesEq2){
            return ResultadoEnum.GANADOR_EQ2;
        }else if(this.golesEq1 > this.golesEq2){
            return ResultadoEnum.GANADOR_EQ1;

        }
        return null;
    }

    public Equipo getEq1() {
        return eq1;
    }

    public Equipo getEq2() {
        return eq2;
    }
    
    
    
    
}
