package uba.algo3.tp3.ejercicio1;

import java.util.ArrayList;

public class GrafoMaterias {
	
	private ArrayList<Nodo> grafo;

	public GrafoMaterias(int n){
		grafo = new ArrayList<Nodo>(n);
		
		for (int i = 0; i < n; i++)
			grafo.add(null);
	}
	
	public ArrayList<Nodo> getGrafo() {
		return grafo;
	}
	public void setGrafo(ArrayList<Nodo> grafo) {
		this.grafo = grafo;
	}
	public void setNodo(int id,Nodo nodo) {
		grafo.set(id, nodo);
	}
	
	public Integer getCantidadColoresNodo(Integer id)
	{
		return getNodo(id).getColores().size();
	}
	
	public Nodo getNodo(int id) {
		return grafo.get(id);
	}
}
