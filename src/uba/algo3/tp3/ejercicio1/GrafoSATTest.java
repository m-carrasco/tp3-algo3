package uba.algo3.tp3.ejercicio1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GrafoSATTest {
	
	@Test
	public void TestCompConexa()
	{
	
		GrafoMaterias g = new GrafoMaterias(2);
		
		Nodo m0 = new Nodo();
		m0.addVecinos(1);
		ArrayList<Integer> colores0 = new ArrayList<Integer>();
		colores0.add(0); //rojo
		colores0.add(1); //verde
		m0.setColores(colores0);
		
		Nodo m1 = new Nodo();
		m1.addVecinos(0);
		ArrayList<Integer> colores1 = new ArrayList<Integer>();
		colores1.add(1); //verde
		m1.setColores(colores1);
		
		g.setNodo(0, m0);
		g.setNodo(1, m1);
		
		GrafoSAT gs = new GrafoSAT(g); //O(n + m)
		
		CompFuerteConexas cfc = gs.CC();  //O(n+m)
		Integer cant = 4;
		assertEquals(cant, cfc.getCantCFC());
		
		assertEquals(true, gs.Satisfacible(cfc.getCFCPorNodo()));
		
		System.out.println();
		
		assertEquals("[3, 0, 0, 3, 2, 1, -1, -1]", cfc.getCFCPorNodo().toString());
		
		ArrayList<LinkedList<Integer>>  ady = gs.AdyacenciaEntreCompFuertConex(cfc);
		assertEquals("[[1], [2], [3], []]", ady.toString());
		
		gs.Pintar(ady, cfc);
		
		for (NodoSAT n : gs.getGrafo())
		{
			if (n != null)
				System.out.println(n.isAfirmacion());
		}
	}
	
	@Test
	public void GrafoMateriasASAT() {
	
		GrafoMaterias g = new GrafoMaterias(2);
		
		Nodo m0 = new Nodo();
		m0.addVecinos(1);
		ArrayList<Integer> colores0 = new ArrayList<Integer>();
		colores0.add(0); //rojo
		colores0.add(1); //verde
		m0.setColores(colores0);
		
		Nodo m1 = new Nodo();
		m1.addVecinos(0);
		ArrayList<Integer> colores1 = new ArrayList<Integer>();
		colores1.add(1); //verde
		m1.setColores(colores1);
		
		g.setNodo(0, m0);
		g.setNodo(1, m1);
		
		GrafoSAT gs = new GrafoSAT(g);
		
		// Si modulo 4 me da: 
		// -> 0 entonces es afirmacion del primer color
		// -> 1 entonces es negacion del primer color
		// -> 2 entonces es afirmacion del segundo color
		// -> 3 entonces es negacion del segundo color
		
		LinkedList<Integer> vRojo1 = new LinkedList<Integer>();
		vRojo1.add(3);
		//vRojo1.add(4);
		assertEquals(vRojo1, gs.getNodo(0).getVecinos());
		
		LinkedList<Integer> vNoRojo1 = new LinkedList<Integer>();
		vNoRojo1.add(2);
		assertEquals(vNoRojo1, gs.getNodo(1).getVecinos());
		
		LinkedList<Integer> vVerde1 = new LinkedList<Integer>();
		vVerde1.add(1);
		vVerde1.add(5);
		assertEquals(vVerde1, gs.getNodo(2).getVecinos());
		
		LinkedList<Integer> vNoVerde1 = new LinkedList<Integer>();
		vNoVerde1.add(0);
		assertEquals(vNoVerde1, gs.getNodo(3).getVecinos());
		
		LinkedList<Integer> vVerde2 = new LinkedList<Integer>();
		vVerde2.add(3);
		assertEquals(vVerde2, gs.getNodo(4).getVecinos());
		
		LinkedList<Integer> vNoVerde2 = new LinkedList<Integer>();
		vNoVerde2.add(4);
		assertEquals(vNoVerde2, gs.getNodo(5).getVecinos());
		
	}

}
