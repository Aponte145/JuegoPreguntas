/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package juego;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import juego.Contralador.LogicaJuego;
import juego.Modelo.JugadoresModel;
import juego.Modelo.PreguntasModel;
import javafx.util.Pair;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oscar Aponte
 */
public class PreguntasController implements Initializable {

    LogicaJuego logicajuego = new LogicaJuego();

    private PreguntasModel preguntaAsignada;
    private String selectedOption;
    private JugadoresModel jugador;


    @FXML
    private ImageView imagenPregunta;

    @FXML
    private Label LabelPregunta;

    @FXML
    private RadioButton RadioOption1;

    @FXML
    private RadioButton RadioOption2;

    @FXML
    private RadioButton RadioOption3;

    @FXML
    private RadioButton RadioOption4;

    @FXML
    private ImageView ImgOption1;

    @FXML
    private ImageView ImgOption2;

    @FXML
    private ImageView ImgOption3;

    @FXML
    private ImageView ImgOption4;

    @FXML
    private Button ButtonEnviar;
    
    @FXML
    private Button ButtonSiguiente;
    


    private ToggleGroup toggleGroup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        toggleGroup = new ToggleGroup();
        RadioOption1.setToggleGroup(toggleGroup);
        RadioOption2.setToggleGroup(toggleGroup);
        RadioOption3.setToggleGroup(toggleGroup);
        RadioOption4.setToggleGroup(toggleGroup);

    }

    public void cargaPregunta(PreguntasModel preguntaAsignada) {
        
       
                
        System.out.println(preguntaAsignada.getPregunta());

        LabelPregunta.setText(preguntaAsignada.getPregunta());

        Image image = new Image(preguntaAsignada.getRutaImagen());
        imagenPregunta.setImage(image);
        RadioOption1.setText(preguntaAsignada.getOpciones().get(0));
        RadioOption2.setText(preguntaAsignada.getOpciones().get(1));
        RadioOption3.setText(preguntaAsignada.getOpciones().get(2));
        RadioOption4.setText(preguntaAsignada.getOpciones().get(3));

    }

    public void IniciarCuestionario(JugadoresModel jugadorEntrada) throws IOException {

        jugador = jugadorEntrada;
        Cuestionario();

    }

    private void Cuestionario() throws IOException {
        
        ButtonSiguiente.setVisible(false);
        ButtonEnviar.setVisible(true);

        preguntaAsignada = logicajuego.asignarPregunta();

        if (preguntaAsignada != null) {

            cargaPregunta(preguntaAsignada);

        }else {
             
                FXMLLoader loader = new FXMLLoader(getClass().getResource("./puntacionFXML.fxml"));
                Parent root = loader.load();
                PuntacionFXMLController puntacionFXMLController = loader.getController();
                // Aquí puedes configurar las preguntas en el controlador de la pantalla de preguntas
                puntacionFXMLController.cargaPuntage();
                
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                
                // cerrar la ventana actual después de abrir la pantalla de preguntas
                Stage currentStage = (Stage) LabelPregunta.getScene().getWindow();

                currentStage.close();
                
                
        }
        
    }

    @FXML
    private void handleSendButtonAction(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            selectedOption = selectedRadioButton.getText();

            Pair<PreguntasModel, Boolean> resultado = logicajuego.califcicarRespuesta(preguntaAsignada, selectedOption, jugador);
            PreguntasModel pregunta = resultado.getKey();
            boolean resultadoRespuesta = resultado.getValue();

            // Respuesta correcta
            for (Toggle toggle : toggleGroup.getToggles()) {
                RadioButton radioButton = (RadioButton) toggle;
                if (radioButton.getText().equals(pregunta.getRespuestaCorrecta())) {
                    mostrarImagen(radioButton, true); // Marcar como correcta
                } else {
                    mostrarImagen(radioButton, false); // Marcar como incorrecta
                }
            }
            
            ButtonEnviar.setVisible(false);
            ButtonSiguiente.setVisible(true);
            //
        } else {
            // No se ha seleccionado ninguna opción
        }
    }
    @FXML
    private void handleNextButtonAction(ActionEvent event) throws IOException {
        
        toggleGroup.selectToggle(null);
        resetImageViews(); 
        Cuestionario(); 

   
    }
    
   private void resetImageViews() {
    ImgOption1.setImage(null);
    ImgOption2.setImage(null);
    ImgOption3.setImage(null);
    ImgOption4.setImage(null);
    imagenPregunta.setImage(null);
}
    

    private void mostrarImagen(RadioButton radioButton, boolean esCorrecta) {
        ImageView imageView;
        if (radioButton == RadioOption1) {
            imageView = ImgOption1;
        } else if (radioButton == RadioOption2) {
            imageView = ImgOption2;
        } else if (radioButton == RadioOption3) {
            imageView = ImgOption3;
        } else {
            imageView = ImgOption4;
        }

        if (esCorrecta) {
            imageView.setImage(new Image("archivos/imagen_correcta.png"));
        } else {
            imageView.setImage(new Image("archivos/imagen_incorrecta.png"));
        }
    }
}
