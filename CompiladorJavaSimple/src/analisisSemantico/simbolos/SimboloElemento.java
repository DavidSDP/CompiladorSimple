package analisisSemantico.simbolos;

public class SimboloElemento {
	
	private SimboloAsignacion asignacion;
	private SimboloFuncionDecl funcionDecl;
	private SimboloClase clase;
	
	public SimboloElemento(SimboloAsignacion a) {
		this.asignacion = a;
	}
	
	public SimboloElemento(SimboloFuncionDecl f) {
		this.funcionDecl = f;
	}
	
	public SimboloElemento(SimboloClase c) {
		this.clase = c;
	}
}
