/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import data.*;
import data.Usuario;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ui.Consola;

/**
 *
 * @author LENOVO
 */
public class EstructurasDeDatos extends Application {
    public static Stage primaryStage;
    public static Scene registro, new_account, cartelera,sillas,operation, select, consulta;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
            registro = new Scene(FXMLLoader.load(getClass().getResource("/GUI/Registro.fxml")));
            new_account = new Scene(FXMLLoader.load(getClass().getResource("/GUI/New_Account.fxml")));
            cartelera = new Scene(FXMLLoader.load(getClass().getResource("/GUI/Cartelera.fxml")));
            sillas= new Scene(FXMLLoader.load(getClass().getResource("/GUI/Sillas_Sala.fxml")));
            operation= new Scene(FXMLLoader.load(getClass().getResource("/GUI/Operation_Data.fxml")));
            select = new Scene(FXMLLoader.load(getClass().getResource("/GUI/Select.fxml")));
            consulta= new Scene(FXMLLoader.load(getClass().getResource("/GUI/Consulta.fxml")));
            
            primaryStage = stage;
            
            //Tamaño stage
            primaryStage.setMaxHeight(530);
            primaryStage.setMinHeight(530);

            primaryStage.setMaxWidth(800);
            primaryStage.setMinWidth(800);
            
            //Titulo primaryStage 
            primaryStage.setTitle("Teatro");
            primaryStage.getIcons().add(new Image("/images/compra.png"));
            stage.setScene(registro);
            
            changeScene("login");
            
            primaryStage.show();
            
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
                @Override
                public void handle(WindowEvent t){
                    Platform.exit();
                    System.exit(0);
                }
            });
        }catch(Exception e){
            System.err.println("ERROR AQUI: "+e.getLocalizedMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Dia> dias= new ArrayList<>();
    
    private static Hash<String,Usuario> usuarios = new Hash<>();
    
    public static void main(String[] args) {
        addDia();
        usuarios.add("1234", new Usuario("admin", "1234", "0000"));
        launch(args);
        /*
        Consola consola = new Consola();
    	boolean activo=true;
    	
    	while(activo) {
    	System.out.println("Cuantos ejecuciones?: ");
        Scanner teclado=new Scanner(System.in);
    	int numEjeciones=teclado.nextInt();
    	for(int j=0;j<numEjeciones;j++) {
    	System.out.println("Cuantos casos de prueba?: ");
        
        int numReservas=teclado.nextInt();
        long millisTotal=0;
        
	        LocalTime inicio = LocalTime.now();
	        long iniciomi=System.currentTimeMillis();
	        
	        for(int i = 0;i<numReservas;i++) {
	        	if(dias.isEmpty()) {
	    			addDia();
	    			addDia();
	    			addDia();
	    		}
	    		Usuario comprador = consola.login();
	    		
	    		boolean activoMenu=true;
	    		while(activoMenu)
	    			activoMenu=consola.menu(comprador);
	    	}
	        
	        long finmi=System.currentTimeMillis();
	        LocalTime fin = LocalTime.now();
	        System.out.println("Inicio: " + inicio.toString());
	        System.out.println("Fin: " + fin.toString());
	        System.out.println("Tiempo Transcurrido = "+ (finmi-iniciomi) + " millis");
	        System.out.println("Numero de casos de prueba: "+ numReservas);
	        //System.out.println("Numero de RESERVAS :"+ usuarios.get("").getReservas().size());
	        System.out.println("Usuarios registrados: "+usuarios.size()+"\n");
	        
	        millisTotal+=finmi-iniciomi;//
	        usuarios= new Hash<>();
	        dias.clear();
        }
        //System.out.println("Tiempo Total: "+ millisTotal);
        addDia();
        
    }*/
        
    }
    public static void changeScene(String s){
            switch(s){
                case "login":
                    primaryStage.setScene(registro);
                    break;
                case "registro":
                    primaryStage.setScene(new_account);
                    break;
                case "cartelera":
                    primaryStage.setScene(cartelera);
                    break;
                case "sillas":
                    primaryStage.setScene(sillas);
                    break;    
                case "operation":
                	primaryStage.setScene(operation);
                    break;
                case "select":
                	primaryStage.setScene(select);
                     break;
                case "consulta":
                	primaryStage.setScene(consulta);
                    break;
                default:
                        break;
            }
    
    }
    

    public static void addDia() {
		dias.add(new Dia());
	}
    
    public static ArrayList<Dia> getDias() {
		return dias;
	}

    public static Hash<String,Usuario> getUsuarios() {
		return usuarios;
	}
    public static boolean usuarioRegistrado(String cedula){
        Usuario usuario = usuarios.get(cedula);
        if(usuario==null)
            return false;
        return true;
    }

    }
    

