package analisisSemantico.simbolos;

public class SimboloContenido {
	
	private SimboloContenido contenido;
	private SimboloAsignacion asignacion;
	private SimboloFuncionInvk funcionInvk;
	
	public SimboloContenido(SimboloContenido contenido, SimboloAsignacion asignacion) {
		this.contenido = contenido;
		this.asignacion = asignacion;
	}
	
	public SimboloContenido(SimboloContenido contenido, SimboloFuncionInvk funcionInvk) {
		this.contenido = contenido;
		this.funcionInvk = funcionInvk;
	}
	
}
