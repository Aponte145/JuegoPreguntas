/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package juego.Modelo;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergio
 */
public class PreguntasModelTest {
    
    public PreguntasModelTest() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        PreguntasModel instance = new PreguntasModel();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 1;
        PreguntasModel instance = new PreguntasModel();
        instance.setId(id);
        
    }

    @Test
    public void testGetPregunta() {
        System.out.println("getPregunta");
        String pregunta= "Esta es una pregunta";
        
        PreguntasModel instance = new PreguntasModel();
        instance.setPregunta(pregunta);
        String expResult = "Esta es una pregunta";
        
        String result = instance.getPregunta();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetPregunta() {
        System.out.println("setPregunta");
        String pregunta= "Esta es una pregunta";
        
        PreguntasModel instance = new PreguntasModel();
        instance.setPregunta(pregunta);
        String expResult = "Esta es una pregunta";
        
        String result = instance.getPregunta();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetOpciones() {
        System.out.println("getOpciones");
        List<String> opciones = Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3");
        PreguntasModel instance = new PreguntasModel(1,"Pregunta 1", opciones);
        List<String> expResult = opciones;
        List<String> result = instance.getOpciones();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetOpciones() {
        System.out.println("setOpciones");
        List<String> opciones = Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3");
        PreguntasModel instance = new PreguntasModel();
        instance.setOpciones(opciones);
        assertEquals(opciones, instance.getOpciones());
        
    }

    @Test
    public void testGetRespuestaCorrecta() {
        System.out.println("getRespuestaCorrecta");
        String pregunta = "Pregunta 1";
        List<String> opciones = Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3");
        String respuestaCorrecta = "Opcion 2";
        PreguntasModel instance = new PreguntasModel(pregunta, opciones, respuestaCorrecta);
        String expResult = "Opcion 2";
        String result = instance.getRespuestaCorrecta();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetRespuestaCorrecta() {
        System.out.println("setRespuestaCorrecta");
        String pregunta = "Pregunta 1";
        List<String> opciones = Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3");
        String respuestaCorrecta = "Opcion 2";
        PreguntasModel instance = new PreguntasModel(1, pregunta, opciones);
        instance.setRespuestaCorrecta(respuestaCorrecta);
        String expResult = "Opcion 2";
        String result = instance.getRespuestaCorrecta();
        assertEquals(expResult, result);
    }
    
}
