package analisisSemantico.simbolos;

public class SimboloOperacion{

	private SimboloOperacion operacion;
	private String operador;
	private SimboloFactor factor;
	
	public SimboloOperacion(SimboloOperacion o) {
		this.operacion = o;
	}
	
	public SimboloOperacion(SimboloFactor f) {
		this.factor = f;
	}
	
	public SimboloOperacion(SimboloOperacion o, String operador, SimboloFactor f) {
		this.operacion = o;
		this.operador = operador;
		this.factor = f;
	}

	public SimboloOperacion getOperacion() {
		return operacion;
	}

	public void setOperacion(SimboloOperacion operacion) {
		this.operacion = operacion;
	}

	public SimboloFactor getFactor() {
		return factor;
	}

	public void setFactor(SimboloFactor factor) {
		this.factor = factor;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}
	
}
