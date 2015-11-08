package uba.algo3.tp3.ejercicio2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import uba.algo3.tp3.ejercicio1.*;

public class ListColoring {

	
	private void AgregarColores(Nodo m, Integer materiaIdx, GrafoMaterias input, Integer i, boolean par)
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
	public boolean recursion(GrafoMaterias input, GrafoMaterias materia, Integer materiaIdx, Integer[] res)
	{
		if (input.getGrafo().size() == materia.getGrafo().size())
		{
			Integer[] t = TwoListColoring.solve(input);
			if (t != null)
			{
				res = t;
				return true;
			}
			
			return false;
		}
		
		// materia
		Nodo m = new Nodo();
		List<Integer> vecinos = input.getNodo(materiaIdx).getVecinos();
		
		materia.getGrafo().set(materiaIdx, m);
		
		List<Integer> noVecinosEnRecursion = new LinkedList<Integer>();
		
		for (Integer vecino : vecinos)
		{
			if (materia.getNodo(vecino) != null)
			{
				// me linkeo doble
				materia.getNodo(vecino).addVecinos(materiaIdx);
				m.addVecinos(vecino);
			} else
			{
				noVecinosEnRecursion.add(vecino);
			}
		}
		
		boolean par = input.getCantidadColoresNodo(materiaIdx) % 2 == 0;
		
		for (Integer i = 0; i < input.getCantidadColoresNodo(materiaIdx); i = i+2)
		{
			AgregarColores(m, materiaIdx, input, i, par);
			
			if (!TwoListColoring.esSastifacible(materia))
				continue;
			
			for (Integer vecino : noVecinosEnRecursion)
			{
				// agrego la arista a vecino para el grafo materias.
				if (recursion(input, materia, vecino, res))
					return true;
			}
			
			// En la proxima se pisan los colores
		}

		materia.setNodo(materiaIdx, null);
		
		for (Integer vecino : vecinos)
		{
			if (materia.getNodo(vecino) != null)
			{
				// me deslinkeo de mis vecinos
				((LinkedList<Integer>) materia.getNodo(vecino).getVecinos()).removeLast();
			}
		}
		
		/*for (Integer i = 0; i < (colores(materiaIdx)+1)/2; i++)
		{
			Agregar materiaIdx a materias con los dos colores
			if (!resolver2Sat(materia))
			{
				Sacar materia;
				continue;
			} 

			// NO REPETIR ARISTAS 
			for (vecino : vecinos(materiaIdx))
			{
				if (Recursion(input, materia, vecino))
					return true;
			}
			Sacar materiaIdx
		}*/
		
		return false;	
	}
}
