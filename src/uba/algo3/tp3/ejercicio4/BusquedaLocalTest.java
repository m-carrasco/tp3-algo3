package uba.algo3.tp3.ejercicio4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;
import uba.algo3.tp3.ejercicio1.Nodo;
import uba.algo3.tp3.parser.Parser;

public class BusquedaLocalTest {

	private static final Integer ROJO = 0;
	private static final Integer VERDE = 1;
	private static final Integer AZUL = 2;
	private static final Integer NARANJA = 3;
	private static final Integer VIOLETA = 4;
	
	/*
Ejercicio4 variando n Switch
N M LC Tiempo promedio
100 4950 10 11.15
200 19900 10 67.2
300 44850 10 246.23
400 79800 10 627.65
500 124750 10 1226.0
*/	@Test
	public void testVariandoNSwitch() throws IOException
	{
		Parser p = new Parser();
		
		Integer it = 100;
		
		System.out.println("Ejercicio4 variando n Switch");
		System.out.println("N M LC Tiempo promedio");
		
		// iteramos por cada caso
		for (Integer i = 100; i <= 500; i = i + 100)
		{
			String filename = "entradaEj4CN" + i +"C10";
			
			GrafoMaterias original = p.parse(filename);
					
			// warmup
			runHeuristica( it, original, "switch");

			long inicio = System.currentTimeMillis();
			
			runHeuristica( it, original, "switch");
			
			Double delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
			System.out.println(i + " " + i*(i-1)/2 +" " + 10 + " "  + delta);
		}	
		
	}
	
/*
 * Ejercicio4 variando n recoloreo
N M LC Tiempo promedio
100 4950 10 0.69
200 19900 10 1.45
300 44850 10 3.42
400 79800 10 6.32
500 124750 10 9.79
 */
	@Test
	public void testVariandoNRecoloreo() throws IOException
	{
		Parser p = new Parser();
		
		Integer it = 100;
		
		System.out.println("Ejercicio4 variando n recoloreo");
		System.out.println("N M LC Tiempo promedio");
		
		// iteramos por cada caso
		for (Integer i = 100; i <= 500; i = i + 100)
		{
			String filename = "entradaEj4CN" + i +"C10";
			
			GrafoMaterias original = p.parse(filename);
					
			// warmup
			runHeuristica( it, original, "recoloreo");

			long inicio = System.currentTimeMillis();
			
			runHeuristica( it, original, "recoloreo");
			
			Double delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
			System.out.println(i + " " + i*(i-1)/2 +" " + 10 + " "  + delta);
		}	
		
	}
/*
 * 
 * Ejercicio4 variando c recoloreo
N M LC Tiempo promedio
200 19900 2 1.53
200 19900 4 1.46
200 19900 5 1.72
200 19900 10 2.55
200 19900 20 1.42
200 19900 25 2.04
200 19900 50 2.43
200 19900 100 2.46
200 19900 200 1.58

	
 */
	@Test
	public void testVariandoCRecoloreo() throws IOException
	{
		Parser p = new Parser();
		
		Integer it = 100;
		
		System.out.println("Ejercicio4 variando c recoloreo");
		System.out.println("N M LC Tiempo promedio");
	
		String heuristica = "recoloreo";
		String filename;
		GrafoMaterias original;
		long inicio;
		Double delta;
		
		int i = 200;
		
		int c;
		
		c = 2;
		filename = "entradaEj4CN200C2";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 4;
		filename = "entradaEj4CN200C4";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 5;
		filename = "entradaEj4CN200C5";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		
		c = 10;
		filename = "entradaEj4CN200C10";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 20;
		filename = "entradaEj4CN200C20";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 25;
		filename = "entradaEj4CN200C25";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
	
		c = 50;
		filename = "entradaEj4CN200C50";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 100;
		filename = "entradaEj4CN200C100";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 200;
		filename = "entradaEj4CN200C200";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);		
	}
	
	@Test
	public void testVariandoCSwitch() throws IOException
	{
		Parser p = new Parser();
		
		Integer it = 100;
		
		System.out.println("Ejercicio4 variando c switch");
		System.out.println("N M LC Tiempo promedio");
	
		String heuristica = "switch";
		String filename;
		GrafoMaterias original;
		long inicio;
		Double delta;
		
		int i = 200;
		
		int c;
		
		c = 2;
		filename = "entradaEj4CN200C2";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 4;
		filename = "entradaEj4CN200C4";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 5;
		filename = "entradaEj4CN200C5";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		
		c = 10;
		filename = "entradaEj4CN200C10";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 20;
		filename = "entradaEj4CN200C20";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 25;
		filename = "entradaEj4CN200C25";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
	
		c = 50;
		filename = "entradaEj4CN200C50";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 100;
		filename = "entradaEj4CN200C100";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);
		
		c = 200;
		filename = "entradaEj4CN200C200";
		original = p.parse(filename);			
		runHeuristica( it, original, heuristica);
		inicio = System.currentTimeMillis();
		runHeuristica( it, original, heuristica);
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println(i + " " + i*(i-1)/2 +" " + c + " "  + delta);		
	}

	
	@Test
	public void testSwitchNodos() {
		Nodo n0 = new Nodo();
		Nodo n1 = new Nodo();
		Nodo n2 = new Nodo();
		Nodo n3 = new Nodo();
		Nodo n4 = new Nodo();
		Nodo n5 = new Nodo();
		Nodo n6 = new Nodo();
		Nodo n7 = new Nodo();
		Nodo n8 = new Nodo();
		
		n0.addVecinos(2);
		
		n1.addVecinos(2);
		
		n2.addVecinos(0);
		n2.addVecinos(1);
		n2.addVecinos(3);
		
		n3.addVecinos(2);
		n3.addVecinos(4);
		n3.addVecinos(5);
		n3.addVecinos(6);
		n3.addVecinos(7);
		n3.addVecinos(8);
		
		n4.addVecinos(3);
		
		n5.addVecinos(3);
		
		n6.addVecinos(3);
		
		n7.addVecinos(3);
		
		n8.addVecinos(3);
		
		ArrayList<Integer> colores0 = new ArrayList<Integer>();
		colores0.add(ROJO);
		n0.setColores(colores0);
		
		ArrayList<Integer> colores1 = new ArrayList<Integer>();
		colores1.add(ROJO);
		n1.setColores(colores1);
		
		ArrayList<Integer> colores2 = new ArrayList<Integer>();
		colores2.add(ROJO);
		colores2.add(VIOLETA);
		n2.setColores(colores2);
		
		ArrayList<Integer> colores3 = new ArrayList<Integer>();
		colores3.add(ROJO);
		colores3.add(VIOLETA);
		n3.setColores(colores3);
		
		ArrayList<Integer> colores4 = new ArrayList<Integer>();
		colores4.add(VIOLETA);
		n4.setColores(colores4);
	
		ArrayList<Integer> colores5 = new ArrayList<Integer>();
		colores5.add(VIOLETA);
		n5.setColores(colores5);
		
		ArrayList<Integer> colores6 = new ArrayList<Integer>();
		colores6.add(VIOLETA);
		n6.setColores(colores6);
		
		ArrayList<Integer> colores7 = new ArrayList<Integer>();
		colores7.add(VIOLETA);
		n7.setColores(colores7);
		
		ArrayList<Integer> colores8 = new ArrayList<Integer>();
		colores8.add(ROJO);
		n8.setColores(colores8);

		n0.setColorPintado(ROJO);
		n1.setColorPintado(ROJO);
		n2.setColorPintado(ROJO);
		n3.setColorPintado(VIOLETA);
		n4.setColorPintado(VIOLETA);
		n5.setColorPintado(VIOLETA);
		n6.setColorPintado(VIOLETA);
		n7.setColorPintado(VIOLETA);
		n8.setColorPintado(ROJO);
		
		
		ArrayList<Nodo> grafo = new ArrayList<Nodo>();
		grafo.add(n0);
		grafo.add(n1);
		grafo.add(n2);
		grafo.add(n3);
		grafo.add(n4);
		grafo.add(n5);
		grafo.add(n6);
		grafo.add(n7);
		grafo.add(n8);
		
		GrafoMaterias g = new GrafoMaterias(9);
		g.setGrafo(grafo);
		System.out.println(BusquedaLocal.mejorarSolucion(g, 6, 1,"recoloreo"));
		//System.out.println(BusquedaLocal.switchNodos(g, 6));
	}
	@Test
	public void testConParser() throws IOException {
		Parser p = new Parser();
		GrafoMaterias original = p.parse("test1");
		
		original.getGrafo().get(0).setColorPintado(VIOLETA);
		original.getGrafo().get(1).setColorPintado(VIOLETA);
		original.getGrafo().get(5).setColorPintado(VIOLETA);
		original.getGrafo().get(6).setColorPintado(VIOLETA);
		original.getGrafo().get(2).setColorPintado(ROJO);
		original.getGrafo().get(3).setColorPintado(ROJO);
		original.getGrafo().get(4).setColorPintado(ROJO);
		
		System.out.println(BusquedaLocal.switchNodos(original, 6));
		System.out.println(BusquedaLocal.mejorarSolucion(original, 4, 1,"recoloreo"));
		
	}
	
	public Integer PintarPrimerColor(GrafoMaterias g)
	{
		
		for (Nodo n : g.getGrafo())
			n.setColorPintado(n.getColores().get(0));
		
		Integer conflictivas = 0;
		//Ahora el grafo tiene solo un color en cada nodo
		Boolean[] visitados = new Boolean[g.getSize()]; 
		Boolean[] conflictos = new Boolean[g.getSize()];
		
		Queue<Integer> cola = new LinkedList<Integer>(); //En la cola se guarda el index de cada nodo del grafo
		for(int j = 0; j < visitados.length; j++){
			visitados[j] = false;
			conflictos[j] = false;
		}

		for (int k = 0; k < visitados.length; k++)
		{
			if (visitados[k])
				continue;
			visitados[k] = true;
			cola.add(k);
			
			// El ciclo no pushea dos veces el mismo nodo
			// O(#nodos)
			while(!cola.isEmpty())
			{//Mientras haya vecinos sigo recorriendo
				Integer idxNodo = cola.poll(); //index del nodo en el grafo materias
				visitados[idxNodo] = true;
				// O(#nodos)
				for(Integer vecino : g.getNodo(idxNodo).getVecinos())//recorro los vecinos del nodo en el grafo
				{
					if (!conflictos[vecino])
					{
						if(g.getNodo(idxNodo).getColorPintado().equals(g.getNodo(vecino).getColorPintado())) //hay conflicto
						{	
							conflictivas++;
						}
					}
					
					if (!visitados[vecino])
					{
						cola.add(vecino);
						visitados[vecino] = true;
					}
				}
				
				conflictos[idxNodo] = true;
			}
			
		}
		return conflictivas;
	}
	
	public void prueba(String name, String heuristica) throws IOException
	{
		Parser p = new Parser();
		GrafoMaterias g = p.parse(name);
		int conflictos = PintarPrimerColor(g);//ListColoringGoloso.solve(g).size();
		System.out.println("Conflictos originales: " + conflictos);
		System.out.println("Conflictos restantes: " + BusquedaLocal.mejorarSolucion(g, conflictos, conflictos,heuristica));
	}
	
	// Corre it veces greedy sobre el grafo temp y lo restaura en cada iteracion.
	public void run(Integer it, GrafoMaterias g, String heuristica)
	{
		for (Integer j = 0; j < it; j++)
		{
			int conflictos = PintarPrimerColor(g);
			BusquedaLocal.mejorarSolucion(g, conflictos, conflictos,heuristica);
		}
	}
	
	public void runHeuristica(Integer it, GrafoMaterias g, String heuristica)
	{
		for (Integer j = 0; j < it; j++)
		{
			Integer conflictos = PintarPrimerColor(g);
			
			if(heuristica == "recoloreo")
				BusquedaLocal.recolorearNodo(g,conflictos);
				
			if(heuristica == "switch")
				BusquedaLocal.switchNodos(g,conflictos);
		}
	}
	
	@Test 
	public void testComparacion() throws IOException
	{
		Parser p = new Parser();
		
		Integer it = 100;
		
				
		System.out.println("Arbol Binario Recoloreo");
		prueba("entradaEj4ABAleN512", "recoloreo");
		System.out.println("Arbol Binario Switch");
		prueba("entradaEj4ABAleN512", "switch");
		
		System.out.println("Completo Recoloreo");
		prueba("entradaEj4CAleN100", "recoloreo");
		System.out.println("Completo Switch");
		prueba("entradaEj4CAleN100", "switch");
		
		System.out.println("Rueda Recoloreo");
		prueba("entradaEj4RAleN512", "recoloreo");
		System.out.println("Rueda Switch");
		prueba("entradaEj4RAleN512", "switch");
		
		GrafoMaterias original = p.parse("entradaEj4RAleN512");
		run( it, original, "switch");
		long inicio = System.currentTimeMillis();
		run( it, original, "switch");
		Double delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println("Promedio para Rueda Aleatoria - Switch: " + delta);
		
		
		original = p.parse("entradaEj4RAleN512");
		run( it, original, "recoloreo");
		inicio = System.currentTimeMillis();
		run( it, original, "recoloreo");
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println("Promedio para Rueda Aleatoria - Recoloreo: " + delta);
		
		original = p.parse("entradaEj4CAleN100");
		run( it, original, "recoloreo");
		inicio = System.currentTimeMillis();
		run( it, original, "recoloreo");
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println("Promedio para Completo Aleatoria - Recoloreo: " + delta);

		original = p.parse("entradaEj4CAleN100");
		run( it, original, "switch");
		inicio = System.currentTimeMillis();
		run( it, original, "switch");
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println("Promedio para Completo Aleatoria - Switch: " + delta);
		
		original = p.parse("entradaEj4ABAleN512");
		run( it, original, "switch");
		inicio = System.currentTimeMillis();
		run( it, original, "switch");
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println("Promedio para AB Aleatoria - Switch: " + delta);
		
		original = p.parse("entradaEj4ABAleN512");
		run( it, original, "recoloreo");
		inicio = System.currentTimeMillis();
		run( it, original, "recoloreo");
		delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
		System.out.println("Promedio para AB Aleatoria - Recoloreo: " + delta);
	

		
	}
	
	@Test
	public void testPruebas() throws IOException {
		Parser p = new Parser();
		
		System.out.println("Completo Aleatorio - Recoloreo");
		prueba("entradaEj4CAle", "recoloreo");
		
		
		System.out.println("Completo Aleatorio - Switch");
		prueba("entradaEj4CAle", "switch");
		
		System.out.println("Completo Minimo - Recoloreo");
		prueba("entradaEj4CMin", "recoloreo");
		
		System.out.println("Completo Minimo - Switch");
		prueba("entradaEj4CMin", "switch");
		
		System.out.println("Completo Maximo - Recoloreo");
		prueba("entradaEj4CMax", "recoloreo");
	
		System.out.println("Completo Maximo - Switch");
		prueba("entradaEj4CMax", "switch");
		
		
		// RUEDA

		System.out.println("Rueda Maxima - Recoloreo");
		prueba("entradaEj4RMax", "recoloreo");
		
		System.out.println("Rueda Maxima - Switch");
		prueba("entradaEj4RMax", "switch");
		
		System.out.println("Rueda Minima - Recoloreo");
		prueba("entradaEj4RMin", "recoloreo");

		System.out.println("Rueda Minima - Switch");
		prueba("entradaEj4RMin", "switch");		
		
		System.out.println("Rueda Aleatoria - Recoloreo");
		prueba("entradaEj4RAle", "recoloreo");
		
		System.out.println("Rueda Aleatoria - Switch");
		prueba("entradaEj4RAle", "switch");
	
		// ARBOL
		
		System.out.println("Arbol Maxima - Recoloreo");
		prueba("entradaEj4AMax", "recoloreo");
		
		System.out.println("Arbol Maxima - Switch");
		prueba("entradaEj4AMax", "switch");
		
		
		System.out.println("Arbol Minima - Recoloreo");
		prueba("entradaEj4AMin", "recoloreo");
		
		System.out.println("Arbol Minima - Switch");
		prueba("entradaEj4AMin", "switch");
		
		System.out.println("Arbol Aleatoria - Recoloreo");
		prueba("entradaEj4AAle", "recoloreo");
		
		System.out.println("Arbol Aleatoria - Switch");
		prueba("entradaEj4AAle", "switch");
		
		// ARBOL BINARIO
		System.out.println("Arbol Binaria Maxima - Recoloreo");
		prueba("entradaEj4ABMax", "recoloreo");
		
		System.out.println("Arbol Binaria Maxima - Switch");
		prueba("entradaEj4ABMax", "switch");
		
		
		System.out.println("Arbol Binaria Minima - Recoloreo");
		prueba("entradaEj4ABMin", "recoloreo");
		
		System.out.println("Arbol Binaria Minima - Switch");
		prueba("entradaEj4ABMin", "switch");
		
		System.out.println("Arbol Binaria Aleatoria - Recoloreo");
		prueba("entradaEj4ABAle", "recoloreo");
		
		System.out.println("Arbol Binaria Aleatoria - Switch");
		prueba("entradaEj4ABAle", "switch");
		
				
	}

}
