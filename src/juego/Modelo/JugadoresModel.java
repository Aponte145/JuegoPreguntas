/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.Modelo;

import java.util.Date;

/**
 * La clase JugadoresModel representa a un jugador en el juego. Esta clase se
 * encarga de almacenar información relacionada con los jugadores, como su
 * nombre, puntaje y fecha del juego. También proporciona métodos para acceder y
 * modificar dicha información.
 *
 * @author Oscar Aponte, Lizeth Arango, Sergio Hernandez, Cristian Ortiz, Laura
 * Bernal
 */
public class JugadoresModel {

    private static int nextId = 1; // Identificador para el siguiente jugador
    private int id; // Identificador único del jugador
    private String nameJugado; // Nombre del jugador
    private int puntaje; // Puntaje del jugador
    private Date fecha; // Fecha del juego

    /**
     * Constructor de la clase JugadoresModel.
     *
     * @param nameJugado El nombre del jugador.
     * @param puntaje El puntaje del jugador.
     * @param fecha La fecha del juego.
     */
    public JugadoresModel(String nameJugado, int puntaje, Date fecha) {
        this.id = nextId; // Asignar el identificador único
        nextId++; // Incrementar el identificador para el siguiente jugador
        this.nameJugado = nameJugado;
        this.puntaje = puntaje;
        this.fecha = fecha;
    }

    /**
     * Constructor de la clase JugadoresModel.
     *
     * @param nameJugado El nombre del jugador.
     * @param puntaje El puntaje del jugador.
     */
    public JugadoresModel(String nameJugado, int puntaje) {
        this.nameJugado = nameJugado;
        this.puntaje = puntaje;
    }

    /**
     * Obtiene el identificador del jugador.
     *
     * @return El identificador del jugador.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del jugador.
     *
     * @param id El identificador del jugador.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre del jugador.
     */
    public String getNameJugado() {
        return nameJugado;
    }

    /**
     * Establece el nombre del jugador.
     *
     * @param nameJugado El nombre del jugador.
     */
    public void setNameJugado(String nameJugado) {
        this.nameJugado = nameJugado;
    }

    /**
     * Obtiene el puntaje del jugador.
     *
     * @return El puntaje del jugador.
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Establece el puntaje del jugador.
     *
     * @param puntaje El puntaje del jugador.
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Obtiene la fecha del juego.
     *
     * @return La fecha del juego.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del juego.
     *
     * @param fecha La fecha del juego.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
