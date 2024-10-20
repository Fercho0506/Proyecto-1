package Preguntas;

public class PreguntaAbierta extends Pregunta{
	
	public PreguntaAbierta(String pregunta) {
		super(pregunta);
	}
	public void mostrar() {
		System.out.print(this.getPregunta());
	}
}
