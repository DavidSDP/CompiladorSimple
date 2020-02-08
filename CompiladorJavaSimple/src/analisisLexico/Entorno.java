package analisisLexico;

import java.util.Hashtable;
import java.util.Iterator;

import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

public class Entorno {
	
	private static Integer IDENTIFIER = 0;
	
	private Hashtable<String, ComplexSymbol> tabla;
	protected Entorno entornoAnterior;
	private Integer _IDENTIFIER;
	
	public Entorno(Entorno entorno) {
		_IDENTIFIER = IDENTIFIER;
		IDENTIFIER++;
		this.tabla = new Hashtable<>();
		this.entornoAnterior = entorno;
	}
	
	public void put(String s, ComplexSymbol sim) {
		this.tabla.put(s, sim);
	}
	
	public Boolean contains(String s) {
		return this.tabla.containsKey(s);
	}
	
	public ComplexSymbol get(String s) {
		for(Entorno e = this; e != null; e = e.entornoAnterior) {
			ComplexSymbol sim = e.tabla.get(s);
			if(sim!=null)
				return sim;
		}
		return null;
	}
	
	public void printEntorno() {
		System.out.println();
		System.out.println("____________________________________");
		System.out.println(" -> ENTORNO "+this._IDENTIFIER+" <- ");
		System.out.println("");
		Iterator<String> iterator = tabla.keySet().iterator();
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			ComplexSymbol symbol = tabla.get(key);
			System.out.println("KEY: "+key+" , VALUE: "+symbol.value);
		}
		System.out.println("____________________________________");
	}
	
	@Override
	public String toString() {
		return this._IDENTIFIER + "";
	}
	
}
