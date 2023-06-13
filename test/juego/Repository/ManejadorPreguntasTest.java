/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package juego.Repository;

import java.util.Arrays;
import juego.Modelo.PreguntasModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergio
 */
public class ManejadorPreguntasTest {
    
    public ManejadorPreguntasTest() {
    }

    @Test
    public void testAddPregunta() {
        System.out.println("addPregunta");
        PreguntasModel pregunta = new PreguntasModel("Pregunta 1", Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3"), "Opcion 1");
        ManejadorPreguntas instance = new ManejadorPreguntas();
        instance.addPregunta(pregunta);
        PreguntasModel preguntaAsignada =  instance.asignarPregunta();
        assertEquals(pregunta.getPregunta(), preguntaAsignada.getPregunta());
    }

    

    @Test
    public void testAsignarPregunta() {
        /*
        System.out.println("asignarPregunta");
        ManejadorPreguntas instance = new ManejadorPreguntas();
        PreguntasModel expResult = null;
        PreguntasModel result = instance.asignarPregunta();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
*/
    }

    @Test
    public void testProcesarRespuesta() {
        /*
        System.out.println("procesarRespuesta");
        PreguntasModel PreguntaSeleccionada = null;
        ManejadorPreguntas instance = new ManejadorPreguntas();
        PreguntasModel expResult = null;
        PreguntasModel result = instance.procesarRespuesta(PreguntaSeleccionada);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
*/
    }
    
}
