package Preguntas;

public class Respuesta {
	private String respuesta;
	private Pregunta pregunta;
	
	public Respuesta(String respuesta, Pregunta pregunta) {
		this.respuesta=respuesta;
		this.pregunta=pregunta;
	}
	
	public Pregunta getPregunta() {
		return pregunta;
	}
	
	public String getRespuesta() {
		return respuesta;
	}
}
