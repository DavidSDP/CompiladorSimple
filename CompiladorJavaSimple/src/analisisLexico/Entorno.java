package analisisLexico;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import analisisSintactico.sym;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

public class Entorno {
	
	private Integer nivel;
	
	private Hashtable<String, ComplexSymbol> tablaIDs;
	private Hashtable<String, ComplexSymbol> tablaFunciones;
	private Hashtable<String, List<String>> tablaFuncionesArgs;
	
	private Entorno entornoAnterior;
	private Integer _identificador_entorno;
	
	public Entorno(Entorno entornoAnterior) {
		if(entornoAnterior == null) {
			this.nivel = 0;
		}else {
			this.nivel = entornoAnterior.getNivel() + 1;
		}
		this._identificador_entorno = GlobalVariables.getIdentificador();
		this.tablaIDs = new Hashtable<>();
		this.tablaFunciones = new Hashtable<>();
		this.tablaFuncionesArgs = new Hashtable<>()
;		this.entornoAnterior = entornoAnterior;
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
		for(Entorno e = this; e != null; e = e.getEntornoAnterior()) {
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
		for(Entorno e = this; e != null; e = e.getEntornoAnterior()) {
			ComplexSymbol sim = e.tablaFunciones.get(s);
			if(sim!=null)
				return sim;
		}
		return null;
	}
	
	// Añade argumentos a la función
	public void putFuncionArgs(String funcionID, String argumentoID) {
		if(!this.getEntornoAnterior().containsFuncion(funcionID))
			throw new Error("La función con identificador: '"+funcionID+"' no ha sido declarada en la tabla de funciones del entorno");
		if(!this.contains(argumentoID))
			throw new Error("El identificador: '"+argumentoID+"' no ha sido declarado en la tabla de identificadores del entorno");
		if(this.getEntornoAnterior().containsFuncionArgs(funcionID, argumentoID))
			throw new Error("Se ha definido el argumento: '"+argumentoID+"' duplicado para la función '"+funcionID+"'");
		List<String> args = this.getFuncionArgs(funcionID);
		if(args==null) {
			List<String> aux = new ArrayList<>();
			aux.add(argumentoID);
			this.getEntornoAnterior().tablaFuncionesArgs.put(funcionID, aux);
		}else {
			args.add(argumentoID);
		}
	}
	public Boolean containsFuncionArgs(String funcionID, String argumentoID) {
		if(!this.tablaFuncionesArgs.containsKey(funcionID))
			return false;
		if(!this.tablaFuncionesArgs.get(funcionID).contains(argumentoID)) {
			return false;
		}
		return true;
	}
	public List<String> getFuncionArgs(String funcionID) {
		return this.getEntornoAnterior().tablaFuncionesArgs.get(funcionID);
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
		System.out.println(" FUNCIONES - ARGUMENTOS: ");
		Iterator<String> iteratorFuncionesArgs = tablaFuncionesArgs.keySet().iterator();
		while(iteratorFuncionesArgs.hasNext()) {
			String key = (String) iteratorFuncionesArgs.next();
			List<String> args = tablaFuncionesArgs.get(key);
			StringBuffer aux = new StringBuffer();
			args.forEach(x->{aux.append(" "+x+" ");});
			System.out.println("FUNCION ID: "+key+" , ARGS: "+aux);
		}
		System.out.println();
		System.out.println("___<<<____________<<<______________<<<");
	}
	
	@Override
	public String toString() {
		return this._identificador_entorno + "";
	}

	public Entorno getEntornoAnterior() {
		return entornoAnterior;
	}
	
}
