package uba.algo3.tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class NodoSAT {

	private List<Integer> vecinos = new LinkedList<Integer>();
	private boolean afirmacion; //si es true es afirmacion, sino es negacion.
	
	public List<Integer> getVecinos() {
		return vecinos;
	}

	public boolean isAfirmacion() {
		return afirmacion;
	}
	public void setAfirmacion(boolean afirmacion) {
		this.afirmacion = afirmacion;
	}
	
	public void addVecino(Integer vecino){
		vecinos.add(vecino);
	}
	
	
}
