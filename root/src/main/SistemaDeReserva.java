package main;

import java.util.ArrayList;
import java.util.Scanner;
import data.*;
import ui.Consola;

/**
 *
 * @author Daniel Delgado, Sebastian Leon, Juan Avila
 */

public class SistemaDeReserva {

    private static ArrayList<Dia> dias= new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public static void main(String[] args) {//Crea tre dias inicialmente, manda al usuario a una pantalla de inicio de sesion y luego al menu
    	
        Consola consola = new Consola();
    	//boolean activo=true;
    	
    	//while(activo) {
        System.out.println("Cuantos casos de prueba?: ");
        Scanner teclado=new Scanner(System.in);
        int numReservas=teclado.nextInt();
        
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
        System.out.println("\n\nUsuarios registrados: "+usuarios.size());
    }

    public static void addDia() {
		dias.add(new Dia());
	}
    
	public static ArrayList<Dia> getDias() {
		return dias;
	}

	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
}
