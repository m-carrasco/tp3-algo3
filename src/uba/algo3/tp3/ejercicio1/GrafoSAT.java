package uba.algo3.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GrafoSAT {
	private ArrayList<NodoSAT> grafo;
	
	public NodoSAT getNodo(Integer i)
	{
		return grafo.get(i);
	}
	
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
			
			for(int j = 0; j < colores.size()*2; j = j+2)
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
				
			} else 
			{
				// un solo color
				grafo.get(i*4+1).addVecino(i*4);
				
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

	private void InvertirAristas()
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
	
	private void DFSVuelta(Integer idxNodo, ArrayList<Boolean> visitado, CompFuerteConexas res, Integer cc)
	{
		visitado.set(idxNodo, true);
	
		res.setearCFCNodo(idxNodo, cc);
		for (Integer vecino : grafo.get(idxNodo).getVecinos())
		{
			if (!visitado.get(vecino)){
				
				res.setearCFCNodo(vecino, cc);
				DFSVuelta(vecino, visitado, res, cc);
			}
		}
	}
	
	private void DFSIda(Integer idxNodo, ArrayList<Boolean> visitado, Stack<Integer> pila)
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
	
	
	private CompFuerteConexas CC()
	{
		Stack<Integer> pila = new Stack<Integer>();
		CompFuerteConexas res = new CompFuerteConexas(grafo.size());
		ArrayList<Boolean> visitados = new ArrayList(grafo.size());
		
		for (Integer i = 0; i < grafo.size(); i++){
			visitados.add(false);
		}
		
		for (Integer i = 0; i < visitados.size(); i++)
			if (!visitados.get(i) && grafo.get(i) != null)
				DFSIda(i, visitados, pila);
		
		InvertirAristas();
		
		for (Integer i = 0; i < grafo.size(); i++)
			visitados.add(false);
		
		Integer cc = -1;
		while (pila.size() > 0)
		{
			Integer n = pila.pop();
			
			if (!visitados.get(n)){
				cc++;
				DFSVuelta(n, visitados, res, cc);	
			}
		}
		
		// O(n)
		res.agruparPorCompFuerConexa();
		
		return res;
	}
	
	private boolean Satisfacible(ArrayList<Integer> cc)
	{
		for (Integer i = 0; i < cc.size(); i = i + 2)
		{
			// si es -1 es que el nodo no existe.
			// se trata de una materia de un solor color.
			if (cc.get(i) != -1 && cc.get(i) == cc.get(i+1))
				return false;
		}
		
		return true;
	}
	
	private ArrayList<LinkedList<Integer>> AdyacenciaEntreCompFuertConex(CompFuerteConexas cfc)
	{
		ArrayList<LinkedList<Integer>> res = new ArrayList<LinkedList<Integer>>(cfc.getCantCFC());
		
		for (Integer i = 0; i < cfc.getCantCFC(); i++)
			res.add(new LinkedList<Integer>());

		// Recorro todos los nodos del grafo por Comp Fuert Conexa. 
		// En total recorro toda la lista de adyacencia del grafo sat. O(N + M)
		// Pero hay que tener en cuenta la creacion del arrelgo.
		for (Integer i = 0; i < cfc.getCantCFC(); i++)
		{
			Boolean[] revisados = new Boolean[cfc.getCantCFC()];
			
			List<Integer> nodosXCFC = cfc.getnodosPorCompFuertConexa(i);
			
			for (Integer idxNodo : nodosXCFC)
			{	
				NodoSAT nodo = grafo.get(idxNodo);
				
				for (Integer idxVecino : nodo.getVecinos())
				{
					if (cfc.getCFCNodo(idxVecino) != cfc.getCFCNodo(idxNodo))
					{
						if (!revisados[cfc.getCFCNodo(idxVecino)])
						{
							res.get(cfc.getCFCNodo(idxNodo)).add(cfc.getCFCNodo(idxVecino));
							revisados[cfc.getCFCNodo(idxVecino)] = true;
						}
					}
				}
			}
		}
		
		return res;
	}
	
	boolean HayCamino(Integer comp1, Integer comp2, ArrayList<LinkedList<Integer>> caminos)
	{		
		for (Integer compVecina : caminos.get(comp1))
		{
			if (compVecina == comp2)
				return true;
			
			if (HayCamino(compVecina, comp2, caminos))
				return true;
		}
		return false;
	}
	
	private void Pintar(ArrayList<LinkedList<Integer>> caminos,CompFuerteConexas cc){
		
		for(Integer i = 0; i < grafo.size(); i=i+2){
			NodoSAT n1 = grafo.get(i);
			NodoSAT n2 = grafo.get(i+1);
			if(n1!=null){
				Integer comp1 = cc.getCFCNodo(i);
				Integer comp2 = cc.getCFCNodo(i+1);
				if(HayCamino(comp1,comp2,caminos)){
					n1.setAfirmacion(false);
					n2.setAfirmacion(true);
				}
				else{
					n2.setAfirmacion(false);
					n1.setAfirmacion(true);
				}
			}
		}
	}
	
}
