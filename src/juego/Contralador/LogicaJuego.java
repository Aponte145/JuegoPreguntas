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
 * La clase LogicaJuego se encarga de la lógica del juego.
 * Controla la preparación de preguntas, la creación de jugadores, la asignación de preguntas
 * y la calificación de las respuestas de los jugadores.
 * 
 * @author Oscar Aponte, Lizeth Arango, Sergio Hernandez, Cristian Ortiz, Laura
 * Bernal
 */
public class LogicaJuego {

    /**
     * Inicia el juego, preparando las preguntas.
     */
    public void iniciarJuego() {

        ManejadorPreguntas manejadorPreguntas = new ManejadorPreguntas();
        manejadorPreguntas.preparaPregunta();


    }

    /**
     * Crea un nuevo jugador con el nombre proporcionado.
     * @param name El nombre del jugador.
     * @return El objeto JugadoresModel del jugador creado.
     */
    public JugadoresModel crearjugador(String name) {
        ManejadorJugador manejadorjugador = new ManejadorJugador();
        JugadoresModel jugador = manejadorjugador.crearJugador(name);

        return jugador;
    }

    /**
     * Asigna una pregunta al azar al jugador.
     * @return La pregunta asignada.
     */
    public PreguntasModel asignarPregunta() {
        ManejadorPreguntas manejadorPreguntas = new ManejadorPreguntas();

        return manejadorPreguntas.asignarPregunta();

    }

    /**
     * Califica la respuesta proporcionada por el jugador.
     * @param PreguntaSeleccionada La pregunta seleccionada por el jugador.
     * @param respuesta La respuesta proporcionada por el jugador.
     * @param jugador El objeto JugadoresModel del jugador.
     * @return Un objeto Pair que contiene la pregunta con la respuesta correcta y un valor booleano que indica si la respuesta fue correcta.
     */
    public Pair<PreguntasModel, Boolean> califcicarRespuesta(PreguntasModel PreguntaSeleccionada, String respuesta, JugadoresModel jugador) {

        ManejadorJugador manejadorjugador = new ManejadorJugador();
        ManejadorPreguntas manejadorPreguntas = new ManejadorPreguntas();
        boolean resultadoRespuesta = false;
        PreguntasModel respuestaCorrecta = manejadorPreguntas.procesarRespuesta(PreguntaSeleccionada);

        if (respuestaCorrecta.getRespuestaCorrecta().equals(respuesta)) {
            manejadorjugador.puntacion(jugador, 10);
            resultadoRespuesta = true;
        }

        return new Pair<>(respuestaCorrecta, resultadoRespuesta);

    }

}
