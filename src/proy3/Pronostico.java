package proy3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author camii
 */
public class Pronostico {
    private Partido partido;
    private ResultadoEnum pronostico;
    private int idRonda;
    
    public Pronostico(Partido partido, ResultadoEnum pronostico, int idRonda) {
        this.partido = partido;
        this.pronostico = pronostico;
        this.idRonda = idRonda;
    }
    
    public int puntos(){
        int puntos = 0;
        if(this.partido.resultado() == this.pronostico){
            puntos = 1;
        }
        return puntos;
    }

    public Partido getPartido() {
        return partido;
    }

    public int getIdRonda() {
        return idRonda;
    }
    
    
    
}
