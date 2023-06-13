/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.Modelo;

import java.util.List;

/**
 * La clase PreguntasModel representa una pregunta en el juego. Contiene
 * información sobre la pregunta, opciones de respuesta y la respuesta correcta.
 * También proporciona métodos para acceder y modificar dicha información.
 *
 * @author Oscar Aponte, Lizeth Arango, Sergio Hernandez, Cristian Ortiz, Laura
 * Bernal
 */
public class PreguntasModel {

    private static int nextId = 1; // Identificador para la siguiente pregunta
    private int id; // Identificador único de la pregunta
    private String Pregunta; // La pregunta
    private List<String> Opciones; // Opciones de respuesta
    private String RespuestaCorrecta; // Respuesta correcta

    /**
     * Constructor de la clase PreguntasModel.
     *
     * @param Pregunta La pregunta.
     * @param Opciones Las opciones de respuesta.
     * @param RespuestaCorrecta La respuesta correcta.
     */
    public PreguntasModel(String Pregunta, List<String> Opciones, String RespuestaCorrecta) {
        this.id = nextId; // Asignar el identificador único
        nextId++; // Incrementar el identificador para la siguiente pregunta
        this.Pregunta = Pregunta;
        this.Opciones = Opciones;
        this.RespuestaCorrecta = RespuestaCorrecta;
    }

    /**
     * Constructor vacío de la clase PreguntasModel.
     */
    public PreguntasModel() {

    }

    /**
     * Constructor de la clase PreguntasModel.
     *
     * @param id El identificador de la pregunta.
     * @param Pregunta La pregunta.
     * @param Opciones Las opciones de respuesta.
     */
    public PreguntasModel(int id, String Pregunta, List<String> Opciones) {
        this.id = id;
        this.Pregunta = Pregunta;
        this.Opciones = Opciones;
    }

    /**
     * Obtiene el identificador de la pregunta.
     *
     * @return El identificador de la pregunta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la pregunta.
     *
     * @param id El identificador de la pregunta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la pregunta.
     *
     * @return La pregunta.
     */
    public String getPregunta() {
        return Pregunta;
    }

    /**
     * Establece la pregunta.
     *
     * @param Pregunta La pregunta.
     */
    public void setPregunta(String Pregunta) {
        this.Pregunta = Pregunta;
    }

    /**
     * Obtiene las opciones de respuesta.
     *
     * @return Las opciones de respuesta.
     */
    public List<String> getOpciones() {
        return Opciones;
    }

    /**
     * Establece las opciones de respuesta.
     *
     * @param Opciones Las opciones de respuesta.
     */
    public void setOpciones(List<String> Opciones) {
        this.Opciones = Opciones;
    }

    /**
     * Obtiene la respuesta correcta.
     *
     * @return La respuesta correcta.
     */
    public String getRespuestaCorrecta() {
        return RespuestaCorrecta;
    }

    /**
     * Establece la respuesta correcta.
     *
     * @param RespuestaCorrecta La respuesta correcta.
     */
    public void setRespuestaCorrecta(String RespuestaCorrecta) {
        this.RespuestaCorrecta = RespuestaCorrecta;
    }
}
