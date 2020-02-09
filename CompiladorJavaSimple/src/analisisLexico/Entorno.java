package analisisLexico;

import java.util.EmptyStackException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Stack;

import analisisSintactico.sym;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

public class Entorno {
	
	public static class GlobalVariables{
		
		public static Boolean DEBUG_MODE = true;
		private static Integer CONTADOR = 1;
		private static Stack<Entorno> pilaEntornos = new Stack<>();
		
		public static Entorno entornoActual() {
			try {
				return pilaEntornos.peek();
			}catch(EmptyStackException e) {
				return null;
			}
		}
		
		public static void asignaID(String id, String tipo) {
			Entorno top = entornoActual();
			if(top.contains(id))
				throw new Error("ID "+id+" YA EXISTE");
			top.put(Tipo.getTipo(tipo), id);
		}
		
		public static void asignaFuncionID(String id, String tipo) {
			Entorno top = entornoActual();
			if(top.containsFuncion(id))
				throw new Error("FUNCION ID "+id+" YA EXISTE");
			top.putFuncion(Tipo.getTipo(tipo), id);
		}
		
		public static void entraBloque() {
			Entorno e = new Entorno(entornoActual());
			pilaEntornos.push(e);
		}
		
		public static void saleBloque() {
			Entorno popped = pilaEntornos.pop();
			if(DEBUG_MODE) {
				popped.printEntorno();
			}
		}
		
	}
	
	
	private Integer nivel;
	
	private Hashtable<String, ComplexSymbol> tablaIDs;
	private Hashtable<String, ComplexSymbol> tablaFunciones;
	private Entorno entornoAnterior;
	private Integer _identificador_entorno;
	
	public Entorno(Entorno entornoAnterior) {
		if(entornoAnterior == null) {
			this.nivel = 0;
		}else {
			this.nivel = entornoAnterior.getNivel() + 1;
		}
		this._identificador_entorno = getIdentificador();
		this.tablaIDs = new Hashtable<>();
		this.tablaFunciones = new Hashtable<>();
		this.entornoAnterior = entornoAnterior;
	}
	
	public static Integer getIdentificador() {
		return GlobalVariables.CONTADOR++;
	}
	
	public Integer getNivel() {
		return this.nivel;
	}
	
	public static enum Tipo{
		Integer, String, Boolean, Class, Void;
		public static Tipo getTipo(String s) {
			switch(s) {
				case "void":
					return Tipo.Void;
				case "class":
					return Tipo.Class;
				case "int":
					return Tipo.Integer;
				case "String":
					return Tipo.String;
				case "boolean":
					return Tipo.Boolean;
				default:
					throw new Error("No se ha encontrado el tipo especificado");
			}
		}
	}
	
	public void put(Tipo tipo, String s) {
		ComplexSymbol simbolo = new ComplexSymbol(tipo.name(), sym.id);
		this.tablaIDs.put(s, simbolo);
	}
	
	public Boolean contains(String s) {
		return this.tablaIDs.containsKey(s);
	}
	
	public ComplexSymbol get(String s) {
		for(Entorno e = this; e != null; e = e.entornoAnterior) {
			ComplexSymbol sim = e.tablaIDs.get(s);
			if(sim!=null)
				return sim;
		}
		return null;
	}
	public void putFuncion(Tipo tipo, String s) {
		ComplexSymbol simbolo = new ComplexSymbol(tipo.name(), sym.id);
		this.tablaFunciones.put(s, simbolo);
	}
	
	public Boolean containsFuncion(String s) {
		return this.tablaFunciones.containsKey(s);
	}
	
	public ComplexSymbol getFuncion(String s) {
		for(Entorno e = this; e != null; e = e.entornoAnterior) {
			ComplexSymbol sim = e.tablaFunciones.get(s);
			if(sim!=null)
				return sim;
		}
		return null;
	}
	
	public void printEntorno() {
		System.out.println();
		System.out.println("___>>>____________>>>______________>>>");
		System.out.println();
		System.out.println(" -> ENTORNO "+this._identificador_entorno+", de nivel "+this.nivel+" <- ");
		System.out.println();
		System.out.println(" VARIABLES: ");
		Iterator<String> iterator = tablaIDs.keySet().iterator();
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			ComplexSymbol symbol = tablaIDs.get(key);
			System.out.println("ID: "+key+" , TIPO: "+symbol.getName());
		}
		System.out.println();
		System.out.println(" FUNCIONES: ");
		Iterator<String> iteratorFunciones = tablaFunciones.keySet().iterator();
		while(iteratorFunciones.hasNext()) {
			String key = (String) iteratorFunciones.next();
			ComplexSymbol symbol = tablaFunciones.get(key);
			System.out.println("ID: "+key+" , TIPO: "+symbol.getName());
		}
		System.out.println();
		System.out.println("___<<<____________<<<______________<<<");
	}
	
	@Override
	public String toString() {
		return this._identificador_entorno + "";
	}
	
}
