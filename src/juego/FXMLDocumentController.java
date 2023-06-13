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
 *
 * @author Oscar Aponte
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField Text;
    @FXML
    private Button button;

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
