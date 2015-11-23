package uba.algo3.tp3.ejercicio4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;

public class BusquedaLocal {

	public static int BFS(GrafoMaterias g,int conf) 
	{
		
		Queue<Integer> cola = new LinkedList<Integer>();
		ArrayList<Boolean> visitados = new ArrayList<Boolean>(g.getSize());
		for(int i=0;i<g.getSize();i++)
			visitados.add(false);
		
		
		for(int i=0;i<g.getSize();i++){
			if(visitados.get(i)==false)
			{
				visitados.set(i, true);
				cola.add(i);
			}
			while(!cola.isEmpty())
			{
				// busco conflictos... Elijo el color que menos conflictos me generó
				//O(M*C)
				int id = cola.poll();
				Integer colorMenosConf = g.getNodo(id).getColorPintado();
				int menorConflicto =g.getNodo(id).getVecinos().size()+1;
				int conflictosOriginales=0; 
				for(Integer color : g.getNodo(id).getColores()){
					int conflictos=0;
					for (Integer vecino : g.getNodo(id).getVecinos())
					{
						if(color.equals(g.getNodo(vecino).getColorPintado())){
							conflictos++;
						}
					}
					if(color.equals(g.getNodo(id).getColorPintado()))
					{
						conflictosOriginales=conflictos;
					}
					
					if(conflictos < menorConflicto)
					{
						menorConflicto=conflictos;
						colorMenosConf=color;
					}
				}
					
				if(menorConflicto<conflictosOriginales)
				{
					g.getNodo(id).setColorPintado(colorMenosConf);
					return conf - conflictosOriginales + menorConflicto;
				}
				//O(M)
	
				for (Integer vecino : g.getNodo(id).getVecinos())
				{
					if (!visitados.get(vecino))
					{
						visitados.set(vecino, true);
						cola.add(vecino);
					}
				}
			}
		}
		
		return conf;
		
	}
	
	public static int MejorarSolucion(GrafoMaterias g,LinkedList<Integer[]> conflictos, Integer it) //ya coloreado
	{
		Integer j = 0;
		int conf = conflictos.size();

		while (j < it || j < conflictos.size())
		{
			int res=BFS(g,conf);
			if(res>=conf)
			{
				return res;
			}
			
			conf=res;
			j++;
		}
		return conf;
		
		

	}
}
