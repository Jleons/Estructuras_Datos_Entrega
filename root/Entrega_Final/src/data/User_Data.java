/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import data.*;
/**
 *
 * @author LENOVO
 */
public class User_Data {
    public static Dia dia;
    public static Pelicula pelicula;
    public static Sala sala;
    public static Silla silla;
    public static Usuario usuario;

    public static Dia getDia() {
        return dia;
    }

    public static void setDia(Dia dia) {
        User_Data.dia = dia;
    }

    public static Pelicula getPelicula() {
        return pelicula;
    }

    public static void setPelicula(Pelicula pelicula) {
        User_Data.pelicula = pelicula;
    }

    public static Sala getSala() {
        return sala;
    }

    public static void setSala(Sala sala) {
        User_Data.sala = sala;
    }

    public static Silla getSilla() {
        return silla;
    }

    public static void setSilla(Silla silla) {
        User_Data.silla = silla;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        User_Data.usuario = usuario;
    }
    
    
}
