package uba.algo3.tp3.ejercicio4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;
import uba.algo3.tp3.ejercicio1.Nodo;

public class BusquedaLocal {

	public static int switchNodos(GrafoMaterias g, int conf)
	{		
		Queue<Integer> cola = new LinkedList<Integer>();
		ArrayList<Boolean> visitados = new ArrayList<Boolean>(g.getSize());
		for(int i=0;i<g.getSize();i++)
			visitados.add(false);
	
		for(int i=0;i<g.getSize();i++)
		{
			if(visitados.get(i)==false)
			{
				visitados.set(i, true);
				cola.add(i);
			}
			while(!cola.isEmpty())
			{
				int id = cola.poll();	
				
				Nodo actual = g.getNodo(id);
				
				boolean tieneConflictos = false;
				for(Integer v : actual.getVecinos())
				{
					if(g.getNodo(v).getColorPintado().intValue() == actual.getColorPintado().intValue())
					{
						tieneConflictos = true;
						break;
					}
				}
				if(!tieneConflictos)
					continue;
				
				for (Integer vecinoId : actual.getVecinos())
				{
					
					Nodo vecino = g.getNodo(vecinoId);
					int miColor = actual.getColorPintado().intValue();
					int suColor = vecino.getColorPintado().intValue();
					
					boolean tieneColorMio = false;
					for (Integer color : vecino.getColores())
					{
						if (color.intValue() == miColor && suColor != miColor)
						{
							//tiene como opcion mi color, y ademas no es conflictivo conmigo
							tieneColorMio = true;
							break;
						}
					}
						
					// reviso que yo tenga su color
					boolean tengoSuColor = false;
					if (tieneColorMio)
					{
						for (Integer color : actual.getColores())
						{
							if (color.intValue() == suColor)
							{
								tengoSuColor = true;
								break;
							}
						}
					}
					
					if (tieneColorMio && tengoSuColor)
					{
						// Intento hacer switch si no se rompe.
						int viejosConflictos = 0;
						int nuevosConflictos = 0;
						for(Integer suVecino : vecino.getVecinos())
						{
							
							if(suVecino.intValue() != id) //no me considero a mi mismo
							{
								if(g.getNodo(suVecino).getColorPintado().intValue() == miColor)
									nuevosConflictos++;
								if(g.getNodo(suVecino).getColorPintado().intValue() == suColor)
									viejosConflictos++;
							}
						}
						
						for(Integer miVecino : actual.getVecinos())
						{
							if(miVecino.intValue() != vecinoId.intValue()) //no considero al vecino conflictivo
							{
								if(g.getNodo(miVecino).getColorPintado().intValue() == suColor)
									nuevosConflictos++;
								if(g.getNodo(miVecino).getColorPintado().intValue() == miColor)
									viejosConflictos++;
							}
						}
						
						if(nuevosConflictos < viejosConflictos) // vale la pena hacer el switch
						{
							actual.setColorPintado(suColor);
							vecino.setColorPintado(miColor);
							return conf - viejosConflictos + nuevosConflictos;
						}
					}
					
				}
				
				for (Integer vecino : actual.getVecinos())
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
	public static int recolorearNodo(GrafoMaterias g,int conf) 
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
	
	public static int mejorarSolucion(GrafoMaterias g,int  conflictos, Integer it,String tipo) //ya coloreado
	{
		
		Integer j = 0;
		int conf=conflictos;

		while (j < it && j < conf)
		{
			int res=0;
			if(tipo == "recoloreo")
				res=recolorearNodo(g,conflictos);
				
			if(tipo == "switch")
				res=recolorearNodo(g,conflictos);
				
			if(res>=conflictos)
			{
				return res;
			}
			
			conflictos=res;
			j++;
		}
		return conflictos;
		
		

	}
}
