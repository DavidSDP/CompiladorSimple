package analisisSemantico.simbolos;

public class SimboloFuncionDef {
	private String id;
	private SimboloArgs args;
	private SimboloContenido contenido;
	
	public SimboloFuncionDef(String i, SimboloArgs a, SimboloContenido c) {
		this.id = i;
		this.args = a;
		this.contenido = c;
	}
	
	public String getID() {
		return this.id;
	}
	
}
