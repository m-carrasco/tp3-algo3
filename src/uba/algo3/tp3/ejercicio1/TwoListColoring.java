package uba.algo3.tp3.ejercicio1;


import java.util.ArrayList;
import java.util.LinkedList;

public class TwoListColoring {
	public static Integer[] solve(GrafoMaterias materias){

		GrafoSAT gs = new GrafoSAT(materias); //O(n + m)
		CompFuerteConexas cfc = gs.CC();  //O(n+m)
		if(gs.Satisfacible(cfc.getCFCPorNodo())){
			ArrayList<LinkedList<Integer>>  ady = gs.AdyacenciaEntreCompFuertConex(cfc);
			gs.Pintar(ady, cfc);
			return materiasPintadas(gs, materias);
		}
		
		return null;
		
	};
	
	public static Boolean esSastifacible(GrafoMaterias materias){
		GrafoSAT gs = new GrafoSAT(materias); //O(n + m)
		CompFuerteConexas cfc = gs.CC();  //O(n+m)
		return gs.Satisfacible(cfc.getCFCPorNodo());
	}

	private static Integer[] materiasPintadas(GrafoSAT gs, GrafoMaterias materias) {
		//retornamos un arreglo que tiene en cada posicion el color correspondiente a esa materia
		Integer[] colores = new Integer[materias.getGrafo().size()];
		
		for(int i = 0; i < materias.getGrafo().size(); i++)
		{
			Nodo nodoM = materias.getGrafo().get(i);
			for(int j = 0; j < nodoM.getColores().size(); j++)
			{
				//j es el indice en el arreglo de colores, NO el color en si
				if(gs.getNodo(4*i+j*2).getVoyYo())
				{
					colores[i] = nodoM.getColores().get(j);
					break;
				}
			}
		}
		return colores;
	};
		
}
