/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package juego;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import juego.Contralador.LogicaJuego;
import juego.Modelo.JugadoresModel;

/**
 * FXML Controller class
 * Controlador de la interfaz FXML para mostrar las puntuaciones de los jugadores.
 * Se encarga de cargar los datos de los jugadores y ordenar la tabla por puntuación.
 * También permite abrir otra ventana de tabla de puntuaciones.
 *
 * @author Oscar Aponte, Lizeth Arango, Sergio Hernandez, Cristian Ortiz, Laura Bernal
 */
public class PuntacionFXMLController implements Initializable {
    
    @FXML
    private Label puntajeLabel; // Etiqueta para mostrar el puntaje
    @FXML
    private TableView<JugadoresModel> tablaJugadores; // Tabla para mostrar los jugadores
    @FXML
    private TableColumn<JugadoresModel, String> columnaNombre; // Columna para el nombre del jugador
    @FXML
    private TableColumn<JugadoresModel, Integer> columnaPuntuacion; // Columna para la puntuación del jugador

    LogicaJuego logicajuego = new LogicaJuego(); // Instancia de la lógica del juego

    /**
     * Método para cargar el puntaje del jugador actual en la etiqueta.
     */
    public void cargaPuntage() {
        JugadoresModel Jugador = logicajuego.cosultarPuntacion(); // Obtener el jugador actual
        puntajeLabel.setText(Jugador.getPuntaje() + "/100"); // Mostrar el puntaje en la etiqueta
    }
    
    /**
     * Método para cargar los resultados de los jugadores en la tabla.
     */
    public void tablaResultados() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nameJugado")); // Asignar la propiedad de nombre a la columna
        columnaPuntuacion.setCellValueFactory(new PropertyValueFactory<>("puntaje")); // Asignar la propiedad de puntuación a la columna

        // Cargar los datos de los jugadores en la tabla
        List<JugadoresModel> jugadores = logicajuego.consultarTabla(); // Obtener la lista de jugadores
        tablaJugadores.getItems().addAll(jugadores); // Agregar los jugadores a la tabla
        ordenarTablaPorPuntuacion(); // Ordenar la tabla por puntuación
    }
    
    /**
     * Método para ordenar la tabla por puntuación de forma descendente.
     */
    private void ordenarTablaPorPuntuacion() {
        // Obtener la lista de jugadores de la tabla
        ObservableList<JugadoresModel> jugadores = tablaJugadores.getItems();

        // Ordenar la lista utilizando un comparador personalizado
        jugadores.sort(Comparator.comparingInt(JugadoresModel::getPuntaje).reversed());

        // Actualizar la tabla con la lista ordenada
        tablaJugadores.setItems(jugadores);
    }
    
    /**
     * Manejador del evento del botón de la tabla.
     * Abre una nueva ventana de tabla de puntuaciones.
     */
    @FXML
    private void handleTablaButtonAction(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./TablaPuntacion.fxml"));
            Parent root = loader.load();
            PuntacionFXMLController puntacionFXMLController = loader.getController();
            // Aquí puedes configurar las preguntas en el controlador de la pantalla de preguntas
            puntacionFXMLController.tablaResultados();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
            // Cerrar la ventana actual después de abrir la pantalla de preguntas
            Stage currentStage = (Stage) puntajeLabel.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            // Manejar cualquier excepción que ocurra al cargar la pantalla de preguntas
            e.printStackTrace();
        }
    }
    
    /**
     * Método de inicialización del controlador.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Implementar cualquier lógica de inicialización adicional
    }    
}
