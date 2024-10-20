package Preguntas;

public class OpcionMultiple extends Pregunta{
	private Opcion[] opciones;
	
	public OpcionMultiple(String pregunta, Opcion[] opciones) {
		super(pregunta);
		this.opciones=opciones;
	}
	public Opcion[] getOpciones() {
		return opciones;
	}
	
	public void setOpciones(Opcion[] opciones) {
		this.opciones=opciones;
	}
	
	public void mostrar() {
		System.out.print(this.getPregunta()+"\n");
		for (int i=0; i<4; i++) {
			Opcion opcion= opciones[i];
			int numero= i+1;
			System.out.print(numero + " "+ opcion.getOpcion()+ "\n");
		}
	}
	
}
