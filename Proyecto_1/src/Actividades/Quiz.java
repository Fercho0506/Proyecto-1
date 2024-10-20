package Actividades;

import java.util.ArrayList;
import java.util.List;

import Preguntas.OpcionMultiple;

public class Quiz extends Actividad{
	
	private List<OpcionMultiple> preguntas;
	private int calificacion;
	
	public Quiz(String descripcion, String objetivo,
			String nivel, String dificultad, int duracion, boolean obligatoria, 
			int calificacion) {
		super(descripcion,objetivo, nivel, dificultad, duracion, obligatoria);
		this.preguntas= new ArrayList<OpcionMultiple>();
		this.calificacion=calificacion;
	}
	
	public void addPreguunta(OpcionMultiple pregunta) {
		preguntas.addLast(pregunta);
	}
	
	public int getCalificacion() {
		return calificacion;
	}
	
	public void setCalificacion(int numero) {
		this.calificacion=numero;
	}
}
