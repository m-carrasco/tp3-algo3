package uba.algo3.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GrafoSAT {
	private ArrayList<NodoSAT> grafo;
	
	public ArrayList<NodoSAT> getGrafo()
	{
		return grafo;
		
	}
	public NodoSAT getNodo(Integer i)
	{
		return grafo.get(i);
	}
	
	public GrafoSAT(GrafoMaterias g)
	{
		// orden del array: Ci1 NOCi1 Ci2 NoCi2
		
		grafo = new ArrayList<NodoSAT>(g.getGrafo().size()*4); //cota maxima de nodos O(4*s) = O(s)
		
		for (int i = 0; i < g.getGrafo().size()*4; i++)   // O(4*s)
			grafo.add(null);

		int i = 0;
		
		for(Nodo n : g.getGrafo()) //para cada nodo de la lista de nodos del grafo   O(#materias + #superpociosiones)
		{
			if (n == null)
			{
				i++;
				continue;
			}
			ArrayList<Integer> colores = n.getColores(); //O(1)
			
			for(int j = 0; j < colores.size()*2; j = j+2)  // O(4*1)
			{
				NodoSAT falso = new NodoSAT();  // O(1)
				NodoSAT verdadero = new NodoSAT();  // O(1)
				grafo.set(i*4+j, verdadero); // O(1)
				grafo.set(i*4+j+1, falso);	// O(1)	
			}
			
			if (colores.size() == 2)   //0(1)
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
					// itero colores de mi vecino
					for(int sucolor = 0; sucolor< g.getNodo(mivecino).getColores().size();sucolor++){
						if(n.getColores().get(micolor).intValue()== g.getNodo(mivecino).getColores().get(sucolor).intValue()){
							grafo.get(i*4+micolor*2).addVecino(mivecino*4+sucolor*2+1);
						}
					}
				}
			}
			
			i++;
		}
		
		return;
		
	}

	private void InvertirAristas()
	{
		ArrayList<NodoSAT> invertido = new ArrayList<NodoSAT>(grafo.size());
		
		//for (NodoSAT n : grafo)
		//	invertido.add(new NodoSAT());
		
		for (Integer idx = 0; idx < grafo.size(); idx++)
		{
			if (grafo.get(idx) != null)
				invertido.add(new NodoSAT());
			else 
				invertido.add(null);
		}
		
		for (Integer idx = 0; idx < grafo.size(); idx++)
		{
			NodoSAT n = grafo.get(idx);
			
			if (invertido.get(idx) != null) // si invertido no es null n tampoco.
			{	
				invertido.get(idx).setVoyYo(n.getVoyYo());
				for (Integer vecino : n.getVecinos())
					invertido.get(vecino).addVecino(idx);
			}
		}
		
		/*Integer idx = 0;
		for (NodoSAT n : grafo)
		{
			invertido.get(idx).setAfirmacion(n.isAfirmacion());
			for (Integer vecino : n.getVecinos())
				invertido.get(vecino).addVecino(idx);
			idx++;
		}*/
		
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
	
	
	public CompFuerteConexas CC()
	{
		Stack<Integer> pila = new Stack<Integer>();
		CompFuerteConexas res = new CompFuerteConexas(grafo.size()); //O(n)
		ArrayList<Boolean> visitados = new ArrayList<Boolean>(grafo.size()); // O(n)
		
		for (Integer i = 0; i < grafo.size(); i++){
			visitados.add(false);
		}
		
		for (Integer i = 0; i < visitados.size(); i++)  //O(n + m)
			if (!visitados.get(i) && grafo.get(i) != null)
				DFSIda(i, visitados, pila);
		
		InvertirAristas();
		

		for (Integer i = 0; i < grafo.size(); i++)
			visitados.set(i, false);
		
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
		
		InvertirAristas();
		return res;
	}
	
	public boolean Satisfacible(ArrayList<Integer> cc)
	{
		for (Integer i = 0; i < cc.size(); i = i + 2)
		{
			// si es -1 es que el nodo no existe.
			// se trata de una materia de un solor color.
			if (cc.get(i) != -1 && cc.get(i).intValue() == cc.get(i+1).intValue())
				return false;
		}
		
		return true;
	}
	
	// O(n^2) n = #materias
	public ArrayList<LinkedList<Integer>> AdyacenciaEntreCompFuertConex(CompFuerteConexas cfc)
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
			
			for (Integer j = 0; j < cfc.getCantCFC(); j++)
				revisados[j] = false;
	
			
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
			if (compVecina.intValue() == comp2.intValue())
				return true;
			
			if (HayCamino(compVecina, comp2, caminos))
				return true;
		}
		return false;
	}
	
	private void PintarCompConexa(Integer cfcIdx, boolean color, CompFuerteConexas cfc, Boolean[] pintados)
	{
		List<Integer> nodos = cfc.getnodosPorCompFuertConexa(cfcIdx);
		for (Integer nodeIdx : nodos)
		{
			NodoSAT nodo = grafo.get(nodeIdx);
			nodo.setVoyYo(color);
		}
		
		pintados[cfcIdx] = true;
	}
	
	private void PintarCompConexasAdyacentes(Integer cfcIdx, boolean color, CompFuerteConexas cc, Boolean[] pintados, ArrayList<LinkedList<Integer>> caminos)
	{
		// obtengo comp fuert adyacentes a cfcIdx
		for (Integer adyacente : caminos.get(cfcIdx))
		{
			if (pintados[adyacente])
				continue;
			PintarCompConexa(adyacente, color, cc, pintados);
		}
	}
	
	public void Pintar(ArrayList<LinkedList<Integer>> caminos,CompFuerteConexas cc){
		Boolean[] pintados = new Boolean[cc.getCantCFC()];
		
		for (Integer i = 0; i < cc.getCantCFC(); i++)
			pintados[i] = false;
		
		Integer cfcIdx = 0;
		for (List<Integer> cfc : cc.getNodosPorCompFuertConex())
		{
			// Los siguientes no pueden ser falsos, nada mas me adelanto a setear verdaderos.
			// en todo caso me encuentor verdaderos o no seteados.
			Integer nodeIdx = cfc.get(0);
			
			NodoSAT primero = grafo.get(nodeIdx);
			NodoSAT negPrimero = null;
			Integer cfcNegIdx = 0;
			
			Integer mod = nodeIdx % 4;
			if (nodeIdx % 4 == 0 || mod == 2){
				negPrimero = grafo.get(nodeIdx+1);
				cfcNegIdx = cc.getCFCNodo(nodeIdx+1);
			} else if (mod == 1 || mod == 3){
				negPrimero = grafo.get(nodeIdx-1);
				cfcNegIdx = cc.getCFCNodo(nodeIdx-1);
			}
			
			if (!pintados[cfcIdx])
			{
				// si me negación aún no fue pintada, entonces seteo falso a toda mi componete fuertemente conexa.
				if (!pintados[cfcNegIdx])
				{
					PintarCompConexa(cfcIdx, false, cc, pintados);
					// Sino fueron pintadas ya
					//PintarCompConexasImplicadasPor(cfcIdx, true); 
				} else {
					// mi negacion ya fue pintada
					if (!negPrimero.getVoyYo())
					{
						// mi negacion es falsa yo soy verdadero
						PintarCompConexa(cfcIdx, true, cc, pintados);
						// Sino fueron pintadas ya
						PintarCompConexasAdyacentes(cfcIdx, true, cc, pintados, caminos); 
					} else
						PintarCompConexa(cfcIdx, false, cc, pintados);
				}
			} else if (primero.getVoyYo())
			{
				PintarCompConexasAdyacentes(cfcIdx, true, cc, pintados, caminos);
			}
			
			cfcIdx++;
		}
		/*for(Integer i = 0; i < grafo.size(); i=i+2){
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
		}*/
	}
	
}
