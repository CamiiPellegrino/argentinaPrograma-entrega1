/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package proy3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author camii
 */
public class proy3 {

    public static void main(String[] args) throws FileNotFoundException, IOException  {

    	
    	Ronda rondas[] = new Ronda[3];
        Pronostico todosLosPronosticos[] = new Pronostico[20];
        int pronosticosAgregados = 0;
        int rondasAgregadas = 0;
        
        
    //resultados: 
        
        
        BufferedReader br = new BufferedReader(new FileReader("src//resultados.csv"));
            
        String line = br.readLine();
        line = br.readLine();

        while(line != null){
            String linea[] = line.split(",");
            Equipo eq1 = new Equipo(linea[0]);
            Equipo eq2 = new Equipo(linea[3]);
            Partido partido = new Partido(eq1, eq2, Integer.parseInt(linea[1]), Integer.parseInt(linea[2]));
            boolean rondaEncontrada = false;
            int i=0; 
            while(i<rondas.length & rondaEncontrada == false & rondas[i] != null){
                if(rondas[i].getIdRonda() == Integer.parseInt(linea[4])){
                    rondaEncontrada = true;
                    rondas[i].agregarPartido(partido);
                }
                i++;
            }
            if(!rondaEncontrada & rondasAgregadas<rondas.length){
                Ronda r = new Ronda(Integer.parseInt(linea[4]));
                rondas[rondasAgregadas] = r;
                rondas[i].agregarPartido(partido);
                rondasAgregadas++;
            }
            line = br.readLine();
        }
    
    //Pronosticos:
        br = new BufferedReader(new FileReader("src//pronosticos.csv"));
        line = br.readLine();
        line = br.readLine();
        while(line != null){
            String linea[] = line.split(",");
            int idRonda = Integer.parseInt(linea[5]);
            ResultadoEnum re = null;
            int e=1;
            boolean encontrado = false;
            while(e<=3 & encontrado==false){ 
                if(linea[e].equals("X")){
                    encontrado = true;
                    switch (e) {
                        case 1:
                            re = ResultadoEnum.GANADOR_EQ1;
                            break;
                        case 2:
                            re = ResultadoEnum.EMPATE;
                            break;
                        case 3:
                            re = ResultadoEnum.GANADOR_EQ2;
                            break;
                        default:
                            break;
                    }
                }
                e++;
            }
            int i=0;
            boolean rondaEncontrada = false;
            while(i<rondas.length & rondaEncontrada==false & rondas[i] != null){
                if(rondas[i].getIdRonda() == idRonda){
                    
                    Partido partido = rondas[i].buscarPartido(linea[0], linea[4]);
                    if(partido != null & re != null){
                        Pronostico pronostico = new Pronostico(partido, re, idRonda);
                        if(pronosticosAgregados<todosLosPronosticos.length){
                            todosLosPronosticos[pronosticosAgregados] = pronostico;
                            pronosticosAgregados++;
                        }
                    }
                }
                i++;
            }
        line = br.readLine();
        }
        
        
        int puntosRonda = 0;
        for(Ronda r : rondas){
            if(r != null){
                puntosRonda = r.puntosDePronosticosPorRonda(todosLosPronosticos);
                System.out.println("puntos de la ronda " + r.getIdRonda() +": "+puntosRonda);
            }
        }
    }
}
