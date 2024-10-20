package Preguntas;

public abstract class Pregunta {
	private String pregunta;
	
	public Pregunta(String pregunta) {
		this.pregunta=pregunta;
	}
	
	public String getPregunta() {
		return pregunta;
	}
	
	public void setPregunta(String texto) {
		this.pregunta= texto;
	}
}
