package GUI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

import main.EstructurasDeDatos;

import java.util.Optional;

import data.*;
import data.User_Data;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Operation_DataController implements Initializable {
    
            @FXML
	    private Label peliculaLabel;

            @FXML
            private ImageView imagen_pelicula;
            
	    @FXML
	    private Label sala;

	    @FXML
	    private Label silla;

	    @FXML
	    private Label hora;

	    @FXML
	    private Label precio;
	
            
	
	 @FXML
	    void comprar(MouseEvent event) {

		 Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmacion de compra");
			alert.setHeaderText("Quiere comprar la entrada a "+User_Data.pelicula.getNombrePelicula()+
                                " Hora: "+User_Data.pelicula.getHora()+"?");
			alert.setContentText("Valor Total: $" +User_Data.silla.getPrecio());
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
                            User_Data.silla.setOcupada(true);
                            User_Data.usuario.addReserva(new Reserva(User_Data.dia,
                                    User_Data.pelicula,User_Data.pelicula.getSala(),User_Data.silla));
				EstructurasDeDatos.changeScene("cartelera");
			} else {
			    
			}
	    }
	
	
   

    @FXML
    void back(MouseEvent event) {
    	EstructurasDeDatos.changeScene("sillas");
    }

     @FXML
    void refresh(MouseEvent event) {
        peliculaLabel.setText("Pelicula: " + User_Data.pelicula.getNombrePelicula());
        sala.setText("Sala: " + User_Data.silla.getNumeroSala());
        silla.setText("Silla: " + User_Data.silla.getNumeroSilla());
        hora.setText("Hora: " + User_Data.pelicula.getHora());
        precio.setText("Precio: " + User_Data.silla.getPrecio());
        imagen_pelicula.setImage(new Image("/peliculas/"+User_Data.pelicula.getNombrePelicula()+".png"));
    }

        
         
        
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
}
