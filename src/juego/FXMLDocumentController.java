/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package juego;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import juego.Contralador.LogicaJuego;

/**
 * Controlador de la interfaz gráfica FXMLDocument.fxml.
 * Se encarga de manejar los eventos de los elementos de la interfaz y llamar a la lógica del juego.
 * 
 *  * @authors Oscar Aponte, Lizeth Arango, Sergio Hernandez, Cristian Ortiz, Laura
 * Bernal
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
            logicajuego.crearjugador(playerName);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
