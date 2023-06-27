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
 *
 * @author Oscar Aponte
 */
public class PuntacionFXMLController implements Initializable {
    
    @FXML
    private Label puntajeLabel;
    @FXML
    private TableView<JugadoresModel> tablaJugadores;
    @FXML
    private TableColumn<JugadoresModel, String> columnaNombre;
    @FXML
    private TableColumn<JugadoresModel, Integer> columnaPuntuacion;

    
     LogicaJuego logicajuego = new LogicaJuego();
     
     

    
    
    public void cargaPuntage (){
        
        JugadoresModel Jugador = logicajuego.cosultarPuntacion();
        
        puntajeLabel.setText(Jugador.getPuntaje()+ "/100");
       
        
        
    }
    
    public void tablaResultados(){
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nameJugado"));
        columnaPuntuacion.setCellValueFactory(new PropertyValueFactory<>("puntaje"));

        // Cargar los datos de los jugadores en la tabla
        List<JugadoresModel> jugadores = logicajuego.consultarTabla();
        tablaJugadores.getItems().addAll(jugadores);
        ordenarTablaPorPuntuacion();
    }
    
    private  void ordenarTablaPorPuntuacion() {
        // Obtener la lista de jugadores de la tabla
        ObservableList<JugadoresModel> jugadores = tablaJugadores.getItems();

        // Ordenar la lista utilizando un comparador personalizado
        jugadores.sort(Comparator.comparingInt(JugadoresModel::getPuntaje).reversed());

        // Actualizar la tabla con la lista ordenada
        tablaJugadores.setItems(jugadores);
    }
    
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
                
                // cerrar la ventana actual después de abrir la pantalla de preguntas
                Stage currentStage = (Stage) puntajeLabel.getScene().getWindow();
                currentStage.close();
              } catch (IOException e) {
                // Manejar cualquier excepción que ocurra al cargar la pantalla de preguntas
                e.printStackTrace();
            }  

   
    }
    
            
            
            
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
