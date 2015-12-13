package uba.algo3.tp3.ejercicio5;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;
import uba.algo3.tp3.ejercicio2.ListColoring;
import uba.algo3.tp3.ejercicio3.ListColoringGoloso;
import uba.algo3.tp3.parser.Parser;

public class Ejercicio5TestMycielski {

	@Test
	public void test() throws IOException {
		Parser p = new Parser();
		
		System.out.println("Myciel 4");
		GrafoMaterias g = p.parse("entradaEj5MycielskiN4");
		if (ListColoring.solve(g) != null)
			System.out.println("Exitoso");
		
		System.out.println("conflictos " + ListColoringGoloso.solve(g).size());
		
		System.out.println("Myciel 5");
		g = p.parse("entradaEj5MycielskiN5");
		if (ListColoring.solve(g) != null)
			System.out.println("Exitoso");

		System.out.println("conflictos " + ListColoringGoloso.solve(g).size());
		
		System.out.println("Myciel 6");
		g = p.parse("entradaEj5MycielskiN6");
		if (ListColoring.solve(g) != null)
			System.out.println("Exitoso");

		System.out.println("conflictos " + ListColoringGoloso.solve(g).size());
		
		System.out.println("Myciel 7");
		g = p.parse("entradaEj5MycielskiN7");
		if (ListColoring.solve(g) != null)
			System.out.println("Exitoso");

		System.out.println("conflictos " + ListColoringGoloso.solve(g).size());
		
		System.out.println("Myciel 8");
		g = p.parse("entradaEj5MycielskiN8");
		if (ListColoring.solve(g) != null)
			System.out.println("Exitoso");
		
		System.out.println("conflictos " + ListColoringGoloso.solve(g).size());
		
		System.out.println("Myciel 9");
		g = p.parse("entradaEj5MycielskiN9");
		if (ListColoring.solve(g) != null)
			System.out.println("Exitoso");
		
		System.out.println("conflictos " + ListColoringGoloso.solve(g).size());
		
		System.out.println("Myciel 10");
		g = p.parse("entradaEj5MycielskiN10");
		if (ListColoring.solve(g) != null)
			System.out.println("Exitoso");
		
		System.out.println("conflictos " + ListColoringGoloso.solve(g).size());
		
		System.out.println("Myciel 11");
		g = p.parse("entradaEj5MycielskiN11");
		if (ListColoring.solve(g) != null)
			System.out.println("Exitoso");
		
		System.out.println("conflictos " + ListColoringGoloso.solve(g).size());
		
		System.out.println("Myciel 12");
		g = p.parse("entradaEj5MycielskiN12");
		if (ListColoring.solve(g) != null)
			System.out.println("Exitoso");
		
		System.out.println("conflictos " + ListColoringGoloso.solve(g).size());
		
		
	}

}
