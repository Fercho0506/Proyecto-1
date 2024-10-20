package Usuarios;

import java.util.ArrayList;
import java.util.List;

import Entrega.ProgresoLearningPath;
import LearningPath.LearningPath;

public class Estudiante extends Usuario{
	private List<ProgresoLearningPath> inscripciones;
	
	public Estudiante(String usuario, String password) {
		super(usuario, password, "estudiante");
		this.inscripciones= new ArrayList<ProgresoLearningPath>();
	}
	
	public void inscribirseLearning(LearningPath learning) {
		ProgresoLearningPath nueva= new ProgresoLearningPath(learning, this);
		inscripciones.addLast(nueva);
	}
	public List<ProgresoLearningPath> getInscripciones(){
		return inscripciones;
	}
	
}
