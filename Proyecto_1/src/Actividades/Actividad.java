package Actividades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import LearningPath.Rating;

public abstract class Actividad {
	private String descripcion;
	private String objetivo;
	private String nivel;
	private String dificultad;
	private int duracion;
	private boolean obligatoria;
	private List<Actividad> previas;
	private List<Rating> ratings;
	
	public Actividad(String descripcion, String objetivo, 
			String nivel, String dificultad, int duracion, boolean obligatoria) {
		this.descripcion=descripcion;
		this.objetivo= objetivo;
		this.dificultad= dificultad;
		this.nivel= nivel;
		this.duracion= duracion;
		this.previas= new ArrayList<Actividad>();
		this.obligatoria= obligatoria;
		this.ratings= new ArrayList<Rating>();
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public String getObjetivo() {
		return objetivo;
	}
	
	public String getNivel() {
		return nivel;
	}
	
	public boolean getObligatoria() {
		return obligatoria;
	}
	
	public String getDificultad() {
		return dificultad;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public Collection<Actividad> getPrevias(){
		return previas;
	}
	
	public void setDescripcion(String texto) {
		this.descripcion= texto;
	}
	
	public void setObjetivo(String texto) {
		this.objetivo= texto;
	}
	
	public void setDificultad(String texto) {
		this.dificultad= texto;
	}
	
	public void setNivel(String texto) {
		this.nivel= texto;
	}
	
	public void setDuracion(int tiempo) {
		this.duracion= tiempo;
	}
	
	public void setObligatoria(boolean obli) {
		this.obligatoria=obli;
	}
	
	public void addPrevia(Actividad actividad) {
		previas.addLast(actividad);
	}
	
	public void addRating(Rating rating) {
		ratings.addLast(rating);
	}
	
	public void eliminarPrevia(Actividad actividad) {
		int posicion=0;
		boolean encontrada=false;
		while (posicion< previas.size() && !encontrada) {
			Actividad activity= previas.get(posicion);
			if (actividad== activity) {
				previas.remove(posicion);
				encontrada= true;
			}
			posicion +=1;
		}
	}
}
