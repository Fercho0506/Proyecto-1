package Entrega;

import Actividades.Actividad;
import Usuarios.Estudiante;

public class ProgresoActividad {
	private Estudiante estudiante;
	private Actividad actividad;
	private String estado;
	private String fechaInicio;
	private String fechaFinal;
	
	public ProgresoActividad(Estudiante estudiante, Actividad actividad) {
		this.estudiante= estudiante;
		this.actividad=actividad;
		this.estado="Incompleto";
		this.fechaInicio= "N/A";
		this.fechaFinal="N/A";
	}
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	public Actividad getActividad() {
		return actividad;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}
	
	public String getFechaFinal() {
		return fechaFinal;
	}
	
	public void setEstado(String estado) {
		this.estado=estado;
	}
	
	public void setFechaFinal(String fecha) {
		this.fechaFinal=fecha;
	}
	
	public void setFechaInicio(String fecha) {
		this.fechaInicio=fecha;
	}
}
