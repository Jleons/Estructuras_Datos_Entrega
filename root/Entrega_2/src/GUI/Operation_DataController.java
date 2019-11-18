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

public class Operation_DataController {

	static Silla sillaCompra;
	static Pelicula pelicula;
	static Usuario usuario;
	
	 @FXML
	    static private Label peliculaLabel;

	    @FXML
	    static private Label sala;

	    @FXML
	    static private Label silla;

	    @FXML
	    static private Label hora;

	    @FXML
	    static private Label precio;
	
	static void actualizarCompra() {
		Platform.runLater(new Runnable() {
			  @Override
			  public void run() {
				  peliculaLabel.setText("Pelicula: "+pelicula.getNombrePelicula());
					sala.setText("Sala: "+sillaCompra.getNumeroSala());
					silla.setText("Silla: "+sillaCompra.getNumeroSilla());
					hora.setText("Hora: "+pelicula.getHora());
					precio.setText("Precio: $" +sillaCompra.getPrecio()); 
			  }
			});
		
	}
	
	 @FXML
	    void comprar(MouseEvent event) {

		 Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmacion de compra");
			alert.setHeaderText("Quiere comprar la entrada a "+pelicula.getNombrePelicula()+" Hora: "+pelicula.getHora()+"?");
			alert.setContentText("Valor Total: $" +sillaCompra.getPrecio());

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				EstructurasDeDatos.changeScene("cartelera");
			} else {
			    
			}
	    }
	
	
   

    @FXML
    void back(MouseEvent event) {
    	EstructurasDeDatos.changeScene("sillas");
    }

	public static Silla getSillaCompra() {
		return sillaCompra;
	}

	public static void setSillaCompra(Silla sillaCompra) {
		Operation_DataController.sillaCompra = sillaCompra;
	}

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		Operation_DataController.usuario = usuario;
	}

	public static Pelicula getPelicula() {
		return pelicula;
	}

	public static void setPelicula(Pelicula pelicula) {
		Operation_DataController.pelicula = pelicula;
	}

}
