package uba.algo3.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.Stack;

public class GrafoSAT {
	private ArrayList<NodoSAT> grafo;
	
	public GrafoSAT(GrafoMaterias g)
	{
		// orden del array: Ci1 NOCi1 Ci2 NoCi2
		
		grafo = new ArrayList<NodoSAT>(g.getGrafo().size()*4); //cota maxima de nodos
		
		for (int i = 0; i < g.getGrafo().size()*4; i++)
			grafo.add(null);

		int i = 0;
		
		for(Nodo n : g.getGrafo()) //para cada nodo de la lista de nodos del grafo
		{
			ArrayList<Integer> colores = n.getColores();
			
			for(int j = 0; j < colores.size(); j = j+2)
			{
				NodoSAT falso = new NodoSAT();
				NodoSAT verdadero = new NodoSAT();
				falso.setAfirmacion(false);
				verdadero.setAfirmacion(true);
				grafo.set(i*4+j, verdadero);
				grafo.set(i*4+j+1, falso);

				
			}
			
			if (colores.size() == 2)
			{
				// Si modulo 4 me da: 
				// -> 0 entonces es afirmacion del primer color
				// -> 1 entonces es negacion del primer color
				// -> 2 entonces es afirmacion del segundo color
				// -> 3 entonces es negacion del segundo color
				grafo.get(i*4).addVecino(i*4+3);
				grafo.get(i*4+3).addVecino(i*4);
				grafo.get(i*4+1).addVecino(i*4+2);
				grafo.get(i*4+2).addVecino(i*4+1);
				
			}
			
			for(int micolor = 0; micolor < colores.size();micolor++){// Genera dos iteraciones
				for(int mivecino : n.getVecinos()){
					for(int sucolor = 0; sucolor< g.getNodo(mivecino).getColores().size();sucolor++){
						if(n.getColores().get(micolor)==g.getNodo(mivecino).getColores().get(sucolor)){
							grafo.get(i*4+micolor*2).addVecino(mivecino+4+sucolor*2+1);
						}
					}
				}
			}
			i++;
		}
		
	}

	public void InvertirAristas()
	{
		ArrayList<NodoSAT> invertido = new ArrayList<NodoSAT>(grafo.size());
		
		for (NodoSAT n : grafo)
			invertido.add(new NodoSAT());
		
		Integer idx = 0;
		for (NodoSAT n : grafo)
		{
			invertido.get(idx).setAfirmacion(n.isAfirmacion());
			for (Integer vecino : n.getVecinos())
				invertido.get(vecino).addVecino(idx);
			idx++;
		}
		
		grafo = invertido;
	}
	
	public void DFSVuelta(Integer idxNodo, ArrayList<Boolean> visitado, UnionFind cc)
	{
		visitado.set(idxNodo, true);
	
		for (Integer vecino : grafo.get(idxNodo).getVecinos())
		{
			if (!visitado.get(vecino)){
				
				cc.unionSet(idxNodo, vecino);
				DFSVuelta(vecino, visitado, cc);
			}
				
		}
	}
	
	public void DFSIda(Integer idxNodo, ArrayList<Boolean> visitado, Stack<Integer> pila)
	{
		visitado.set(idxNodo, true);
	
		for (Integer vecino : grafo.get(idxNodo).getVecinos())
		{
			if (!visitado.get(vecino)){
				DFSIda(vecino, visitado, pila);
			}
				
		}
		
		pila.push(idxNodo);
	}
	
	
	public UnionFind CC()
	{
		Stack<Integer> pila = new Stack<Integer>();
		UnionFind cc = new UnionFind(grafo.size());
		
		ArrayList<Boolean> visitados = new ArrayList(grafo.size());
		for (Integer i = 0; i < grafo.size(); i++)
			visitados.add(false);
		
		for (Integer i = 0; i < visitados.size(); i++)
			if (!visitados.get(i))
				DFSIda(i, visitados, pila);
		
		InvertirAristas();
		
		for (Integer i = 0; i < grafo.size(); i++)
			visitados.add(false);
		
		while (pila.size() > 0)
		{
			Integer n = pila.pop();
			DFSVuelta(n, visitados, cc);
		}
		
		return cc;
	}
	
}
