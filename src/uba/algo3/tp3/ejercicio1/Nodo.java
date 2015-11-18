package uba.algo3.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Nodo implements Comparable<Nodo>{
	
	private List<Integer> vecinos = new LinkedList<Integer>();
	
	private ArrayList<Integer> colores;
	
	private Integer colorPintado=-1;
	
	public List<Integer> getVecinos() {
		return vecinos;
	}
	public void setVecinos(List<Integer> vecinos) {
		this.vecinos = vecinos;
	}
	public ArrayList<Integer> getColores() {
		return colores;
	}
	public int cantColores() {
		return colores.size();
	}
	public int cantVecinos() {
		return vecinos.size();
	}
	public void setColores(ArrayList<Integer> colores) {
		this.colores = colores;
	}
	public void addVecinos(Integer vecino) {
		vecinos.add(vecino);
	}
	
	public boolean lessThan( Nodo n ) {
		if (cantColores() < n.cantColores()) 
			return true;
		
		if (cantColores() > n.cantColores())
			return false;
		
		return cantVecinos() < n.cantVecinos();
	}

	public int compareTo( Nodo otherInstance ) {
		if (lessThan( otherInstance ))
			return -1;
		
		else if (otherInstance.lessThan( this ))
			return 1;
		
		return 0;
	}
	public Integer getColorPintado() {
		return colorPintado;
	}
	public void setColorPintado(Integer colorPintado) {
		this.colorPintado = colorPintado;
	}   
}
