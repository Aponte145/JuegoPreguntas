/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import juego.Modelo.PreguntasModel;

/**
 * La clase ManejadorPreguntas se encarga de administrar las preguntas del juego.
 * Permite agregar preguntas, seleccionar una pregunta aleatoria y procesar la respuesta del jugador.
 * 
 * @author Oscar Aponte, Lizeth Arango, Sergio Hernandez, Cristian Ortiz, Laura
 * Bernal
 */
public class ManejadorPreguntas {

    private static List<PreguntasModel> preguntas;

    public ManejadorPreguntas() {

        preguntas = new ArrayList<>();

    }
    /**
     * Agrega una pregunta al listado de preguntas.
     * @param pregunta La pregunta a agregar.
     */
    public void addPregunta(PreguntasModel pregunta) {

        preguntas.add(pregunta);
    }
    
    /**
     * Prepara las preguntas del juego agregando las preguntas al listado.
     * Cada pregunta se crea con su enunciado, opciones y respuesta correcta.
     */
    public void preparaPregunta() {

        // Pregunta 0 
        addPregunta(new PreguntasModel("¿En qué año colapsó la Unión Soviética? ",
                Arrays.asList(
                        "1991",
                        "1982",
                        "1998",
                        "1973"),
                "1991", 
        "archivos/pregunta1.jpg"));
        // Pregunta 1
        addPregunta(new PreguntasModel("¿Cuál fue el primer metal que el hombre empleó?",
                Arrays.asList(
                        "Oro",
                        "Platino",
                        "Cobre",
                        "Diamante"),
                "Cobre",
        "archivos/Pregunta2.jpg"));
        // Pregunta 2       
        preguntas.add(new PreguntasModel("¿A través de qué río africano se alzó el antiguo Egipto?",
                Arrays.asList("Tigris", 
                        "Okavango",
                        "Éufrates",
                        "Nilo"),
                "Nilo", "archivos/Pregunta3.jpg"));

        // Pregunta 3
        preguntas.add(new PreguntasModel("¿Cuáles de estos hechos históricos es más antiguo?",
                Arrays.asList(
                        "Nacimiento de Confucio",
                        "Nacimiento de Alejandro Magno",
                        "Construcción de la Gran Muralla China",
                        "La caída de Tenochtitlán"),
                "Nacimiento de Confucio", "archivos/Pregunta4.jpg"));

        // Pregunta 4
        preguntas.add(new PreguntasModel("¿En que periodo de la historia tuvo lugar la guerra de los cien años?",
                Arrays.asList(
                        "Edad Antigua",
                        "Edad del hierro",
                        "Edad Media",
                        "Edad Moderna"),
                "Edad Media", "archivos/Pregunta5.jpg"));

        // Pregunta 5
        preguntas.add(new PreguntasModel("¿En qué año se presentó el accidente nuclear de Chernóbil?",
                Arrays.asList(
                        "1960",
                        "1980",
                        "1986",
                        "1994"),
                "1986", "archivos/Pregunta6.jpg"));

        // Pregunta 6
        preguntas.add(new PreguntasModel("¿Dónde se inventó la rueda?",
                Arrays.asList(
                        "Mesopotamia",
                        "Egipto",
                        "Grecia",
                        "China"),
                "Mesopotamia", "archivos/Pregunta7.jpg"));

        // Pregunta 7
        preguntas.add(new PreguntasModel("¿Cuál fue la primera civilización en la historia de la humanidad?",
                Arrays.asList(
                        "Los fenicios",
                        "La Antigua Grecia",
                        "La Antigua Roma",
                        "La civilización sumeria"),
                "La civilización sumeria", "archivos/Pregunta8.jpg"));

        // Pregunta 8
        preguntas.add(new PreguntasModel("¿Quién dirigió la Revolución francesa?",
                Arrays.asList(
                        "Luis XV de Francia",
                        "Jean-Paul Marat",
                        "Maximilien de Robespierre",
                        "Napoleón Bonaparte"),
                "Jean-Paul Marat", "archivos/Pregunta9.jpg"));

        // Pregunta 9
        preguntas.add(new PreguntasModel("¿Qué países colonizaron Estados Unidos?",
                Arrays.asList(
                        "España",
                        "Inglaterra",
                        "Países Bajos",
                        "Francia"),
                "Inglaterra", "archivos/Pregunta10.jpg"));

   
    }
    /**
     * Selecciona una pregunta aleatoria del listado de preguntas.
     * @return La pregunta seleccionada.
     */
    public PreguntasModel asignarPregunta() {
    PreguntasModel PreguntaSeleccionada = null;
    Random random = new Random();

    if (!preguntas.isEmpty()) {
        int randomIndex = random.nextInt(preguntas.size());
        PreguntaSeleccionada = preguntas.get(randomIndex);
    }

    if (PreguntaSeleccionada != null) {
        return new PreguntasModel(PreguntaSeleccionada.getId(), PreguntaSeleccionada.getPregunta(), PreguntaSeleccionada.getOpciones(), PreguntaSeleccionada.getRutaImagen() );
    } else {
        // Manejar el caso en el que no haya preguntas disponibles
        return null;
    }
    }
    
    /**
     * Obtiene la pregunta correspondiente a la respuesta proporcionada por el jugador.
     * @param preguntaSeleccionada La pregunta seleccionada por el jugador.
     * @return La pregunta completa con la respuesta correcta.
     */
    private PreguntasModel respuestaCorrecta(PreguntasModel PreguntaSeleccionada) {

        for (PreguntasModel pregunta : preguntas) {
            if (pregunta.getId() == PreguntaSeleccionada.getId()) {
                return pregunta;

            }
        }
        return null;
    }
    /**
     * Procesa la respuesta del jugador, eliminando la pregunta del listado y devolviendo la pregunta con la respuesta correcta.
     * @param PreguntaSeleccionada La pregunta seleccionada por el jugador.
     * @return La pregunta completa con la respuesta correcta.
     */
    
    public PreguntasModel procesarRespuesta(PreguntasModel PreguntaSeleccionada) {

        PreguntasModel respuesta = respuestaCorrecta(PreguntaSeleccionada);
        deletePregunta(PreguntaSeleccionada.getId());

        return respuesta;

    }

     /**
     * Elimina una pregunta del listado de preguntas.
     * @param id El ID de la pregunta a eliminar.
     */    

    private void deletePregunta(int id) {
        Iterator<PreguntasModel> iterator = preguntas.iterator();
        while (iterator.hasNext()) {
            PreguntasModel pregunta = iterator.next();
            if (pregunta.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

}
