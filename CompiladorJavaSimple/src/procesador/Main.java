package procesador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import analisisLexico.Scanner;
import analisisSintactico.parser;
import java_cup.runtime.Symbol;

public class Main {

	public static void main(String[] args) {
		try {
			
//            System.out.println("Escriu l'expressió que vols calcular:");
//            System.out.print(">>> ");
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            input = new CharArrayReader(in.readLine().toCharArray());
            FileReader in = new FileReader(args[0]);
			
            Scanner scanner = new Scanner(in);
            parser parser = new parser(scanner);
            Symbol topSymbol = parser.parse();
            System.out.println(topSymbol);
            System.out.println(parser.production_table());
		} catch (FileNotFoundException e) {
			System.err.println("El fitxer d'entrada '"+args[0]+"' no existeix");
		} catch (IOException e) {
			System.err.println("Error processant el fitxer d'entrada");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
