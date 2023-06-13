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
 *
 * @author Oscar Aponte
 */
public class ManejadorPreguntas {

    private final List<PreguntasModel> preguntas;

    public ManejadorPreguntas() {

        preguntas = new ArrayList<>();

    }

    public void addPregunta(PreguntasModel pregunta) {

        preguntas.add(pregunta);
    }

    public void preparaPregunta() {

        // Pregunta 0 
        addPregunta(new PreguntasModel("Que es POO",
                Arrays.asList("Programación Orientada a Objetos",
                        "Paradigma de Programación", "Modularidad y Reutilización de Código",
                        "Flexibilidad y Mantenibilidad del Sistema"),
                "Programación Orientada a Objetos"));
        // Pregunta 1
        addPregunta(new PreguntasModel("Pilares Fundamentales POO",
                Arrays.asList("Mensajes, Comportamientos, Interacción, Composición",
                        "Modularidad, Reutilización de Código, Flexibilidad, Mantenibilidad",
                        "Clases, Objetos, Métodos, Atributos", "Abstracción, Encapsulamiento, Herencia, Polimorfismo"),
                "Abstracción, Encapsulamiento, Herencia, Polimorfismo"));
        // Pregunta 2
        preguntas.add(new PreguntasModel("Ejemplo de herencia en Java",
                Arrays.asList("Herencia simple", "Herencia múltiple", "Herencia híbrida", "Herencia múltiple y híbrida"),
                "Herencia simple"));

        // Pregunta 3
        preguntas.add(new PreguntasModel("¿Qué es la encapsulación en POO?",
                Arrays.asList("La capacidad de un objeto para ocultar su implementación interna y exponer solo una interfaz",
                        "La capacidad de un objeto para heredar propiedades y comportamientos de otro objeto",
                        "La capacidad de un objeto para tener múltiples formas o comportamientos en función del contexto",
                        "La capacidad de un objeto para agrupar datos y comportamientos relacionados"),
                "La capacidad de un objeto para ocultar su implementación interna y exponer solo una interfaz"));

        // Pregunta 4
        preguntas.add(new PreguntasModel("¿Cuál de las siguientes opciones describe mejor el polimorfismo en POO?",
                Arrays.asList("La capacidad de un objeto para ocultar su implementación interna y exponer solo una interfaz",
                        "La capacidad de un objeto para tener múltiples formas o comportamientos en función del contexto",
                        "La capacidad de un objeto para agrupar datos y comportamientos relacionados",
                        "La capacidad de un objeto para heredar propiedades y comportamientos de otro objeto"),
                "La capacidad de un objeto para tener múltiples formas o comportamientos en función del contexto"));

        // Pregunta 5
        preguntas.add(new PreguntasModel("¿Qué elementos crees que definen a un objeto?",
                Arrays.asList("Sus cardinalidad y su tipo",
                        "Sus atributos y sus métodos",
                        "La forma en que establece comunicación e intercambia mensaje",
                        "Su interfaz y los eventos asociado"),
                "Sus atributos y sus métodos"));

        // Pregunta 6
        preguntas.add(new PreguntasModel("¿Qué código de los siguientes tiene que ver con la herencia?",
                Arrays.asList("public class Componente extends Producto",
                        "public class Componente inherit Producto",
                        "public class Componente implements Producto",
                        "public class Componente belong to Producto"),
                "public class Componente extends Producto"));

        // Pregunta 7
        preguntas.add(new PreguntasModel("¿Qué significa instanciar una clase?",
                Arrays.asList("Duplicar una clase",
                        "Eliminar una clase",
                        "Crear un objeto a partir de la clase",
                        "Conectar dos clases entre sí"),
                "Crear un objeto a partir de la clase"));

        // Pregunta 8
        preguntas.add(new PreguntasModel("¿Qué significa sobrecargar (overload) un método?",
                Arrays.asList("Editarlo para modificar su comportamiento",
                        "Cambiarle el nombre dejándolo con la misma funcionalidad",
                        "Crear un método con el mismo nombre pero diferentes argumentos",
                        "Añadirle funcionalidades a un método"),
                "Crear un método con el mismo nombre pero diferentes argumentos"));

        // Pregunta 9
        preguntas.add(new PreguntasModel("¿Qué es una excepción?",
                Arrays.asList("Un objeto que no puede ser instanciado",
                        "Un bucle que no finaliza",
                        "Un error que lanza un método cuando algo va mal",
                        "Un tipo de evento muy utilizado al crear interfaces"),
                "Un error que lanza un método cuando algo va mal"));

   
    }

    public PreguntasModel asignarPregunta() {

        PreguntasModel PreguntaSeleccionada = new PreguntasModel();
        Random random = new Random();

        int randomIndex = random.nextInt(preguntas.size());
        PreguntaSeleccionada = preguntas.get(randomIndex);

        return new PreguntasModel(PreguntaSeleccionada.getId(), PreguntaSeleccionada.getPregunta(), PreguntaSeleccionada.getOpciones());

    }

    private PreguntasModel respuestaCorrecta(PreguntasModel PreguntaSeleccionada) {

        for (PreguntasModel pregunta : preguntas) {
            if (pregunta.getId() == PreguntaSeleccionada.getId()) {
                return pregunta;

            }
        }
        return null;
    }

    public PreguntasModel procesarRespuesta(PreguntasModel PreguntaSeleccionada) {

        PreguntasModel respuesta = respuestaCorrecta(PreguntaSeleccionada);
        deletePregunta(PreguntaSeleccionada.getId());

        return respuesta;

    }

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
