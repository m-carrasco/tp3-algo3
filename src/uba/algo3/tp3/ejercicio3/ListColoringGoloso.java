package uba.algo3.tp3.ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;
import uba.algo3.tp3.ejercicio1.Nodo;

public class ListColoringGoloso {

	public static ArrayList<Nodo> OrdenarPorColores(GrafoMaterias g)
	{
		ArrayList<Nodo> ordenados = new ArrayList<Nodo>(g.getGrafo());
		Collections.sort(ordenados);
		return ordenados;
	}
	
	//modifica el grafo y me lo devuelve con todos los nodos de un color
	public static void Goloso(GrafoMaterias g)
	{		
		ArrayList<Nodo> ordenados = OrdenarPorColores(g); 
		
		for(Nodo n : ordenados) //O((n+m)c^2)
		{
			Double[] valoresPorColor = new Double[n.cantColores()];
			
			for(int j = 0; j < valoresPorColor.length; j++)
				valoresPorColor[j] = 0.0;
			
			for(Integer vecino : n.getVecinos())
			{
				int i = 0;
				
				for(Integer c : n.getColores())
				{
					if(g.getNodo(vecino).getColorPintado()!=-1){
						
						if(c == g.getNodo(vecino).getColorPintado())
							valoresPorColor[i] += 1.0;
						
					}else{
						for(Integer colorVecino : g.getNodo(vecino).getColores())
						{
							if(c == colorVecino)
								valoresPorColor[i] += 1.0/g.getNodo(vecino).cantColores();
							
						}
					}
					i++;
				}
				
			}
			
			
			// busco el que tenga valor minimo, porque es el que afecta menos a los demas (tienen mas opciones para elegir)
			
			Double min = valoresPorColor[0];
			int idx = 0;
			for(int j = 1; j < valoresPorColor.length; j++)
			{
				if(valoresPorColor[j] < min)
				{
					min = valoresPorColor[j];
					idx = j;
				}
			}
			n.setColorPintado(n.getColores().get(idx));
			
		}
		
	}
	
	//devuelve la cantidad de conflictos
	public static LinkedList<Integer[]> solve(GrafoMaterias g)
	{
		LinkedList<Integer[]> conflictivas = new LinkedList<Integer[]>();
		Goloso(g); 
		//Ahora el grafo tiene solo un color en cada nodo
		Boolean[] visitados = new Boolean[g.getSize()]; 
		Queue<Integer> cola = new LinkedList<Integer>(); //En la cola se guarda el index de cada nodo del grafo
		for(int j = 0; j < visitados.length; j++)
			visitados[j] = false;

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
					if(!visitados[vecino]){//sino fue visitado
						if(g.getNodo(idxNodo).getColorPintado() == g.getNodo(vecino).getColorPintado()) //hay conflicto
						{	
							Integer[] tupla = {idxNodo,vecino};
							conflictivas.add(tupla);
						}
						cola.add(vecino);
					}
				}
			}
			
		}
		return conflictivas;
	}
}
