package uba.algo3.tp3.ejercicio4;

import java.util.LinkedList;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;

public class BusquedaLocal {

	public static void CambioDeColores(GrafoMaterias g,LinkedList<Integer[]> conflictos) //ya coloreado
	{
		//IDEAS:
		//cambiar el for por mirar el primer nodo que no haya sido chequeado y que la funcion se llame recursivamente
		
		//no tener lista de nodos conflictivos (nos esta generando problemas sobre como mantenerla consistente)
		//utilizar directamente el grafo
		
		//con la idea que esta escrita, revisar ambos nodos de la tupla todas las veces
		
		
		// *************************** WORK IN PROGRESS *******************************
		for(Integer[] tupla : conflictos){
			Integer idxNodo = tupla[0];
			Integer miColor= g.getNodo(idxNodo).getColorPintado();
			Integer ConflictosViejos =0;
			for(Integer vecino: g.getNodo(idxNodo).getVecinos()){
				if(g.getNodo(vecino).getColorPintado() == miColor){
					ConflictosViejos++;
				}
			}
			
			Integer minimo=ConflictosViejos;
			Integer colorMinimo=miColor;
			for(Integer color:g.getNodo(idxNodo).getColores()){
				Integer ConflictosNuevos=0;
				if(color!=miColor){
					for(Integer vecino: g.getNodo(idxNodo).getVecinos()){
						if(g.getNodo(vecino).getColorPintado() == miColor){
							ConflictosNuevos++;
						}
					}
					if(ConflictosNuevos<minimo){
						minimo=ConflictosNuevos;
						colorMinimo=color;
					}
				}
			}
			
			g.getNodo(idxNodo).setColorPintado(colorMinimo);
			
		}
		//TODO
	}
}
