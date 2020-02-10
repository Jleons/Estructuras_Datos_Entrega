/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import data.User_Data;
import data.*;
import data.Reserva;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import main.EstructurasDeDatos;
/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ConsultaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label usuario;

      @FXML
    private TableView<Reserva> table;

    @FXML
    private TableColumn Pelicula;

    @FXML
    private TableColumn Dia;

    @FXML
    private TableColumn Hora;

    @FXML
    private TableColumn Sala;

    @FXML
    private TableColumn Silla;
    
    ObservableList<Reserva> reservas1;
    private int position;

    @FXML
    void back(MouseEvent event) {
        EstructurasDeDatos.changeScene("select");

    }
    
    
    @FXML
    void actualizar(MouseEvent event) {
            usuario.setText(User_Data.usuario.getNombre());
            reservas1.clear();
           for(Reserva reserva:User_Data.usuario.getReservas())
               reservas1.add(reserva);
    }
    
    private void inicializarTabla(){
        Pelicula.setCellValueFactory(new PropertyValueFactory<Reserva,String>("pelicula1"));
        Dia.setCellValueFactory(new PropertyValueFactory<Reserva,String>("dia1"));
        Hora.setCellValueFactory(new PropertyValueFactory<Reserva,String>("hora1"));
        Sala.setCellValueFactory(new PropertyValueFactory<Reserva,String>("sala1"));
        Silla.setCellValueFactory(new PropertyValueFactory<Reserva,String>("silla1"));
        
        reservas1 =FXCollections.observableArrayList();
        table.setItems(reservas1);
    
    }
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        inicializarTabla();
    }    
    
}
