package uba.algo3.tp3.ejercicio2;
 
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;
import uba.algo3.tp3.ejercicio1.Nodo;
import uba.algo3.tp3.ejercicio1.TwoListColoring;
import uba.algo3.tp3.parser.Parser;

public class ListColoringTest {
	
	private static final Integer ROJO = 0;
	private static final Integer VERDE = 1;
	private static final Integer AZUL = 2;
	private static final Integer NARANJA = 3;
	private static final Integer VIOLETA = 4;
	
	
	@Test
	public void testCasoLC16() throws IOException
	{
		Parser p = new Parser();
		GrafoMaterias input = p.parse("entradaPeorEj2N10LC16");
		System.out.println("Vecinos nodo 7");
		for (Integer v : input.getNodo(7).getVecinos())
			System.out.println(v);
		System.out.println("Vecinos nodo 8");
		for (Integer v : input.getNodo(8).getVecinos())
			System.out.println(v);
		System.out.println("Vecinos nodo 9");
		for (Integer v : input.getNodo(9).getVecinos())
			System.out.println(v);
		
		System.out.println("Cantidad Colores del nodo 8 y 9");
		System.out.println(input.getNodo(8).getColores().size());
		System.out.println(input.getNodo(9).getColores().size());
		System.out.println("Colores del nodo 8 y 9");
		System.out.println(input.getNodo(8).getColores().get(0));
		System.out.println(input.getNodo(9).getColores().get(0));
		
		//System.out.println(input.getNodo(7).getColores().size());
		//System.out.println(input.getNodo(8).getColores().get(0));
		//System.out.println(input.getNodo(9).getColores().get(0));
		//for (Integer v : input.getNodo(9).getVecinos())
		//	System.out.println(v);
		Integer[] res = ListColoring.solve(input);
		//for (Integer i : res)
		//	System.out.println(i);
		Assert.assertEquals(null, res);
	}
	
	@Test
	public void testPeorCasoFijoN() throws IOException
	{
		// En este caso probamos las instancias de peor caso fijando N y dejando libre LC
		Parser p = new Parser();
		for (Integer i = 16; i < 102; i++)
		{
			System.out.println("Testeando con LC " + i);
			GrafoMaterias input = p.parse("entradaPeorEj2N10LC" + i);
			Integer[] res = ListColoring.solve(input);
			Assert.assertEquals(null, res);
		}


		//for (Integer v : input.getNodo(7).getVecinos())
		//	System.out.println(v);
		//System.out.println(input.getNodo(7).getColores().size());
		//System.out.println(input.getNodo(8).getColores().get(0));
		//System.out.println(input.getNodo(9).getColores().get(0));
		//for (Integer v : input.getNodo(9).getVecinos())
		//	System.out.println(v);
		//for (Integer i : res)
	//		System.out.println(i);
		

	}
	
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
		Integer[] orden = {0,2,1,3,4};
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

	
	@Test
	public void K3K3() {
		GrafoMaterias DosConexas = new GrafoMaterias(6);
		
		Nodo m0 = new Nodo(); 
		Nodo m1 = new Nodo();
		Nodo m2 = new Nodo();
		
		Nodo m3 = new Nodo();
		Nodo m4 = new Nodo();
		Nodo m5 = new Nodo();
		
		m0.addVecinos(1);
		m0.addVecinos(2);
		m1.addVecinos(0);
		m1.addVecinos(2);
		m2.addVecinos(0);
		m2.addVecinos(1);
		
		m3.addVecinos(4);
		m3.addVecinos(5);
		m4.addVecinos(3);
		m4.addVecinos(5);
		m5.addVecinos(3);
		m5.addVecinos(4);
		
		ArrayList<Integer> c0 = new ArrayList<Integer>();
		c0.add(AZUL);
		c0.add(NARANJA);
		m0.setColores(c0);
		
		ArrayList<Integer> c1 = new ArrayList<Integer>();
		c1.add(AZUL);
		c1.add(NARANJA);
		c1.add(VERDE);
		m1.setColores(c1);
		
		ArrayList<Integer> c2 = new ArrayList<Integer>();
		c2.add(VERDE);
		c2.add(NARANJA);
		m2.setColores(c2);
		
		ArrayList<Integer> c4 = new ArrayList<Integer>();
		c4.add(AZUL);
		c4.add(NARANJA);
		m3.setColores(c4);
		
		ArrayList<Integer> c5 = new ArrayList<Integer>();
		c5.add(VERDE);
		c5.add(NARANJA);
		m4.setColores(c5);
		
		ArrayList<Integer> c6 = new ArrayList<Integer>();
		c6.add(NARANJA);
		c6.add(ROJO);
		m5.setColores(c6);
		
		DosConexas.setNodo(0, m0);
		DosConexas.setNodo(1, m1);
		DosConexas.setNodo(2, m2);
		DosConexas.setNodo(3, m3);
		DosConexas.setNodo(4, m4);
		DosConexas.setNodo(5, m5);
		
		Integer[] colores = ListColoring.solve(DosConexas);
		Integer[] expected = {2,3,1,2,1,0};
		
		Assert.assertArrayEquals(expected, colores);
	}
	
}
