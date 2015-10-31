package uba.algo3.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompFuerteConexas {

	private ArrayList<Integer> nodos; // dado un nodo te digo a que comp fuert conexa esta
	private ArrayList<LinkedList<Integer>> nodosPorCompFuertConex;
	
	private Integer ultimaCfc;
	
	public CompFuerteConexas(Integer nodes)
	{
		nodos = new ArrayList<Integer>(nodes);
		for (Integer i = 0; i < nodes; i++)
			nodos.add(-1); // no tiene comp fuerte conexa asignada. se asigna a nodos no existentes.
			
		ultimaCfc = 0;
	}
	
	public void setearCFCNodo(Integer nodo, Integer cfc)
	{
		if (ultimaCfc < cfc)
			ultimaCfc = cfc;

		nodos.set(nodo, cfc);
	}
	
	public Integer getCFCNodo(Integer nodo)
	{
		return nodos.get(nodo);
	}
	
	public Integer getCantCFC()
	{
		return ultimaCfc+1;
	}
	
	// Se debe llamar luego de que seteamos todos los nodos a su CFC.
	public void agruparPorCompFuerConexa()
	{
		nodosPorCompFuertConex = new ArrayList<LinkedList<Integer>>(ultimaCfc+1);
		
		for (Integer i = 0; i < ultimaCfc+1; i++)
			nodosPorCompFuertConex.add(new LinkedList<Integer>());
		
		for (Integer i = 0; i < nodos.size(); i++)
		{
			Integer cfc = nodos.get(i);
			
			if (cfc != -1)
				nodosPorCompFuertConex.get(cfc).add(i);
		}
	}
	
	public List<Integer> getnodosPorCompFuertConexa(Integer cfc)
	{
		return nodosPorCompFuertConex.get(cfc);
	}
}
