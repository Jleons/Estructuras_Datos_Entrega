/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
//Muestra La cartelera 
import data.Dia;
import data.Pelicula;
import data.User_Data;

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
    private Label sala;

    @FXML
    private Label hora;

        @FXML
    private Button continuar;

        @FXML
    private DatePicker diaSelect;

        @FXML
    void actualizarDia(ActionEvent event) {
        	User_Data.dia=new Dia(diaSelect.getValue());
        	boolean diaYaEsta=false;
        	
        	//Revisa si el dia ya esta creado
        	for(Dia d:EstructurasDeDatos.getDias()) {
        		if(User_Data.dia.getFechaDia().equals(d.getFechaDia())) {
        			User_Data.dia=d;
        			diaYaEsta=true;
        		}
        	}
        	
        	//Si no esta el dia, lo anade a la lista de dias
        	if(!diaYaEsta)
        		EstructurasDeDatos.getDias().add(User_Data.dia);
        	
                
        	choice_box.getItems().clear();
                choice_box.getItems().add("(Seleccione)");
                choice_box.setValue("(Seleccione)");
        	//Llena el check box de peliculas con el dia seleccionado
        	for(Pelicula p:User_Data.dia.getPeliculas()) {
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
        for(Pelicula p:User_Data.dia.getPeliculas()) {
    		if(nombrePeli.equals(p.getNombrePelicula())&&horaPeli.equals(p.getHora()))
    			User_Data.pelicula=p;
    	}
        User_Data.sala=User_Data.pelicula.getSala();
        EstructurasDeDatos.changeScene("sillas");

    }
    
        @FXML
    void back(MouseEvent event) {
        EstructurasDeDatos.changeScene("select");

    }
    
    @FXML
    void cb_selected(Event event) throws MalformedURLException {
        //Actualiza la pantalla de cartelera segun las peliculas
        if(choice_box.getSelectionModel().getSelectedItem().equals("(Seleccione)")){
            continuar.setDisable(true);
            imagen_pelicula.setImage(null);
            titulo_pelicula.setText(null);
            sala.setText(null);
            hora.setText(null);
            
        }else{
            continuar.setDisable(false);
            Scanner scan=new Scanner(choice_box.getSelectionModel().getSelectedItem());
            String nombrePeli=scan.next();
            String horaPeli=scan.next();
            scan.close();
            imagen_pelicula.setImage(new Image("/peliculas/"+nombrePeli+".png"));
            for(Pelicula p:User_Data.dia.getPeliculas()) {
    		if(nombrePeli.equals(p.getNombrePelicula())&&horaPeli.equals(p.getHora()))
    			User_Data.pelicula=p;
    	}
            titulo_pelicula.setText(nombrePeli);
            sala.setText("Sala: "+User_Data.pelicula.getSala().getNumeroSala());
            hora.setText("Hora: "+horaPeli);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
        choice_box.getItems().add("(Seleccione)");

        choice_box.setValue("(Seleccione)");

    }    
    
}
