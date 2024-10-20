package Entrega;

import java.util.ArrayList;
import java.util.List;

import Actividades.Actividad;
import LearningPath.LearningPath;
import Usuarios.Estudiante;

public class ProgresoLearningPath {
	private List<ProgresoActividad> progresoActividades;
	private LearningPath learningPath;
	private Estudiante estudiante;
	
	public ProgresoLearningPath(LearningPath learning, Estudiante estudiante) {
		this.progresoActividades= new ArrayList<ProgresoActividad>();
		this.learningPath=learning;
		this.estudiante=estudiante;
	}
	
	public void addProgresoActividad() {
		for (Actividad i: this.learningPath.getActividades()) {
			ProgresoActividad progreso= new ProgresoActividad(this.estudiante, i);
			progresoActividades.addLast(progreso);
		}
	}
	
	public List<ProgresoActividad> getProgreso(){
		return progresoActividades;
	}
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
}
