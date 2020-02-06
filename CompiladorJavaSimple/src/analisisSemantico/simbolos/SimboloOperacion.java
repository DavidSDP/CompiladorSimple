package analisisSemantico.simbolos;

public class SimboloOperacion extends Nodo{

	private SimboloOperacion1 operacion1;
	private SimboloOperacion operacion;
	private String opSuma;
	private SimboloFactor factor;
	
	public SimboloOperacion(SimboloOperacion1 o1) {
		this.operacion1 = o1;
	}
	
	public SimboloOperacion(SimboloOperacion o, String s, SimboloFactor f) {
		this.operacion = o;
		this.opSuma = s;
		this.factor = f;
	}
	
	public SimboloOperacion1 getOperacion1() {
		return operacion1;
	}

	public void setOperacion1(SimboloOperacion1 operacion1) {
		this.operacion1 = operacion1;
	}

	public SimboloOperacion getOperacion() {
		return operacion;
	}

	public void setOperacion(SimboloOperacion operacion) {
		this.operacion = operacion;
	}

	public String getOpSuma() {
		return opSuma;
	}

	public void setOpSuma(String opSuma) {
		this.opSuma = opSuma;
	}

	public SimboloFactor getFactor() {
		return factor;
	}

	public void setFactor(SimboloFactor factor) {
		this.factor = factor;
	}
	
}
