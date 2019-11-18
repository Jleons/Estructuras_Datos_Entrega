package GUI;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import main.EstructurasDeDatos;
import data.*;

public class Sillas_SalaController {
	//Necesita Actualizar la sala cada vez que se muestre

	private Sala sala=EstructurasDeDatos.getDias().get(0).getPeliculas()[0].getSala();
	static private Pelicula pelicula;
	private Silla sillaComprada;
	
	
	
	@FXML
	void click(ActionEvent event) {
		//Accion de los botones al hacerles click
		Alert alert = new Alert(AlertType.CONFIRMATION);
		Button botonSilla= (Button)event.getSource();
		int numSilla=Integer.valueOf(botonSilla.getText());
		alert.setTitle("Confirmacion de silla");
		alert.setHeaderText("Quiere comprar la silla " + numSilla+"?");
		alert.setContentText("Cuesta $" +sala.getSilla(numSilla).getPrecio());

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			//Desactiva el boton de la silla
			botonSilla.setDisable(true);
			
			//Guarda la silla seleccionada en la variable de la clase
			sillaComprada=sala.getSilla(numSilla);
			
			//Pone la y pelicula silla en operation_data
			Operation_DataController.setSillaCompra(sillaComprada);
			Operation_DataController.setPelicula(pelicula);
			Operation_DataController.actualizarCompra();
			EstructurasDeDatos.changeScene("operation");
			
		} else {
		    
		}
	}
	 
	@FXML
    void back(MouseEvent event) {
		EstructurasDeDatos.changeScene("cartelera");
    }
	
	@FXML
	void initialize() {
		refreshButtons();
	}
	
	void refreshButtons() {
		//Activa y desactiva los botones de las sillas, segun si estan ocupadas
		for(Silla silla: sala.getSillas()){
			int numSilla= silla.getNumeroSilla();
			String stringSilla= ""+(numSilla-1);
			if (numSilla>=0&&numSilla<=10)
				stringSilla= "0"+(numSilla-1);
        	if(silla.isOcupada()) 
        		getBoton(stringSilla).setDisable(true);
        	else
        		getBoton(stringSilla).setDisable(false);
		}
	}
	
	Button getBoton(String numSilla) {
		//Obtiene el boton con el numero de silla que se le de
	    try {
	        
	        Field field = this.getClass().getDeclaredField("silla"+numSilla);
	        field.setAccessible(true);
	        Object boton = field.get(this);
	        
	        return (Button)boton;
	    } catch (Throwable e) {System.out.println(); }
	    return null;
	}
	
    public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
		refreshButtons();
	}

	public Silla getSillaComprada() {
		return sillaComprada;
	}

	public void setSillaComprada(Silla sillaComprada) {
		this.sillaComprada = sillaComprada;
	}

	public static Pelicula getPelicula() {
		return pelicula;
	}

	public static void setPelicula(Pelicula pelicula) {
		Sillas_SalaController.pelicula = pelicula;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane silllasGeneral;

    @FXML
    public Button silla00;

    @FXML
    private Button silla01;

    @FXML
    private Button silla02;

    @FXML
    private Button silla03;

    @FXML
    private Button silla04;

    @FXML
    private Button silla05;

    @FXML
    private Button silla06;

    @FXML
    private Button silla07;

    @FXML
    private Button silla08;

    @FXML
    private Button silla09;

    @FXML
    private Button silla10;

    @FXML
    private Button silla11;

    @FXML
    private Button silla12;

    @FXML
    private Button silla13;

    @FXML
    private Button silla14;

    @FXML
    private Button silla15;

    @FXML
    private Button silla16;

    @FXML
    private Button silla17;

    @FXML
    private Button silla18;

    @FXML
    private Button silla19;

    @FXML
    private Button silla20;

    @FXML
    private Button silla21;

    @FXML
    private Button silla22;

    @FXML
    private Button silla23;

    @FXML
    private Button silla24;

    @FXML
    private Button silla25;

    @FXML
    private Button silla26;

    @FXML
    private Button silla27;

    @FXML
    private Button silla28;

    @FXML
    private Button silla29;

    @FXML
    private Button silla30;

    @FXML
    private Button silla31;

    @FXML
    private Button silla32;

    @FXML
    private Button silla33;

    @FXML
    private Button silla34;

    @FXML
    private Button silla35;

    @FXML
    private Button silla36;

    @FXML
    private Button silla37;

    @FXML
    private Button silla38;

    @FXML
    private Button silla39;

    @FXML
    private Button silla40;

    @FXML
    private Button silla41;

    @FXML
    private Button silla42;

    @FXML
    private Button silla43;

    @FXML
    private Button silla44;

    @FXML
    private Button silla45;

    @FXML
    private Button silla46;

    @FXML
    private Button silla47;

    @FXML
    private Button silla48;

    @FXML
    private Button silla49;

    @FXML
    private Button silla50;

    @FXML
    private Button silla51;

    @FXML
    private Button silla52;

    @FXML
    private Button silla53;

    @FXML
    private Button silla54;

    @FXML
    private Button silla55;

    @FXML
    private Button silla56;

    @FXML
    private Button silla57;

    @FXML
    private Button silla58;

    @FXML
    private Button silla59;

    @FXML
    private Button silla60;

    @FXML
    private Button silla61;

    @FXML
    private Button silla62;

    @FXML
    private Button silla63;

    @FXML
    private Button silla64;

    @FXML
    private Button silla65;

    @FXML
    private Button silla66;

    @FXML
    private Button silla67;

    @FXML
    private Button silla68;

    @FXML
    private Button silla69;

    @FXML
    private Button silla70;

    @FXML
    private Button silla71;

    @FXML
    private Button silla72;

    @FXML
    private Button silla73;

    @FXML
    private Button silla74;

    @FXML
    private Button silla75;

    @FXML
    private Button silla76;

    @FXML
    private Button silla77;

    @FXML
    private Button silla78;

    @FXML
    private Button silla79;

    @FXML
    private Button silla80;

    @FXML
    private Button silla81;

    @FXML
    private Button silla82;

    @FXML
    private Button silla83;

    @FXML
    private Button silla84;

    @FXML
    private Button silla85;

    @FXML
    private Button silla86;

    @FXML
    private Button silla87;

    @FXML
    private Button silla88;

    @FXML
    private Button silla89;

    @FXML
    private Button silla90;

    @FXML
    private Button silla91;

    @FXML
    private Button silla92;

    @FXML
    private Button silla93;

    @FXML
    private Button silla94;

    @FXML
    private Button silla95;

    @FXML
    private Button silla96;

    @FXML
    private Button silla97;

    @FXML
    private Button silla98;

    @FXML
    private Button silla99;

}
