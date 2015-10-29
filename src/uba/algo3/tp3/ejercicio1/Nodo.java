package uba.algo3.tp3.ejercicio1;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Nodo {
	
	private List<Integer> vecinos = new LinkedList<Integer>();
	
	private ArrayList<Integer> colores;
	
	
	public List<Integer> getVecinos() {
		return vecinos;
	}
	public void setVecinos(List<Integer> vecinos) {
		this.vecinos = vecinos;
	}
	public ArrayList<Integer> getColores() {
		return colores;
	}
	public void setColores(ArrayList<Integer> colores) {
		this.colores = colores;
	}
	public void addVecinos(Integer vecino) {
		vecinos.add(vecino);
	}
	
}
