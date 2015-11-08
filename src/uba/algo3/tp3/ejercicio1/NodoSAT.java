package uba.algo3.tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class NodoSAT {

	private List<Integer> vecinos = new LinkedList<Integer>();
	private boolean voyYo; //si es true es afirmacion, sino es negacion.
	
	public NodoSAT()
	{
		voyYo = false;
	}
	public List<Integer> getVecinos() {
		return vecinos;
	}

	public boolean getVoyYo() {
		return voyYo;
	}
	public void setVoyYo(boolean afirmacion) {
		this.voyYo = afirmacion;
	}
	
	public void addVecino(Integer vecino){
		vecinos.add(vecino);
	}
	
	
}
