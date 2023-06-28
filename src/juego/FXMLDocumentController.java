/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import juego.Contralador.LogicaJuego;
import juego.Modelo.JugadoresModel;

/**
 * Controlador de la interfaz gráfica FXMLDocument.fxml.
 * Se encarga de manejar los eventos de los elementos de la interfaz y llamar a la lógica del juego.
 * 
 * Autores: Oscar Aponte, Lizeth Arango, Sergio Hernandez, Cristian Ortiz, Laura Bernal
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField Text;
    @FXML
    private Button button;

    /**
     * Maneja el evento del botón.
     * Se llama cuando se hace clic en el botón.
     * Inicia el juego, crea un nuevo jugador con el nombre proporcionado y lo registra en la lógica del juego.
     * @param event El evento del botón.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {

        LogicaJuego logicajuego = new LogicaJuego();
        logicajuego.iniciarJuego();
        String playerName = Text.getText();

        if (playerName != null && !playerName.isEmpty()) {
           JugadoresModel  JugadoresModel = logicajuego.crearjugador(playerName);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("./Preguntas.fxml"));
                Parent root = loader.load();
                PreguntasController preguntasController = loader.getController();
                // Aquí puedes configurar las preguntas en el controlador de la pantalla de preguntas
                preguntasController.IniciarCuestionario(JugadoresModel);
                
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                
                // Opcionalmente, puedes cerrar la ventana actual después de abrir la pantalla de preguntas
                Stage currentStage = (Stage) Text.getScene().getWindow();
                currentStage.close();
                
            } catch (IOException e) {
                // Manejar cualquier excepción que ocurra al cargar la pantalla de preguntas
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
