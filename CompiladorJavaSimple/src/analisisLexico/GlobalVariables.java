package analisisLexico;

import java.util.EmptyStackException;
import java.util.Stack;

import analisisLexico.Entorno.Tipo;
import analisisSemantico.simbolos.SimboloArgs;
import analisisSemantico.simbolos.SimboloParams;

public class GlobalVariables{
		
		public static Boolean DEBUG_MODE = true;
		static Integer CONTADOR = 1;
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
		
		public static void asignaFuncionID(String idFuncion, String tipo) {
			Entorno top = entornoActual();
			if(top.containsFuncion(idFuncion))
				throw new Error("FUNCION ID "+idFuncion+" YA EXISTE");
			top.putFuncion(Tipo.getTipo(tipo), idFuncion);
		}
		
		public static void asignaFuncionArgs(String idFuncion, SimboloArgs args) {
			Entorno top = entornoActual();
			for(SimboloArgs a = args; a != null; a = a.getNextArg()) {
				top.putFuncionArgs(idFuncion, a.getId());
			}
		}
		
		public static void compruebaID(String id) {
			Boolean found = false;
			for(Entorno top = entornoActual(); (top != null)&&(!found); top = top.getEntornoAnterior()) {
				if(top.contains(id))
					found = true;
			}
			if(!found)
				throw new Error("El id "+id+" no es un símbolo declarado en el entorno");
		}
		
		public static void compruebaFuncionID(String id) {
			Boolean found = false;
			for(Entorno top = entornoActual(); (top != null)&&(!found); top = top.getEntornoAnterior()) {
				if(top.containsFuncion(id))
					found = true;
			}
			if(!found)
				throw new Error("El id "+id+" no es un símbolo de función declarado en el entorno");
		}
		
		public static void compruebaFuncionTipoParams(String funcionID, SimboloParams params) {
//			Entorno top = entornoActual();
//			for(SimboloParams p = params; p!=null; p = p.getNextParam()) {
//				if(!top.containsFuncionArgs(funcionID, p.)
//						throw new Error("El id "+id+" no es un símbolo de función declarado en el entorno");
//			}
			//TBI
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
		
		public static Integer getIdentificador() {
			return CONTADOR++;
		}
		
	}