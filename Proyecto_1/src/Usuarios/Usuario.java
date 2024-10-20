package Usuarios;

public abstract class Usuario {
	private String usuario;
	private String password;
	private String tipo;
	
	public Usuario(String usuario, String password, String tipo) {
		this.usuario=usuario;
		this.password=password;
		this.tipo=tipo;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsuario(String usuario) {
		this.usuario=usuario;
	}
}