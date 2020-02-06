package analisisSemantico.simbolos;

public class SimboloCuerpo {
	
	private SimboloCuerpo cuerpo;
	private SimboloElemento elemento;
	
	public SimboloCuerpo(SimboloCuerpo c, SimboloElemento e) {
		this.cuerpo = c;
		this.elemento = e;
	}
	
}
