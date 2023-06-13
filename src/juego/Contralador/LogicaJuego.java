/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.Contralador;

import javafx.util.Pair;
import juego.Repository.ManejadorJugador;
import juego.Repository.ManejadorPreguntas;
import juego.Modelo.JugadoresModel;
import juego.Modelo.PreguntasModel;


/**
 *
 * @author Oscar Aponte
 */
public class LogicaJuego {
    
    
    public  void iniciarJuego(){
        
        ManejadorPreguntas manejadorPreguntas = new ManejadorPreguntas();
        manejadorPreguntas.preparaPregunta();
        
        //preguntamos nombre al jugador 
    }
    
    public JugadoresModel crearjugador (String name){
        ManejadorJugador manejadorjugador = new ManejadorJugador();
        JugadoresModel jugador = manejadorjugador.crearJugador(name);
        
        return jugador;
    }
    
    public PreguntasModel asignarPregunta (){
      ManejadorPreguntas manejadorPreguntas = new ManejadorPreguntas();
      
      return manejadorPreguntas.asignarPregunta();
      
    }
    
    public Pair<PreguntasModel, Boolean >  califcicarRespuesta(PreguntasModel PreguntaSeleccionada, String respuesta,JugadoresModel judador  ){
        
        ManejadorJugador manejadorjugador = new ManejadorJugador();
        ManejadorPreguntas manejadorPreguntas = new ManejadorPreguntas();
        boolean resultadoRespuesta = false;        
        PreguntasModel respuestaCorrecta = manejadorPreguntas.procesarRespuesta(PreguntaSeleccionada);
        
        if(respuestaCorrecta.getRespuestaCorrecta() == respuesta){
            manejadorjugador.puntacion(judador, 10);
            resultadoRespuesta = true;
            }
        
        
     return new Pair<>(respuestaCorrecta, resultadoRespuesta);
            
    }
    

    
    
}
