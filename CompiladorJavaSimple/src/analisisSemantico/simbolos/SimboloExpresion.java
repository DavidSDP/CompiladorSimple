package analisisSemantico.simbolos;

public class SimboloExpresion {
	
	private SimboloAsignacion a;
	private SimboloFuncionInvk f;
	
	public SimboloExpresion(SimboloAsignacion a) {
		this.a = a;
	}
	
	public SimboloExpresion(SimboloFuncionInvk f) {
		this.f = f;
	}
	
}
