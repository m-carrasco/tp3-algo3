package uba.algo3.tp3.ejercicio1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GrafoSATTest {

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
		
		
		// ESTO NO ANDA TODAVIA, PARECE NO ESTAR LA FLECHA DE ROJO1 A ¬ROJO2
		LinkedList<Integer> vRojo1 = new LinkedList<Integer>();
		vRojo1.add(3);
		vRojo1.add(4);
		assertEquals(vRojo1, gs.getNodo(0).getVecinos());
	}

}
