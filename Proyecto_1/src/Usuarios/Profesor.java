package Usuarios;

import java.util.ArrayList;
import java.util.List;

import LearningPath.LearningPath;

public class Profesor extends Usuario{
	private List<LearningPath> learnings;
	
	public Profesor(String usuario, String password) {
		super(usuario, password, "profesor");
		this.learnings= new ArrayList<LearningPath>();
	}
	
	public void addLearning(LearningPath learning) {
		learnings.addLast(learning);
	}
}
