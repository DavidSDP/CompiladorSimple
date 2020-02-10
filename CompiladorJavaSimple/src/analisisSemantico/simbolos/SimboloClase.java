package analisisSemantico.simbolos;

import analisisLexico.Entorno.Tipo;

public class SimboloClase implements TipoSubyacente{
	
	private String tClass;
	private String id;
	private SimboloCuerpo cuerpo;
	
	public SimboloClase(String t, String i, SimboloCuerpo c) {
		this.tClass = t;
		this.id = i;
		this.cuerpo = c;
	}

	@Override
	public Tipo getTipoSubyacente() {
		return Tipo.Void;
	}
	
}
