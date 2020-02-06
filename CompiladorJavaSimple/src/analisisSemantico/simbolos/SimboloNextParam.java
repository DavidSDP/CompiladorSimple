package analisisSemantico.simbolos;

public class SimboloNextParam extends Nodo{
	
	private SimboloOperacion operacion;
	private SimboloNextParam nextParam;
	
	public SimboloNextParam(SimboloOperacion o, SimboloNextParam n) {
		this.setOperacion(o);
		this.setNextParam(n);
	}

	public SimboloOperacion getOperacion() {
		return operacion;
	}

	public void setOperacion(SimboloOperacion operacion) {
		this.operacion = operacion;
	}

	public SimboloNextParam getNextParam() {
		return nextParam;
	}

	public void setNextParam(SimboloNextParam nextParam) {
		this.nextParam = nextParam;
	}
}
