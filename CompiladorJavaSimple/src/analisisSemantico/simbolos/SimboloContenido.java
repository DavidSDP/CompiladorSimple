package analisisSemantico.simbolos;

public class SimboloContenido {
	
	private SimboloContenido contenido;
	private SimboloExpresion expresion;
	private SimboloOperacion operacion;
	private String retorno;
	
	public SimboloContenido(SimboloContenido c, SimboloExpresion e) {
		this.contenido = c;
		this.expresion = e;
	}
	
	public SimboloContenido(SimboloContenido c, String r, SimboloOperacion o) {
		this.retorno = r;
		this.contenido = c;
		this.operacion = o;
	}
	
}
