package uba.algo3.tp3.ejercicio3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;
import uba.algo3.tp3.ejercicio1.Nodo;
import uba.algo3.tp3.parser.Parser;

public class ListColoringGolosoTest {
	
	private static final Integer ROJO = 0;
	private static final Integer VERDE = 1;
	private static final Integer AZUL = 2;
	private static final Integer NARANJA = 3;
	private static final Integer VIOLETA = 4;

	// Corre it veces greedy sobre el grafo temp y lo restaura en cada iteracion.
	public void run(Integer it, GrafoMaterias g)
	{
		for (Integer j = 0; j < it; j++)
		{
			ListColoringGoloso.solve(g);
			for (Nodo n : g.getGrafo())
				n.setColorPintado(-1);
		}
	}
	
	@Test 
	public void CasoMalo() throws IOException
	{
		
		Parser p = new Parser();
		GrafoMaterias g = p.parse("Ej3CasoMalo");
		ListColoringGoloso.solve(g);
		int i = 0;
		for(Nodo nodo : g.getGrafo())
		{
			System.out.println("Nodo " + i + " " + nodo.getColorPintado());
			i++;
		}	
	}
	
	@Test 
	public void testVariarN() throws IOException
	{
		// Para este caso deberia comportarse de manera n*log n
	
		Parser p = new Parser();
		
		Integer it = 2000;
		
		System.out.println("Ejercicio3 variando n");
		System.out.println("N M LC Tiempo promedio");
		
		// iteramos por cada caso
		for (Integer i = 1000; i <= 20000; i = i + 1000)
		{
			String filename = "entradaEj3N" + i+"M100LC10";
			GrafoMaterias original = p.parse(filename);
					
			// warmup
			run( it, original);

			long inicio = System.currentTimeMillis();
			
			run( it, original);
			
			Double delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
			System.out.println(i + " 100 10 " + delta);
		}	
	}


	@Test 
	public void testVariarC() throws IOException
	{
		// Para este caso deberia comportarse de manera n*log n
	
		Parser p = new Parser();
		
		Integer it = 100;
		
		System.out.println("Ejercicio3 variando c");
		System.out.println("N M LC Tiempo promedio");
		
		// iteramos por cada caso
		for (Integer i = 100; i <= 1500; i = i + 100)
		{
			String filename = "entradaEj3N250M50LC" + i;
			GrafoMaterias original = p.parse(filename);
					
			// warmup
			run( it, original);

			long inicio = System.currentTimeMillis();
			
			run( it, original);
			
			Double delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
			System.out.println("250 50 " +i + " "+  delta);
		}	
	}

	@Test 
	public void testVariarM() throws IOException
	{
		// Para este caso deberia comportarse de manera n*log n
	
		Parser p = new Parser();
		
		Integer it = 1000;
		
		System.out.println("Ejercicio3 variando M");
		System.out.println("N M LC Tiempo promedio");
		
		// iteramos por cada caso
		for (Integer i = 1000; i <= 20000; i = i + 1000)
		{
			String filename = "entradaEj3N500M"+i+"LC10";
			GrafoMaterias original = p.parse(filename);
					
			// warmup
			run( it, original);

			long inicio = System.currentTimeMillis();
			
			run( it, original);
			
			Double delta = (System.currentTimeMillis() - inicio) / it.doubleValue();
			System.out.println("500 " +i + " 100 "+  delta);
		}	
	}

	
	
	@Test
	public void grafoUnSoloColor() {

		GrafoMaterias g = new GrafoMaterias(2);
		
		Nodo m0 = new Nodo();
		m0.addVecinos(1);
	
		ArrayList<Integer> colores0 = new ArrayList<Integer>();
		colores0.add(ROJO);
		m0.setColores(colores0);
		
		Nodo m1 = new Nodo();
		m1.addVecinos(0);
		
		ArrayList<Integer> colores1 = new ArrayList<Integer>();
		colores1.add(ROJO);
		m1.setColores(colores1);
	
		g.setNodo(0, m0);
		g.setNodo(1, m1);
		
		LinkedList<Integer[]> expected = new LinkedList<Integer[]>();
		Integer[] tupla = {0,1};
		expected.add(tupla);
		Assert.assertArrayEquals(expected.toArray(), ListColoringGoloso.solve(g).toArray());
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
		
		LinkedList<Integer[]> expected = new LinkedList<Integer[]>();
		Integer[] tupla = {1,2};
		expected.add(tupla);
		Assert.assertArrayEquals(expected.toArray(), ListColoringGoloso.solve(materias).toArray());
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
		c0.add(VIOLETA);
		c0.add(NARANJA);
		m0.setColores(c0);
		
		ArrayList<Integer> c1 = new ArrayList<Integer>();
		c1.add(VERDE);
		c1.add(AZUL);
		m1.setColores(c1);
		
		ArrayList<Integer> c2 = new ArrayList<Integer>();
		c2.add(VIOLETA);
		m2.setColores(c2);
		
		ArrayList<Integer> c3 = new ArrayList<Integer>();
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
		
		
		LinkedList<Integer[]> expected = new LinkedList<Integer[]>();
		
		Integer[] tupla3 = {2,3};
		expected.add(tupla3);
		Integer[] tupla2 = {2,4};
		expected.add(tupla2);
		Integer[] tupla = {3,4};
		expected.add(tupla);
		
		Assert.assertArrayEquals(expected.toArray(), ListColoringGoloso.solve(materias).toArray());
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
		c5.add(VIOLETA);
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
		
		
		LinkedList<Integer[]> expected = new LinkedList<Integer[]>();

		Assert.assertArrayEquals(expected.toArray(), ListColoringGoloso.solve(DosConexas).toArray());
		
	}
}
