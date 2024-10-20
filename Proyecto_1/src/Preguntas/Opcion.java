package Preguntas;

public class Opcion {
	private String opcion;
	private boolean correcta;
	private String explicacion;
	
	public Opcion(String opcion, boolean correcto, String explicacion) {
		this.correcta=correcto;
		this.opcion=opcion;
		this.explicacion=explicacion;
	}
	
	public String getOpcion() {
		return opcion;
	}
	
	public String getExplicacion() {
		return explicacion;
	}
	
	public boolean getCorrecta() {
		return correcta;
	}
	
	public void setOpcion(String opcion) {
		this.opcion= opcion;
	}
	
	public void setExplicacion(String texto) {
		this.explicacion=texto;
	}
	public void setCorrecta(boolean correcto) {
		this.correcta=correcto;
	}
}
