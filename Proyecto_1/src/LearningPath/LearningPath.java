package LearningPath;

import java.util.ArrayList;
import java.util.List;

import Actividades.Actividad;
import Usuarios.Profesor;

public class LearningPath {
	private String titulo;
	private String descripcion;
	private String dificultad;
	private int duracion;
	private Profesor creador;
	private List<Actividad> actividades;
	private List<Rating> ratings;
	
	public LearningPath(String titulo, String descripcion, String dificultad,
			int duracion, Profesor creador) {
		this.titulo=titulo;
		this.dificultad=dificultad;
		this.duracion=duracion;
		this.creador=creador;
		this.descripcion=descripcion;
		this.actividades= new ArrayList<Actividad>();
		this.ratings= new ArrayList<Rating>();
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public List<Actividad> getActividades(){
		return actividades;
	}
	
	public Profesor getCreador() {
		return creador;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getDificultad() {
		return dificultad;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDescripcion(String texto) {
		this.descripcion= texto;
	}
	
	public void setDuracion(int tiempo) {
		this.duracion= tiempo;
	}
	
	public void setDificultad(String texto) {
		this.dificultad= texto;
	}
	
	public void addActividad(Actividad actividad) {
		actividades.addLast(actividad);
	}
	
	public void addRating(Rating rating) {
		ratings.addLast(rating);
	}
	
	public void eliminarActividad(Actividad actividad) {
		int posicion=0;
		boolean encontrada=false;
		while (posicion< actividades.size() && !encontrada) {
			Actividad activity= actividades.get(posicion);
			if (actividad== activity) {
				actividades.remove(posicion);
				encontrada= true;
			}
			posicion +=1;
		}
	}
	
	public LearningPath hacerCopia(Profesor profesor) {
		return new LearningPath(titulo, descripcion, dificultad, duracion, profesor);
	}
}