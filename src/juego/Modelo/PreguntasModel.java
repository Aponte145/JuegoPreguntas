/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.Modelo;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Oscar Aponte
 */
public class PreguntasModel {


    private static int nextId = 1;
    private int id;
    private String Pregunta;
    private List<String> Opciones;
    private String RespuestaCorrecta;
    
    


    public PreguntasModel (String Pregunta, List<String>Opciones, String RespuestaCorrecta){

        this.id = nextId;
        nextId++;
        this.Pregunta = Pregunta;
        this.Opciones = Opciones;
        this.RespuestaCorrecta = RespuestaCorrecta;

 }
    
        public PreguntasModel (){

        }
        
        public PreguntasModel (int id , String Pregunta, List<String>Opciones){

        this.id = id;
        this.Pregunta = Pregunta;
        this.Opciones = Opciones;
   
 }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String Pregunta) {
        this.Pregunta = Pregunta;
    }

    public List<String> getOpciones() {
        return Opciones;
    }

    public void setOpciones(List<String> Opciones) {
        this.Opciones = Opciones;
    }

    public String getRespuestaCorrecta() {
        return RespuestaCorrecta;
    }

    public void setRespuestaCorrecta(String RespuestaCorrecta) {
        this.RespuestaCorrecta = RespuestaCorrecta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.Pregunta);
        hash = 37 * hash + Objects.hashCode(this.Opciones);
        return hash;
    }
    
   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PreguntasModel other = (PreguntasModel) obj;
        
        if (!Objects.equals(this.Pregunta, other.Pregunta)) {
            return false;
        }
        
        return Objects.equals(this.Opciones, other.Opciones);
    }
    


}


