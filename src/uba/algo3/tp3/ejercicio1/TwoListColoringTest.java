package uba.algo3.tp3.ejercicio1;



import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import uba.algo3.tp3.parser.Parser;

public class TwoListColoringTest {
	
	private static final Integer ROJO = 0;
	private static final Integer VERDE = 1;
	private static final Integer AZUL = 2;
	private static final Integer NARANJA = 3;
	private static final Integer VIOLETA = 4;
	

	@Test
	public void testing() throws IOException{
		Parser p = new Parser();
		GrafoMaterias input = p.parse("testEntradaTwo");

		for (Integer i :TwoListColoring.solve(input))
			System.out.println(i);
		
		Assert.assertArrayEquals(null, TwoListColoring.solve(input));
	}
	@Test
	public void grafoUnSoloColor() {

		GrafoMaterias g = new GrafoMaterias(2);
		
		Nodo m0 = new Nodo();
		m0.addVecinos(1);
	
		ArrayList<Integer> colores0 = new ArrayList<Integer>();
		colores0.add(ROJO); //rojo
		colores0.add(VERDE); //verde
		m0.setColores(colores0);
		
		Nodo m1 = new Nodo();
		m1.addVecinos(0);
		
		ArrayList<Integer> colores1 = new ArrayList<Integer>();
		colores1.add(VERDE); //verde
		m1.setColores(colores1);
	
		g.setNodo(0, m0);
		g.setNodo(1, m1);
		
		Integer[] expected = {ROJO, VERDE};

		Assert.assertArrayEquals(expected, TwoListColoring.solve(g));
	
	}
	
	@Test
	public void grafoNoSatisfacible(){
	
		GrafoMaterias materias = new GrafoMaterias(4);
		
		Nodo m0 = new Nodo();
		Nodo m1 = new Nodo();
		Nodo m2 = new Nodo();
		Nodo m3 = new Nodo();
		
		m0.addVecinos(1);
		m1.addVecinos(0);
		m1.addVecinos(2);
		m1.addVecinos(3);
		m2.addVecinos(1);
		m2.addVecinos(3);
		m3.addVecinos(1);
		m3.addVecinos(2);
		
		ArrayList<Integer> c0 = new ArrayList<Integer>();
		c0.add(ROJO);
		c0.add(VERDE);
		m0.setColores(c0);
		
		ArrayList<Integer> c1 = new ArrayList<Integer>();
		c1.add(VERDE);
		c1.add(AZUL);
		m1.setColores(c1);
		
		ArrayList<Integer> c2 = new ArrayList<Integer>();
		c2.add(VERDE);
		c2.add(AZUL);
		m2.setColores(c2);
		
		ArrayList<Integer> c3 = new ArrayList<Integer>();
		c3.add(AZUL);
		m3.setColores(c3);
		
		materias.setNodo(0, m0);
		materias.setNodo(1, m1);
		materias.setNodo(2, m2);
		materias.setNodo(3, m3);
		
		Assert.assertArrayEquals(null, TwoListColoring.solve(materias));
	}
	
	@Test
	public void grafoK5(){
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
		m0.setColores(c0);
		
		ArrayList<Integer> c1 = new ArrayList<Integer>();
		c1.add(VERDE);
		c1.add(AZUL);
		m1.setColores(c1);
		
		ArrayList<Integer> c2 = new ArrayList<Integer>();
		c2.add(AZUL);
		m2.setColores(c2);
		
		ArrayList<Integer> c3 = new ArrayList<Integer>();
		c3.add(NARANJA);
		
		c3.add(VIOLETA);
		m3.setColores(c3);
		
		ArrayList<Integer> c4 = new ArrayList<Integer>();
		c4.add(VIOLETA);
		m4.setColores(c4);
		
		materias.setNodo(0, m0);
		materias.setNodo(1, m1);
		materias.setNodo(2, m2);
		materias.setNodo(3, m3);
		materias.setNodo(4, m4);
		
		Integer[] expected = {ROJO, VERDE, AZUL, NARANJA, VIOLETA};
		Assert.assertArrayEquals(expected, TwoListColoring.solve(materias));
	}	

}
