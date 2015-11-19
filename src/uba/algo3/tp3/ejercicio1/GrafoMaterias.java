package uba.algo3.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	
	public int getSize()
	{
		return grafo.size();
	}
	
	// retorna un arreglo que es el orden de los nodos vistados.
	// ademas cc se modifica para retornar los indices en los que comienza cada componente conexa
	public List<List<Integer>> BFS(){
	
		List<List<Integer>> cc = new LinkedList<List<Integer>>();
		Boolean[] visitados = new Boolean[this.getSize()]; 
		Queue<Integer> cola = new LinkedList<Integer>(); //En la cola se guarda el index de cada nodo del grafo

		// O(#nodos)
		
		for(int j = 0; j < visitados.length; j++){
			visitados[j] = false;
			//ninguno fue visitado
		}

		List<Integer> nodosEnCC;
		for (int k = 0; k < visitados.length; k++)
		{
			if (visitados[k])
				continue;
			
			// se empieza a explorar una nueva cc.
			nodosEnCC = new LinkedList<Integer>();
			visitados[k] = true;
			
			cola.add(k);
			
			// El ciclo no pushea dos veces el mismo nodo
			// O(#nodos)
			while(!cola.isEmpty()){//Mientras haya vecinos sigo recorriendo
				Integer idxNodo = cola.poll(); //index del nodo en el grafo materias			
				visitados[idxNodo] = true;

				// O(#nodos)
				for(Integer vecino : this.getNodo(idxNodo).getVecinos())//recorro los vecinos del nodo en el grafo
				{
					if(!visitados[vecino]){//sino fue visitado
						cola.add(vecino);
						visitados[vecino] = true;
					}
				}
				
				nodosEnCC.add(idxNodo);
			}
			
			cc.add(nodosEnCC);
		}
		
		return cc;
	}
}
