/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import juego.Modelo.JugadoresModel;

/**
 * La clase ManejadorJugador se encarga de administrar la carga y el guardado de los resultados de los jugadores en un archivo JSON.
 * También proporciona métodos para crear jugadores, actualizar sus puntuaciones y cargar los resultados almacenados.
 * 
 * @author Oscar Aponte, Lizeth Arango, Sergio Hernandez, Cristian Ortiz, Laura
 * Bernal
 */
public class ManejadorJugador {

    /**
     * Devuelve la ruta del archivo donde se almacenan los resultados.
     * Si el archivo no existe, se crea.
     * @return La ruta del archivo de resultados.
     */
private static String rutaArchivo() {
    String ruta = "src/archivos/resultados.json";
    File archivo = new File(ruta);
    System.out.println("Directorio actual: " + System.getProperty("user.dir"));
    System.out.println("Ruta absoluta del archivo: " + archivo.getAbsolutePath());

    if (archivo.exists()) {
        System.out.println("El archivo ya existe: " + ruta);
    } else {
        try {
            if (archivo.createNewFile()) {
                System.out.println("Se ha creado el archivo: " + ruta);
            } else {
                System.out.println("No se pudo crear el archivo: " + ruta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    return ruta;
}


    /**
     * Carga los resultados de los jugadores desde el archivo JSON.
     * @return La lista de jugadores cargados.
     */
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

    /**
     * Guarda el resultado de un jugador en el archivo JSON.
     * @param jugador El jugador cuyo resultado se va a guardar.
     */
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

    /**
     * Crea un nuevo jugador con el nombre especificado.
     * @param nombre El nombre del jugador.
     * @return El objeto JugadoresModel creado.
     */
    public JugadoresModel crearJugador(String nombre) {

        JugadoresModel nuevoJugador = new JugadoresModel(nombre, 0);
        return nuevoJugador;
    }

    /**
     * Actualiza la puntuación del jugador sumando el puntaje especificado.
     * @param jugador El jugador cuya puntuación se va a actualizar.
     * @param puntaje El puntaje a sumar.
     * @return El objeto JugadoresModel actualizado.
     */
    public JugadoresModel puntacion(JugadoresModel jugador, int puntaje) {

        jugador.setPuntaje(jugador.getPuntaje() + puntaje);
        return jugador;
    }
    
    public JugadoresModel resultadoPuntaje (JugadoresModel jugador){
      
        return jugador;
    }

}
