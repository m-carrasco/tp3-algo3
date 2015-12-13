package uba.algo3.tp3.ejercicio5_euleriano;

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
		for (Integer i = 101; i <= 701; i = i + 100)
		{
			String filename = "entradaEj5EuImpar" + i ;
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
			
			
			runListColoring(it2, original);
			
			delta = (System.currentTimeMillis() - inicio) / it2.doubleValue();
			System.out.println("ListColoring " + i + " " + delta + " " + res);
			
			
			
		}
		for (Integer i = 99; i <= 699; i = i + 100)
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
			
			
			runListColoring(it2, original);
			
			delta = (System.currentTimeMillis() - inicio) / it2.doubleValue();
			System.out.println("ListColoring " + i + " " + delta + " " + res);
			
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
	
	public int runListColoring(Integer it, GrafoMaterias g)
	{
		int res=0;
		for (Integer j = 0; j < it; j++)
		{
			ListColoring.solve(g);
			
		}
		return res;
	}
}
