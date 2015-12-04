package uba.algo3.tp3.ejercicio4;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import uba.algo3.tp3.ejercicio1.GrafoMaterias;
import uba.algo3.tp3.ejercicio1.Nodo;
import uba.algo3.tp3.parser.Parser;

public class BusquedaLocalTest {

	private static final Integer ROJO = 0;
	private static final Integer VERDE = 1;
	private static final Integer AZUL = 2;
	private static final Integer NARANJA = 3;
	private static final Integer VIOLETA = 4;
	
	@Test
	public void testSwitchNodos() {
		Nodo n0 = new Nodo();
		Nodo n1 = new Nodo();
		Nodo n2 = new Nodo();
		Nodo n3 = new Nodo();
		Nodo n4 = new Nodo();
		Nodo n5 = new Nodo();
		Nodo n6 = new Nodo();
		Nodo n7 = new Nodo();
		Nodo n8 = new Nodo();
		
		n0.addVecinos(2);
		
		n1.addVecinos(2);
		
		n2.addVecinos(0);
		n2.addVecinos(1);
		n2.addVecinos(3);
		
		n3.addVecinos(2);
		n3.addVecinos(4);
		n3.addVecinos(5);
		n3.addVecinos(6);
		n3.addVecinos(7);
		n3.addVecinos(8);
		
		n4.addVecinos(3);
		
		n5.addVecinos(3);
		
		n6.addVecinos(3);
		
		n7.addVecinos(3);
		
		n8.addVecinos(3);
		
		ArrayList<Integer> colores0 = new ArrayList<Integer>();
		colores0.add(ROJO);
		n0.setColores(colores0);
		
		ArrayList<Integer> colores1 = new ArrayList<Integer>();
		colores1.add(ROJO);
		n1.setColores(colores1);
		
		ArrayList<Integer> colores2 = new ArrayList<Integer>();
		colores2.add(ROJO);
		colores2.add(VIOLETA);
		n2.setColores(colores2);
		
		ArrayList<Integer> colores3 = new ArrayList<Integer>();
		colores3.add(ROJO);
		colores3.add(VIOLETA);
		n3.setColores(colores3);
		
		ArrayList<Integer> colores4 = new ArrayList<Integer>();
		colores4.add(VIOLETA);
		n4.setColores(colores4);
	
		ArrayList<Integer> colores5 = new ArrayList<Integer>();
		colores5.add(VIOLETA);
		n5.setColores(colores5);
		
		ArrayList<Integer> colores6 = new ArrayList<Integer>();
		colores6.add(VIOLETA);
		n6.setColores(colores6);
		
		ArrayList<Integer> colores7 = new ArrayList<Integer>();
		colores7.add(VIOLETA);
		n7.setColores(colores7);
		
		ArrayList<Integer> colores8 = new ArrayList<Integer>();
		colores8.add(ROJO);
		n8.setColores(colores8);

		n0.setColorPintado(ROJO);
		n1.setColorPintado(ROJO);
		n2.setColorPintado(ROJO);
		n3.setColorPintado(VIOLETA);
		n4.setColorPintado(VIOLETA);
		n5.setColorPintado(VIOLETA);
		n6.setColorPintado(VIOLETA);
		n7.setColorPintado(VIOLETA);
		n8.setColorPintado(ROJO);
		
		
		ArrayList<Nodo> grafo = new ArrayList<Nodo>();
		grafo.add(n0);
		grafo.add(n1);
		grafo.add(n2);
		grafo.add(n3);
		grafo.add(n4);
		grafo.add(n5);
		grafo.add(n6);
		grafo.add(n7);
		grafo.add(n8);
		
		GrafoMaterias g = new GrafoMaterias(9);
		g.setGrafo(grafo);
		System.out.println(BusquedaLocal.mejorarSolucionRecolorear(g, 6, 1));
		//System.out.println(BusquedaLocal.switchNodos(g, 6));
	}
	@Test
	public void testConParser() throws IOException {
		Parser p = new Parser();
		GrafoMaterias original = p.parse("test1");
		
		original.getGrafo().get(0).setColorPintado(VIOLETA);
		original.getGrafo().get(1).setColorPintado(VIOLETA);
		original.getGrafo().get(5).setColorPintado(VIOLETA);
		original.getGrafo().get(6).setColorPintado(VIOLETA);
		original.getGrafo().get(2).setColorPintado(ROJO);
		original.getGrafo().get(3).setColorPintado(ROJO);
		original.getGrafo().get(4).setColorPintado(ROJO);
		
		System.out.println(BusquedaLocal.switchNodos(original, 6));
		System.out.println(BusquedaLocal.mejorarSolucionRecolorear(original, 4, 1));
		
	}

}
