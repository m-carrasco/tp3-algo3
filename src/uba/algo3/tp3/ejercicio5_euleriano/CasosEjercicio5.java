package uba.algo3.tp3.ejercicio5_euleriano;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;
import uba.algo3.tp3.ejercicio1.Nodo;
import uba.algo3.tp3.ejercicio2.ListColoring;
import uba.algo3.tp3.ejercicio3.ListColoringGoloso;
import uba.algo3.tp3.parser.Parser;

public class CasosEjercicio5 {

	@Test
	public void testPares() throws IOException {
		Parser p = new Parser();
		
		Integer it = 1000;
		
		System.out.println("Ejercicio5 Impares");
		System.out.println("N Tiempo promedio Errores");
		
		// iteramos por cada caso
		for (Integer i = 1001; i <= 1601; i = i + 100)
		{
			String filename = "entradaEj5EuImpar" + i ;
			System.out.println(filename);
			GrafoMaterias original = p.parse(filename);
					
			// warmup
			runGoloso( it, original);

			long inicio = System.currentTimeMillis();
			
			assertEquals(runGoloso( it, original), 0);
			
			Double delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
			System.out.println("Goloso " + i + " " + delta);
			
			Integer it2=1;
			original = p.parse(filename);
			runListColoring( it2, original);

			inicio = System.currentTimeMillis();
			
			
			boolean satisfacible = runListColoring(it2, original);
			
			delta = (System.currentTimeMillis() - inicio) / it2.doubleValue();
			System.out.println("ListColoring " + i + " " + delta);//+ " " + res);
			if (!satisfacible)
				System.out.println("Esta instancia no es satisfacible según backtracking.");
			
		}
		for (Integer i = 999; i <= 1599; i = i + 100)
		{
			String filename = "entradaEj5EuPar" + i ;
			System.out.println(filename);
			GrafoMaterias original = p.parse(filename);
					
			// warmup
			runGoloso( it, original);

			long inicio = System.currentTimeMillis();
			
			int res = runGoloso( it, original);
			
			Double delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
			System.out.println("Goloso " + i + " " + delta + " " + res);
			
			
			Integer it2=1;
			original = p.parse(filename);
			runListColoring( it2, original);

			inicio = System.currentTimeMillis();
			
			
			boolean satisfacible = runListColoring(it2, original);
			
			delta = (System.currentTimeMillis() - inicio) / it2.doubleValue();
			System.out.println("ListColoring " + i + " " + delta);//  + " " + res);
			if (!satisfacible)
				System.out.println("Esta instancia no es satisfacible según backtracking.");
			
		}	
	}

	@Test
	public void testGolosoDeMas() throws IOException {
		Parser p = new Parser();
		
		Integer it = 1000;
		
		System.out.println("Ejercicio5 Impares");
		System.out.println("N Tiempo promedio Errores");
		
		// iteramos por cada caso
		for (Integer i = 2001; i <= 5001; i = i + 1000)
		{
			String filename = "entradaEj5EuImpar" + i ;
			System.out.println(filename);
			GrafoMaterias original = p.parse(filename);
					
			// warmup
			runGoloso( it, original);

			long inicio = System.currentTimeMillis();
			
			assertEquals(runGoloso( it, original), 0);
			
			Double delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
			System.out.println("Goloso " + i + " " + delta);
			
			
		}
		for (Integer i = 1999; i <= 4999; i = i + 1000)
		{
			String filename = "entradaEj5EuPar" + i ;
			System.out.println(filename);
			GrafoMaterias original = p.parse(filename);
					
			// warmup
			runGoloso( it, original);

			long inicio = System.currentTimeMillis();
			
			int res = runGoloso( it, original);
			
			Double delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
			System.out.println("Goloso " + i + " " + delta + " " + res);
			
			
		}	
	}
	
	public int runGoloso(Integer it, GrafoMaterias g)
	{
		int res=0;
		for (Integer j = 0; j < it; j++)
		{
			res=ListColoringGoloso.solve(g).size();
			for (Nodo n : g.getGrafo())
				n.setColorPintado(-1);
		}
		return res;
	}
	
	public boolean runListColoring(Integer it, GrafoMaterias g)
	{
		boolean satisfacible = false;
		for (Integer j = 0; j < it; j++)
		{
			satisfacible = ListColoring.solve(g) != null;
			
		}
		return satisfacible;
	}
}
