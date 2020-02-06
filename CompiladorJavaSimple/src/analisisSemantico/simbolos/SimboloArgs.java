package analisisSemantico.simbolos;

import java_cup.runtime.Symbol;

public class SimboloArgs {
	
	private String tipo;
	private String id;
	private SimboloArgs nextArg;
	
	public SimboloArgs(String t, String i, SimboloArgs n) {
		this.tipo = t;
		this.id = i;
		this.nextArg = n;
	}
	
}
