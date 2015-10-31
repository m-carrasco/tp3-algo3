package uba.algo3.tp3.ejercicio1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class GrafoMateriasTest {

	@Test
	public void testMaterias() {
		GrafoMaterias g = new GrafoMaterias(2);
		
		Nodo m0 = new Nodo();
		m0.addVecinos(1);
		ArrayList<Integer> colores0 = new ArrayList<Integer>();
		colores0.add(0);
		colores0.add(1);
		m0.setColores(colores0);
		
		Nodo m1 = new Nodo();
		m1.addVecinos(0);
		ArrayList<Integer> colores1 = new ArrayList<Integer>();
		colores1.add(1);
		m1.setColores(colores1);
		
		g.setNodo(0, m0);
		g.setNodo(1, m1);
		
		List<Integer> expectedList = new ArrayList<Integer>();
		expectedList.add(1);
		assertEquals(expectedList, g.getNodo(0).getVecinos());
		
		List<Integer> expectedList2 = new ArrayList<Integer>();
		expectedList2.add(0);
		assertEquals(expectedList2, g.getNodo(1).getVecinos());
				
		assertEquals(colores0, g.getNodo(0).getColores());
		assertEquals(colores1, g.getNodo(1).getColores());
	}

}
