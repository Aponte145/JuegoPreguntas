/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package juego.Modelo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.Instant;
import java.util.Date;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergio
 */
public class JugadoresModelTest {
    
    public JugadoresModelTest() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        JugadoresModel instance = new JugadoresModel("jugador 1",0);
        instance.setId(1);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 5;
        JugadoresModel instance = new JugadoresModel("jugador 1",0);
        instance.setId(id);
        assertEquals(5,instance.getId());
        
    }

    @Test
    public void testGetNameJugado() {
        System.out.println("getNameJugado");
        JugadoresModel instance = new JugadoresModel("jugador 1", 0);
        String expResult = "jugador 1";
        String result = instance.getNameJugado();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetNameJugado() {
        System.out.println("setNameJugado");
        String nameJugado = "jugador 2";
        JugadoresModel instance = new JugadoresModel("jugador 1", 0);
        instance.setNameJugado(nameJugado);
        assertEquals("jugador 2", instance.getNameJugado());
        
    }

    @Test
    public void testGetPuntaje() {
        System.out.println("getPuntaje");
        JugadoresModel instance = new JugadoresModel("jugador 1", 10);
        int expResult = 10;
        int result = instance.getPuntaje();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetPuntaje() {
        System.out.println("setPuntaje");
        int puntaje = 10;
        JugadoresModel instance = new JugadoresModel("jugador 1", 0);
        instance.setPuntaje(puntaje);
        assertEquals(10, instance.getPuntaje());
    }

    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Date hoy = new Date();
        JugadoresModel instance = new JugadoresModel("jugador 1", 0, hoy);
        Date expResult = hoy;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        LocalDateTime hoy = LocalDateTime.now();
        Instant instant = hoy.atZone(ZoneId.systemDefault()).toInstant();
        Date fechahoy = Date.from(instant);
        JugadoresModel instance = new JugadoresModel("jugador 1", 0, fechahoy);
        
        LocalDateTime tomorrow = hoy.plusDays(1);
        instant = tomorrow.atZone(ZoneId.systemDefault()).toInstant();
        Date fechaSiguiente = Date.from(instant);
        
        instance.setFecha(fechaSiguiente);
        
        assertEquals(fechaSiguiente, instance.getFecha());
       
    }

    
}
