package proy3;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author camii
 */
public class Ronda {
    private ArrayList<Partido> partido = new ArrayList<>();
    private int idRonda;
    public Ronda(int idRonda) {
        this.idRonda=idRonda;
    }
    
    
    
    public Partido buscarPartido(String eq1, String eq2){
        for(Partido p : partido){
            if(p.getEq1().getNombre().equals(eq1) & p.getEq2().getNombre().equals(eq2)){
                return p;
            }
        }
        return null;
    }

    public int puntosDePronosticosPorRonda(Pronostico pronosticos[]){
        int puntos = 0;
        for(int i=0; i<pronosticos.length; i++){
            if(pronosticos[i] != null){
                if(pronosticos[i].getIdRonda()==this.idRonda){
                    puntos += pronosticos[i].puntos();

                }
            }
        }
        return puntos;
    }
    
    public void agregarPartido(Partido p){
        this.partido.add(p);
    }
    
    
    public int getIdRonda() {
        return idRonda;
    }

    public ArrayList<Partido> getPartido() {
        return partido;
    }
    
    
}
