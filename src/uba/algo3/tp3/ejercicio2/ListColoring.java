package uba.algo3.tp3.ejercicio2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import uba.algo3.tp3.ejercicio1.*;

public class ListColoring {

	
	private static void AgregarColores(Nodo m, Integer materiaIdx, GrafoMaterias input, Integer i, boolean par)
	{
		ArrayList<Integer> colores = new ArrayList<Integer>();
		if (par || !(i == input.getCantidadColoresNodo(materiaIdx) - 1))
		{
			colores.add(input.getNodo(materiaIdx).getColores().get(i));
			colores.add(input.getNodo(materiaIdx).getColores().get(i+1));
		}else{
			colores.add(input.getNodo(materiaIdx).getColores().get(i));
		}
		m.setColores(colores);
		
	}
	public static boolean recursion(GrafoMaterias input, GrafoMaterias materia, Integer idx, Integer[] nodos)
	{
		
		// nodos es un array de indices de nodos en el grafo input. Las posiciones del array marcan el orden en el que los recorremos
		
		
		Integer idxInput = nodos[idx];
		// REFERENCIA A INPUT
		Nodo nuevom = new Nodo();
		Nodo m = input.getNodo(idxInput);
		
		List<Integer> vecinos = m.getVecinos();
		materia.getGrafo().set(idxInput, nuevom);
		
		//Se linkea el nuevo nodo con sus vecinos existentes
		for (Integer vecino : vecinos)
		{
			if (materia.getNodo(vecino) != null)
			{
				// me linkeo doble
				materia.getNodo(vecino).addVecinos(idxInput);
				materia.getNodo(idxInput).addVecinos(vecino);
			}
		}
		
		boolean par = m.getColores().size() % 2 == 0;
		
		for (Integer i = 0; i < m.getColores().size(); i = i+2)
		{
			AgregarColores(materia.getGrafo().get(idxInput), idxInput, input, i, par);
			
			if (!TwoListColoring.esSastifacible(materia))
				continue;
			if(idx == nodos.length -1)
				return true;
			else if(recursion(input, materia, idx+1, nodos))
				return true;
		}
		
		// Si sali del for es que todos mis vecinos fallaron al pintarse. Me tengo que sacar y devolver false
		//Me saco del materias
		materia.setNodo(idxInput, null);
		
		for (Integer vecino : vecinos)
		{
			if (materia.getNodo(vecino) != null)
			{
				// me deslinkeo de mis vecinos
				((LinkedList<Integer>) materia.getNodo(vecino).getVecinos()).removeLast();
			}
		}
		return false;	
	}
}
