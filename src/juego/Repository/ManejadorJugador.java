/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import juego.Modelo.JugadoresModel;

/**
 *
 * @author Oscar Aponte
 */
public class ManejadorJugador {
    


    private static String rutaArchivo() {

        File archivo = new File("archivos/resultados.json");

        if (archivo.exists()) {
             System.out.println ("El archivo ya existe:  archivos/resultados.json");
        } else {
            try {
                if (archivo.createNewFile()) {
                System.out.println("Se ha creado el archivo: archivos/resultados.json " );
                } else {
                   System.out.println("No Se pudo creado el archivo: archivos/resultados.json " );
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return "archivos/resultados.json";
    }

    public static List<JugadoresModel> cargarResultados() {

        List<JugadoresModel> jugadores = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String ruta = rutaArchivo();
            jugadores = objectMapper.readValue(new File(ruta), new TypeReference<List<JugadoresModel>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jugadores;
    }
    
    public static void guardarResultado(JugadoresModel jugador) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String ruta = rutaArchivo();
            List<JugadoresModel> jugadores = cargarResultados();
            jugadores.add(jugador);
            objectMapper.writeValue(new File(ruta), jugadores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public JugadoresModel crearJugador(String nombre){
        
        JugadoresModel nuevoJugador = new JugadoresModel(nombre, 0);
        return nuevoJugador;
    }
    
    public JugadoresModel puntacion (JugadoresModel jugador , int puntaje){
        
        
        jugador.setPuntaje(jugador.getPuntaje() + puntaje);
        return jugador;
    }
    


}
