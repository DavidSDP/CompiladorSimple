package analisisSintactico;

import java.util.List;

import java_cup.runtime.Symbol;

public class Nodo {
	
	private Nodo parent;
	private Symbol symbol;
	private List<Nodo> children;
	private List<Object> properties;
	private String semanticRules;
	
	public Nodo() {
	}

	public Nodo getParent() {
		return parent;
	}

	public void setParent(Nodo parent) {
		this.parent = parent;
	}

	public List<Nodo> getChildren() {
		return children;
	}

	public void setChildren(List<Nodo> children) {
		this.children = children;
	}

	public List<Object> getProperties() {
		return properties;
	}

	public void setProperties(List<Object> properties) {
		this.properties = properties;
	}

	public String getSemanticRules() {
		return semanticRules;
	}

	public void setSemanticRules(String semanticRules) {
		this.semanticRules = semanticRules;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	
}
