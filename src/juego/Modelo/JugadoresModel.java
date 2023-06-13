/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.Modelo;

import java.util.Date;

/**
 *
 * @author Oscar Aponte
 */
    
    public class JugadoresModel {


    private static int nextId = 1;
    private int id;
    private String nameJugado;
    private int puntaje;
    private Date fecha;





    public JugadoresModel(String nameJugado, int puntaje, Date fecha) {
        
        this.id = nextId;
        nextId++;
        this.nameJugado = nameJugado;
        this.puntaje = puntaje;
        this.fecha = fecha;
    }
      public JugadoresModel(String nameJugado, int puntaje) {
        

        this.nameJugado = nameJugado;
        this.puntaje = puntaje;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNameJugado() {
        return nameJugado;
    }

    public void setNameJugado(String nameJugado) {
        this.nameJugado = nameJugado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
        
    
    
    
    
    
}
