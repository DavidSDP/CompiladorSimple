package analisisSemantico.simbolos;

import java_cup.runtime.Symbol;

public class SimboloFuncionDecl {
	
	private String tipo;
	private SimboloFuncionDef def;
	
	public SimboloFuncionDecl(String t, SimboloFuncionDef f) {
		this.tipo = t;
		this.def = f;
	}
	
}
