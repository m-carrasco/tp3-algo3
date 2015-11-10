package uba.algo3.tp3.ejercicio2;
 
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;
import uba.algo3.tp3.ejercicio1.Nodo;
import uba.algo3.tp3.ejercicio1.TwoListColoring;

public class ListColoringTest {
	
	private static final Integer ROJO = 0;
	private static final Integer VERDE = 1;
	private static final Integer AZUL = 2;
	private static final Integer NARANJA = 3;
	private static final Integer VIOLETA = 4;
	
	@Test
	public void test() {
		GrafoMaterias materias = new GrafoMaterias(5);
		
		Nodo m0 = new Nodo();
		Nodo m1 = new Nodo();
		Nodo m2 = new Nodo();
		Nodo m3 = new Nodo();
		Nodo m4 = new Nodo();
		
		m0.addVecinos(1);
		m0.addVecinos(2);
		m0.addVecinos(3);
		m0.addVecinos(4);

		m1.addVecinos(0);
		m1.addVecinos(2);
		m1.addVecinos(3);
		m1.addVecinos(4);
		
		m2.addVecinos(0);
		m2.addVecinos(1);
		m2.addVecinos(3);
		m2.addVecinos(4);
		
		m3.addVecinos(0);
		m3.addVecinos(1);
		m3.addVecinos(2);
		m3.addVecinos(4);
		
		m4.addVecinos(0);
		m4.addVecinos(1);
		m4.addVecinos(2);
		m4.addVecinos(3);
		
		ArrayList<Integer> c0 = new ArrayList<Integer>();
		c0.add(ROJO);
		
		c0.add(VERDE);
		c0.add(AZUL);
		m0.setColores(c0);
		
		ArrayList<Integer> c1 = new ArrayList<Integer>();
		c1.add(VERDE);
		
		c1.add(AZUL);
		c1.add(ROJO);
		m1.setColores(c1);
		
		ArrayList<Integer> c2 = new ArrayList<Integer>();
		c2.add(AZUL);
		
		c2.add(VERDE);
		c2.add(ROJO);
		m2.setColores(c2);
		
		ArrayList<Integer> c3 = new ArrayList<Integer>();
		c3.add(NARANJA);
		
		c3.add(AZUL);
		c3.add(VIOLETA);
		m3.setColores(c3);
		
		ArrayList<Integer> c4 = new ArrayList<Integer>();
		c4.add(VIOLETA);
		c4.add(VERDE);
		c4.add(ROJO);
		m4.setColores(c4);
		
		materias.setNodo(0, m0);
		materias.setNodo(1, m1);
		materias.setNodo(2, m2);
		materias.setNodo(3, m3);
		materias.setNodo(4, m4);
		
		Integer[] expected = {ROJO, VERDE, AZUL, NARANJA, VIOLETA};
		Integer[] orden = {0,1,2,3,4};
		GrafoMaterias res = new GrafoMaterias(5);
		Assert.assertEquals(true, ListColoring.recursion(materias, res, 0, orden));
		
		for (Integer i : TwoListColoring.solve(res))
			System.out.println(i);
		
		Assert.assertArrayEquals(expected, TwoListColoring.solve(res));
	}
	
	@Test
	public void k5NoSatisfacible() {
		GrafoMaterias materias = new GrafoMaterias(5);
		
		Nodo m0 = new Nodo();
		Nodo m1 = new Nodo();
		Nodo m2 = new Nodo();
		Nodo m3 = new Nodo();
		Nodo m4 = new Nodo();
		
		m0.addVecinos(1);
		m0.addVecinos(2);
		m0.addVecinos(3);
		m0.addVecinos(4);

		m1.addVecinos(0);
		m1.addVecinos(2);
		m1.addVecinos(3);
		m1.addVecinos(4);
		
		m2.addVecinos(0);
		m2.addVecinos(1);
		m2.addVecinos(3);
		m2.addVecinos(4);
		
		m3.addVecinos(0);
		m3.addVecinos(1);
		m3.addVecinos(2);
		m3.addVecinos(4);
		
		m4.addVecinos(0);
		m4.addVecinos(1);
		m4.addVecinos(2);
		m4.addVecinos(3);
		
		ArrayList<Integer> c0 = new ArrayList<Integer>();
		c0.add(ROJO);
		c0.add(VERDE);
		c0.add(AZUL);
		c0.add(NARANJA);
		m0.setColores(c0);
		
		ArrayList<Integer> c1 = new ArrayList<Integer>();
		c1.add(ROJO);
		c1.add(VERDE);
		c1.add(AZUL);
		c1.add(NARANJA);
		m1.setColores(c1);
		
		ArrayList<Integer> c2 = new ArrayList<Integer>();
		c2.add(ROJO);
		c2.add(VERDE);
		c2.add(AZUL);
		c2.add(NARANJA);
		m2.setColores(c2);
		
		ArrayList<Integer> c3 = new ArrayList<Integer>();
		c3.add(ROJO);
		c3.add(VERDE);
		c3.add(AZUL);
		c3.add(NARANJA);
		m3.setColores(c3);
		
		ArrayList<Integer> c4 = new ArrayList<Integer>();
		c4.add(ROJO);
		c4.add(VERDE);
		c4.add(AZUL);
		c4.add(NARANJA);
		m4.setColores(c4);
		
		materias.setNodo(0, m0);
		materias.setNodo(1, m1);
		materias.setNodo(2, m2);
		materias.setNodo(3, m3);
		materias.setNodo(4, m4);
		
		Integer[] orden = {0,1,2,3,4};
		GrafoMaterias res = new GrafoMaterias(5);
		Assert.assertEquals(false, ListColoring.recursion(materias, res, 0, orden));
		
		for (Nodo n : res.getGrafo())
			Assert.assertEquals(null, n);
	}
	

}
