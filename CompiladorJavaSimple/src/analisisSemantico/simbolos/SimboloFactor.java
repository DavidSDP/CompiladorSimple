package analisisSemantico.simbolos;

import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

public class SimboloFactor {
	
	private SimboloID id;
	private String string;
	private ComplexSymbol numero;
	private ComplexSymbol booleano;
	private SimboloFuncionInvk funcionInvk;
	private SimboloOperacion operacion;

	public SimboloFactor(SimboloID id) {
		this.id = id;
	}

	public SimboloFactor(String string) {
		this.string = string;
	}
	
	public SimboloFactor(ComplexSymbol numero) {
		this.numero = numero;
	}
	
//	public SimboloFactor(ComplexSymbol booleano) {
//		
//	}
	
	public SimboloFactor(SimboloFuncionInvk funcionInvk) {
		this.funcionInvk = funcionInvk;
	}
	public SimboloFactor(SimboloOperacion operacion) {
		this.operacion = operacion;
	}
	
}
