/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
//Creacion de usuario
import data.Usuario;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.EstructurasDeDatos;
import ui.Consola;
/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class New_AccountController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private PasswordField contrasena;

    @FXML
    private PasswordField contrasena2;

    @FXML
    private TextField nombre;

    @FXML
    private TextField cedula;
    
    @FXML 
    private Label cedulaIncorrecta; 
    
    @FXML 
    private Label contrasenaIncorrecta; 
    
        @FXML
    void back(MouseEvent event) {
        cedula.clear();
        nombre.clear();
        contrasena.clear();
        contrasena2.clear();
        contrasenaIncorrecta.setVisible(false);
        cedulaIncorrecta.setVisible(false);
        EstructurasDeDatos.changeScene("login");
    }
    
     @FXML
    void registrar(ActionEvent event) {
        contrasenaIncorrecta.setVisible(false);
        cedulaIncorrecta.setVisible(false);
        if(contrasena.getText().equals("")||contrasena2.getText().equals("")||cedula.getText().equals("")||nombre.getText().equals("")
                ||!Consola.esNumero(cedula.getText())||EstructurasDeDatos.getUsuarios().containsKey(cedula.getText()))
            cedulaIncorrecta.setVisible(true);
        else if(!contrasena.getText().equals(contrasena2.getText()))
        contrasenaIncorrecta.setVisible(true);
        else{
            Usuario u = new Usuario(nombre.getText(),cedula.getText(),contrasena.getText());
            EstructurasDeDatos.getUsuarios().put(cedula.getText(), u);
            cedula.clear();
            nombre.clear();
            contrasena.clear();
            contrasena2.clear();
            EstructurasDeDatos.changeScene("cartelera");
            }
        }
 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
