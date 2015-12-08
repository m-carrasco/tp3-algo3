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
						if(g.getNodo(idxNodo).getColorPintado() == g.getNodo(vecino).getColorPintado()) //hay conflicto
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
		Integer iteraciones = 5000;
		int conflictos = PintarPrimerColor(g);//ListColoringGoloso.solve(g).size();
		System.out.println("Conflictos originales: " + conflictos);
		System.out.println("Conflictos restantes: " + BusquedaLocal.mejorarSolucion(g, iteraciones, iteraciones,heuristica));
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
				
	}

}
