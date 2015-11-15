package uba.algo3.tp3.ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;
import uba.algo3.tp3.ejercicio1.Nodo;

public class ListColoringGoloso {

	public LinkedList<Nodo> OrdenarPorColores(GrafoMaterias g)
	{
		List<Nodo> ordenados = g.getGrafo();
		Collections.sort(ordenados);
		return (LinkedList<Nodo>)ordenados;
	}
	
	//modifica el grafo y me lo devuelve con todos los nodos de un color
	public void Coloreo(GrafoMaterias g)
	{		
		LinkedList<Nodo> ordenados = OrdenarPorColores(g);
		while(!ordenados.isEmpty())
		{
			Nodo n = ordenados.poll(); //agarra el primer elemento y lo borra
			Double[] valoresPorColor = new Double[n.cantColores()];
			int i = 0;
			for(Integer c : n.getColores())
			{
				valoresPorColor[i] = 0.0;
				for(Integer vecino : n.getVecinos())
				{
					for(Integer colorVecino : g.getNodo(vecino).getColores())
					{
						if(c == colorVecino)
							valoresPorColor[i] += 1.0/g.getNodo(vecino).cantColores();
					}
				}
				i++;
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
			
			ArrayList<Integer> color = new ArrayList<Integer>();
			color.add(n.getColores().get(idx));
			n.setColores(color);
			
		}
		
	}
}
