/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import main.EstructurasDeDatos;
/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class SelectController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Label back;

    @FXML
    private AnchorPane Cartelera_button;

    @FXML
    private AnchorPane Consulta_button;

    @FXML
    void back(MouseEvent event) {

    }

    @FXML
    void to_cartelera(MouseEvent event) {
        EstructurasDeDatos.changeScene("cartelera");
    }

    @FXML
    void to_consulta(MouseEvent event) {
        EstructurasDeDatos.changeScene("consulta");
    }

    @FXML
    void to_registro(MouseEvent event) {
        EstructurasDeDatos.changeScene("login");
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
