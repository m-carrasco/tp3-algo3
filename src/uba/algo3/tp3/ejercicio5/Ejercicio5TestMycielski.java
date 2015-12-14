package uba.algo3.tp3.ejercicio5;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;
import uba.algo3.tp3.ejercicio1.Nodo;
import uba.algo3.tp3.ejercicio2.ListColoring;
import uba.algo3.tp3.ejercicio3.ListColoringGoloso;
import uba.algo3.tp3.ejercicio4.BusquedaLocal;
import uba.algo3.tp3.parser.Parser;

/*
 * 
 * 
 * Goloso & Recoloreo: Tiempos promedios y conflictos restantes para cada instancia de Mycielski (empezando desde 4).
entradaEj5MycielskiN4
0
0.205
entradaEj5MycielskiN5
0
0.1
entradaEj5MycielskiN6
0
0.1
entradaEj5MycielskiN7
0
0.3
entradaEj5MycielskiN8
0
1.05
entradaEj5MycielskiN9
5
4.585
entradaEj5MycielskiN10
11
12.065
entradaEj5MycielskiN11
17
46.185
entradaEj5MycielskiN12
21
339.0
entradaEj5MycielskiN13
90
2583.86
Goloso: Tiempos promedios y conflictos restantes para cada instancia de Mycielski (empezando desde 4).
entradaEj5MycielskiN4
0
0.005
entradaEj5MycielskiN5
0
0.02
entradaEj5MycielskiN6
0
0.07
entradaEj5MycielskiN7
0
0.225
entradaEj5MycielskiN8
0
0.82
entradaEj5MycielskiN9
5
2.795
entradaEj5MycielskiN10
11
9.575
entradaEj5MycielskiN11
25
32.485
entradaEj5MycielskiN12
85
110.15
entradaEj5MycielskiN13
291
386.83
Backtracking: Tiempos promedios para cada instancia de Mycielski (empezando desde 4).
entradaEj5MycielskiN4
160.25
entradaEj5MycielskiN5
250.0
entradaEj5MycielskiN6
383.0
entradaEj5MycielskiN7
1326.0
entradaEj5MycielskiN8
3638.25
entradaEj5MycielskiN9
9960.0
entradaEj5MycielskiN10
28095.75
entradaEj5MycielskiN11
99971.5
entradaEj5MycielskiN12
461593.0
entradaEj5MycielskiN13

 */
public class Ejercicio5TestMycielski {

	public Integer runGolosoHeuristica(Integer it, GrafoMaterias g, String heuristica)
	{
		Integer confRestantes = 0;
		for (Integer j = 0; j < it; j++)
		{
			for (Nodo n : g.getGrafo())
				n.setColorPintado(-1);
			
			LinkedList<Integer[]> conflictos = ListColoringGoloso.solve(g);
			confRestantes = BusquedaLocal.mejorarSolucion(g, conflictos.size(), conflictos.size(),heuristica);
		}
		
		return confRestantes;
	}
	
	public Integer runGoloso(Integer it, GrafoMaterias g)
	{
		Integer confRestantes = 0;
		for (Integer j = 0; j < it; j++)
		{
			for (Nodo n : g.getGrafo())
				n.setColorPintado(-1);
			
			LinkedList<Integer[]> conflictos = ListColoringGoloso.solve(g);
			confRestantes = conflictos.size();
		}
		
		return confRestantes;
	}
	
	public boolean runBacktracking(Integer it, GrafoMaterias g)
	{
		boolean satisfacible = false;
		for (Integer j = 0; j < it; j++)
		{
			// para hacer justa la medicion con los demas run.
			for (Nodo n : g.getGrafo())
				n.setColorPintado(-1);
			
			satisfacible = null != ListColoring.solve(g);
		}
		
		return satisfacible;
	}	
	
	public void testBacktracking(String testFile) throws IOException
	{
		Parser p = new Parser();
		
		Integer itBacktracking = 4;
		GrafoMaterias g;
		long inicio;
		Double delta;
		
		System.out.println(testFile);
		g = p.parse(testFile);
		inicio = System.currentTimeMillis();
		Assert.assertEquals(true, runBacktracking( itBacktracking, g));
		delta = (System.currentTimeMillis() - inicio) / itBacktracking.doubleValue();
		System.out.println(delta);

	}
	
	public void testGoloso(String testFile) throws IOException
	{
		Parser p = new Parser();
		
		Integer itHeuristica = 200;
		GrafoMaterias g;
		long inicio;
		Double delta;
		
		System.out.println(testFile);
		g = p.parse(testFile);
		inicio = System.currentTimeMillis();
		System.out.println(runGoloso( itHeuristica, g));
		delta = (System.currentTimeMillis() - inicio) / itHeuristica.doubleValue();
		System.out.println(delta);

	}

	public void testGolosoRecoloreo(String testFile) throws IOException
	{
		Parser p = new Parser();
		
		Integer itHeuristica = 200;
		GrafoMaterias g;
		long inicio;
		Double delta;
		
		System.out.println(testFile);
		g = p.parse(testFile);
		inicio = System.currentTimeMillis();
		System.out.println(runGolosoHeuristica( itHeuristica, g, "recoloreo"));
		delta = (System.currentTimeMillis() - inicio) / itHeuristica.doubleValue();
		System.out.println(delta);

	}
	
	@Test
	public void test() throws IOException {

		//GOLOSO RECOLOREO MEDIDA DE TIEMPOS
		System.out.println("Goloso & Recoloreo: Tiempos promedios y conflictos restantes para cada instancia de Mycielski (empezando desde 4).");
		
		testGolosoRecoloreo("entradaEj5MycielskiN4");
		testGolosoRecoloreo("entradaEj5MycielskiN5");
		testGolosoRecoloreo("entradaEj5MycielskiN6");
		testGolosoRecoloreo("entradaEj5MycielskiN7");
		testGolosoRecoloreo("entradaEj5MycielskiN8");
		testGolosoRecoloreo("entradaEj5MycielskiN9");
		testGolosoRecoloreo("entradaEj5MycielskiN10");
		testGolosoRecoloreo("entradaEj5MycielskiN11");
		testGolosoRecoloreo("entradaEj5MycielskiN12");		
		testGolosoRecoloreo("entradaEj5MycielskiN13");	
		
		//GOLOSO MEDIDA DE TIEMPOS
		System.out.println("Goloso: Tiempos promedios y conflictos restantes para cada instancia de Mycielski (empezando desde 4).");
		
		testGoloso("entradaEj5MycielskiN4");
		testGoloso("entradaEj5MycielskiN5");
		testGoloso("entradaEj5MycielskiN6");
		testGoloso("entradaEj5MycielskiN7");
		testGoloso("entradaEj5MycielskiN8");
		testGoloso("entradaEj5MycielskiN9");
		testGoloso("entradaEj5MycielskiN10");
		testGoloso("entradaEj5MycielskiN11");
		testGoloso("entradaEj5MycielskiN12");
		testGoloso("entradaEj5MycielskiN13");
		
		
		System.out.println("Backtracking: Tiempos promedios para cada instancia de Mycielski (empezando desde 4).");
		
		testBacktracking("entradaEj5MycielskiN4");
		testBacktracking("entradaEj5MycielskiN5");
		testBacktracking("entradaEj5MycielskiN6");
		testBacktracking("entradaEj5MycielskiN7");
		testBacktracking("entradaEj5MycielskiN8");
		testBacktracking("entradaEj5MycielskiN9");
		testBacktracking("entradaEj5MycielskiN10");
		testBacktracking("entradaEj5MycielskiN11");
		testBacktracking("entradaEj5MycielskiN12");
		testBacktracking("entradaEj5MycielskiN13");
	}

}
