package data;

import javafx.beans.property.SimpleStringProperty;

public class Reserva {
	private Dia dia;
	private Pelicula pelicula;
	private Sala sala;
	private Silla silla;

    public String getDia1() {
        return dia1.get();
    }

    public String getPelicula1() {
        return pelicula1.get();
    }

    public String getSala1() {
        return sala1.get();
    }

    public String getSilla1() {
        return silla1.get();
    }

    public String getHora1() {
        return hora1.get();
    }
        
        public SimpleStringProperty dia1= new SimpleStringProperty();
        public SimpleStringProperty pelicula1= new SimpleStringProperty();
        public SimpleStringProperty sala1= new SimpleStringProperty();
        public SimpleStringProperty silla1= new SimpleStringProperty();
        public SimpleStringProperty hora1= new SimpleStringProperty();
                
        
	
	public Reserva(Dia dia, Pelicula pelicula, Sala sala, Silla silla) {
		this.dia = dia;
		this.pelicula = pelicula;
		this.sala = sala;
		this.silla = silla;
                dia1.set(dia.getFechaDia().toString());
                pelicula1.set(pelicula.getNombrePelicula());
                sala1.set(""+sala.getNumeroSala());
                silla1.set(""+silla.getNumeroSilla());
                hora1.set(pelicula.getHora());
	}

	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Silla getSilla() {
		return silla;
	}
	public void setSilla(Silla silla) {
		this.silla = silla;
	}

	@Override
	public String toString() {
		return "Reserva [Dia=" + dia.getFechaDia() 
		+ ", Pelicula=" + pelicula.getNombrePelicula()  
		+ ", Hora=" + pelicula.getHora() 
		+ ", Sala=" + sala.getNumeroSala() 
		+ ", Silla=" + silla.getNumeroSilla() + "]";
	}
	
}













