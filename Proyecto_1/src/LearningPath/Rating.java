package LearningPath;

import Usuarios.Usuario;

public class Rating {
	
	private Usuario creador;
	private String comentario;
	private int calificacion;
	
	public Rating(Usuario creador, String comentario, int calificacion) {
		this.creador=creador;
		this.comentario= comentario;
		this.calificacion=calificacion;
	}
	
	public Usuario getCreador() {
		return creador;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public int getCalificacion() {
		return calificacion;
	}
}
