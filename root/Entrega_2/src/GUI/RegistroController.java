/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
//Inicio sesión
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import main.EstructurasDeDatos;
/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class RegistroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML // fx:id="user_cedula"
    private TextField user_cedula; // Value injected by FXMLLoader

    @FXML 
    private Button enter; 
    
    @FXML 
    private PasswordField user_password; 
    
    @FXML 
    private Label contrasenaIncorrecta;

    @FXML 
    private Label Nueva_cuenta; 

    @FXML
    void Registro(MouseEvent event) {
        user_cedula.clear();
        user_password.clear();
        contrasenaIncorrecta.setVisible(false);
        EstructurasDeDatos.changeScene("registro");
    }

    @FXML
    void login(ActionEvent event) {
        
        
        if(EstructurasDeDatos.getUsuarios().containsKey(user_cedula.getText()) 
           && EstructurasDeDatos.getUsuarios().get(user_cedula.getText()).getContrasena().equals(user_password.getText())){
            user_cedula.clear();
            user_password.clear();
            contrasenaIncorrecta.setVisible(false);
            EstructurasDeDatos.changeScene("cartelera");
        }
        else
            contrasenaIncorrecta.setVisible(true);
            

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
 
    
    
}
