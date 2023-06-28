/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.Contralador;

import java.util.List;
import javafx.util.Pair;
import juego.Repository.ManejadorJugador;
import juego.Repository.ManejadorPreguntas;
import juego.Modelo.JugadoresModel;
import juego.Modelo.PreguntasModel;

/**
 * La clase LogicaJuego se encarga de la lógica del juego. Controla la preparación de preguntas, 
 * la creación de jugadores, la asignación de preguntas y la calificación de las respuestas de los jugadores.
 * La lógica del juego se implementa en esta clase.
 * Autor: Oscar Aponte, Lizeth Arango, Sergio Hernandez, Cristian Ortiz, Laura Bernal
 */
public class LogicaJuego {

    private static ManejadorPreguntas manejadorPreguntas; // Manejador de preguntas
    private static ManejadorJugador manejadorjugador; // Manejador de jugadores
    private static JugadoresModel jugador; // Jugador actual

    /**
     * Inicia el juego, preparando las preguntas.
     */
    public void iniciarJuego() {
        manejadorPreguntas = new ManejadorPreguntas(); // Inicializar el manejador de preguntas
        manejadorPreguntas.preparaPregunta(); // Preparar las preguntas
    }

    /**
     * Crea un nuevo jugador con el nombre proporcionado.
     *
     * @param name El nombre del jugador.
     * @return El objeto JugadoresModel del jugador creado.
     */
    public JugadoresModel crearjugador(String name) {
        manejadorjugador = new ManejadorJugador(); // Inicializar el manejador de jugadores
        jugador = manejadorjugador.crearJugador(name); // Crear el jugador utilizando el manejador
        return jugador;
    }

    /**
     * Asigna una pregunta al azar al jugador.
     *
     * @return La pregunta asignada.
     */
    public PreguntasModel asignarPregunta() {
        return manejadorPreguntas.asignarPregunta(); // Asignar una pregunta al azar utilizando el manejador
    }

    /**
     * Califica la respuesta proporcionada por el jugador.
     *
     * @param PreguntaSeleccionada La pregunta seleccionada por el jugador.
     * @param respuesta La respuesta proporcionada por el jugador.
     * @param jugador El objeto JugadoresModel del jugador.
     * @return Un objeto Pair que contiene la pregunta con la respuesta correcta y un valor booleano que indica si la respuesta fue correcta.
     */
    public Pair<PreguntasModel, Boolean> califcicarRespuesta(PreguntasModel PreguntaSeleccionada, String respuesta, JugadoresModel jugador) {
        boolean resultadoRespuesta = false;
        PreguntasModel respuestaCorrecta = manejadorPreguntas.procesarRespuesta(PreguntaSeleccionada); // Obtener la respuesta correcta de la pregunta seleccionada

        if (respuestaCorrecta.getRespuestaCorrecta().equals(respuesta)) {
            jugador = manejadorjugador.puntacion(jugador, 10); // Incrementar la puntuación del jugador en 10 si la respuesta es correcta
            resultadoRespuesta = true;
        }

        return new Pair<>(respuestaCorrecta, resultadoRespuesta); // Devolver un objeto Pair con la pregunta y la respuesta correcta, y el resultado de la respuesta del jugador
    }

    /**
     * Consulta la puntuación del jugador actual.
     *
     * @return El objeto JugadoresModel con la puntuación del jugador.
     */
    public JugadoresModel cosultarPuntacion() {
        manejadorjugador.guardarResultado(jugador); // Guardar el resultado del jugador utilizando el manejador
        return jugador;
    }
    
    /**
     * Consulta la tabla de puntuaciones.
     *
     * @return Una lista de JugadoresModel con los resultados de los jugadores.
     */
    public List<JugadoresModel> consultarTabla() {
        return manejadorjugador.cargarResultados(); // Cargar los resultados de los jugadores utilizando el manejador
    }
}
