/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
//Muestra La cartelera 
import data.Dia;
import data.Pelicula;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.Initializable;
import main.EstructurasDeDatos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CarteleraController implements Initializable {

	Dia dia;
	Pelicula peliculaCompra;
    /**
     * Initializes the controller class.
     */
        @FXML
    private ResourceBundle resources;

        @FXML
    private URL location;

        @FXML
    private ChoiceBox<String> choice_box;

        @FXML
    private ImageView imagen_pelicula;

        @FXML
    private Label titulo_pelicula;

        @FXML
    private Label sipnopsis;

        @FXML
    private Button continuar;

        @FXML
    private DatePicker diaSelect;

        @FXML
    void actualizarDia(ActionEvent event) {
        	dia=new Dia(diaSelect.getValue());
        	boolean diaYaEsta=false;
        	
        	//Revisa si el dia ya esta creado
        	for(Dia d:EstructurasDeDatos.getDias()) {
        		if(dia.getFechaDia().equals(d.getFechaDia())) {
        			dia=d;
        			diaYaEsta=true;
        		}
        	}
        	
        	//Si no esta el dia, lo anade a la lista de dias
        	if(!diaYaEsta)
        		EstructurasDeDatos.getDias().add(dia);
        	
        	
        	//Llena el check box de peliculas con el dia seleccionado
        	for(Pelicula p:dia.getPeliculas()) {
        		if(!p.getSala().estaLlena())
        			choice_box.getItems().add(p.getNombrePelicula()+" "+p.getHora());
        	}
        }
        
        @FXML
    void info(ActionEvent event) {
        //Manda a seleccionar la silla
        Scanner scan=new Scanner(choice_box.getSelectionModel().getSelectedItem());
        String nombrePeli=scan.next();
        String horaPeli=scan.next();
        scan.close();
        for(Pelicula p:dia.getPeliculas()) {
    		if(nombrePeli.equals(p.getNombrePelicula())&&horaPeli.equals(p.getHora()))
    			peliculaCompra=p;
    	}
        Sillas_SalaController.setPelicula(peliculaCompra);
        EstructurasDeDatos.changeScene("sillas");

    }
    
        @FXML
    void back(MouseEvent event) {
        EstructurasDeDatos.changeScene("login");

    }
    
    @FXML
    void cb_selected(Event event) throws MalformedURLException {
        //Actualiza la pantalla de cartelera segun las peliculas
        if(choice_box.getSelectionModel().getSelectedItem().equals("(Seleccione)")){
            continuar.setDisable(true);
            imagen_pelicula.setImage(null);
            titulo_pelicula.setText(null);
        }else{
            continuar.setDisable(false);
            Scanner scan=new Scanner(choice_box.getSelectionModel().getSelectedItem());
            String nombrePeli=scan.next();
            scan.close();
            imagen_pelicula.setImage(new Image("/peliculas/"+nombrePeli+".png"));
            titulo_pelicula.setText(choice_box.getValue());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        choice_box.getItems().add("(Seleccione)");

        choice_box.setValue("(Seleccione)");

    }    
    
}
